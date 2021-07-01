package com.example.ruloapp;

import android.os.Message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import android.util.Log;

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
            byte[] criptosJson = conexionHTTP.obtenerRespuesta("https://criptoya.com/api/btc/ars/1/");

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

    public List<Cripto> parserJson(String jsonCriptos) {

        //String jsonCriptos = "{'argenbtc':{'ask':6047335.89,'totalAsk':6047335.89,'bid':5752344,'totalBid':5752344,'time':1623366529},'bitex':{'ask':6176301.98,'totalAsk':6227654.84,'bid':5269056.43,'totalBid':5225399.66,'time':1623366529},'buenbit':{'ask':6065300,'totalAsk':6065300,'bid':5975700,'totalBid':5975700,'time':1623366529},'ripio':{'ask':6025264.39,'totalAsk':6085517.04,'bid':5881001.08,'totalBid':5822191.07,'time':1623366530},'ripioexchange':{'ask':8261122.68,'totalAsk':8261122.68,'bid':4278487.3,'totalBid':4278487.3,'time':1623366529},'satoshitango':{'ask':6049380.37,'totalAsk':6109874.17,'bid':5760948.3,'totalBid':5703338.82,'time':1623366530},'cryptomkt':{'ask':5831782.46,'totalAsk':5941895.84,'bid':5651563.58,'totalBid':5562614.75,'time':1623366503},'buda':{'ask':30079681.77,'totalAsk':30502241.14,'bid':605611,'totalBid':597161.51,'time':1623366493},'universalcoins':{'ask':5759739.54,'totalAsk':5950156.53,'bid':5702712.42,'totalBid':5634279.87,'time':1623366529},'decrypto':{'ask':6031133.41,'totalAsk':6052242.38,'bid':5832625.55,'totalBid':5742464.82,'time':1623366529},'latamex':{'ask':6204572.76,'totalAsk':6297641.35,'bid':6043255.51,'totalBid':5982822.95,'time':1623366497},'bitso':{'ask':6131974.05,'totalAsk':6168765.89,'bid':5786365.79,'totalBid':5751647.59,'time':1623366529},'sesocio':{'ask':6108882.53,'totalAsk':6108882.53,'bid':5984235.22,'totalBid':5875621.35,'time':1623366466},'criptofacil':{'ask':6255940.6,'totalAsk':6287220.3,'bid':5734820,'totalBid':5734820,'time':1623366530},'copter':{'ask':6179647.71,'totalAsk':6303240.67,'bid':5568818.5,'totalBid':5424697.48,'time':1623366535},'letsbit':{'ask':6084266.4,'totalAsk':6084266.4,'bid':5863017.57,'totalBid':5863017.57,'time':1623366533},'fiwind':{'ask':6047151.84,'totalAsk':6107623.36,'bid':5855510.49,'totalBid':5796955.39,'time':1623366516},'lemoncash':{'ask':6123011.26,'totalAsk':6184241.37,'bid':5901697.6,'totalBid':5872189.11,'time':1623366530},'bitmonedero':{'ask':6302812.93,'totalAsk':6302812.93,'bid':5493024.15,'totalBid':5438093.91,'time':1623366529}}";
        List<Cripto> criptos = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(jsonCriptos);

            for(int i=0; i<jsonArray.length(); i++) {
                Log.d("", "ENTRE AL PARTSEEER");
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                criptos.add(new Cripto("", "BTC", jsonObject.getDouble("totalBid"), jsonObject.getDouble("totalAsk")));
                //jsonObject.getString("key")
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return criptos;
    }

}
