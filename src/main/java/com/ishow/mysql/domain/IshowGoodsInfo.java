package com.ishow.mysql.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class IshowGoodsInfo implements Serializable {
    private Integer pid;

    private String goodsName;

    private Integer whetherHat;

    private BigDecimal price;

    private String color;

    private String size;

    private String style;

    private Integer whetherBlock;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getWhetherHat() {
        return whetherHat;
    }

    public void setWhetherHat(Integer whetherHat) {
        this.whetherHat = whetherHat;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public Integer getWhetherBlock() {
        return whetherBlock;
    }

    public void setWhetherBlock(Integer whetherBlock) {
        this.whetherBlock = whetherBlock;
    }
}