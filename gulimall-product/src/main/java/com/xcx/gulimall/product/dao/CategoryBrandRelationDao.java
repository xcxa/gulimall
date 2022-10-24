package com.xcx.gulimall.product.dao;

import com.xcx.gulimall.product.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Ʒ�Ʒ������
 * 
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 15:59:10
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {

    /**
     * @param catId
     * @param name
     */
    void updateCategory(@Param("catId") Long catId, @Param("name") String name);

}
