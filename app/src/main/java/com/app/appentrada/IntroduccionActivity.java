package com.app.appentrada;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class IntroduccionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cambiarPantalla();
            }
        }, 3000);
    }

    void cambiarPantalla(){
        Intent intent = new Intent(this, IniciarSesionActivity.class);
        startActivity(intent);
    }
}
