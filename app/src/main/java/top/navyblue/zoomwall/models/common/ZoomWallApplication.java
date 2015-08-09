package top.navyblue.zoomwall.models.common;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by CIR on 8/2/15.
 */
public class ZoomWallApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();

        init();
    }

    private void init() {
        Fresco.initialize(mContext);
    }

    public static Context getContext(){
        return mContext;
    }
}
