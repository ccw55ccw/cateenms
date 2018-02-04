package com.hjj.framework.model;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/12/19.
 */
public class ResponseJsonMap extends HashMap<String, Object> {

    private final String success = "isSuccess";

    public ResponseJsonMap(boolean isSuccess){
        init(isSuccess);
    }
    public ResponseJsonMap(){
        init(true);
    }

    public void setIsSuccess(boolean isSuccess){
        put(success, isSuccess);
    }

    private void init(boolean isSuccess){
        this.put(success, isSuccess);
        this.put("_", System.currentTimeMillis());
    }
}
