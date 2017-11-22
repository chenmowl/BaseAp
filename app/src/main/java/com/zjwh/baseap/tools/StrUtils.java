package com.zjwh.baseap.tools;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * xbm工具类
 *
 * Created by xbm on 2017/7/24.
 */
public class StrUtils {

    private static final String NULL_LOWER = "null";
    private static final String NULL_UP = "NULL";


    public static boolean isEmpty(@Nullable CharSequence str) {
        if (str == null || str.length() == 0 || NULL_LOWER.equals(str) || NULL_UP.equals(str))
            return true;
        else
            return false;
    }

    /**
     * 从asset中获取json字符串
     * @param context
     * @param fileName
     * @return
     */
    public static String getJsonFromAsset(Context context, String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
