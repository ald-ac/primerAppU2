package com.appsmoviles.u2primerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoIvaActivity extends AppCompatActivity {

    TextView tvCosto, tvIva, tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_iva);

        Intent intent = getIntent();
        Bundle data = intent.getBundleExtra("data");
        Double costoOriginal = data.getDouble("costoOriginal");
        Double iva = data.getDouble("iva");
        Double costo = data.getDouble("costo");

        tvCosto = findViewById(R.id.tv_costo);
        tvIva = findViewById(R.id.tv_iva);
        tvTotal = findViewById(R.id.tv_total);

        tvCosto.setText(String.format("$%.2f", costoOriginal));
        tvIva.setText(String.format("$%.2f", iva));
        tvTotal.setText(String.format("$%.2f", costo));
    }
}