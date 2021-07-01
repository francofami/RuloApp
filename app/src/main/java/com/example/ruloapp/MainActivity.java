package com.example.ruloapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback, IOnButtonClick{

    List<Cripto> criptoList = new ArrayList<>();
    Integer posicionActual = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //criptoList.add(new Cripto("Binance", "Bitcoin", (float) 6000000));
        //this.criptoList = parsearJSON();

        Handler handler = new Handler(this);

        HiloConexion hiloCriptos = new HiloConexion(handler, false);
        hiloCriptos.start();

        /*HiloConexion hiloImg = new HiloConexion(handler, true);
        hiloImg.start();*/

        this.crearRecyclerView();


    }

    private void crearRecyclerView() {
        CriptoAdapter adapter = new CriptoAdapter(criptoList, this);
        RecyclerView rv = super.findViewById(R.id.rvCriptos);

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
    }

    @Override
    public void onButtonClick(int position) {
        this.posicionActual = position;
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {

        if(message.arg1==HiloConexion.CRIPTOS) {
            TextView tvPrecioVentaCripto = super.findViewById(R.id.precioCriptomoneda);
            TextView tvNombreCripto = super.findViewById(R.id.nombreCriptomoneda);

            List<String> criptos = (List<String>) message.obj;

            for(int i=0; i<=criptos.size(); i++) {
                //tv.setText(criptos.get(i));
            }

            tvPrecioVentaCripto.setText("PRUEBA");
            tvNombreCripto.setText("PRUEBA");

            //tv.setText(criptos.get(0));

        } else if(message.arg1==HiloConexion.IMAGEN) {
            ImageView iv = super.findViewById(R.id.imgExchange);
            byte[] img = (byte[]) message.obj;
            iv.setImageBitmap(BitmapFactory.decodeByteArray(img, 0, img.length));
        }

        return false;
    }
}