package com.yutons.shiro.web.controller.admin;

import com.yutons.shiro.util.OcrUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * @title: CommonController
 * @Author fq
 * @Date: 2022/4/4 11:29
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/common")
public class CommonController {

    @RequestMapping(value = "/upload/{type}", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject upload(HttpServletRequest request, @PathVariable("type") String type) {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
        JSONObject obj = null;
        MultipartFile file = req.getFile(req.getFileNames().next());
        try(InputStream inputStream = file.getInputStream()){
            obj = OcrUtil.ocrDeal(inputStream, type);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
