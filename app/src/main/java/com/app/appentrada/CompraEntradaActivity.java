package com.app.appentrada;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.appentrada.dao.MySqlZona;
import com.app.appentrada.entidad.Zona;

import java.util.ArrayList;

public class CompraEntradaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Toolbar toolbar;
    EditText edtNombreEvento, edtPrecio, edtMonto;
    Spinner spnZona, spnCantidad;
    Button btnValidar;
    ImageView imgFoto;

    MySqlZona daoZona = new MySqlZona(this);
    ArrayList<String> listaprecio = new ArrayList<>();
    ArrayList<String> nombreZona = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compraentrada);

        toolbar = (Toolbar) findViewById(R.id.toolbarPersonalizado);
        setSupportActionBar(toolbar);

        edtNombreEvento = findViewById(R.id.edtNombreEventoCompra);
        edtPrecio = findViewById(R.id.edtPrecioCompra);
        edtMonto = findViewById(R.id.edtMontoCompra);
        spnZona = findViewById(R.id.spnZonaCompra);
        spnCantidad = findViewById(R.id.spnCantidadCompra);
        btnValidar = findViewById(R.id.btnValidarCompra);
        imgFoto = findViewById(R.id.imgCompraEntrada);
        spnZona.setOnItemSelectedListener(this);
        spnCantidad.setOnItemSelectedListener(this);
        btnValidar.setOnClickListener(this);

        edtNombreEvento.setEnabled(false);
        edtPrecio.setEnabled(false);
        edtMonto.setEnabled(false);
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
        int posicionZona = spnZona.getSelectedItemPosition();
        edtPrecio.setText(listaprecio.get(posicionZona));

        int posCantidad = spnCantidad.getSelectedItemPosition();
        double montoTotal = calcularMonto(posicionZona, posCantidad);
        edtMonto.setText(""+montoTotal);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    void cargarDatos(){
        ArrayList<Zona> listaZonas;
        listaZonas = daoZona.listarZona();
        int tamano = listaZonas.size();

        Zona bean;
        for(int i=0; i<tamano; i++){
            bean = new Zona();
            bean.setCodZona(listaZonas.get(i).getCodZona());
            bean.setNombre(listaZonas.get(i).getNombre());
            bean.setPrecio(listaZonas.get(i).getPrecio());

            nombreZona.add(bean.getNombre());
            listaprecio.add(""+ bean.getPrecio());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, nombreZona);
        spnZona.setAdapter(adapter);


        Bundle datos = this.getIntent().getExtras();
        edtNombreEvento.setText(datos.getString("nombreConcierto"));
        String foto = datos.getString("foto");

        int id = this.getResources().getIdentifier("i"+foto, "drawable", this.getPackageName());
        imgFoto.setImageResource(id);
    }

    double calcularMonto(int posZona, int poscantidad){
        double montoTotal=0;
        if(poscantidad==0)
            montoTotal=0.0;
        else
            montoTotal = Double.parseDouble(listaprecio.get(posZona)) * poscantidad;
        return montoTotal;
    }

}
