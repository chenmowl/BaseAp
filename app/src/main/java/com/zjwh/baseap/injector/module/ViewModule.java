package com.zjwh.baseap.injector.module;


import com.zjwh.baseap.base.BaseView;
import com.zjwh.baseap.injector.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@Module
public class ViewModule {

    private BaseView view;

    public ViewModule(BaseView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BaseView getView() {
        return view;
    }
}
