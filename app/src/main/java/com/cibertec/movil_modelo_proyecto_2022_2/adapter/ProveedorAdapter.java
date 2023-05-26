package com.cibertec.movil_modelo_proyecto_2022_2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cibertec.movil_modelo_proyecto_2022_2.R;
import com.cibertec.movil_modelo_proyecto_2022_2.entity.Proveedor;

import java.util.List;

public class ProveedorAdapter extends ArrayAdapter<Proveedor>  {

    private Context context;
    private List<Proveedor> lista;

    public ProveedorAdapter(@NonNull Context context, int resource, @NonNull List<Proveedor> lista) {
        super(context, resource, lista);
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.activity_proveedor_item, parent, false);

        TextView txtIdProveedor = row.findViewById(R.id.txtIdProveedor);
        TextView txtRazonSocial = row.findViewById(R.id.txtRazonSocial);
        TextView txtRuc = row.findViewById(R.id.txtRuc);
        TextView txtDireccion = row.findViewById(R.id.txtDireccion);
        TextView txtFechaRegistro = row.findViewById(R.id.txtFechaRegistro);

        Proveedor objProveedor = lista.get(position);
        txtIdProveedor.setText(String.valueOf(objProveedor.getIdProveedor()));
        txtRazonSocial.setText(objProveedor.getRazonsocial());
        txtRuc.setText(objProveedor.getRuc());
        txtDireccion.setText(objProveedor.getDireccion());
        txtFechaRegistro.setText(objProveedor.getFechaRegistro());


        return row;
    }

}
