package com.ishow.mysql.mapper;

import com.ishow.mysql.domain.IShowShop;
import com.ishow.mysql.domain.IShowShopExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IShowShopMapper {
    long countByExample(IShowShopExample example);

    int deleteByExample(IShowShopExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(IShowShop record);

    int insertSelective(IShowShop record);

    List<IShowShop> selectByExample(IShowShopExample example);

    IShowShop selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") IShowShop record, @Param("example") IShowShopExample example);

    int updateByExample(@Param("record") IShowShop record, @Param("example") IShowShopExample example);

    int updateByPrimaryKeySelective(IShowShop record);

    int updateByPrimaryKey(IShowShop record);

    IShowShop selectShopByKey(String key);
}