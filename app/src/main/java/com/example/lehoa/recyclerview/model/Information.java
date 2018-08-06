package com.example.lehoa.recyclerview.model;

import android.app.Activity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.format.DateUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lehoa.recyclerview.MainActivity;
import com.example.lehoa.recyclerview.R;
import com.example.lehoa.recyclerview.adapter.AdapterTimeLine;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Information {
    private String title , content , adress , urlIamge ;
    private long dtPost ;
    private Activity context ;
    private SpannableString spannableString;
    private CharSequence ago;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Information() {
    }

    public String getAdress() {
        return adress;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setUrlIamge(String urlIamge) {
        this.urlIamge = urlIamge;
    }

    public void setDtPost(long dtPost) {
        this.dtPost = dtPost;
    }

    public String getUrlIamge() {
        return urlIamge;
    }

    public long getDtPost() {
        return dtPost;
    }

    public Information(String title, String content, String adress, String urlIamge, long dtPost) {
        this.title = title;
        this.content = content;
        this.adress = adress;
        this.urlIamge = urlIamge;
        this.dtPost = dtPost;
    }
    public  CharSequence getCharSequence(){
        try{
            ago = DateUtils.getRelativeTimeSpanString(this.getDtPost(), System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS);
        }
        catch (Exception e){
            Log.d("Error :",e.getMessage());
        }
        return ago ;
    }

    public SpannableString getSpannable (Activity context) {
        this.context=context;
        try {
            Pattern mentionPattern = Pattern.compile("(@[A-Za-z0-9_-]+)");
            Pattern hashtagPattern = Pattern.compile("#(\\w+|\\W+)");

            Matcher o = hashtagPattern.matcher(this.content);
            Matcher mention = mentionPattern.matcher(this.content);


            spannableString = new SpannableString(this.content);


            while (o.find()) {

                spannableString.setSpan(new NonUnderlinedClickableSpan(o.group(),
                                Type.hashtag), o.start(), o.end(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            }


            while (mention.find()) {
                spannableString.setSpan(
                        new NonUnderlinedClickableSpan(mention.group(), Type.link), mention.start(), mention.end(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            }

        }
        catch (Exception e){
            Log.d("Error :",e.getMessage());
        }
        return  spannableString;
    }

    public enum Type {
        hashtag,
        mention,
        link
    }

    public class NonUnderlinedClickableSpan extends ClickableSpan {
        Type type ;
        String text;// Keyword or url
        String time;

        public NonUnderlinedClickableSpan(String text, Type type) {
            this.text = text;
            this.type = type;
            this.time = time;
        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public void updateDrawState(TextPaint ds) {
            if (type == type.hashtag)
                ds.setColor(context.getResources().getColor(
                        R.color.colorAccent));
            else
                ds.setColor(context.getResources().getColor(
                        R.color.colorAccent));
            ds.setUnderlineText(false);
        }
    }
}
