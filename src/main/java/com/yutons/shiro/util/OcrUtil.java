package com.yutons.shiro.util;

import net.sf.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.*;
import org.springframework.util.StringUtils;


/**
 * @title: OcrUtil
 * @Author fq
 * @Date: 2022/4/4 15:56
 * @Version 1.0
 */
public class OcrUtil {
    /**
     * 图片文字识别
     * @param input
     * @return
     */
    public static JSONObject ocrDeal(InputStream input, String type) {
        JSONObject obj = null;
        try{
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential("AKIDxjFVUBdoiMkrgEWXHkvwg8JDqDJ8gxxi", "VP2OUJq65nENFqAE0WljQs2xb3E7j48v");
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("ocr.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            OcrClient client = new OcrClient(cred, "ap-beijing", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            RecognizeTableOCRRequest req = new RecognizeTableOCRRequest();
            int available = input.available();
            byte[] array = new byte[available];
            input.read(array);
            String encode = java.util.Base64.getEncoder().encodeToString(array);
            req.setImageBase64(encode);
            // 返回的resp是一个RecognizeTableOCRResponse的实例，与请求对象对应
            RecognizeTableOCRResponse resp = client.RecognizeTableOCR(req);
            obj = resolve(resp, type);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static JSONObject resolve(RecognizeTableOCRResponse resp, String type) {
        Map<String, String> quotaMap = QuotaUtil.typeMap.get(type);
        JSONObject object = new JSONObject();
        TableDetectInfo[] tableDetections = resp.getTableDetections();
        if(tableDetections != null && tableDetections.length > 1) {
            TableDetectInfo tableDetection = tableDetections[1];
            TableCell[] cells = tableDetection.getCells();
            int i = 0;
            while(i < cells.length) {
                String text = cells[i].getText();
                String[] s = text.split(" ");
                String code = s[s.length-1];
                String[] split = code.split("\\.");
                if(split.length > 0) {
                    code = split[0];
                }
                String key = quotaMap.get(code);
                if(!StringUtils.isEmpty(key)) {
                    String value = cells[i+1].getText();
                    String v = value.split(" ")[0];
                    if(!"".equals(v) && !"-".equals(v) && v.indexOf("/") == -1) {
                        object.put(key, v);
                    }
                    i++;
                }
                i++;
            }

        }
        return object;

    }

}
