package com.zjwh.baseap.model.net;


import com.zjwh.baseap.model.net.api.PetShowApi;


/**
 * Created by dijiaoliang on 17/3/6.
 */
public class RetrofitHelper {

    private PetShowApi petShowApi;

    public RetrofitHelper(PetShowApi petShowApi) {
        this.petShowApi = petShowApi;
    }

    /**
     * 1、获取首页中的大v列表
     *
     * @return
     */
//    public Observable<HomeVipListResult> vipListData() {
//        return petShowApi.vipListData();
//    }


}
