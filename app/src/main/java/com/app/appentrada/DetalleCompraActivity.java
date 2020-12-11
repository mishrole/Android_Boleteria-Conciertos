package com.app.appentrada;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetalleCompraActivity extends AppCompatActivity {

    Toolbar toolbar;

    TextView tvTransaccion, tvFecha, tvConcierto, tvZona, tvCantidad, tvPrecio, tvMonto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallecompra);

        toolbar = (Toolbar) findViewById(R.id.toolbarPersonalizado);
        setSupportActionBar(toolbar);

        tvTransaccion = findViewById(R.id.tvNroTransac_DetalleCompra);
        tvFecha = findViewById(R.id.tvFecha_DetalleCompra);
        tvConcierto = findViewById(R.id.tvConcierto_DetalleCompra);
        tvZona = findViewById(R.id.tvZona_DetalleCompra);
        tvCantidad = findViewById(R.id.tvCantidad_DetalleCompra);
        tvPrecio = findViewById(R.id.tvPrecio_DetalleCompra);
        tvMonto = findViewById(R.id.tvMonto_DetalleCompra);

        cargarDatos();
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
            Toast.makeText(this, "OPCION 5", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.opcion5){
            Intent intent = new Intent(this, IniciarSesionActivity.class);
            startActivity(intent);
        }

        return true;
    }

    void cargarDatos(){
        Bundle datos = this.getIntent().getExtras();
        tvTransaccion.setText("Numero de Transaccion: ");
        tvFecha.setText("Fecha de Compra: "+datos.getString("fecha"));
        tvConcierto.setText("Concierto: "+datos.getString("concierto"));
        tvZona.setText("Zona: "+datos.getString("zona"));
        tvCantidad.setText("Cantidad: "+datos.getString("cantidad"));
        tvPrecio.setText("Precio c/u: "+datos.getString("precio"));
        tvMonto.setText("Monto Total: "+datos.getString("monto"));

    }

}
