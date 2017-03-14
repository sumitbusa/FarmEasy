package com.sumit.a8080.agriculture;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MarketActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        final Spinner typesSpinner = (Spinner) findViewById(R.id.commdityApp);
        ArrayAdapter<CharSequence> interestadapter = ArrayAdapter.createFromResource(this, R.array.Commodity, android.R.layout.simple_spinner_item);
        interestadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        toolbar = (Toolbar) findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        typesSpinner.setAdapter(interestadapter);

        ArrayList<HashMap<String, String>> arraylist = new ArrayList<HashMap<String, String>>();

        ListView listView = (ListView) findViewById(R.id.marketdata);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arraylist, android.R.layout.simple_list_item_1, new String[]{"Company"}, new int[]{android.R.id.text1});
        listView.setAdapter(simpleAdapter);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (typesSpinner.getSelectedItemPosition() == 0) {
                    new BackgroundTask().execute();
                } else if (typesSpinner.getSelectedItemPosition() == 1) {
                    new AppleTask().execute();
                } else if (typesSpinner.getSelectedItemPosition() == 2) {
                    new BeetrootTask().execute();
                }
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        typesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Selected Option  : ", String.valueOf(i));
                if (i == 0) {
                    new BackgroundTask().execute();
                } else if (i == 1) {
                    new AppleTask().execute();
                } else if (i == 2) {
                    new BeetrootTask().execute();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                new BackgroundTask().execute();
            }
        });
        //new BackgroundTask().execute();
    }


    class BeetrootTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog pr;
        ListView listView;
        WordAdapter simpleAdapter;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pr = new ProgressDialog(MarketActivity.this);
            pr.setMessage("Retrieving data...");
            pr.show();
            //Toast.makeText(DealersActivity.this, "Json Data is downloading...", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //get the Response form the server.
            JsonRequest json_request = new JsonRequest("http://techprominds.esy.es/CodeShastra/beetroot.php", "");
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
                        String mandi = data.getString("Mandi");
                        String price = data.getString("price");
                        String date = data.getString("date");
                        String Commodity = data.getString("Commodity");
                        arraylist.add(new Word(mandi, price, date));
                    }
                    listView = (ListView) findViewById(R.id.marketdata);
                    simpleAdapter = new WordAdapter(MarketActivity.this, arraylist);
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


    class AppleTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog pr;
        ListView listView;
        WordAdapter simpleAdapter;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pr = new ProgressDialog(MarketActivity.this);
            pr.setMessage("Retrieving data...");
            pr.show();
            //Toast.makeText(DealersActivity.this, "Json Data is downloading...", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //get the Response form the server.
            JsonRequest json_request = new JsonRequest("http://techprominds.esy.es/CodeShastra/apple_market.php", "");
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
                        String mandi = data.getString("Mandi");
                        String price = data.getString("price");
                        String date = data.getString("date");
                        String Commodity = data.getString("Commodity");
                        arraylist.add(new Word(mandi, price, date));
                    }
                    listView = (ListView) findViewById(R.id.marketdata);
                    simpleAdapter = new WordAdapter(MarketActivity.this, arraylist);
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
            pr = new ProgressDialog(MarketActivity.this);
            pr.setMessage("Retrieving data...");
            pr.show();
            //Toast.makeText(DealersActivity.this, "Json Data is downloading...", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //get the Response form the server.
            JsonRequest json_request = new JsonRequest("http://techprominds.esy.es/CodeShastra/general_market.php", "");
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
                        String mandi = data.getString("Mandi");
                        String price = data.getString("price");
                        String date = data.getString("date");
                        String Commodity = data.getString("Commodity");
                        arraylist.add(new Word(mandi, price, date));

                    }
                    listView = (ListView) findViewById(R.id.marketdata);
                    simpleAdapter = new WordAdapter(MarketActivity.this, arraylist);
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