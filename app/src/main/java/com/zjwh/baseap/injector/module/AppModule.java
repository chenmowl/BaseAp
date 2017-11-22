package com.zjwh.baseap.injector.module;


import com.zjwh.baseap.App;
import com.zjwh.baseap.model.net.RetrofitHelper;
import com.zjwh.baseap.model.net.api.PetShowApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    App provideApp() {
        return App.getAppInstance();
    }

    @Singleton
    @Provides
    RetrofitHelper provideRetrofitHelper(PetShowApi petShowApi) {
        return new RetrofitHelper(petShowApi);
    }

}
