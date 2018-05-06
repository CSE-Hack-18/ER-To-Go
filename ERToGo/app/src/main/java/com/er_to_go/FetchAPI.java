package com.er_to_go;

import android.os.AsyncTask;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;


public class FetchAPI extends AsyncTask<Void, Void, Void> {
    private StringBuilder result = new StringBuilder();
    private String data = "";
    private boolean zz = false;

    public void setData(String data) {
        this.data = data;
    }

    public void set2(boolean aa) {zz = aa;}

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
             //System.out.println(result.toString());
            obj= new JSONObject(obj.getString("query"));
             extract = obj.getString("pages");

             String find = "\"extract\"";

             int start = extract.indexOf(find);

             extract = extract.substring(start + find.length() +2, extract.length() -5);

             if (extract.length() > 100) {
                 int cut = extract.indexOf(" ", 140);
                 extract = extract.substring(0, cut);
                 extract += "...";
             }

             if (!zz) {
                 selfDiagnoze.fetched.setText(extract);
                 selfDiagnoze.sd.setLoading(false);

             } else {
                 BodyPartActivity.fetched2.setText(extract);
                 BodyPartActivity.sd.setLoading(false);
             }
        } catch (Exception e) {

            if (!zz) {
                selfDiagnoze.sd.setLoading(false);
            } else {
                BodyPartActivity.sd.setLoading(false);
            }

            e.printStackTrace();
        }
    }

}
