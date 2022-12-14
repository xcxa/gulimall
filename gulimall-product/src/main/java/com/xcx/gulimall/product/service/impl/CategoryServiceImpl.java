package com.xcx.gulimall.product.service.impl;

import com.xcx.gulimall.product.dao.CategoryBrandRelationDao;
import com.xcx.gulimall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcx.common.utils.PageUtils;
import com.xcx.common.utils.Query;

import com.xcx.gulimall.product.dao.CategoryDao;
import com.xcx.gulimall.product.entity.CategoryEntity;
import com.xcx.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {


    @Autowired
    CategoryBrandRelationDao CategoryBrandRelationDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        List<CategoryEntity> level1 = categoryEntities.stream().
                filter((categoryEntity -> categoryEntity.getParentCid() == 0))
                .map((menu -> {
                    menu.setChildren(getChildrens(menu,categoryEntities));
                    return menu;
                })).sorted((menu1,menu2) ->{
                    return (menu1.getSort()==null?0: menu1.getSort())-
                            (menu2.getSort()==null?0: menu2.getSort());
                }).
                collect(Collectors.toList());
        return  level1;
    }

    @Override
    public void removeMenusByIds(List<Long> asList) {
        //todo 1?????????????????????
        baseMapper.deleteBatchIds(asList);
    }



    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> path = new ArrayList<>();
        List<Long> parentPath = findParentPath(catelogId, path);
        Collections.reverse(parentPath);
        return  parentPath.toArray(new Long[path.size()]);
    }

    @Override
    public void updateDetail(CategoryEntity category) {
        this.updateById(category);
        CategoryBrandRelationDao.updateCategory(category.getCatId(),category.getName());

    }

    public List<Long> findParentPath(Long catelogId, List<Long> path) {
        CategoryEntity byId = this.getById(catelogId);
        if (byId.getParentCid()!=0){
            path.add(catelogId);

            findParentPath(byId.getParentCid(), path);
        }
        return path;

    }

        private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all){
        List<CategoryEntity> children = all.stream().filter(s ->
                s.getParentCid() == root.getCatId()
            ).map(menu ->{
                menu.setChildren(getChildrens(menu,all));
                return menu;
            }).sorted((menu1,menu2) ->{
             return (menu1.getSort()==null?0:menu1.getSort())-
                     (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }

}