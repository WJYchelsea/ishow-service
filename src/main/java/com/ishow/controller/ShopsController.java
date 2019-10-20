package com.ishow.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ishow.entity.ShopDetailDTO;
import com.ishow.entity.XFResponse;
import com.ishow.manager.ltp.ltp;
import com.ishow.mysql.domain.IshowGoodsInfo;
import com.ishow.service.ShopAndGoodsInfoService;
import com.ishow.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 商铺控制器类
 *
 * @author zhaohaojie
 * @date 2019-10-20 1:28
 */
@RestController
public class ShopsController {

    @Autowired
    private ShopAndGoodsInfoService shopService;

    @GetMapping("/list")
    public IshowGoodsInfo getShopsList(@RequestParam(required = false) List<String> keyWords){
        return shopService.getShopList(keyWords);
    }

    @PostMapping("file/upload")
    public List<Object> pubggupload(@RequestParam("file") MultipartFile file) throws Exception {
        String name=file.getOriginalFilename();
        List<Object>list = ExcelUtils.excelToShopIdList(file.getInputStream());
        return list;
    }

    @GetMapping("/shopAndGoods/detail")
    public List<ShopDetailDTO> getDirectDetail(@RequestParam String originalText){
        // 调科大讯飞的接口
        XFResponse response= new XFResponse();
        ltp kdxff = new ltp();
        String key = kdxff.getKey(originalText);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            response = objectMapper.readValue(key, XFResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 查询数据库
        List<ShopDetailDTO> detailDTO = shopService.getShopDetail(response.getData().getKe());
        return detailDTO;
    }

    @GetMapping("/goodsDetail")
    public IshowGoodsInfo getGoodsInfo(@RequestParam Integer id){
        return shopService.selectGoodsDetailById(id);
    }
}

