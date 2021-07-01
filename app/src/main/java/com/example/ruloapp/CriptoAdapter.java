package com.example.ruloapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CriptoAdapter extends RecyclerView.Adapter<CriptoViewHolder> {

    private List<Cripto> criptoList;
    private IOnButtonClick listener;

    public CriptoAdapter(List<Cripto> criptoList, IOnButtonClick listener) {
        this.criptoList = criptoList;
        this.listener = listener;
    }

    @Override
    public int getItemCount() { return this.criptoList.size(); }

    @NonNull
    @Override
    public CriptoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        CriptoViewHolder criptoViewHolder = new CriptoViewHolder(view, listener);

        return criptoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CriptoViewHolder holder, int position) {
        Cripto cripto = this.criptoList.get(position);

        holder.tvNombreCriptomoneda.setText(cripto.getNombreCriptomoneda());
        holder.tvPrecioCriptomoneda.setText(cripto.getPrecioVenta().toString());
        holder.setPosition(position);
    }

}
