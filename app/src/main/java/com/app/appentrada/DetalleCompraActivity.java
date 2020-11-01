package com.app.appentrada;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetalleCompraActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallecompra);

        toolbar = (Toolbar) findViewById(R.id.toolbarPersonalizado);
        setSupportActionBar(toolbar);
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
            Toast.makeText(this, "OPCION 1", Toast.LENGTH_SHORT).show();
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
}
