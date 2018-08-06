package com.example.lehoa.recyclerview;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lehoa.recyclerview.adapter.AdapterTimeLine;
import com.example.lehoa.recyclerview.model.Information;

import java.util.ArrayList;
import java.util.Date;
import android.support.design.widget.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcTimeLine ;
    public static ArrayList<Information> listTimeLine = new ArrayList<>();
    AdapterTimeLine adapterTimeLine;
    FloatingActionButton fab;
    String linkPicture = "https://zmp3-photo.zadn.vn/thumb/240_240/avatars/4/3/43d8be33dc00a33132c82adb9d0d3a54_1509355224.jpg";
    String contents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        addcontrols();
        addevents();
    }

    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void addevents() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this ,CreateFeedActivity.class);
                i.putExtra("url" , linkPicture);
                startActivity(i);
            }
        });
    }

    private void addcontrols() {
        fab = findViewById(R.id.fab);
        rcTimeLine = findViewById(R.id.rcTimeLine);
        rcTimeLine.setHasFixedSize(true);

        addData();


        adapterTimeLine = new AdapterTimeLine(this ,listTimeLine);
        rcTimeLine.setAdapter(adapterTimeLine);
        rcTimeLine.setLayoutManager(new LinearLayoutManager(this));


    }

    private void addData() {
        long dt = Long.parseLong("1533338840000");
        listTimeLine.add(new Information(
                "We Don't Talk Anymore" ,
                "#eco please enter go go go www.gooogle.com Điều tra nghi vấn khuất tất trong chấm trắc nghiệm, Công an tỉnh Hòa Bình đã khởi tố vụ án Lợi dụng chức vụ quyền hạn...",
                "@lehoangthienan",
                linkPicture,
                dt
        ));
        listTimeLine.add(new Information(
                "We Don't Talk Anymore" ,
                "#bcd24XC5S please go go go  www.gooogle.com Điều tra nghi vấn khuất tất trong chấm trắc nghiệm, Công an tỉnh Hòa Bình đã khởi tố vụ án Lợi dụng chức vụ quyền hạn...",
                "@lehoangthienan",
                linkPicture,
                dt
        ));
        listTimeLine.add(new Information(
                "We Don't Talk Anymore" ,
                "#fff123 please enter go go  www.gooogle.com Điều tra nghi vấn khuất tất trong chấm trắc nghiệm, Công an tỉnh Hòa Bình đã khởi tố vụ án Lợi dụng chức vụ quyền hạn...",
                "@lehoangthienan",
                linkPicture,
                dt
        ));
        listTimeLine.add(new Information(
                "We Don't Talk Anymore" ,
                "#xxx please enter go go go  www.gooogle.com Điều tra nghi vấn khuất tất trong chấm trắc nghiệm, Công an tỉnh Hòa Bình đã khởi tố vụ án Lợi dụng chức vụ quyền hạn...",
                "@lehoangthienan",
                linkPicture,
                dt
        ));
        listTimeLine.add(new Information(
                "We Don't Talk Anymore" ,
                "#ANL please enter go go go  www.gooogle.com Điều tra nghi vấn khuất tất trong chấm trắc nghiệm, Công an tỉnh Hòa Bình đã khởi tố vụ án Lợi dụng chức vụ quyền hạn...",
                "@lehoangthienan",
                linkPicture,
                dt
        ));
        listTimeLine.add(new Information(
                "We Don't Talk Anymore" ,
                "#eco please enter go go go www.gooogle.com Điều tra nghi vấn khuất tất trong chấm trắc nghiệm, Công an tỉnh Hòa Bình đã khởi tố vụ án Lợi dụng chức vụ quyền hạn...",
                "@lehoangthienan",
                linkPicture,
                dt
        ));
        listTimeLine.add(new Information(
                "We Don't Talk Anymore" ,
                "#bcd24XC5S please go go go  www.gooogle.com Điều tra nghi vấn khuất tất trong chấm trắc nghiệm, Công an tỉnh Hòa Bình đã khởi tố vụ án Lợi dụng chức vụ quyền hạn...",
                "@lehoangthienan",
                linkPicture,
                dt
        ));
        listTimeLine.add(new Information(
                "We Don't Talk Anymore" ,
                "#fff123 please enter go go  www.gooogle.com Điều tra nghi vấn khuất tất trong chấm trắc nghiệm, Công an tỉnh Hòa Bình đã khởi tố vụ án Lợi dụng chức vụ quyền hạn...",
                "@lehoangthienan",
                linkPicture,
                dt
        ));
        listTimeLine.add(new Information(
                "We Don't Talk Anymore" ,
                "#xxx please enter go go go  www.gooogle.com Điều tra nghi vấn khuất tất trong chấm trắc nghiệm, Công an tỉnh Hòa Bình đã khởi tố vụ án Lợi dụng chức vụ quyền hạn...",
                "@lehoangthienan",
                linkPicture,
                dt
        ));
        listTimeLine.add(new Information(
                "We Don't Talk Anymore" ,
                "#ANL please enter go go go  www.gooogle.com Điều tra nghi vấn khuất tất trong chấm trắc nghiệm, Công an tỉnh Hòa Bình đã khởi tố vụ án Lợi dụng chức vụ quyền hạn...",
                "@lehoangthienan",
                linkPicture,
                dt
        ));

    }

    @Override
    public void onResume(){
        super.onResume();
        adapterTimeLine.notifyDataSetChanged();
    }
}
