package com.xcx.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcx.common.utils.PageUtils;
import com.xcx.gulimall.coupon.entity.SkuLadderEntity;

import java.util.Map;

/**
 * ��Ʒ���ݼ۸�
 *
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 17:38:33
 */
public interface SkuLadderService extends IService<SkuLadderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

