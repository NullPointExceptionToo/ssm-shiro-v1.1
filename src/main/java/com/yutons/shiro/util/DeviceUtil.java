package com.yutons.shiro.util;

/**
 * @title: DeviceUtil
 * @Author fq
 * @Date: 2022/4/10 12:56
 * @Version 1.0
 */
public class DeviceUtil {
    //定义移动端请求的所有可能类型
    private final static String[] agent = { "Android", "iPhone", "iPod","iPad", "Windows Phone", "MQQBrowser" };
    /**
     * 判断请求是否来自移动端
     * @param ua
     * @return
     */
    public static boolean isMobileEdvice(String ua) {
        boolean flag = false;
        if (!ua.contains("Windows NT") || (ua.contains("Windows NT") && ua.contains("compatible; MSIE 9.0;"))) {
            // 排除 苹果桌面系统
            if (!ua.contains("Windows NT") && !ua.contains("Macintosh")) {
                for (String item : agent) {
                    if (ua.contains(item)) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }
}
