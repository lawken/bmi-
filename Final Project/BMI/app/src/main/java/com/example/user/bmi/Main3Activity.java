package com.example.user.bmi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity
implements  DialogInterface.OnClickListener,Button.OnClickListener{
    TextView text_show;
    Button back1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        text_show=(TextView)findViewById(R.id.answer);
        back1=(Button)findViewById(R.id.back1);
        back1.setOnClickListener(this);
        new AlertDialog.Builder(this)
                .setMessage("你的BMI結果是怎樣?")
                .setCancelable(true)
                .setIcon(R.drawable.graph)
                .setTitle("BMI結果之建議")
                .setPositiveButton("BMI<18.5", this)
                .setNegativeButton("24.9<BMI", this)
                .setNeutralButton("18.5<BMI<24.9", this)
                .show();



    }


    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            text_show.setText("同學你體重不足，最常見的原因是進食不足而引致的營養不良，建議多維持健康飲食習慣，如問題惡化需會見醫師。");
        } else if (which == DialogInterface.BUTTON_NEGATIVE) {
            text_show.setText("同學身體響起警號! 要注意了! 過重有礙健康，研究顯示，過重為糖尿病、心血管疾病、惡性腫瘤 等慢性疾病的主要風險因素，建議同學注意飲食，三餐要正常，低脂少油炸，並安排適當的運動至少30分鐘，有需要約見營養師 ");
        } else if (which == DialogInterface.BUTTON_NEUTRAL) {
            text_show.setText("同學恭喜你，你擁有健康的身體，請繼續保持良好的飲食和運動習慣。");
        }

    }

    @Override
    public void onClick(View view) {
        Intent intent1=new Intent();
        intent1.setClass(Main3Activity.this,Main2Activity.class);
        startActivity(intent1);

    }
}
