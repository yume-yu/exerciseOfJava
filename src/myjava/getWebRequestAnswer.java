package myjava;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class getWebRequestAnswer {

    private static HttpURLConnection urlConnection = null;

    public getWebRequestAnswer() {

    }

    /*
        引数はここ(http://weather.livedoor.com/forecast/rss/primary_area.xml)参照

     */

    public static JsonObject getForecast(String citycode) {
        try {
            URL livedoorForecast = new URL("http://weather.livedoor.com/forecast/webservice/json/v1?city=" + citycode);
            urlConnection = (HttpURLConnection)livedoorForecast.openConnection();
            //接続タイムアウトを設定する。
            urlConnection.setConnectTimeout(100000);
            //レスポンスデータ読み取りタイムアウトを設定する。
            urlConnection.setReadTimeout(100000);
            //ヘッダーにUser-Agentを設定する。
            urlConnection.setRequestProperty("User-Agent", "Android");
            //ヘッダーにAccept-Languageを設定する。
            urlConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
            //ヘッダーにContent-Typeを設定する
            urlConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            //HTTPのメソッドをPOSTに設定する。
            urlConnection.setRequestMethod("GET");
            //リクエストのボディ送信を許可する
            urlConnection.setDoOutput(false);
            //レスポンスのボディ受信を許可する
            urlConnection.setDoInput(true);

            //ステップ4.コネクションを開く
            urlConnection.connect();
            //ステップ6:レスポンスボディの読み出しを行う。
            int statusCode = urlConnection.getResponseCode();

            InputStream stream = urlConnection.getInputStream();
            StringBuffer sb = new StringBuffer();
            String line = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            try {
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            urlConnection.disconnect();
            Gson json = new Gson();
            JsonParser psr = new JsonParser();
            JsonObject jsa = psr.parse(sb.toString()).getAsJsonObject();
            return jsa;

        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}