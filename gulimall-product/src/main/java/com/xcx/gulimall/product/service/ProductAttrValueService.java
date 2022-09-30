package com.xcx.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcx.common.utils.PageUtils;
import com.xcx.gulimall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu����ֵ
 *
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 15:59:10
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

