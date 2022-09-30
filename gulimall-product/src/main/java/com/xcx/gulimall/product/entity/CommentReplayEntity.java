package com.xcx.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ��Ʒ���ۻظ���ϵ
 * 
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 15:59:10
 */
@Data
@TableName("pms_comment_replay")
public class CommentReplayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ����id
	 */
	private Long commentId;
	/**
	 * �ظ�id
	 */
	private Long replyId;

}
