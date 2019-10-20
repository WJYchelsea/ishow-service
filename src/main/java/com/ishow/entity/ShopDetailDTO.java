package com.ishow.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 返回用户商铺的所有信息
 *
 * @author zhaohaojie
 * @date 2019-10-20 12:18
 */
@Getter
@Setter
public class ShopDetailDTO {

    // 店铺id
    private Integer shopId;
    // 商品id
    private Integer goodsId;
    // 商铺名称
    private String shopName;
    // 商品名称
    private String goodsName;
    // 商品价格
    private BigDecimal price;
    private String pictureURL;//可以null
    // 商铺地址
    private String address;
}

