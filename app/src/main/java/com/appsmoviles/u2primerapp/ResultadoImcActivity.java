package com.appsmoviles.u2primerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoImcActivity extends AppCompatActivity {
    TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_imc);

        //Componentes GUI
        tvResultado = findViewById(R.id.tv_resultado);

        Intent intent = getIntent();
        Bundle data = intent.getBundleExtra("data");

        //Asignar resultado a textview
        tvResultado.setText(data.getString("resultado"));
        tvResultado.setTextColor(Color.parseColor(data.getString("colorTexto")));
    }
}