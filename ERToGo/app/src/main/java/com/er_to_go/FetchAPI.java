package com.er_to_go;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;


public class FetchAPI extends AsyncTask<Void, Void, Void> {
    private StringBuilder result = new StringBuilder();
    private String data = "";

    public void setData(String data) {
        this.data = data;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=" + data);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while (line != null) {
                result.append(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception ex) {
            System.out.println("Unable to fetch data from url");
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        JSONObject obj;
        String extract;
        try {
             obj= new JSONObject(result.toString());
             System.out.println(result.toString());
            obj= new JSONObject(obj.getString("query"));
             extract = obj.getString("pages");

             String find = "\"extract\"";

             int start = extract.indexOf(find);

             extract = extract.substring(start + find.length(), extract.length() -5);

             if (extract.length() > 100) {
                 extract = extract.substring(0, 140);
                 extract += "...";
             }

             selfDiagnoze.fetched.setText(extract);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
