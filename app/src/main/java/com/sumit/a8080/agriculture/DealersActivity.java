package com.sumit.a8080.agriculture;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DealersActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealers);

        final Spinner locationSpinner = (Spinner) findViewById(R.id.location);
        ArrayAdapter<CharSequence> locationadapter = ArrayAdapter.createFromResource(this,R.array.location,android.R.layout.simple_spinner_item);
        locationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationadapter);

        final Spinner typesSpinner = (Spinner) findViewById(R.id.types);
        ArrayAdapter<CharSequence> interestadapter = ArrayAdapter.createFromResource(this,R.array.type,android.R.layout.simple_spinner_item);
        interestadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        toolbar = (Toolbar) findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        typesSpinner.setAdapter(interestadapter);

        ArrayList<HashMap<String,String>> arraylist = new ArrayList<HashMap<String, String>>();

        ListView listView = (ListView) findViewById(R.id.dealersData);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arraylist, android.R.layout.simple_list_item_1, new String[] {"Company"}, new int[] {android.R.id.text1});
        listView.setAdapter(simpleAdapter);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(typesSpinner.getSelectedItemPosition() == 0){
                    new BackgroundTask().execute();
                }
                else if(typesSpinner.getSelectedItemPosition() == 1){
                    new SeedTask().execute();
                }
                else if(typesSpinner.getSelectedItemPosition() == 2){
                    new PesticidesTask().execute();
                }
                else if(typesSpinner.getSelectedItemPosition() == 3){
                    new FertilizerTask().execute();
                }
                else if(typesSpinner.getSelectedItemPosition() == 4){
                    new FarmMachineryTask().execute();
                }
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        typesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Selected Option  : ",String.valueOf(i));
                if(i == 0){
                    new BackgroundTask().execute();
                }
                else if(i == 1){
                    new SeedTask().execute();
                }
                else if(i == 2){
                    new PesticidesTask().execute();
                }
                else if(i == 3){
                    new FertilizerTask().execute();
                }
                else if(i == 4){
                    new FarmMachineryTask().execute();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                new BackgroundTask().execute();
            }
        });
        //new BackgroundTask().execute();
    }


    class SeedTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog pr;
        ListView listView;
        WordAdapter simpleAdapter;
        ArrayList<Word> arraylist = new ArrayList<Word>();;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pr =new ProgressDialog(DealersActivity.this);
            pr.setMessage("verifying userData : ");
            pr.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pr.show();
            //Toast.makeText(DealersActivity.this, "Json Data is downloading...", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //get the Response form the server.
            JsonRequest json_request = new JsonRequest("http://techprominds.esy.es/CodeShastra/seed.php", "");
            String Json = json_request.jsonRequest();
            Log.e("Json Message : ", "" + Json);
            if (!Json.equals("")) {
                try {
                    JSONObject jsonObject = new JSONObject(Json);
                    JSONArray server_response = jsonObject.optJSONArray("server_response");


                    for (int i = 0; i < server_response.length(); i++) {
                        JSONObject data = server_response.getJSONObject(i);
                        String id = data.getString("id");
                        String company_name = data.getString("company_name");
                        String phone_no = data.getString("phone_no");
                        String type = data.getString("type");
                        String Address = data.getString("Address");
                        arraylist.add(new Word(company_name,Address,phone_no));

                    }
                    listView = (ListView) findViewById(R.id.dealersData);
                    simpleAdapter = new WordAdapter(DealersActivity.this,arraylist);
                    //Log.e("Data : ",id+""+company_name+""+phone_no+""+type+""+Address);
                } catch (JSONException j) {
                    Log.e("Error  : ", j.getMessage().toString());
                    j.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(!arraylist.isEmpty()) {
                listView.setAdapter(simpleAdapter);
            }
            else{
                //listView.setAdapter();
                Toast.makeText(DealersActivity.this,"No Data is Avaailable ",Toast.LENGTH_LONG).show();
            }
            pr.dismiss();
        }
    }

    class PesticidesTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog pr;
        ListView listView;
        WordAdapter simpleAdapter;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pr =new ProgressDialog(DealersActivity.this);
            pr.setMessage("Retrieving data...");
            pr.show();
            //Toast.makeText(DealersActivity.this, "Json Data is downloading...", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //get the Response form the server.
            JsonRequest json_request = new JsonRequest("http://techprominds.esy.es/CodeShastra/pesticides.php", "");
            String Json = json_request.jsonRequest();
            Log.e("Json Message : ", "" + Json);
            if (!Json.equals("")) {
                try {
                    JSONObject jsonObject = new JSONObject(Json);
                    JSONArray server_response = jsonObject.optJSONArray("server_response");

                    ArrayList<Word> arraylist = new ArrayList<Word>();
                    for (int i = 0; i < server_response.length(); i++) {
                        JSONObject data = server_response.getJSONObject(i);
                        String id = data.getString("id");
                        String company_name = data.getString("company_name");
                        String phone_no = data.getString("phone_no");
                        String type = data.getString("type");
                        String Address = data.getString("Address");
                        arraylist.add(new Word(company_name,Address,phone_no));

                    }
                    listView = (ListView) findViewById(R.id.dealersData);
                    simpleAdapter = new WordAdapter(DealersActivity.this,arraylist);
                    //Log.e("Data : ",id+""+company_name+""+phone_no+""+type+""+Address);
                } catch (JSONException j) {
                    Log.e("Error  : ", j.getMessage().toString());
                    j.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            listView.setAdapter(simpleAdapter);
            pr.dismiss();
        }
    }

    class FertilizerTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog pr;
        ListView listView;
        WordAdapter simpleAdapter;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pr =new ProgressDialog(DealersActivity.this);
            pr.setMessage("Retrieving data...");
            pr.show();
            //Toast.makeText(DealersActivity.this, "Json Data is downloading...", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //get the Response form the server.
            JsonRequest json_request = new JsonRequest("http://techprominds.esy.es/CodeShastra/Fertilizer.php", "");
            String Json = json_request.jsonRequest();
            Log.e("Json Message : ", "" + Json);
            if (!Json.equals("")) {
                try {
                    JSONObject jsonObject = new JSONObject(Json);
                    JSONArray server_response = jsonObject.optJSONArray("server_response");

                    ArrayList<Word> arraylist = new ArrayList<Word>();
                    for (int i = 0; i < server_response.length(); i++) {
                        JSONObject data = server_response.getJSONObject(i);
                        String id = data.getString("id");
                        String company_name = data.getString("company_name");
                        String phone_no = data.getString("phone_no");
                        String type = data.getString("type");
                        String Address = data.getString("Address");
                        arraylist.add(new Word(company_name,Address,phone_no));

                    }
                    listView = (ListView) findViewById(R.id.dealersData);
                    simpleAdapter = new WordAdapter(DealersActivity.this,arraylist);
                    //Log.e("Data : ",id+""+company_name+""+phone_no+""+type+""+Address);
                } catch (JSONException j) {
                    Log.e("Error  : ", j.getMessage().toString());
                    j.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            listView.setAdapter(simpleAdapter);
            pr.dismiss();
        }
    }


    class FarmMachineryTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog pr;
        ListView listView;
        WordAdapter simpleAdapter;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pr =new ProgressDialog(DealersActivity.this);
            pr.setMessage("Retrieving data...");
            pr.show();
            //Toast.makeText(DealersActivity.this, "Json Data is downloading...", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //get the Response form the server.
            JsonRequest json_request = new JsonRequest("http://techprominds.esy.es/CodeShastra/FarmMachinery.php", "");
            String Json = json_request.jsonRequest();
            Log.e("Json Message : ", "" + Json);
            if (!Json.equals("")) {
                try {
                    JSONObject jsonObject = new JSONObject(Json);
                    JSONArray server_response = jsonObject.optJSONArray("server_response");

                    ArrayList<Word> arraylist = new ArrayList<Word>();
                    for (int i = 0; i < server_response.length(); i++) {
                        JSONObject data = server_response.getJSONObject(i);
                        String id = data.getString("id");
                        String company_name = data.getString("company_name");
                        String phone_no = data.getString("phone_no");
                        String type = data.getString("type");
                        String Address = data.getString("Address");
                        arraylist.add(new Word(company_name,Address,phone_no));

                    }
                    listView = (ListView) findViewById(R.id.dealersData);
                    simpleAdapter = new WordAdapter(DealersActivity.this,arraylist);
                    //Log.e("Data : ",id+""+company_name+""+phone_no+""+type+""+Address);
                } catch (JSONException j) {
                    Log.e("Error  : ", j.getMessage().toString());
                    j.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            listView.setAdapter(simpleAdapter);
            pr.dismiss();
        }
    }

    class BackgroundTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog pr;
        ListView listView;
        WordAdapter simpleAdapter;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pr =new ProgressDialog(DealersActivity.this);
            pr.setMessage("Retrieving data...");
            pr.show();
            //Toast.makeText(DealersActivity.this, "Json Data is downloading...", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //get the Response form the server.
            JsonRequest json_request = new JsonRequest("http://techprominds.esy.es/CodeShastra/config.php", "");
            String Json = json_request.jsonRequest();
            Log.e("Json Message : ", "" + Json);
            if (!Json.equals("")) {
                try {
                    JSONObject jsonObject = new JSONObject(Json);
                    JSONArray server_response = jsonObject.optJSONArray("server_response");

                    ArrayList<Word> arraylist = new ArrayList<Word>();
                    for (int i = 0; i < server_response.length(); i++) {
                        JSONObject data = server_response.getJSONObject(i);
                        String id = data.getString("id");
                        String company_name = data.getString("company_name");
                        String phone_no = data.getString("phone_no");
                        String type = data.getString("type");
                        String Address = data.getString("Address");
                        arraylist.add(new Word(company_name,Address,phone_no));

                    }
                    listView = (ListView) findViewById(R.id.dealersData);
                    simpleAdapter = new WordAdapter(DealersActivity.this,arraylist);
                    //Log.e("Data : ",id+""+company_name+""+phone_no+""+type+""+Address);
                } catch (JSONException j) {
                    Log.e("Error  : ", j.getMessage().toString());
                    j.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            listView.setAdapter(simpleAdapter);
            pr.dismiss();
        }
    }
}
