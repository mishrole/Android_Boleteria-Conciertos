package com.app.appentrada;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class IniciarSesionActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtUsusario, edtContraseña;
    Button btnIngresar, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);

        edtUsusario = findViewById(R.id.edtUsuarioInicio);
        edtContraseña = findViewById(R.id.edtContrasenaInicio);
        btnIngresar = findViewById(R.id.btnIngresarInicio);
        btnRegistrar = findViewById(R.id.btnRegistrarInicio);
        btnIngresar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnIngresar){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, RegistroActivity.class);
            startActivity(intent);
        }
    }
}
