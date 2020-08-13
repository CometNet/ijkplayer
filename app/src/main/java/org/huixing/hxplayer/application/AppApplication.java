package org.huixing.hxplayer.application;

import android.app.Application;
import android.os.Environment;

import org.huixing.hxplayer.utils.Utils;

import java.io.File;

public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        initECarXLog();
    }

    private void initECarXLog() {

        String packageName = getPackageName();
        String xsfCarLifeLogPath = "xsf/log/" + packageName;       // 所有日志文件存放到统一根目录下，便于收集，同时按照应用分子目录存放，必要时按应用内功能模块划分
        File carlifeLogDir = new File(Environment.getExternalStorageDirectory(), xsfCarLifeLogPath);

    }


}
