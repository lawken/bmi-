package com.example.user.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity
implements Button.OnClickListener{
    Button button1,button2,button3,button4,back,next;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        back=(Button)findViewById(R.id.back);
        next=(Button)findViewById(R.id.next);
        show=(TextView)findViewById(R.id.show);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }
    protected void back()
    {
        Intent intent1=new Intent();
        intent1.setClass(Main2Activity.this,MainActivity.class);
        startActivity(intent1);
    }
    protected void next1()
    {
        Intent intent2=new Intent();
        intent2.setClass(Main2Activity.this,Main3Activity.class);
        startActivity(intent2);
    }

    @Override
    public void onClick(View v) {
        int visible=View.VISIBLE;
        int gone=View.GONE;
        switch (v.getId()){
            case R.id.button1:
                findViewById(R.id.light).setVisibility(visible);
                findViewById(R.id.normal).setVisibility(gone);
                findViewById(R.id.heavy).setVisibility(gone);
                findViewById(R.id.obesity).setVisibility(gone);
                Toast.makeText(getApplicationContext(),"體重過輕",Toast.LENGTH_LONG).show();

                break;
            case R.id.button2:
                findViewById(R.id.light).setVisibility(gone);
                findViewById(R.id.normal).setVisibility(visible);
                findViewById(R.id.heavy).setVisibility(gone);
                findViewById(R.id.obesity).setVisibility(gone);
                Toast.makeText(getApplicationContext(),"體重正常",Toast.LENGTH_LONG).show();
                show.setText("繼續保持健康的飲食習慣.");
                break;
            case R.id.button3:
                findViewById(R.id.light).setVisibility(gone);
                findViewById(R.id.normal).setVisibility(gone);
                findViewById(R.id.heavy).setVisibility(visible);
                findViewById(R.id.obesity).setVisibility(gone);
                Toast.makeText(getApplicationContext(),"超重",Toast.LENGTH_LONG).show();

                break;
            case R.id.button4:
                findViewById(R.id.light).setVisibility(gone);
                findViewById(R.id.normal).setVisibility(gone);
                findViewById(R.id.heavy).setVisibility(gone);
                findViewById(R.id.obesity).setVisibility(visible);
                Toast.makeText(getApplicationContext(),"肥胖",Toast.LENGTH_LONG).show();

                break;
            case R.id.back:
                back();
                break;
            case R.id.next:
                next1();
        }
    }
}
