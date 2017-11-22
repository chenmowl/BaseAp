package com.zjwh.baseap.model.net;


import com.zjwh.baseap.App;

import java.io.File;

/**
 * net
 *
 * Created by dijiaoliang on 17/3/2.
 */
public final class ApiConfig {

    //主机名
    public static final String API_HOST="https://cats.big2333.com";//萌宠秀
    public static final String QINIU_HOST="https://qiniu.big2333.com";
    public static final String PIC_HOST="";//图片的主地址
//    public static final String PIC_HOST="https://cunchu.big2333.com/";//图片的主地址

    //测试版的主路径
//    public static final String API_HOST="http://test.big2333.com";//萌宠秀

    //版本更新
    public static final String VERSION_CHECK_URL = "https://cats.big2333.com/index.php?m=UsersApi&a=version&version_name=";
//    public static final String VERSION_CHECK_URL = "http://192.168.50.218/xbz-manage/device/getAndroidVersionUpdate?username=admin&password=123456";

    public static final String SHARE_PAGE_URL="https://cats.big2333.com/index.php?m=List&a=article_info&id=";

    //正式发布时要做修改
    public static final boolean DEBUG = Boolean.parseBoolean("false");

    public static final String PATH_DATA = App.getAppInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

}
