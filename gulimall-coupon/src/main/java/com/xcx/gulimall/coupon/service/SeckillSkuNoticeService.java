package com.xcx.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcx.common.utils.PageUtils;
import com.xcx.gulimall.coupon.entity.SeckillSkuNoticeEntity;

import java.util.Map;

/**
 * ��ɱ��Ʒ֪ͨ����
 *
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 17:38:33
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

