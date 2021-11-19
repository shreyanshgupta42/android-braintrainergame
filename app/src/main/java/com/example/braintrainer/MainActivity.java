package com.example.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    int tag;
    int totalplay=0;
    int win=0;

    public void random(){
        Random rand=new Random();
        int a=rand.nextInt(101);
        int b=rand.nextInt(101);
        textView3.setText(String.valueOf(a)+"+"+String.valueOf(b));

        tag=rand.nextInt(5);

        if(Integer.parseInt(button1.getTag().toString())==tag){
            button1.setText(String.valueOf(a+b));
            button2.setText(String.valueOf(rand.nextInt(201)));
            button3.setText(String.valueOf(rand.nextInt(201)));
            button4.setText(String.valueOf(rand.nextInt(201)));
        }
        else if(Integer.parseInt(button2.getTag().toString())==tag){
            button2.setText(String.valueOf(a+b));
            button1.setText(String.valueOf(rand.nextInt(201)));
            button3.setText(String.valueOf(rand.nextInt(201)));
            button4.setText(String.valueOf(rand.nextInt(201)));
        }
        else if(Integer.parseInt(button3.getTag().toString())==tag){
            button3.setText(String.valueOf(a+b));
            button2.setText(String.valueOf(rand.nextInt(201)));
            button1.setText(String.valueOf(rand.nextInt(201)));
            button4.setText(String.valueOf(rand.nextInt(201)));
        }
        else{
            button4.setText(String.valueOf(a+b));
            button2.setText(String.valueOf(rand.nextInt(201)));
            button3.setText(String.valueOf(rand.nextInt(201)));
            button1.setText(String.valueOf(rand.nextInt(201)));
        }
    }
    public void start(View view){

        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        textView4=(TextView)findViewById(R.id.textView4);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);

        random();
        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                textView2.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                textView2.setText("0");
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setVisibility(View.VISIBLE);
                textView4.setText("TIME UP!");
            }
        }.start();
    }


    public void onclick(View view){
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        textView4=(TextView)findViewById(R.id.textView4);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);

        totalplay++;
        Button counter=(Button) view;
        int tagtemp=Integer.parseInt(counter.getTag().toString());
        if(tagtemp==tag){
            win++;
        }
        textView1.setText(String.valueOf(win)+"\n"+String.valueOf(totalplay));
        random();
    }

    public void playagain(View view){
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        textView4=(TextView)findViewById(R.id.textView4);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);

        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        textView2.setText("30");
        textView3.setText("START");
        textView1.setText("0\n0");
        textView4.setText("");
        totalplay=0;
        win=0;

        button5.setVisibility(View.INVISIBLE);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand=new Random();
        textView1=(TextView)findViewById(R.id.textView1);
        textView1=(TextView)findViewById(R.id.textView1);
        textView1=(TextView)findViewById(R.id.textView1);
        textView1=(TextView)findViewById(R.id.textView1);
    }
}
