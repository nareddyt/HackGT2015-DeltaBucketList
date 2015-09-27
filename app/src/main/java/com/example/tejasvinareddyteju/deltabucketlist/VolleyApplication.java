package com.example.tejasvinareddyteju.deltabucketlist;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Tejasvi on 9/26/2015.
 */
class VolleyApplication extends Application {

    private static VolleyApplication sInstance;

    private RequestQueue mRequestQueue;

    public synchronized static VolleyApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mRequestQueue = Volley.newRequestQueue(this);

        sInstance = this;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }


}
