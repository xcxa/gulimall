package com.xcx.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcx.common.utils.PageUtils;
import com.xcx.gulimall.coupon.entity.HomeSubjectEntity;

import java.util.Map;

/**
 * ��ҳר�����jd��ҳ����ܶ�ר�⣬ÿ��ר�������µ�ҳ�棬չʾר����Ʒ��Ϣ��
 *
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 17:38:33
 */
public interface HomeSubjectService extends IService<HomeSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

