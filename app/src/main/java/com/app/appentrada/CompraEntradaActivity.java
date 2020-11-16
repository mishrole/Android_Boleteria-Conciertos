package com.app.appentrada;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CompraEntradaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Toolbar toolbar;
    EditText edtNombreEvento, edtPrecio, edtMonto;
    Spinner spnZona, spnCantidad;
    Button btnValidar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compraentrada);

        toolbar = (Toolbar) findViewById(R.id.toolbarPersonalizado);
        setSupportActionBar(toolbar);

        edtNombreEvento = findViewById(R.id.edtNombreEventoCompra);
        edtPrecio = findViewById(R.id.edtPrecioCompra);
        edtMonto = findViewById(R.id.edtPrecioCompra);
        spnZona = findViewById(R.id.spnZonaCompra);
        spnCantidad = findViewById(R.id.spnCantidadCompra);
        btnValidar = findViewById(R.id.btnValidarCompra);
        spnZona.setOnItemSelectedListener(this);
        spnCantidad.setOnItemSelectedListener(this);
        btnValidar.setOnClickListener(this);
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
        if (view == btnValidar){
            Intent intent = new Intent(this, DetalleCompraActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
