package com.appsmoviles.u2primerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IvaActivity extends AppCompatActivity {

    EditText etCosto;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iva);

        //Instanciar
        etCosto = findViewById(R.id.et_radio);
        btnCalcular = findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validar contenido et
                if(etCosto.getText().toString().trim() == "") {
                    Toast.makeText(getApplication(), "Costo invalido", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });
    }
}