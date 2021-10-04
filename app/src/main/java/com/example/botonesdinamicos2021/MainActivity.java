package com.example.botonesdinamicos2021;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button buttonCrear;
    EditText editTextNBotones;
    LinearLayout linearLayout;

    Color dameColorAleatorio(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCrear = findViewById(R.id.buttonCrear);
        editTextNBotones = findViewById(R.id.editTextNBotones);
        linearLayout = findViewById(R.id.linearLayout);




        buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cantidad = Integer.parseInt(editTextNBotones.getText().toString());
                for (int i = 0; i < cantidad; i++) {
                    Button b = new Button(MainActivity.this);
                    b.setText("Botón " + i);
                    b.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            view.setBackgroundColor(Color.RED);
                        }
                    });

                    linearLayout.addView(b);

                }
            }
        });


    }
}