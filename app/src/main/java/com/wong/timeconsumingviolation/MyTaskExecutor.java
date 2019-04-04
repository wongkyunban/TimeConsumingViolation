package com.wong.timeconsumingviolation;

import android.os.StrictMode;
import android.os.SystemClock;

/**
 * @author WongKyunban
 * description
 * created at 2019-04-04 下午8:12
 * @version 1.0
 */
public class MyTaskExecutor {
    public static long CAN_BEAR_TIME = 500;
    public void execute(Runnable task){
        long sTime = SystemClock.uptimeMillis();
        task.run();
        long cTime = SystemClock.uptimeMillis() - sTime;
        if(cTime > CAN_BEAR_TIME){
            StrictMode.noteSlowCall("slow call cost:"+cTime);
        }
    }
}
