package com.xcx.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ��ɱ�����
 * 
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 17:38:33
 */
@Data
@TableName("sms_seckill_session")
public class SeckillSessionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ��������
	 */
	private String name;
	/**
	 * ÿ�տ�ʼʱ��
	 */
	private Date startTime;
	/**
	 * ÿ�ս���ʱ��
	 */
	private Date endTime;
	/**
	 * ����״̬
	 */
	private Integer status;
	/**
	 * ����ʱ��
	 */
	private Date createTime;

}
