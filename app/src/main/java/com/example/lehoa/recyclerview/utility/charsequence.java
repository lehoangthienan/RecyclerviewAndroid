package com.example.lehoa.recyclerview.utility;

import android.text.format.DateUtils;
import android.util.Log;

public class charsequence {
    private CharSequence ago;
    private Long time ;

    public charsequence(Long time) {
        this.time = time;
    }

    public CharSequence getAgo() {
        return ago;
    }

    public Long getTime() {
        return time;
    }

    public void setAgo(CharSequence ago) {
        this.ago = ago;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public  CharSequence getCharSequence(){
        try{
            ago = DateUtils.getRelativeTimeSpanString(time, System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS);
        }
        catch (Exception e){
            Log.d("Error :",e.getMessage());
        }
        return ago ;
    }
}
