package com.app.appentrada;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    Button n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbarPersonalizado);
        setSupportActionBar(toolbar);

        n = findViewById(R.id.button2);
        n.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        if(view == n){
            Intent intent = new Intent(this, DetalleEventoActivity.class);
            startActivity(intent);
        }
    }
}