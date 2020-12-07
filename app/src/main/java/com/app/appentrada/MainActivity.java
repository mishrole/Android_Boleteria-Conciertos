package com.app.appentrada;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.appentrada.adaptador.CardViewAdaptador;
import com.app.appentrada.dao.MySqlConcierto;
import com.app.appentrada.entidad.Concierto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;

    RecyclerView rvEventos;
    CardViewAdaptador adaptador;
    ArrayList<Concierto> listaConcierto = new ArrayList<>();
    MySqlConcierto daoConcierto = new MySqlConcierto(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbarPersonalizado);
        setSupportActionBar(toolbar);

        /*CardView y RecyclerView*/
        rvEventos = findViewById(R.id.rvEventos);
        listaConcierto = daoConcierto.listarConcierto();
        rvEventos.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new CardViewAdaptador(this, daoConcierto.listarConcierto());
        rvEventos.setAdapter(adaptador);

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
            Intent intent = new Intent(this, PerfilActivity.class);
            startActivity(intent);
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
            Intent intent = new Intent(this, IniciarSesionActivity.class);
            startActivity(intent);
        }

        return true;
    }

    @Override
    public void onClick(View view) {

    }
}