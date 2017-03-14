package com.sumit.a8080.agriculture;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageButton weather, Dealers, Market, near_location,machinery,farmView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("AgriCulture");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        weather = (ImageButton) findViewById(R.id.weather);
        Dealers = (ImageButton) findViewById(R.id.Dealers);
        Market = (ImageButton) findViewById(R.id.market);
        near_location = (ImageButton) findViewById(R.id.near_location);
        machinery = (ImageButton) findViewById(R.id.machinery);
        farmView = (ImageButton) findViewById(R.id.farmView);

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(HomeActivity.this, WeatherActivity.class));
                Intent intent = getPackageManager().getLaunchIntentForPackage("net.oneplus.weather");
                startActivity( intent);
            }
        });

        Dealers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, DealersActivity.class));
            }
        });

        Market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MarketActivity.class));
            }
        });

        near_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,GooglePlacesActivity.class));
            }
        });

        machinery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,MachinaryActivity.class));
            }
        });

        farmView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,LandScapActivity.class));
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.registermenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.callData:
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:18001801551"));
                startActivity(callIntent);
                break;
            case R.id.chat:
                startActivity(new Intent(HomeActivity.this,ChatActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
