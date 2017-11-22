package com.zjwh.baseap;

/**
 * 常量类
 * <p>
 * Created by dijiaoliang on 17/3/20.
 */
public class Constant {

    //空字符串
    public static final String STR_EMPTY = "";

    public static final String STR_ZERO = "0";

    public static final String STR_ONE = "1";

    public static final String STR_TWO = "2";

    //数字0,1
    public static final int MINUS = -1;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int TWENTY = 20;

    //首页一页显示的条目个数
    public static final int PAGE_SIZE = 30;

    public static final int ACTIVITY_NUM_MAX = 7;//页面最高层数,超过此值按回退直接进入主界面

    public static final int DISCOVERY_PAGE_SIZE = 6;


    /***************************  业务常量数据  *****************************/

    public static final String TRANSMIT_ARTICLE = "articleid";

    //petsex 1公 2母
    public static final int PET_SEX_1 = 1;
    public static final int PET_SEX_2 = 2;

    //type：1图片2视频
    public static final String TYPE_PIC = "1";
    public static final String TYPE_VIDEO = "2";

    //大V列表中是否加v标示  0不加  1加
    public static final String V_NOT_ADD = "0";
    public static final String V_ADD = "1";

    //宠物类别：type  0猫1狗2其它
    public static final String PET_CAT = "0";
    public static final String PET_DOG = "1";
    public static final String PET_RABBIT = "2";

    //操作行为：act    add 新建 edit 修改
    public static final String PET_ACT_ADD = "add";
    public static final String PET_ACT_EDIT = "edit";

    //操作行为：  act 1领养 0取消领养
    public static final String PET_ACT_BRING = "1";
    public static final String PET_ACT_BRING_CANCEL = "0";

    //我的消息  type：1领养消息 2取消领养消息
    public static final String PET_MESSAGE_BRING = "1";
    public static final String PET_MESSAGE_BRING_CANCEL = "2";

    //云养状态：  0未云养1已云养 2自己宠物
    public static final String PET_NOT_BRING = "0";
    public static final String PET_HAS_BRING = "1";
    public static final String PET_MY_PET = "2";
    public static final String PET_OTHER_PET = "3";

    //  0未点赞1已点赞
    public static final String PET_NOT_PRAISE = "0";
    public static final String PET_HAS_PRAISE = "1";

    //身份 1主人2云养人
    public static final int IDENTITY_OWNER = 1;
    public static final int IDENTITY_BRING = 2;

    //ispet： 是否有宠物 0无1有
    public static final int HAS_PET = 1;
    public static final int HAS_NO_PET = 0;

    //宠物详情    是否需要铲屎：isshit   0未云养（隐藏）1需要（红色） 2不可铲(灰色)
    public static final String PET_HAS_NOT_BRING = "0";
    public static final String PET_NEET_SHIT = "1";
    public static final String PET_NOT_NEED_SHIT = "2";

    //isshit：可否铲屎  0不可1可以2非云养关系
    public static final int CAN_SHIT = 1;
    public static final int RELATE_NOT_BRING = 2;

    //第三方登陆类型：opentype  1为腾讯QQ，2微博 3为微信
    public static final String LOGIN_QQ = "1";
    public static final String LOGIN_WB = "2";
    public static final String LOGIN_WX = "3";

    //头像上传 类别：type  1用户2宠物
    public static final String HEADER_PEOPLE = "1";
    public static final String HEADER_PET = "2";

    //客户端：platform  0安卓1苹果
    public static final String PLATFORM_IOS = "1";
    public static final String PLATFORM_ANDROID = "0";

    //登陆状态
    public static final int STATUS_LOGIN = 1;
    public static final int STATUS_NOT_LOGIN = 0;

    //四种占位图  square  rectangle  topic topicDetail
    public static final int HOLDER_SQUARE = 1;
    public static final int HOLDER_RECTANGLE = 2;
    public static final int HOLDER_TOPIC = 3;
    public static final int HOLDER_TOPIC_DETAIL = 4;

    //我的消息类型    1、2云养消息3点赞4评论5通知
    public static final String MY_MSG_BRING = "1";
    public static final String MY_MSG_BRING2 = "2";
    public static final String MY_MSG_PRAISE = "3";
    public static final String MY_MSG_COMMENT = "4";
    public static final String MY_MSG_NOTICE = "5";

    //清空消息的类型 type：1云养消息3点赞 4评论
    public static final String MESSAGE_TYPE_BRING = "1";
    public static final String MESSAGE_TYPE_PRAISE = "3";
    public static final String MESSAGE_TYPE_COMMENT = "4";


    //type 1  云养消息推送
    public static final String TYPE_MESSAGE = "1";

    //pet image flag标记
    public static final String PET_HEADER_IMAGE = "PET_HEADER_IMAGE";

    public static final String UPDATE_USERNAME = "UPDATE_USERNAME";//修改昵称标记
    public static final String COMMENT_NUM = "COMMENT_NUM";//评论个数标记
    public static final String COMMENT_BEAN_ARRAY = "COMMENT_BEAN_ARRAY";//评论实体数组
    public static final String INTEGRAL_VALUE = "INTEGRAL_VALUE";//评论个数标记

    public static final String PET_ID = "PET_ID";
    public static final String USER_ID = "USER_ID";

    public static final String CODE = "CODE";//微信请求token的code

    public static final String CATS = "cats";//token加密的内容

    public static final String SHARE_NAME = "小宝宝";//分享
    public static final String SHARE_TITLE_BEFORE = "【";//分享
    public static final String SHARE_TITLE_AFTER = "】的萌宠正在卖萌，铲屎官们快来围观哦!";//分享
    public static final String SHARE_CONTENT = "喜欢萌宠的朋友快来看!";//分享

    public static final int ACTIVITY_PUBLISH_VIDEO_FLAG = 1010;

    /***************************  页面跳转参数标记  *****************************/

    public static final String FLAG_HAS_PET = "FLAG_HAS_PET";

    //跳转帖子评论详情
    public static final String FLAG_ARTICLEID = "FLAG_ARTICLEID";//帖子id
    public static final String FLAG_REPLYID = "FLAG_REPLYID";//评论id

    /***************************  页面跳转请求码  *****************************/
    //页面跳转请求码
    public static final int REQUEST_PET_COMMENT = 1001;//评论列表

    public static final int REQUEST_CODE_USERNAME = 1002;
    //请求相机
    public static final int REQUEST_CAPTURE = 100;
    //请求相册
    public static final int REQUEST_PICK = 101;
    //请求截图
    public static final int REQUEST_CROP_PHOTO = 102;

    /***************************  网络常量数据  *****************************/
    //接口状态码：code 1为请求成功， 0 为请求失败，如果失败则 info 字段为提示信息
    public static final int CODE_COMPLETE = 1;
    public static final int CODE_FAILURE = 0;


    /***************************  刷新常量数据  *****************************/

    public static final int REFRESH_NORMAL = 1;//正常刷新
    public static final int REFRESH_UP_LOADMORE = 2;//上拉加载更多
    public static final int REFRESH_DOWN = 3;//下拉刷新

    /***************************  版本校验参数  *****************************/

    public static final String username = "admin";
    public static final String password = "123456";

}
