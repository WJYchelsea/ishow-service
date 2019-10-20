package com.ishow.mysql.mapper;

import com.ishow.mysql.domain.IShowGoodsInfoShop;
import com.ishow.mysql.domain.IShowGoodsInfoShopExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IShowGoodsInfoShopMapper {
    long countByExample(IShowGoodsInfoShopExample example);

    int deleteByExample(IShowGoodsInfoShopExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(IShowGoodsInfoShop record);

    int insertSelective(IShowGoodsInfoShop record);

    List<IShowGoodsInfoShop> selectByExample(IShowGoodsInfoShopExample example);

    IShowGoodsInfoShop selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") IShowGoodsInfoShop record, @Param("example") IShowGoodsInfoShopExample example);

    int updateByExample(@Param("record") IShowGoodsInfoShop record, @Param("example") IShowGoodsInfoShopExample example);

    int updateByPrimaryKeySelective(IShowGoodsInfoShop record);

    int updateByPrimaryKey(IShowGoodsInfoShop record);
}