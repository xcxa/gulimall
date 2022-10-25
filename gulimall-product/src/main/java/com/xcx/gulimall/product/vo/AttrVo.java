package com.xcx.gulimall.product.vo;

import lombok.Data;

@Data
public class AttrVo {

    private Long attrId;
    /**
     * ������
     */
    private String attrName;
    /**
     * �Ƿ���Ҫ����[0-����Ҫ��1-��Ҫ]
     */
    private Integer searchType;
    /**
     * ����ͼ��
     */
    private String icon;
    /**
     * ��ѡֵ�б�[�ö��ŷָ�]
     */
    private String valueSelect;
    /**
     * ��������[0-�������ԣ�1-�������ԣ�2-���������������ǻ�������]
     */
    private Integer attrType;
    /**
     * ����״̬[0 - ���ã�1 - ����]
     */
    private Long enable;
    /**
     * ��������
     */
    private Long catelogId;
    /**
     * ����չʾ���Ƿ�չʾ�ڽ����ϣ�0-�� 1-�ǡ�����sku����Ȼ���Ե���
     */
    private Integer showDesc;


    private Long  attrGroupId;



}
