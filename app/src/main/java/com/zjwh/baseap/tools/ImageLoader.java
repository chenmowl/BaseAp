package com.zjwh.baseap.tools;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * Created by codeest on 2016/8/2.
 */
public class ImageLoader {

    public static void load(Context context, String url, ImageView iv) {    //使用Glide加载圆形ImageView(如头像)时，不要使用占位图
        if (context != null)
            Glide.with(context).load(url).into(iv);
//            Glide.with(context).load(url).error(R.drawable.dongman5).crossCrop().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
    }

//    public static void load(Activity activity, String url, ImageView iv) {    //使用Glide加载圆形ImageView(如头像)时，不要使用占位图
//        if (activity != null)
//            Glide.with(activity).load(url).into(iv);
////            Glide.with(activity).load(url).error(R.drawable.dongman5).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
//    }

    /**
     * type目前包含四种占位图  square  rectangle  topic topicDetail
     * <p>
     * int HOLDER_SQUARE = 1;
     * int HOLDER_RECTANGLE = 2;
     * int HOLDER_TOPIC = 3;
     * int HOLDER_TOPIC_DETAIL = 4;
     *
     * @param context
     * @param url
     * @param iv
     * @param type
     */
//    public static void load(Context context, String url, ImageView iv, int type) {    //使用Glide加载圆形ImageView(如头像)时，不要使用占位图
//        if (context != null) {
//            switch (type) {
//                case Constant.HOLDER_SQUARE:
//                    Glide.with(context).load(url).apply(a.option.placeholder(R.mipmap.holder_square)).into(iv);
//                    break;
//                case Constant.HOLDER_RECTANGLE:
//                    Glide.with(context).load(url).apply(a.option.placeholder(R.mipmap.holder_rectangle)).into(iv);
//                    break;
//                case Constant.HOLDER_TOPIC:
//                    Glide.with(context).load(url).apply(a.option.placeholder(R.mipmap.holder_topic)).into(iv);
//                    break;
//                case Constant.HOLDER_TOPIC_DETAIL:
//                    Glide.with(context).load(url).apply(a.option.placeholder(R.mipmap.holder_topic_detail)).into(iv);
//                    break;
//            }
//        }
//    }

//    private static class a {
//        public static final RequestOptions option = new RequestOptions();
//    }

}
