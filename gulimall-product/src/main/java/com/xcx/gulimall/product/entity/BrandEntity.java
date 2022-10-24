package com.xcx.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.xcx.common.valid.AddGroup;
import com.xcx.common.valid.UpdateGroup;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Ʒ��
 * 
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 15:59:10
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Ʒ��id
	 */
	@TableId
	@Null(message = "新增不能指定id",groups = AddGroup.class)
	@NotNull(message = "修改必须指定id",groups = UpdateGroup.class)
	private Long brandId;
	/**
	 * Ʒ����
	 */
	@NotBlank(message = "品牌名不能为空",groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	/**
	 * Ʒ��logo��ַ
	 */
	private String logo;
	/**
	 * ����
	 */
	private String descript;
	/**
	 * ��ʾ״̬[0-����ʾ��1-��ʾ]
	 */
	private Integer showStatus;
	/**
	 * ��������ĸ
	 */
	private String firstLetter;
	/**
	 * ����
	 */
	private Integer sort;

}
