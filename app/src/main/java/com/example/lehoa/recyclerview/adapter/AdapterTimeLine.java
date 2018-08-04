package com.example.lehoa.recyclerview.adapter;

import android.app.Activity;
import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lehoa.recyclerview.R;
import com.example.lehoa.recyclerview.model.Information;
import com.luseen.autolinklibrary.AutoLinkMode;
import com.luseen.autolinklibrary.AutoLinkTextView;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdapterTimeLine extends RecyclerView.Adapter<AdapterTimeLine.ViewHolder> {

    private List<Information> objects;
    private Activity context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView imgAvt ;
        public TextView txtTitle  , txtTime , txtContent , txtAdress ;
//        public AutoLinkTextView txtContent;

        public ViewHolder(View view) {
            super(view);
            imgAvt = view.findViewById(R.id.imgAvt);
            txtTitle = view.findViewById(R.id.txtTitle);
            txtContent = view.findViewById(R.id.edtContent);
            txtAdress = view.findViewById(R.id.txtAdress);
            txtTime = view.findViewById(R.id.txtTime);

        }
        public ImageView getAvt() {
            return imgAvt;
        }
        public TextView getTitle() { return txtTitle; }
        public TextView getContent() { return txtContent; }
        public TextView getAdress() { return txtAdress; }
        public TextView getTime() { return txtTime; }
    }

    public AdapterTimeLine(Activity context,List<Information> objects) {
        this.context = context;
        this.objects = objects;

    }
    @NonNull
    @Override
    public AdapterTimeLine.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_timeline, viewGroup, false);

        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.getTitle().setText(objects.get(i).getTitle());
        viewHolder.getAdress().setText(objects.get(i).getAdress());

        try{
            Pattern mentionPattern = Pattern.compile("(@[A-Za-z0-9_-]+)");
            Pattern hashtagPattern = Pattern.compile("#(\\w+|\\W+)");

            Matcher o = hashtagPattern.matcher(objects.get(i).getContent());
            Matcher mention = mentionPattern.matcher(objects.get(i).getContent());


            SpannableString spannableString = new SpannableString(objects.get(i).getContent());
            //#hashtags

            while (o.find()) {

                spannableString.setSpan(new NonUnderlinedClickableSpan(o.group(),
                                0), o.start(), o.end(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            }

            // --- @mention
            while (mention.find()) {
                spannableString.setSpan(
                        new NonUnderlinedClickableSpan(mention.group(), 1), mention.start(), mention.end(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            }

            viewHolder.getContent().setText(spannableString);
            viewHolder.getContent().setMovementMethod(LinkMovementMethod.getInstance());
        }
        catch (Exception e ){
            Toast.makeText(context, "Content have problems",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        try{
            CharSequence ago = DateUtils.getRelativeTimeSpanString(objects.get(i).getDtPost(), System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS);
            viewHolder.getTime().setText(ago);
        }
        catch (Exception e){
            Toast.makeText(context, "Time have problems",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        try{
            Glide.with(context)
                    .asBitmap()
                    .load(objects.get(i).getUrlIamge())
                    .into(viewHolder.getAvt());


        }
        catch (Exception e){
            Toast.makeText(context, "Can not drawable picture",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class NonUnderlinedClickableSpan extends ClickableSpan {

        int type;// 0-hashtag , 1- mention, 2- url link
        String text;// Keyword or url
        String time;

        public NonUnderlinedClickableSpan(String text, int type) {
            this.text = text;
            this.type = type;
            this.time = time;
        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public void updateDrawState(TextPaint ds) {
            //adding colors
            if (type == 1)
                ds.setColor(context.getResources().getColor(
                        R.color.colorAccent));
            else
                ds.setColor(context.getResources().getColor(
                        R.color.colorAccent));
            ds.setUnderlineText(false);
        }
    }
}
