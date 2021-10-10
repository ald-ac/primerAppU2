package com.appsmoviles.u2primerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CirculoActivity extends AppCompatActivity {

    EditText etRadio;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        etRadio = findViewById(R.id.et_radio);
        btnCalcular = findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validar contenido et
                if(etRadio.getText().toString().isEmpty()) {
                    Toast.makeText(getApplication(), "Valor de radio obligatorio", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        Double radio = Double.parseDouble(etRadio.getText().toString());
                        Double area = Math.PI * radio * radio;
                        Double perimetro = Math.PI * radio * 2;

                        //Guardar valores para envio
                        Bundle data = new Bundle();
                        data.putDouble("area", area);
                        data.putDouble("perimetro", perimetro);

                        //Ir a actividad
                        Intent intent = new Intent(getApplicationContext(), ResultadoCirculoActivity.class);
                        intent.putExtra("data", data);
                        startActivity(intent);
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplication(), "Valor de radio invalido", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}