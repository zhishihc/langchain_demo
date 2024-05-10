package com.mall.filter;

import com.sun.org.apache.xpath.internal.objects.XString;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/6/1 2:19 下午
 */
public class UrlFilter {
    private static final String nointerceterurl = "/api/user/login,/api/user/add";
    /**
     * 用来判断 如果 当前的请求 在 放行的请求中存在,(不需要拦截 :true,否则需要拦截:false)
     *
     * @return
     */
    public static boolean hasAutorize(String uri) {
        String[] split = nointerceterurl.split(",");

        for (String s : split) {
            if (s.equals(uri)) {
                //不需要拦截
                return true;
            }
        }

        //要拦截
        return false;
    }

}
