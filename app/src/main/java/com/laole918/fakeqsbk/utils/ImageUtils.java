package com.laole918.fakeqsbk.utils;

import com.laole918.fakeqsbk.model.User;

/**
 * Created by laole918 on 2016/1/3.
 */
public class ImageUtils {
    //http://pic.qiushibaike.com/system/avtnew/2938/29383534/thumb/20150719213920.jpg
    private static String pic = "http://pic.qiushibaike.com";
    private static String avtnew = "/system/avtnew";
    private static String thumb = "/thumb";

    public static String getUserIconUri(User u) {
        if(u != null && u.getId() > 0 && u.getIcon() != null) {
            String id = String.valueOf(u.getId());
            String icon = u.getIcon();
            String id_path = id.substring(0, id.length() - 4);
            id_path = "/" + id_path + "/" + id;
            String icon_path = "/" + icon;
            return pic + avtnew + id_path + thumb + icon_path;
        }
        return null;
    }
}
