package com.zjwh.baseap.model.sp;

/**
 * Created by zhangxiaoming on 16/6/15.
 */
public class SpConstant {

    /**
     * 登录状态
     */
    public static final String LOGIN_FILE = "LoginState";

    public static final String LOGIN_STATUS = "LoginState";

    /**
     * 微信信息
     * <p>
     * access_token	接口调用凭证
     * expires_in	access_token接口调用凭证超时时间，单位（秒）
     * refresh_token	用户刷新access_token
     * openid	授权用户唯一标识
     * scope	用户授权的作用域，使用逗号（,）分隔
     *
     * <p>
     * openid	普通用户的标识，对当前开发者帐号唯一
     * nickname	普通用户昵称
     * sex	普通用户性别，1为男性，2为女性
     * province	普通用户个人资料填写的省份
     * city	普通用户个人资料填写的城市
     * country	国家，如中国为CN
     * headimgurl	用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
     * privilege	用户特权信息，json数组，如微信沃卡用户为（chinaunicom）
     * unionid	用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的。
     */
    public static final String WX_USER_FILE = "WX_USER_FILE";

    //微信服务器返回的数据
    public static final String access_token = "access_token";
    public static final String refresh_token = "refresh_token";
    public static final String openid = "openid";
    public static final String scope = "scope";

    public static final String user_openid = "user_openid";
    public static final String nickname = "nickname";
    public static final String sex = "sex";
    public static final String province = "province";
    public static final String city = "city";
    public static final String country = "country";
    public static final String headimgurl = "headimgurl";//微信服务器上的用户头像
    public static final String privilege = "privilege";
    public static final String unionid = "unionid";

    //震惊服务器上的信息
    public static final String userid = "userid";
    public static final String token = "token";
    public static final String icon = "icon";//震惊服务器上的用户头像
    public static final String pid = "pid";


    /**
     * 极光推送
     */
    public static final String JPUSH_FILE = "JPUSH_FILE";

    public static final String HAS_CUSTOME_MESSAGE = "HAS_MESSAGE";//是否收到自定义消息
}
