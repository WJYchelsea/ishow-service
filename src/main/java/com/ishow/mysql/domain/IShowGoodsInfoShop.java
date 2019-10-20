package com.ishow.mysql.domain;

import java.io.Serializable;

public class IShowGoodsInfoShop implements Serializable {
    private Integer pid;

    private String shopId;

    private Integer goodsInfoId;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public Integer getGoodsInfoId() {
        return goodsInfoId;
    }

    public void setGoodsInfoId(Integer goodsInfoId) {
        this.goodsInfoId = goodsInfoId;
    }
}