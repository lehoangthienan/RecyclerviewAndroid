package com.example.lehoa.recyclerview.utility;

import android.app.Activity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;

import com.example.lehoa.recyclerview.R;
import com.example.lehoa.recyclerview.model.Information;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class spannablestring {
    private SpannableString spannableString;
    private String content;
    private Activity context;


    public spannablestring( Activity context , String content) {
        this.content = content;
        this.context = context;
    }

    public void setSpannableString(SpannableString spannableString) {
        this.spannableString = spannableString;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public enum Type {
        hashtag,
        mention,
        link
    }


    public SpannableString getSpannableString() {
        try {
            Pattern mentionPattern = Pattern.compile("(@[A-Za-z0-9_-]+)");
            Pattern hashtagPattern = Pattern.compile("#(\\w+|\\W+)");

            Matcher o = hashtagPattern.matcher(this.content);
            Matcher mention = mentionPattern.matcher(this.content);


            spannableString = new SpannableString(this.content);


            while (o.find()) {

                spannableString.setSpan(new spannablestring.NonUnderlinedClickableSpan(o.group(),
                                spannablestring.Type.hashtag), o.start(), o.end(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            }


            while (mention.find()) {
                spannableString.setSpan(
                        new spannablestring.NonUnderlinedClickableSpan(mention.group(), spannablestring.Type.link), mention.start(), mention.end(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            }

        }
        catch (Exception e){
            Log.d("Error :",e.getMessage());
        }
        return  spannableString;
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

    public String getContent() {
        return content;
    }
}
