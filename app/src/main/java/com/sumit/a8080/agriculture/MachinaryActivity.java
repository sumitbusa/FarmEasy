package com.sumit.a8080.agriculture;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.sumit.a8080.agriculture.LoginActivity.sharedpreferences;

public class MachinaryActivity extends AppCompatActivity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machinary);

        //String Json = sharedpreferences.getString("Json", "");
            new BackgroundTask().execute();

            mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
            mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    new BackgroundTask().execute();
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            });
    }

    class BackgroundTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog pr;
        ListView listView;
        WordAdapter simpleAdapter;
        ArrayList<Word> arraylist = new ArrayList<Word>();
        public static final String MyPREFERENCES = "Agriculture_json" ;
        private String Json="";
        private boolean wasOnline=false;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pr = new ProgressDialog(MachinaryActivity.this);
            pr.setMessage("Retrieving data...");
            pr.show();

            sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            Json = sharedpreferences.getString("Json","");
            //Toast.makeText(DealersActivity.this, "Json Data is downloading...", Toast.LENGTH_LONG).show();
            wasOnline=isonLine();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            if(wasOnline) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                Log.e("Is Online ", "online");
                JsonRequest json_request = new JsonRequest("http://techprominds.esy.es/CodeShastra/Machinary.php", "");
                Json = json_request.jsonRequest();
                editor.putString("Json", Json.toString());
                editor.commit();
            }
            //get the Response form the server.

            //Json = "{\"server_response\":[{\"id\":\"1\",\"name\":\"Agricultural technology\",\"sub_title\":\"Agricultural technology refers to technology for the production\",\"decription\":\"Agricultural technology is among the most revolutionary and impactful areas of modern technology, driven by the fundamental need for food and for feeding an ever-growing population. It has opened an era in which powered machinery does the work formerly performed by people and animals (such as oxen and horses). These machines have massively increased farm output and dramatically changed the way people are employed and produce food worldwide. A well-known example of agricultural machinery is the t\"},{\"id\":\"2\",\"name\":\"Farming Goes High Tech\",\"sub_title\":\"Dave is a DIY kind of guy\",\"decription\":\"Dave is a DIY kind of guy. But Dave would like to do more than just change his tractor\\u2019s oil. He\\u2019d like to be able to modify the engine timing. He\\u2019d like to harvest the information that his tractor collects to learn more about how his crops grow. He\\u2019d like to troubleshoot error codes. Most of all, he\\u2019d like to be able to repair his equipment himself\\u2014because it\\u2019s what he\\u2019s been doing all his life.\"},{\"id\":\"3\",\"name\":\"abc\",\"sub_title\":\"abcdefgkn lkfngf zkngnf\",\"decription\":\"zdfkgkjkjdg jnzngndng dgijpidnsg oubzfdgf pizdjfng jnpidjzfnfigjzd fogjzdfj gj dzojf gj dpgiudjnf gj jdigjd jogidsipgj jldf ugbidndgj jl dgoubu\"}]}";
            Log.e("Json Message : ", "" + Json);
            if (!Json.equals("")) {
                try {
                    JSONObject jsonObject = new JSONObject(Json);
                    JSONArray server_response = jsonObject.optJSONArray("server_response");


                    for (int i = 0; i < server_response.length(); i++) {
                        JSONObject data = server_response.getJSONObject(i);
                        String id = data.getString("id");
                        String name = data.getString("name");
                        String sub_title = data.getString("sub_title");
                        String decription = data.getString("decription");
                        arraylist.add(new Word(name, sub_title, decription));

                    }
                    listView = (ListView) findViewById(R.id.dealersData);
                    simpleAdapter = new WordAdapter(MachinaryActivity.this, arraylist);
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
            //SharedPreferences.Editor editor = sharedpreferences.edit();
            //editor.putString("Json", Json.toString());
            //editor.commit();
            if (!arraylist.isEmpty()) {
                listView.setAdapter(simpleAdapter);
            } else {
                //listView.setAdapter();
                Toast.makeText(MachinaryActivity.this, "No Data is Avaailable ", Toast.LENGTH_LONG).show();
            }
            pr.dismiss();
        }
    }

    public boolean isonLine() {
        ConnectivityManager config = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nf = config.getActiveNetworkInfo();
        if (nf == null || !nf.isConnected() || !nf.isAvailable()) {
            Toast.makeText(getBaseContext(), "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
