package com.codehub.pfacademy12;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class AbstractActivity extends AppCompatActivity {

    //app lifecycle simplification
    abstract void initial();

    abstract void running();

    abstract void stopped();

    abstract void destroy();

    // App lifecycle primary stages

    private Button btn;

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

        btn = findViewById(R.id.mainBtn);

        btn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                return false;
            }
        });
//        btn.isFocused();
//        btn.isSelected();
//        btn.isEnabled();
//        btn.isAttachedToWindow();
//        btn.isClickable();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoNextScreen();
                btn.setEnabled(false);
            }
        });

        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                showMessage();
                return false;
            }
        });
    }

    private void gotoNextScreen(){
        Intent intent = new Intent(AbstractActivity.this, SecondActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn.setEnabled(true);
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