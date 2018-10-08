package com.example.cperez.simondice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Records extends AppCompatActivity {
    Bundle mensaje_jugar;
    int max_level;
    EditText edi1, edi2, edi3,edi4, edi5;
    Button men;
    public Handler esper = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        edi1 = (EditText)findViewById(R.id.editText3);
        edi2 = (EditText)findViewById(R.id.editText5);
        edi3 = (EditText)findViewById(R.id.editText6);
        edi4 = (EditText)findViewById(R.id.editText7);
        edi5 = (EditText)findViewById(R.id.editText8);
        men = (Button)findViewById(R.id.button);
       mensaje_jugar = getIntent().getExtras();
        int nivel_menu = mensaje_jugar.getInt("maximo_nivel");
        if(nivel_menu < 1){
            edi1.setEnabled(false);
            edi2.setEnabled(false);
            edi3.setEnabled(false);
            edi4.setEnabled(false);
            edi5.setEnabled(false);
        }
        if(max_level < nivel_menu){
            max_level = nivel_menu;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    public void pressmen(View v_men){
        men.setEnabled(false);
        esper.postDelayed(new Runnable() {
            @Override
            public void run() {
                salttomenu();
            }
        },1000);
    }
     public void salttomenu(){
         Intent pag_record1 = new Intent(this, Menu.class);
         men.setEnabled(true);
         edi1.setEnabled(true);
         edi2.setEnabled(true);
         edi3.setEnabled(true);
         edi4.setEnabled(true);
         edi5.setEnabled(true);
         finish();
     }
}
