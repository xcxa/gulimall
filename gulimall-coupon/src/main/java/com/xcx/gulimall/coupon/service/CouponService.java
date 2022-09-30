package com.xcx.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcx.common.utils.PageUtils;
import com.xcx.gulimall.coupon.entity.CouponEntity;

import java.util.Map;

/**
 * �Ż�ȯ��Ϣ
 *
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 17:38:32
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

