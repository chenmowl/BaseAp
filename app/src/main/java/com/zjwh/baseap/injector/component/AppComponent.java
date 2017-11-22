package com.zjwh.baseap.injector.component;


import com.zjwh.baseap.App;
import com.zjwh.baseap.injector.module.AppModule;
import com.zjwh.baseap.injector.module.NetModule;
import com.zjwh.baseap.model.net.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dijiaoliang on 17/3/6.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

    RetrofitHelper getRetrofitHelper();

    App provideApp();

}
