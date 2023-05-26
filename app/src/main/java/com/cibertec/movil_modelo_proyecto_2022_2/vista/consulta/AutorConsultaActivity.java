package com.cibertec.movil_modelo_proyecto_2022_2.vista.consulta;

import
        android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.cibertec.movil_modelo_proyecto_2022_2.R;
import com.cibertec.movil_modelo_proyecto_2022_2.adapter.AutorAdapter;
import com.cibertec.movil_modelo_proyecto_2022_2.entity.Autor;
import com.cibertec.movil_modelo_proyecto_2022_2.service.ServiceAutor;
import com.cibertec.movil_modelo_proyecto_2022_2.util.ConnectionRest;
import com.cibertec.movil_modelo_proyecto_2022_2.util.NewAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AutorConsultaActivity extends NewAppCompatActivity {

    Button btnListar;


    GridView lstAutor;
    ArrayList<Autor> data = new ArrayList<Autor>();
    AutorAdapter adaptador;


    ServiceAutor serviceAutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_autor_consulta);

        btnListar = findViewById(R.id.btnListaAutor);
        lstAutor = findViewById(R.id.lstAutor);
        adaptador = new AutorAdapter(this, R.layout.activity_item_autor, data);
        lstAutor.setAdapter(adaptador);
        lstAutor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Autor objAutor = data.get(i);

                Intent intent = new Intent(AutorConsultaActivity.this,AutorConsultaDetalleActivity.class);
                intent.putExtra("VAR_OBJETO", objAutor);
                //intent.putExtra("VAR_OBJETO", objAutor);
                startActivity(intent);
            }
        });
        serviceAutor = ConnectionRest.getConnection().create(ServiceAutor.class);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listaAutor();
            }
        });


    }
    public  void  listaAutor() {
        Call<List<Autor>> call = serviceAutor.listaAutor();
        call.enqueue(new Callback<List<Autor>>() {
            @Override
            public void onResponse(Call<List<Autor>> call, Response<List<Autor>> response) {
                if (response.isSuccessful()) {
                    List<Autor> lista = response.body();
                    data.clear();
                    data.addAll(lista);
                    adaptador.notifyDataSetChanged();


                }

            }


            @Override
            public void onFailure(Call<List<Autor>> call, Throwable t) {

            }
        });


    }

}