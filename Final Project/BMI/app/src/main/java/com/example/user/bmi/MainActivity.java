package com.example.user.bmi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements Button.OnClickListener{
    EditText height,weight;
    TextView result;
    Button button,next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height=(EditText)findViewById(R.id.height);
        weight=(EditText)findViewById(R.id.weight);
        result=(TextView)findViewById(R.id.result);
        button=(Button)findViewById(R.id.button) ;
        next1=(Button)findViewById(R.id.next1);
        next1.setOnClickListener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(height.getText().toString().equals(""))
                    result.setText("請輸入身高");
                else if(weight.getText().toString().equals(""))
                    result.setText("請輸入體重");
                else
                    runAsyncTask();
            }
        });
    }

    private void runAsyncTask(){
        new AsyncTask<Void,Integer,Boolean>(){
            private ProgressDialog dialog=new ProgressDialog(MainActivity.this);
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                dialog.setMessage("計算中...");
                dialog.setCancelable(false);
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.show();
            }
            @Override
            protected Boolean doInBackground(Void... voids) {
                int progress=0;
                while (progress<=100){
                    try{
                        Thread.sleep(50);
                        publishProgress(Integer.valueOf(progress));
                        progress++;
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                return true;
            }
            @Override
            protected void onProgressUpdate(Integer...values){
                super.onProgressUpdate(values);
                dialog.setProgress(values[0]);
            }
            @Override
            protected  void onPostExecute(Boolean status){
                dialog.dismiss();
                double tall=Double.parseDouble(height.getText().toString());
                double kg=Double.parseDouble(weight.getText().toString());
                double cal=kg/(tall*tall);
                result.setText("您的BMI是"+String.format("%.2f",cal));

            }


        }.execute();
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent();
        intent.setClass(MainActivity.this,Main2Activity.class);
        startActivity(intent);

    }
}
