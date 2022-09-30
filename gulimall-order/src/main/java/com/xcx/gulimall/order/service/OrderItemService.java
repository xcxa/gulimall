package com.xcx.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcx.common.utils.PageUtils;
import com.xcx.gulimall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * ��������Ϣ
 *
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 22:32:15
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

