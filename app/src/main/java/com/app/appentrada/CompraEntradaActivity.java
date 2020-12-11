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

import com.app.appentrada.dao.MySqlEntrada;
import com.app.appentrada.dao.MySqlZona;
import com.app.appentrada.entidad.Entrada;
import com.app.appentrada.entidad.Zona;

import java.util.ArrayList;
import java.util.Date;

public class CompraEntradaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    int codigoConcierto;
    Date fecha;
    Toolbar toolbar;
    EditText edtNombreEvento, edtPrecio, edtMonto;
    Spinner spnZona, spnCantidad;
    Button btnValidar;
    ImageView imgFoto;

    MySqlZona daoZona = new MySqlZona(this);
    MySqlEntrada daoEntrada = new MySqlEntrada(this);

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

    @Override
    public void onClick(View view) {
        if (view == btnValidar){
            Entrada bean = null;
            fecha = new Date();
            int salida = -1;
            int cantidad = spnCantidad.getSelectedItemPosition();

            for(int i=0; i<cantidad; i++){
                bean = new Entrada();
                bean.setCodConcierto(codigoConcierto);
                bean.setCodZona(spnZona.getSelectedItemPosition()+1);
                bean.setEstado(1);
                bean.setPrecio(Double.parseDouble(edtPrecio.getText().toString()));
                salida = daoEntrada.adicionarEntrada(bean);
            }

            if(salida == 1){
                mensaje("Adquirio entradas para este concierto");
                Intent intent = new Intent(this, DetalleCompraActivity.class);
                intent.putExtra("fecha", ""+fecha);
                intent.putExtra("concierto", edtNombreEvento.getText().toString());
                intent.putExtra("zona", nombreZona.get(spnZona.getSelectedItemPosition()));
                intent.putExtra("cantidad", ""+spnCantidad.getSelectedItemId());
                intent.putExtra("precio", edtPrecio.getText().toString());
                intent.putExtra("monto", edtMonto.getText().toString());
                startActivity(intent);
            }
            else{
                mensaje("Error al intentar comprar entradas");
            }
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
        /*Cargar datos de los spn del Layout*/
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

        /*Cargar datos del concierto*/
        Bundle datos = this.getIntent().getExtras();
        codigoConcierto = datos.getInt("codConcierto");
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

    void mensaje(String m){
        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }

}
