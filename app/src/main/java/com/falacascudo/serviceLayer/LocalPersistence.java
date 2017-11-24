package com.falacascudo.serviceLayer;

import android.content.Context;

import com.falacascudo.dataLayer.LocalDataBase;
import com.falacascudo.models.FeedBack;

/**
 * Created by carlos on 18/10/2017.
 */

public class LocalPersistence {
    LocalDataBase localDataBase = new LocalDataBase();

    public void insertFeedBack(Context context, FeedBack feedBack){

        localDataBase.setConext(context);
        localDataBase.insert(feedBack);
    }
}
