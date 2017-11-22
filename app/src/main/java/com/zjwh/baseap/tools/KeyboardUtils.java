package com.zjwh.baseap.tools;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/8/2
 *     desc  : 键盘相关工具类
 * </pre>
 */
public class KeyboardUtils {

    private KeyboardUtils() {
        throw new UnsupportedOperationException("u can't fuck me...");
    }

    /**
     * 避免输入法面板遮挡
     * <p>在manifest.xml中activity中设置</p>
     * <p>android:windowSoftInputMode="stateVisible|adjustResize"</p>
     */

    /**
     * 动态隐藏软键盘
     *
     * @param activity activity
     */
    public static void hideSoftInput(Activity activity) {
        View view = activity.getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) activity
                    .getSystemService(INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * 动态隐藏软键盘
     *
     * @param context 上下文
     * @param edit    输入框
     */
    public static void hideSoftInput(Context context, EditText edit) {
        edit.clearFocus();
        InputMethodManager inputmanger = (InputMethodManager) context
                .getSystemService(INPUT_METHOD_SERVICE);
        inputmanger.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }

    /**
     * 点击屏幕空白区域隐藏软键盘（方法1）
     * <p>在onTouch中处理，未获焦点则隐藏</p>
     * <p>参照以下注释代码</p>
     */
    public static void clickBlankArea2HideSoftInput0() {
        Log.i("tips", "U should copy the following code.");
        /*
        @Override
        public boolean onTouchEvent (MotionEvent event){
            if (null != this.getCurrentFocus()) {
                InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
            }
            return super.onTouchEvent(event);
        }
        */
    }

    /**
     * 点击屏幕空白区域隐藏软键盘（方法2）
     * <p>根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘</p>
     * <p>需重写dispatchTouchEvent</p>
     * <p>参照以下注释代码</p>
     */
    public static void clickBlankArea2HideSoftInput1() {
        Log.i("tips", "U should copy the following code.");
        /*
        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                View v = getCurrentFocus();
                if (isShouldHideKeyboard(v, ev)) {
                    hideKeyboard(v.getWindowToken());
                }
            }
            return super.dispatchTouchEvent(ev);
        }

        // 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
        private boolean isShouldHideKeyboard(View v, MotionEvent event) {
            if (v != null && (v instanceof EditText)) {
                int[] l = {0, 0};
                v.getLocationInWindow(l);
                int left = l[0],
                        top = l[1],
                        bottom = top + v.getHeight(),
                        right = left + v.getWidth();
                return !(event.getX() > left && event.getX() < right
                        && event.getY() > top && event.getY() < bottom);
            }
            return false;
        }

        // 获取InputMethodManager，隐藏软键盘
        private void hideKeyboard(IBinder token) {
            if (token != null) {
                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        */
    }

    /**
     * 动态显示软键盘
     *
     * @param context 上下文
     * @param edit    输入框
     */
    public static void showSoftInput(Context context, EditText edit) {
        edit.setFocusable(true);
        edit.setFocusableInTouchMode(true);
        edit.requestFocus();
        InputMethodManager inputManager = (InputMethodManager) context
                .getSystemService(INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(edit, 0);
    }

    /**
     * 切换键盘显示与否状态
     *
     * @param context 上下文
     * @param edit    输入框
     */
    public static void toggleSoftInput(Context context, EditText edit) {
        edit.setFocusable(true);
        edit.setFocusableInTouchMode(true);
        edit.requestFocus();
        InputMethodManager inputManager = (InputMethodManager) context
                .getSystemService(INPUT_METHOD_SERVICE);
        inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    /**
     * 强制关闭软键盘
     * @param context
     * @param dialog
     */
    public static void forceCloseSoftInput(Context context, Dialog dialog){
        InputMethodManager mInputMethodManager = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        mInputMethodManager.hideSoftInputFromWindow(dialog.getCurrentFocus().getWindowToken(), 0);
    }

    /**
     * des:隐藏软键盘,这种方式参数为activity
     *
     * @param activity
     */
    public static void hideInputForce(Activity activity) {
        if (activity == null || activity.getCurrentFocus() == null)
            return;

        ((InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(activity.getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 修复inputmethodmanager导致内存泄漏的问题
     * @param destContext
     */
    public static void fixInputMethodManagerLeak(Context destContext) {
        if (destContext == null) {
            return;
        }

        InputMethodManager imm = (InputMethodManager) destContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }

        String[] arr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
        Field f = null;
        Object obj_get = null;
        for (int i = 0;i < arr.length;i ++) {
            String param = arr[i];
            try{
                f = imm.getClass().getDeclaredField(param);
                if (f.isAccessible() == false) {
                    f.setAccessible(true);
                } // author: sodino mail:sodino@qq.com
                obj_get = f.get(imm);
                if (obj_get != null && obj_get instanceof View) {
                    View v_get = (View) obj_get;
                    if (v_get.getContext() == destContext) { // 被InputMethodManager持有引用的context是想要目标销毁的
                        f.set(imm, null); // 置空，破坏掉path to gc节点
                    } else {
                        // 不是想要目标销毁的，即为又进了另一层界面了，不要处理，避免影响原逻辑,也就不用继续for循环了
//                        if (QLog.isColorLevel()) {
//                            QLog.d(ReflecterHelper.class.getSimpleName(), QLog.CLR, "fixInputMethodManagerLeak break, context is not suitable, get_context=" + v_get.getContext()+" dest_context=" + destContext);
//                        }
                        break;
                    }
                }
            }catch(Throwable t){
                t.printStackTrace();
            }
        }
    }

    /**
     * 处理内存泄漏  inputmethodmanager
     * @param application
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void fixFocusedViewLeak(Application application) {

        // Don't know about other versions yet.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1|| Build.VERSION.SDK_INT > 23) {
            return;
        }

        final InputMethodManager inputMethodManager =
                (InputMethodManager) application.getSystemService(Context.INPUT_METHOD_SERVICE);

        final Field mServedViewField;
        final Field mHField;
        final Method finishInputLockedMethod;
        final Method focusInMethod;
        try {
            mServedViewField = InputMethodManager.class.getDeclaredField("mServedView");
            mServedViewField.setAccessible(true);
            mHField = InputMethodManager.class.getDeclaredField("mServedView");
            mHField.setAccessible(true);
            finishInputLockedMethod = InputMethodManager.class.getDeclaredMethod("finishInputLocked");
            finishInputLockedMethod.setAccessible(true);
            focusInMethod = InputMethodManager.class.getDeclaredMethod("focusIn", View.class);
            focusInMethod.setAccessible(true);
        } catch (NoSuchMethodException | NoSuchFieldException unexpected) {
            Log.e("IMMLeaks", "Unexpected reflection exception", unexpected);
            return;
        }

        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityDestroyed(Activity activity){

            }

            @Override
            public void onActivityStarted(Activity activity){

            }

            @Override
            public void onActivityResumed(Activity activity){

            }

            @Override
            public void onActivityPaused(Activity activity){

            }

            @Override
            public void onActivityStopped(Activity activity){

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle){

            }

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                ReferenceCleaner cleaner = new ReferenceCleaner(inputMethodManager, mHField, mServedViewField,
                        finishInputLockedMethod);
                View rootView = activity.getWindow().getDecorView().getRootView();
                ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                viewTreeObserver.addOnGlobalFocusChangeListener(cleaner);
            }
        });
    }

    static class ReferenceCleaner
            implements MessageQueue.IdleHandler, View.OnAttachStateChangeListener,
            ViewTreeObserver.OnGlobalFocusChangeListener {

        private final InputMethodManager inputMethodManager;
        private final Field mHField;
        private final Field mServedViewField;
        private final Method finishInputLockedMethod;

        ReferenceCleaner(InputMethodManager inputMethodManager, Field mHField, Field mServedViewField,
                         Method finishInputLockedMethod) {
            this.inputMethodManager = inputMethodManager;
            this.mHField = mHField;
            this.mServedViewField = mServedViewField;
            this.finishInputLockedMethod = finishInputLockedMethod;
        }

        @Override
        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
            if (newFocus == null) {
                return;
            }
            if (oldFocus != null) {
                oldFocus.removeOnAttachStateChangeListener(this);
            }
            Looper.myQueue().removeIdleHandler(this);
            newFocus.addOnAttachStateChangeListener(this);
        }

        @Override
        public void onViewAttachedToWindow(View v) {
        }

        @Override
        public void onViewDetachedFromWindow(View v) {
            v.removeOnAttachStateChangeListener(this);
            Looper.myQueue().removeIdleHandler(this);
            Looper.myQueue().addIdleHandler(this);
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public boolean queueIdle() {
            clearInputMethodManagerLeak();
            return false;
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        private void clearInputMethodManagerLeak() {
            try {
                Object lock = mHField.get(inputMethodManager);
                // This is highly dependent on the InputMethodManager implementation.
                synchronized (lock) {
                    View servedView = (View) mServedViewField.get(inputMethodManager);
                    if (servedView != null) {

                        boolean servedViewAttached = servedView.getWindowVisibility() != View.GONE;

                        if (servedViewAttached) {
                            // The view held by the IMM was replaced without a global focus change. Let's make
                            // sure we get notified when that view detaches.

                            // Avoid double registration.
                            servedView.removeOnAttachStateChangeListener(this);
                            servedView.addOnAttachStateChangeListener(this);
                        } else {
                            // servedView is not attached. InputMethodManager is being stupid!
                            Activity activity = extractActivity(servedView.getContext());
                            if (activity == null || activity.getWindow() == null) {
                                // Unlikely case. Let's finish the input anyways.
                                finishInputLockedMethod.invoke(inputMethodManager);
                            } else {
                                View decorView = activity.getWindow().peekDecorView();
                                boolean windowAttached = decorView.getWindowVisibility() != View.GONE;
                                if (!windowAttached) {
                                    finishInputLockedMethod.invoke(inputMethodManager);
                                } else {
                                    decorView.requestFocusFromTouch();
                                }
                            }
                        }
                    }
                }
            } catch (IllegalAccessException |InvocationTargetException unexpected) {
                Log.e("IMMLeaks", "Unexpected reflection exception", unexpected);
            }
        }

        private Activity extractActivity(Context context) {
            while (true) {
                if (context instanceof Application) {
                    return null;
                } else if (context instanceof Activity) {
                    return (Activity) context;
                } else if (context instanceof ContextWrapper) {
                    Context baseContext = ((ContextWrapper) context).getBaseContext();
                    // Prevent Stack Overflow.
                    if (baseContext == context) {
                        return null;
                    }
                    context = baseContext;
                } else {
                    return null;
                }
            }
        }
    }

}