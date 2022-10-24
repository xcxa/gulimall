package com.xcx.gulimall.product.service.impl;

import com.xcx.gulimall.product.dao.CategoryBrandRelationDao;
import com.xcx.gulimall.product.service.CategoryBrandRelationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcx.common.utils.PageUtils;
import com.xcx.common.utils.Query;

import com.xcx.gulimall.product.dao.BrandDao;
import com.xcx.gulimall.product.entity.BrandEntity;
import com.xcx.gulimall.product.service.BrandService;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {
    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        QueryWrapper<BrandEntity> q = new QueryWrapper<>();

        String key = (String)params.get("key");
        if (!StringUtils.isEmpty(key)){
            q.eq("brand_id",key).or().like("name",key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),q
        );

        return new PageUtils(page);
    }

    @Override
    public void updateDetail(BrandEntity brand) {
        this.updateById(brand);
        if(!StringUtils.isEmpty(brand.getName())){
            categoryBrandRelationService.updateBrand(brand.getBrandId(),brand.getName());
        }
    }

}