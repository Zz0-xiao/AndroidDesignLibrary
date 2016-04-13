package com.xjp.androidtoolbardemo.tools;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.xjp.androidtoolbardemo.activity.BaseApplication;


public class UiUtils {
    /**
     * ��ȡ���ַ�����
     *
     * @param tabNames �ַ������id
     */
    public static String[] getStringArray(int tabNames) {
        return getResource().getStringArray(tabNames);
    }

    public static Resources getResource() {
        return BaseApplication.getApplication().getResources();
    }

    public static Context getContext() {
        return BaseApplication.getApplication();
    }

    /**
     * dipת��px
     */
    public static int dip2px(int dip) {
        final float scale = getResource().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * pxת��dip
     */

    public static int px2dip(int px) {
        final float scale = getResource().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * ��Runnable �����ύ�����߳�����
     *
     * @param runnable
     */
    public static void runOnUiThread(Runnable runnable) {
        // �����߳�����
        if (android.os.Process.myTid() == BaseApplication.getMainTid()) {
            runnable.run();
        } else {
            //��ȡhandler
            BaseApplication.getHandler().post(runnable);
        }
    }

    public static View inflate(int id) {
        return View.inflate(getContext(), id, null);
    }

    public static Drawable getDrawalbe(int id) {
        return getResource().getDrawable(id);
    }

    public static int getDimens(int homePictureHeight) {
        return (int) getResource().getDimension(homePictureHeight);
    }

    /**
     * �ӳ�ִ�� ����
     *
     * @param run  ����
     * @param time �ӳٵ�ʱ��
     */
    public static void postDelayed(Runnable run, int time) {
        BaseApplication.getHandler().postDelayed(run, time); // ����Runable�����run����
    }

    /**
     * ȡ������
     *
     * @param auToRunTask
     */
    public static void cancel(Runnable auToRunTask) {
        BaseApplication.getHandler().removeCallbacks(auToRunTask);
    }

    /**
     * ���Դ�activity
     *
     * @param intent
     */
//    public static void startActivity(Intent intent) {
//        // �������activity��ȥ��activity  ��Ҫָ������ջ  ��Ҫ���ñ�ǩ
//        if (BaseActivity.activity == null) {
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            getContext().startActivity(intent);
//        } else {
//            BaseActivity.activity.startActivity(intent);
//        }
//    }

}
