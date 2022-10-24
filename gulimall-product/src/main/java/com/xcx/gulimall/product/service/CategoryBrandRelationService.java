package com.xcx.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcx.common.utils.PageUtils;
import com.xcx.gulimall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * Ʒ�Ʒ������
 *
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 15:59:10
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

    void updateBrand(Long brandId, String name);

    void updateCategory(Long catId, String name);
}

