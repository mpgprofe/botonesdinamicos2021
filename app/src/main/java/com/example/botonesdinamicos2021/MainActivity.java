package com.example.botonesdinamicos2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button buttonCrear, buttonBorrar, buttonBorrarPares;
    EditText editTextNBotones;
    GridLayout layoutTabla;

    int dameColorAleatorio() {
        Random random = new Random();
        return Color.argb(255, random.nextInt(256),
                random.nextInt(256), random.nextInt(256));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCrear = findViewById(R.id.buttonCrear);
        editTextNBotones = findViewById(R.id.editTextNBotones);
        layoutTabla = findViewById(R.id.gridLayoutTabla);
        buttonBorrar = findViewById(R.id.buttonBorrar);
        buttonBorrarPares = findViewById(R.id.buttonBorrarPares);


        buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cantidad = Integer.parseInt(editTextNBotones.getText().toString());
                for (int i = 0; i < cantidad; i++) {
                    Button b = new Button(MainActivity.this);
                    b.setText("Botón " + i);
                    b.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    b.setBackgroundColor(dameColorAleatorio());
                    final int numero = i;
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            view.setBackgroundColor(dameColorAleatorio());
                            Toast.makeText(MainActivity.this, "Soy el botón: " + numero, Toast.LENGTH_SHORT).show();
                        }
                    });

                    layoutTabla.addView(b);

                }
            }
        });

        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutTabla.removeAllViews();
            }
        });

        buttonBorrarPares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<View> botones = layoutTabla.getTouchables();
                Iterator<View> iterator = botones.iterator();


                while (iterator.hasNext()) {
                    View v = iterator.next();
                    if (v instanceof Button) {
                        String[] cadenas = ((Button) v).getText().toString().split(" ");
                        int numero = Integer.parseInt(cadenas[1]);
                        if (numero % 2 == 0) {
                            layoutTabla.removeView(v);
                        }

                    }
                }


            }
        });


    }
}