package com.example.cperez.simondice;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Menu extends AppCompatActivity {
    public Handler espera1 = new Handler();
    private Button jugar_but,list_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        jugar_but = (Button)findViewById(R.id.bt1);
        list_but = (Button)findViewById(R.id.bt3);
    }

    public void Jugar(View v_1){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.intro);
        mp.start();
        jugar_but.setEnabled(false);
        espera1.postDelayed(new Runnable() {
            @Override
            public void run() {
                salto();
            }
        }, 6000);
    }
    public void Record(View v_2){
        list_but.setEnabled(false);
        espera1.postDelayed(new Runnable() {
            @Override
            public void run() {
                salto_list();
            }
        },1000);
    }
    private void salto(){
        Intent pagjugar = new Intent(this, Jugar.class);
        pagjugar.putExtra("nivel_init",1);
        jugar_but.setEnabled(true);
        startActivity(pagjugar);
    }
    private  void salto_list(){
        Intent pag_record = new Intent(this, Records.class);
        pag_record.putExtra("nivel_init",0);
        list_but.setEnabled(true);
        startActivity(pag_record);
    }
}
