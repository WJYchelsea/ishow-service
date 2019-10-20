package com.ishow.service;

import com.ishow.entity.Ke;
import com.ishow.entity.ShopDetailDTO;
import com.ishow.mysql.domain.IShowGoodsInfoShop;
import com.ishow.mysql.domain.IShowGoodsInfoShopExample;
import com.ishow.mysql.domain.IShowShop;
import com.ishow.mysql.domain.IshowGoodsInfo;
import com.ishow.mysql.mapper.IShowGoodsInfoShopMapper;
import com.ishow.mysql.mapper.IShowShopMapper;
import com.ishow.mysql.mapper.IshowGoodsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaohaojie
 * @date 2019-10-20 1:30
 */
@Service
public class ShopAndGoodsInfoService {

    @Autowired
    private IshowGoodsInfoMapper ishowGoodsInfoMapper;

    @Autowired
    private IShowShopMapper iShowShopMapper;

    @Autowired
    private IShowGoodsInfoShopMapper goodsAndShopMapper;

    public IshowGoodsInfo getShopList(List<String> keyWords) {
        IshowGoodsInfo info = ishowGoodsInfoMapper.selectByPrimaryKey(1);
        return info;
    }

    public List<ShopDetailDTO> getShopDetail(List<Ke> keys){
        List<ShopDetailDTO> result = new ArrayList<>();
        for (Ke ke : keys){
            String key = ke.getWord();
            List<ShopDetailDTO> tmp = addShopDetail(key);
            if (tmp!=null){
                result.addAll(tmp);
            }

        }
        return result;
    }
    private List<ShopDetailDTO> addShopDetail(String key){
        List<ShopDetailDTO> result = new ArrayList<ShopDetailDTO>();
        // key 为 igoods表
        List<IshowGoodsInfo> goodsInfoList = ishowGoodsInfoMapper.selectIGoodsByKey(key);

        // key 为 ishop表
        IShowShop iShowShop = iShowShopMapper.selectShopByKey(key);
        // 1.如果都为空，没有匹配的产品
        if ( goodsInfoList.size()==0 && iShowShop == null){
            return null;
        }
        // 3.goodsInfo==null,shop != null
        if ( goodsInfoList.size()==0){
            ShopDetailDTO result2 = new ShopDetailDTO();
            result2.setAddress(iShowShop.getAddress());
            result2.setGoodsId(-1);
            result2.setGoodsName("/");
            result2.setPrice(BigDecimal.valueOf(0.00));
            result2.setShopId(iShowShop.getPid());
            result2.setShopName(iShowShop.getShopName());
            result.add(result2);
        }
        for (IshowGoodsInfo goodsInfo:goodsInfoList){
            ShopDetailDTO result2 = new ShopDetailDTO();
            // 4.shop==null,goodsInfo != null
            IShowGoodsInfoShopExample example = new IShowGoodsInfoShopExample();
            example.createCriteria().andGoodsInfoIdEqualTo(goodsInfo.getPid());
            IShowGoodsInfoShop goodsInfoShop = goodsAndShopMapper.selectByExample(example)
                    .stream().findFirst().orElse(null);
            if (iShowShop == null){
                // 根据商品id查询地址
                if (goodsInfoShop == null){
                    result2.setShopName("附近暂时没有店铺出售该服饰!");
                    result2.setShopId(-1);
                    result2.setGoodsName(goodsInfo.getGoodsName());
                    result2.setPrice(BigDecimal.valueOf(0.00));
                    result2.setGoodsId(goodsInfo.getPid());
                }else{
                    // 查询出该服饰所在的店铺
                    IShowShop shop = iShowShopMapper.selectByPrimaryKey(Integer.valueOf(goodsInfoShop.getShopId()));
                    result2.setPrice(goodsInfo.getPrice());
                    result2.setGoodsId(goodsInfo.getPid());
                    result2.setShopId(shop.getPid());
                    result2.setGoodsName(goodsInfo.getGoodsName());
                    result2.setShopName(shop.getShopName());
                    result2.setAddress(shop.getAddress());
                }
            }
            // 5.如果两者都不为空
            if (iShowShop != null && goodsInfoShop != null
                    && Integer.valueOf(goodsInfoShop.getShopId()).equals(iShowShop.getPid())){
                // 店与商铺匹配
                result2.setGoodsId(goodsInfo.getPid());
                result2.setPrice(goodsInfo.getPrice());
                result2.setGoodsName(goodsInfo.getGoodsName());
                result2.setShopId(iShowShop.getPid());
                result2.setShopName(iShowShop.getShopName());
                result2.setAddress(iShowShop.getAddress());
            }else if (iShowShop != null && goodsInfoShop != null
                    && !Integer.valueOf(goodsInfoShop.getShopId()).equals(iShowShop.getPid())){
                //不匹配
                result2 = null;
            }
            result.add(result2);
        }
        return result;
    }

    public IshowGoodsInfo selectGoodsDetailById(Integer id) {
        return ishowGoodsInfoMapper.selectByPrimaryKey(id);

    }
}

