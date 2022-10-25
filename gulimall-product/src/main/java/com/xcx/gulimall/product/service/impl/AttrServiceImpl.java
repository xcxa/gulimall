package com.xcx.gulimall.product.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.xcx.gulimall.product.dao.AttrAttrgroupRelationDao;
import com.xcx.gulimall.product.dao.AttrGroupDao;
import com.xcx.gulimall.product.dao.CategoryDao;
import com.xcx.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.xcx.gulimall.product.entity.AttrGroupEntity;
import com.xcx.gulimall.product.entity.CategoryEntity;
import com.xcx.gulimall.product.service.AttrAttrgroupRelationService;
import com.xcx.gulimall.product.vo.AttrRespVo;
import com.xcx.gulimall.product.vo.AttrVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcx.common.utils.PageUtils;
import com.xcx.common.utils.Query;

import com.xcx.gulimall.product.dao.AttrDao;
import com.xcx.gulimall.product.entity.AttrEntity;
import com.xcx.gulimall.product.service.AttrService;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    AttrAttrgroupRelationDao attrAttrgroupRelationDao;
    @Autowired
    AttrGroupDao attrGroupDao;
    @Autowired
    CategoryDao categoryDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr,attrEntity);
        this.save(attrEntity);
        AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
        attrAttrgroupRelationEntity.setAttrGroupId(attr.getAttrGroupId());
        attrAttrgroupRelationEntity.setAttrId(attrEntity.getAttrId());
        attrAttrgroupRelationDao.insert(attrAttrgroupRelationEntity);


    }

    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        if (catelogId != 0){
            queryWrapper.eq("catelog_id",catelogId);

        }

        if (!StringUtils.isEmpty(key)){
            queryWrapper.and(qw->{
                qw.eq("attr_id",key).or().like("attr_name",key);
            });
        }
        IPage<AttrEntity> page = this.page(new Query<AttrEntity>().getPage(params), queryWrapper);
        PageUtils pageUtils = new PageUtils(page);
        List<AttrRespVo> list = page.getRecords().stream().map(AttrEntity -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(AttrEntity, attrRespVo);
            // "catelogName": "手机/数码/手机", //所属分类名字
            //      "groupName": "主体", //所属分组名字
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = attrAttrgroupRelationDao.selectById(AttrEntity.getAttrId());
            if (attrAttrgroupRelationEntity != null) {
                AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrAttrgroupRelationEntity.getAttrGroupId());
                attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
            }
            CategoryEntity categoryEntity = categoryDao.selectById(AttrEntity.getCatelogId());
            if (categoryEntity != null) {
                attrRespVo.setCatelogName(categoryEntity.getName());
            }

            return attrRespVo;
        }).collect(Collectors.toList());


        pageUtils.setList(list);
        return pageUtils;


    }

}