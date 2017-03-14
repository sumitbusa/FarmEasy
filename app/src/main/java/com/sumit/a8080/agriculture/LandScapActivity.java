package com.sumit.a8080.agriculture;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LandScapActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private int arr[][]=new int [5][5];
    private String fileName = "MyFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface);

        toolbar = (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        String content = "";
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
                content+=0+",";
        }
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileName,false);
            // outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedReader input = null;
        File file = null;
        try {
            file = new File(getFilesDir(), "MyFile"); // Pass getFilesDir() and "MyFile" to read file
            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line=input.readLine();
            String str[]=line.split(",");
            int k=0;
            for(int i=0;i<5;i++)
                for(int j=0;j<5;j++)
                    arr[i][j]=Integer.parseInt(str[k]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void clickedSelection(View view){
        switch (view.getId())
        {
            case R.id.cell00: if(arr[0][0]== 0){
                arr[0][0]=1;
                findViewById(R.id.cell00).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[0][0]==1){
                arr[0][0]=0;
                findViewById(R.id.cell00).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[0][0]=2;
                findViewById(R.id.cell00).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell01: if(arr[0][1]== 0){
                arr[0][1]=1;
                findViewById(R.id.cell01).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[0][1]==1){
                arr[0][1]=0;
                findViewById(R.id.cell01).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[0][1]=2;
                findViewById(R.id.cell01).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell02: if(arr[0][2]== 0){
                arr[0][2]=1;
                findViewById(R.id.cell02).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[0][2]==1){
                arr[0][2]=0;
                findViewById(R.id.cell02).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[0][2]=2;
                findViewById(R.id.cell02).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell03: if(arr[0][3]== 0){
                arr[0][3]=1;
                findViewById(R.id.cell03).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[0][3]==1){
                arr[0][3]=0;
                findViewById(R.id.cell03).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[0][3]=2;
                findViewById(R.id.cell03).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell04: if(arr[0][4]== 0){
                arr[0][4]=1;
                findViewById(R.id.cell04).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[0][4]==1){
                arr[0][4]=0;
                findViewById(R.id.cell04).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[0][4]=2;
                findViewById(R.id.cell04).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell10: if(arr[1][0]== 0){
                arr[1][0]=1;
                findViewById(R.id.cell10).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[1][0]==1){
                arr[1][0]=0;
                findViewById(R.id.cell10).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[1][0]=2;
                findViewById(R.id.cell10).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell11: if(arr[1][1]== 0){
                arr[1][1]=1;
                findViewById(R.id.cell11).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[1][1]==1){
                arr[1][1]=0;
                findViewById(R.id.cell11).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[1][1]=2;
                findViewById(R.id.cell11).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell12: if(arr[1][2]== 0){
                arr[1][2]=1;
                findViewById(R.id.cell12).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[1][2]==1){
                arr[1][2]=0;
                findViewById(R.id.cell12).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[1][2]=2;
                findViewById(R.id.cell12).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell13: if(arr[1][3]== 0){
                arr[1][3]=1;
                findViewById(R.id.cell13).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[1][3]==1){
                arr[1][3]=0;
                findViewById(R.id.cell13).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[1][3]=2;
                findViewById(R.id.cell13).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell14: if(arr[1][4]== 0){
                arr[1][4]=1;
                findViewById(R.id.cell14).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[1][4]==1){
                arr[1][4]=0;
                findViewById(R.id.cell14).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[1][4]=2;
                findViewById(R.id.cell14).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell20: if(arr[2][0]== 0){
                arr[2][0]=1;
                findViewById(R.id.cell20).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[2][0]==1){
                arr[2][0]=0;
                findViewById(R.id.cell20).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[2][0]=2;
                findViewById(R.id.cell20).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell21: if(arr[2][1]== 0){
                arr[2][1]=1;
                findViewById(R.id.cell21).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[2][1]==1){
                arr[2][1]=0;
                findViewById(R.id.cell21).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[2][1]=2;
                findViewById(R.id.cell21).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell22: if(arr[2][2]== 0){
                arr[2][2]=1;
                findViewById(R.id.cell22).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[2][2]==1){
                arr[2][2]=0;
                findViewById(R.id.cell22).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[2][2]=2;
                findViewById(R.id.cell22).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell23: if(arr[2][3]== 0){
                arr[2][3]=1;
                findViewById(R.id.cell23).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[2][3]==1){
                arr[2][3]=0;
                findViewById(R.id.cell23).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[2][3]=2;
                findViewById(R.id.cell23).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell24: if(arr[2][4]== 0){
                arr[2][4]=1;
                findViewById(R.id.cell24).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[2][4]==1){
                arr[2][4]=0;
                findViewById(R.id.cell24).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[2][4]=2;
                findViewById(R.id.cell24).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell30: if(arr[3][0]== 0){
                arr[3][0]=1;
                findViewById(R.id.cell30).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[3][0]==1){
                arr[3][0]=0;
                findViewById(R.id.cell30).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[3][0]=2;
                findViewById(R.id.cell30).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell31: if(arr[3][1]== 0){
                arr[3][1]=1;
                findViewById(R.id.cell31).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[3][1]==1){
                arr[3][1]=0;
                findViewById(R.id.cell31).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[3][1]=2;
                findViewById(R.id.cell31).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell32: if(arr[3][2]== 0){
                arr[3][2]=1;
                findViewById(R.id.cell32).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[3][2]==1){
                arr[3][2]=0;
                findViewById(R.id.cell32).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[3][2]=2;
                findViewById(R.id.cell32).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell33: if(arr[3][3]== 0){
                arr[3][3]=1;
                findViewById(R.id.cell33).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[3][3]==1){
                arr[3][3]=0;
                findViewById(R.id.cell33).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[3][3]=2;
                findViewById(R.id.cell33).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell34: if(arr[3][4]== 0){
                arr[3][4]=1;
                findViewById(R.id.cell34).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[3][4]==1){
                arr[3][4]=0;
                findViewById(R.id.cell34).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[3][4]=2;
                findViewById(R.id.cell34).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell40: if(arr[4][0]== 0){
                arr[4][0]=1;
                findViewById(R.id.cell40).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[4][0]==1){
                arr[4][0]=0;
                findViewById(R.id.cell40).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[4][0]=2;
                findViewById(R.id.cell40).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell41: if(arr[4][1]== 0){
                arr[4][1]=1;
                findViewById(R.id.cell41).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[4][1]==1){
                arr[4][1]=0;
                findViewById(R.id.cell41).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[4][1]=2;
                findViewById(R.id.cell41).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell42: if(arr[4][2]== 0){
                arr[4][2]=1;
                findViewById(R.id.cell42).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[4][2]==1){
                arr[4][2]=0;
                findViewById(R.id.cell42).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[4][2]=2;
                findViewById(R.id.cell42).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell43: if(arr[4][3]== 0){
                arr[4][3]=1;
                findViewById(R.id.cell43).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[4][3]==1){
                arr[4][3]=0;
                findViewById(R.id.cell43).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[4][3]=2;
                findViewById(R.id.cell43).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
            case R.id.cell44: if(arr[4][4]== 0){
                arr[4][4]=1;
                findViewById(R.id.cell44).setBackgroundColor(getResources().getColor(R.color.selected));
            }   else if(arr[4][4]==1){
                arr[4][4]=0;
                findViewById(R.id.cell44).setBackgroundColor(getResources().getColor(R.color.ground));
            }else{
                arr[4][4]=2;
                findViewById(R.id.cell44).setBackgroundColor(getResources().getColor(R.color.planted));
            }
                break;
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbutton, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_next:
                startActivity(new Intent(LandScapActivity.this,FormActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}