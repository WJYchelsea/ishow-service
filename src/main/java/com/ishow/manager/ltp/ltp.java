package com.ishow.manager.ltp;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class ltp {
	// webapi接口地址
	private static final String WEBTTS_URL = "http://ltpapi.xfyun.cn/v1/ke";
	// 应用ID
	private static final String APPID = "5dabdca7";
	// 接口密钥
	private static final String API_KEY = "3935908b04598960081290c1e6fe438c";
	// 文本
	private static final String TEXT = "我要买两间大房子";


	private static final String TYPE = "dependent";

	/**
	 * 调科大讯飞获取key word
	 * @return
	 */
	public String getKey(String text){
		Map<String, String> header = null;
		String result = "";
		try {
			header = buildHttpHeader();
			result = HttpUtil.doPost1(WEBTTS_URL, header, "text=" + URLEncoder.encode(text, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			log.error("调用讯飞平台异常{} ",e.getMessage());
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		System.out.println(TEXT.length());
		Map<String, String> header = buildHttpHeader();
		String result = HttpUtil.doPost1(WEBTTS_URL, header, "text=" + URLEncoder.encode(TEXT, "utf-8"));
		System.out.println("itp 接口调用结果：" + result);
	}

	/**
	 * 组装http请求头
	 */
	private static Map<String, String> buildHttpHeader() throws UnsupportedEncodingException {
		String curTime = System.currentTimeMillis() / 1000L + "";
		String param = "{\"type\":\"" + TYPE +"\"}";
		String paramBase64 = new String(Base64.encodeBase64(param.getBytes("UTF-8")));
		String checkSum = DigestUtils.md5Hex(API_KEY + curTime + paramBase64);
		Map<String, String> header = new HashMap<String, String>();
		header.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
		header.put("X-Param", paramBase64);
		header.put("X-CurTime", curTime);
		header.put("X-CheckSum", checkSum);
		header.put("X-Appid", APPID);
		return header;
	}
}
