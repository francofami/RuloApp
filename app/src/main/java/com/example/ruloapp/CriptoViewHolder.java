package com.example.ruloapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CriptoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvNombreCriptomoneda;
    TextView tvPrecioCriptomoneda;
    private int position;
    private IOnButtonClick listener;

    public CriptoViewHolder(@NonNull View itemView, IOnButtonClick listener) {
        super(itemView);
        this.tvNombreCriptomoneda = itemView.findViewById(R.id.nombreCriptomoneda);
        this.tvPrecioCriptomoneda = itemView.findViewById(R.id.precioCriptomoneda);

//        Button botonEditar = itemView.findViewById(R.id.botonCalcular);
//        botonEditar.setOnClickListener(this);
//
//        this.listener = listener;
    }

    public void setPosition(int position) { this.position = position; }

    @Override
    public void onClick(View view) {
        listener.onButtonClick(position);
    }
}