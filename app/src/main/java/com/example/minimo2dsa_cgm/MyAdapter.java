package com.example.minimo2dsa_cgm;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Repos> values; //recibira una lista para poder mostrarla (creamos la referencia)

    Activity activity;

    // construcotr de la lista para tener referencia
    public MyAdapter(List<Repos> myDataset, Activity activity) {

        this.values = myDataset;
        this.activity=activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nombre_repo;
        public TextView lenguaje;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            nombre_repo=  v.findViewById(R.id.nombre_repo); //referencias
            lenguaje =  v.findViewById(R.id.lenguaje);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Repos repos = values.get(position);
        holder.lenguaje.setText((repos.getLanguage()));
        holder.nombre_repo.setText(repos.getName());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    } //retorna el tamaño de la lista
}