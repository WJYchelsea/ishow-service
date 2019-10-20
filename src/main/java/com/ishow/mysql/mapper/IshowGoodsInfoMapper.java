package com.ishow.mysql.mapper;

import com.ishow.mysql.domain.IshowGoodsInfo;
import com.ishow.mysql.domain.IshowGoodsInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IshowGoodsInfoMapper {
    long countByExample(IshowGoodsInfoExample example);

    int deleteByExample(IshowGoodsInfoExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(IshowGoodsInfo record);

    int insertSelective(IshowGoodsInfo record);

    List<IshowGoodsInfo> selectByExample(IshowGoodsInfoExample example);

    IshowGoodsInfo selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") IshowGoodsInfo record, @Param("example") IshowGoodsInfoExample example);

    int updateByExample(@Param("record") IshowGoodsInfo record, @Param("example") IshowGoodsInfoExample example);

    int updateByPrimaryKeySelective(IshowGoodsInfo record);

    int updateByPrimaryKey(IshowGoodsInfo record);

    List<IshowGoodsInfo> selectIGoodsByKey(String key);
}