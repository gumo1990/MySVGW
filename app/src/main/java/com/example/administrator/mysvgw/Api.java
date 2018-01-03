package com.example.administrator.mysvgw;

/**
 * Created by whq on 2017/12/27.
 * 所有的接口
 */

public class Api {
    public static final String BASE_URL = "http://api.svgouwu.com/";
    public static final String BASE_WWW = "https://www.svgouwu.com/";


    public static final String URL_LOGIN = BASE_URL + "app.php/login"; //登录
    public static final String URL_USER_BASE_INFO = BASE_URL + "app.php/user/userinfo";//用户基本信息
    public static final String URL_USER_BASE_SAVEINFO = BASE_URL + "app.php/user/edituserinfo"; //编辑用户基本信息
    public static final String URL_MODIFY_PWD = BASE_URL + "app.php/user/edituserpassword"; //修改密码
    public static final String URL_MODIFY_EMAIL = BASE_URL + "app.php/user/edituseremail";//修改邮箱
    public static final String URL_SEND_CODE = BASE_URL + "app.php/send"; //发验证码
    public static final String URL_MODIFY_PHONE = BASE_URL + "app.php/user/editusermobile"; //修改手机号

}
