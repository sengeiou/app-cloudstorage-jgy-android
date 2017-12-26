package com.guoyie.www.delivery.easy.application;

import android.app.Application;
import android.util.DisplayMetrics;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.guoyie.www.delivery.easy.entity.Engine;
import com.guoyie.www.delivery.easy.util.DebugUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author：柯军
 * project：CloudManager
 * package：com.chinayie.cloudmanager.application
 * email：774169396@qq.com
 * data：2017/6/21
 */

public class GApp extends Application {
    public static GApp   app;
    public static int    screenWidth;
    public static int    screenHeight;
    private       Engine mEngine;
    public static GApp getInstance() {
        return app;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        initScreenWidth();
      /*  if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...*/

        mEngine = new Retrofit.Builder()
                .baseUrl("http://7xk9dj.com1.z0.glb.clouddn.com/banner/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Engine.class);

        Fresco.initialize(this);

    }


    /**
     * 初始化屏幕宽高
     */
    private void initScreenWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();
        screenHeight = dm.heightPixels;
        screenWidth = dm.widthPixels;
        DebugUtil.v("屏幕宽高", "宽度" + screenWidth + "高度" + screenHeight);
    }

    /**
     *
     * 保存对象
     *
     * @param ser
     * @param file
     * @throws
     */
    public boolean saveObject(Serializable ser, String file) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = openFileOutput(file, MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(ser);
            oos.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
            }
            try {
                fos.close();
            } catch (Exception e) {



            }
        }
    }

    /**
     * 读取对象
     *
     * @param file
     * @return
     * @throws
     */
    public Serializable readObject(String file) {
        if (!isExistDataCache(file))
            return null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = openFileInput(file);
            ois = new ObjectInputStream(fis);
            return (Serializable) ois.readObject();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            e.printStackTrace();
            // 反序列化失败 - 删除缓存文件
            if (e instanceof InvalidClassException) {
                File data = getFileStreamPath(file);
                data.delete();
            }
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
            }
            try {
                fis.close();
            } catch (Exception e) {
            }
        }
        return null;
    }


    /**
     * 判断缓存是否存在
     *
     * @param cachefile
     * @return
     */
    private boolean isExistDataCache(String cachefile) {
        boolean exist = false;
        File data = getFileStreamPath(cachefile);
        if (data.exists())
            exist = true;
        return exist;
    }


    public Engine getEngine() {
        return mEngine;
    }

    public void  deleteObject(String file) throws Exception {
        if (isExistDataCache(file)){
            File data = getFileStreamPath(file);
            data.delete();
        }else {
            throw new Exception("删除对象不存在");
        }
    }
}
