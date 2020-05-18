package com.codehub.pfacademy12;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class AbstractActivity extends AppCompatActivity {

    //app lifecycle simplification
    abstract void initial();

    abstract void running();

    abstract void stopped();

    abstract void destroy();

    // App lifecycle primary stages


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initial();
//        TextView textView = findViewById(R.id.mainTxt);
//        textView.setText("Spyros");
//        textView.setBackgroundResource(R.color.colorPrimary);
    }



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        running();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopped();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroy();
    }

}