package com.app.appentrada;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetalleEventoActivity  extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    TextView tvNombreEvento, tvArtista, tvFecha, tvLugar, tvDescripcion;
    CheckBox chkFavorito;
    Button btnComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalleevento);

        toolbar = (Toolbar) findViewById(R.id.toolbarPersonalizado);
        setSupportActionBar(toolbar);

        tvNombreEvento = findViewById(R.id.tvNombreEvento_DetalleEvento);
        tvArtista = findViewById(R.id.tvArtista_DetalleEvento);
        tvFecha = findViewById(R.id.tvFecha_DetalleEvento);
        tvLugar = findViewById(R.id.tvLugar_DetalleEvento);
        tvDescripcion = findViewById(R.id.tvDescripcion_DetalleEvento);
        chkFavorito = findViewById(R.id.chkFavorito_DetalleEvento);
        btnComprar = findViewById(R.id.btnComprar_DetalleEvento);
        btnComprar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.opcion1){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.opcion2){
            Toast.makeText(this, "OPCION 2", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.opcion3){
            Toast.makeText(this, "OPCION 3", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.opcion4){
            Toast.makeText(this, "OPCION 4", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.opcion5){
            Toast.makeText(this, "OPCION 5", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.opcion6){
            Toast.makeText(this, "OPCION 6", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.opcion7){
            Toast.makeText(this, "OPCION 7", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == btnComprar){
            Intent intent = new Intent(this, CompraEntradaActivity.class);
            startActivity(intent);
        }
    }
}
