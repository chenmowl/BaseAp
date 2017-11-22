package com.zjwh.baseap.injector.component;


import com.zjwh.baseap.injector.ActivityScope;
import com.zjwh.baseap.injector.module.ViewModule;

import dagger.Component;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ViewModule.class)
public interface ViewComponent {

//    void inject(HomeActivity homeActivity);



}
