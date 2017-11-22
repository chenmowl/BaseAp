package com.zjwh.baseap;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.squareup.leakcanary.LeakCanary;
import com.zjwh.baseap.injector.component.AppComponent;
import com.zjwh.baseap.injector.component.DaggerAppComponent;
import com.zjwh.baseap.injector.module.AppModule;
import com.zjwh.baseap.injector.module.NetModule;

/**
 * 应用类
 *
 * Created by xbm on 2017/8/31.
 */
public class App extends Application {

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
//                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate);
            }
        });
    }

    private static App app;

    private AppComponent appComponent;

    private static boolean hasCheckVersion;//是否已经检查了版本

    public static boolean isHasCheckVersion() {
        return hasCheckVersion;
    }

    public static void setHasCheckVersion(boolean hasCheckVersion) {
        App.hasCheckVersion = hasCheckVersion;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        app = this;
        appComponent= DaggerAppComponent.builder().appModule(new AppModule()).netModule(new NetModule()).build();
        hasCheckVersion=false;//未检查版本

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base); MultiDex.install(this);
    }

    public static App getAppInstance() {
        return app;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
