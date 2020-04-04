package com.example.buddy4study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class DashBoard extends AppCompatActivity {
    Button dash_login , dash_register ;
    ViewFlipper v_flipper ;

    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
//        dash_login = (Button)findViewById(R.id.dash_login);
//        dash_register = (Button)findViewById(R.id.dash_register);
        v_flipper = (ViewFlipper)findViewById(R.id.v_flipper);
        int images[] = {R.drawable.a,R.drawable.b
        ,R.drawable.c};


        for(int image:images){
            flipperImages(image);
        }

    }
    public  void flipperImages(int image){
        ImageView imageView =  new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }
}
