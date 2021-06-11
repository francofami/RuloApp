package com.example.ruloapp;

import android.os.Message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;

public class HiloConexion extends Thread{

    public static final int IMAGEN=1;
    public static final int CRIPTOS=2;

    Handler handler;
    boolean img;

    public HiloConexion(Handler handler, boolean img) {
        this.handler = handler;
        this.img = img;
    }

    @Override
    public void run() {
        ConexionHTTP conexionHTTP = new ConexionHTTP();
        if(!img) {
            byte[] criptosJson = conexionHTTP.obtenerRespuesta("https://criptoya.com/api/btc/ars/1");

            String s = new String(criptosJson);

            Message msg = new Message();
            msg.arg1=CRIPTOS;
            msg.obj = this.parserJson(s);
            handler.sendMessage(msg);
        } else {
            byte[] img = conexionHTTP.obtenerRespuesta("https://cryptologos.cc/logos/bitcoin-btc-logo.png?v=010");

            Message msg = new Message();
            msg.arg1 = IMAGEN;
            msg.obj = img;
            handler.sendMessage(msg);
        }
    }

    public List<String> parserJson(String s) {

        List<String> criptos = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(s);

            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                criptos.add(jsonObject.getString("totalAsk"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return criptos;

    }

}
