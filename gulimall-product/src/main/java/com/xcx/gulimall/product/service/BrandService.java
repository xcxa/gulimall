package com.xcx.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcx.common.utils.PageUtils;
import com.xcx.gulimall.product.entity.BrandEntity;

import java.util.Map;

/**
 * Ʒ��
 *
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 15:59:10
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

