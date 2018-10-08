package com.example.cperez.simondice;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.time.temporal.ChronoUnit;
import java.util.Timer;

import static java.lang.Thread.sleep;

public class Jugar extends AppCompatActivity {
    Bundle paso;
    int nivel, nivelant = 0, contpress = 0;
    boolean Game_over = false,human = false, win =false;
    String Nivel_string;
    private TextView tv_nivel;
    private ImageButton bt1, bt2, bt3, bt4, bt5, bt6;
    public Handler esperajug = new Handler();
    public Handler esperajug1 = new Handler();
    public Handler esperajug2 = new Handler();
    public Handler esperajug3 = new Handler();
    public Handler esperajug4 = new Handler();
    public Handler esperajug5 = new Handler();
    public Handler esperajug6 = new Handler();
    long looptime, initime;
    int[] secu, secuhuman;
    int time_nivel;
    Toast humanmsj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv_nivel = (TextView)findViewById(R.id.Nivel_jugar_tex);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null);
            }
        });
        bt1 = (ImageButton) findViewById(R.id.imageButton7);
        bt2 = (ImageButton) findViewById(R.id.imageButton8);
        bt3 = (ImageButton) findViewById(R.id.imageButton9);
        bt4 = (ImageButton) findViewById(R.id.imageButton10);
        bt5 = (ImageButton) findViewById(R.id.imageButton11);
        bt6 = (ImageButton) findViewById(R.id.imageButton12);
        paso = getIntent().getExtras();
        nivel = paso.getInt("nivel_init");
        secu = new int[nivel];
        secuhuman = new int[nivel];
        time_nivel = nivel*750;
        win = true;
        human = false;
        if (nivelant < nivel){
            Nivel_string = "Nivel " + nivel;
            Toast.makeText(Jugar.this,Nivel_string,Toast.LENGTH_SHORT).show();
            nivelant = nivel;
            tv_nivel.setText(Nivel_string);
        }
            contpress = 0;
        for(int i = 0; i <= nivel - 1; i++){
            secu[i]= (int) (Math.random() * 5) + 1;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        esperajug.postDelayed(new Runnable() {
            @Override
            public void run() {
                Jugar1();
            }
        },500);
    }

    public void dhalsim(View v_3){
        contpress++;
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.dhalsim);
        mp1.start();
        bt1.setImageResource(R.mipmap.dhalsim_activo);
        bt1.setEnabled(false);
        esperajug2.postDelayed(new Runnable() {
            @Override
            public void run() {
                bt1.setImageResource(R.mipmap.dhalsim);
                bt1.setEnabled(true);
            }
        },500);
        if(human == false){
            verifhuman();
        }else {
            if(contpress <= nivel){
                resultjuego(1);
            }
        }
    }
    public void iori(View v_4){
        contpress++;
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.iori);
        mp1.start();
        bt2.setImageResource(R.mipmap.iori_activo);
        bt2.setEnabled(false);
        esperajug2.postDelayed(new Runnable() {
            @Override
            public void run() {
                bt2.setImageResource(R.mipmap.iori);
                bt2.setEnabled(true);
            }
        },500);
        if(human == false){
            verifhuman();
        }else {
            if(contpress <= nivel) {
                resultjuego(2);
            }
        }
    }
    public void sagat(View v_8){
        contpress++;
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.sagat);
        mp1.start();
        bt3.setImageResource(R.mipmap.sagat_activo);
        bt3.setEnabled(false);
        esperajug3.postDelayed(new Runnable() {
            @Override
            public void run() {
                bt3.setImageResource(R.mipmap.sagat);
                bt3.setEnabled(true);
            }
        },500);
        if(human == false){
            verifhuman();
        }else {
            if(contpress <= nivel){
                resultjuego(3);
            }
        }
    }
    public void kim(View v_5){
        contpress++;
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.kim);
        mp1.start();
        bt4.setImageResource(R.mipmap.kim_activo);
        bt4.setEnabled(false);
        esperajug4.postDelayed(new Runnable() {
            @Override
            public void run() {
                bt4.setImageResource(R.mipmap.kim);
                bt4.setEnabled(true);
            }
        },500);
        if(human == false){
            verifhuman();
        }else {
            if(contpress <= nivel){
                resultjuego(4);
            }
        }
    }
    public void rio(View v_7){
        contpress++;
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.rio);
        mp1.start();
        bt5.setImageResource(R.mipmap.rio_activo);
        bt5.setEnabled(false);
        esperajug5.postDelayed(new Runnable() {
            @Override
            public void run() {
                bt5.setImageResource(R.mipmap.rio);
                bt5.setEnabled(true);
            }
        },500);
        if(human == false){
            verifhuman();
        }else {
            if(contpress <= nivel){
                resultjuego(5);
            }
        }
    }
    public void ramon(View v_6){
        contpress++;
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.ramon);
        mp1.start();
        bt6.setImageResource(R.mipmap.ramon_activo);
        bt6.setEnabled(false);
        esperajug6.postDelayed(new Runnable() {
            @Override
            public void run() {
                bt6.setImageResource(R.mipmap.ramon);
                bt6.setEnabled(true);
            }
        },500);
        if(human == false){
            verifhuman();
        }else {
            if(contpress <=   nivel){
                resultjuego(6);
            }
        }
    }
    public void Jugar1(){
        for(int i = 0; i < nivel; i ++){
            final int finalI = i;
            esperajug.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Esperar(finalI);
                }
            },time_nivel);
            initime = System.currentTimeMillis();
            looptime = initime;
            while (initime + 750 > looptime) {
                looptime = System.currentTimeMillis();
            }
        }
    }
    public void Esperar(int j) {
        switch (secu[j]){
            case 1:
                bt1.callOnClick();
                break;
            case 2:
                bt2.callOnClick();
                break;
            case 3:
                bt3.callOnClick();
                break;
            case 4:
                bt4.callOnClick();
                break;
            case 5:
                bt5.callOnClick();
                break;
            case 6:
                bt6.callOnClick();
                break;
        }
    }
    public void verifhuman(){
        if(contpress == nivel){
            human = true;
            contpress = 0;
            humanmsj = Toast.makeText(getApplicationContext(),"BUENA SUERTE",Toast.LENGTH_SHORT);
            humanmsj.show();
        }
    }
    public void resultjuego(int i){
        if(human == true) {
            secuhuman[contpress - 1] = i;
            if (contpress == nivel) {
                for (int k = 0; k < nivel; k++) {
                    if (secuhuman[k] == secu[k] && win == true) {
                        win = true;
                    } else {
                        win = false;
                    }
                }
                if (win == true) {
                    humanmsj = Toast.makeText(getApplicationContext(), "YOU WIN", Toast.LENGTH_SHORT);
                    humanmsj.show();
                    esperajug.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            saltar_otro_nivel();
                        }
                    },1000);
                } else {
                    humanmsj = Toast.makeText(getApplicationContext(), "YOU LOSS", Toast.LENGTH_LONG);
                    humanmsj.show();
                    esperajug.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loss_song();
                        }
                    },1000);
                    esperajug.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            saltar_loss();
                        }
                    },4000);
                }
            }
        }
    }
    public void saltar_otro_nivel(){
        Intent pagjugar = new Intent(this, Jugar.class);
        pagjugar.putExtra("nivel_init",nivel + 1);
        startActivity(pagjugar);
    }
    public void saltar_loss(){
        Intent pagjugar = new Intent(this, Records.class);
        pagjugar.putExtra("nivel_init", nivel);
        startActivity(pagjugar);
    }
    public void loss_song(){
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.game_over);
        mp1.start();
    }

}
