package com.xcx.gulimall.product.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcx.common.utils.PageUtils;
import com.xcx.common.utils.Query;

import com.xcx.gulimall.product.dao.AttrGroupDao;
import com.xcx.gulimall.product.entity.AttrGroupEntity;
import com.xcx.gulimall.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        IPage<AttrGroupEntity> page;
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        String key = (String) params.get("key");

            if (!StringUtils.isEmpty(key)){
                wrapper.eq("attr_group_id",key).or().like("attr_group_name",key);
            }

            if (catelogId != 0){
                wrapper.and(w ->{
                   w.eq("catelog_id",catelogId);
                });
            }


          page = this.page(new Query<AttrGroupEntity>().getPage(params),wrapper);

        return new PageUtils(page);
    }

}