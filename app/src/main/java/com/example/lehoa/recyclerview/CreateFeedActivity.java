package com.example.lehoa.recyclerview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lehoa.recyclerview.model.Information;

import static com.example.lehoa.recyclerview.MainActivity.listTimeLine;

public class CreateFeedActivity extends AppCompatActivity {
    String url ;
    Button btnWrite ;
    EditText edtContent;
    ImageView imgAvt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_feed);

        initView();
        getURL();
        addcontrols();
        addevents();
    }

    private void getURL() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
    }

    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void addevents() {

            btnWrite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    transmitDataContent();
                }
            });
    }

    private void transmitDataContent() {
        if(edtContent.getText().toString().equals("")){
            Toast.makeText(this, "Please Enter Content",
                    Toast.LENGTH_LONG).show();
        }
        else {
            try{
                listTimeLine.add(0, new Information(
                        "We Don't Talk Anymore" ,
                        edtContent.getText().toString(),
                        "@lehoangthienan",
                        url,
                        System.currentTimeMillis()
                ));
                Toast.makeText(this , "Your compose is finished " , Toast.LENGTH_LONG).show();
//                edtContent.setText("");
                this.finish();
            }catch (Exception e){
                Log.d("Error :",e.getMessage());
            }
        }
    }


    private void addcontrols() {
        btnWrite = findViewById(R.id.btnWrite);
        edtContent = findViewById(R.id.edtContent);
        imgAvt = findViewById(R.id.imgAvt);

        loadImages();
    }

    private void loadImages() {
        Glide.with(this)
                .asBitmap()
                .load(url)
                .into(imgAvt);
    }
}
