package com.sumit.a8080.agriculture;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    public static final String MyPREFERENCES = "Agriculture" ;
    public EditText editText,editText2,editText3,editText4;
    public Spinner spinner;
    public static SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        boolean isFirstUsage = sharedpreferences.getBoolean("first_usage", true);
        if(isFirstUsage) {
            login = (Button) findViewById(R.id.login);
            editText = (EditText) findViewById(R.id.editText8);
            //editText1 = (EditText) findViewById(R.id.)
            editText2 = (EditText) findViewById(R.id.editText5);
            editText3 = (EditText) findViewById(R.id.editText6);
            spinner = (Spinner) findViewById(R.id.language);

            final Spinner typesSpinner = (Spinner) findViewById(R.id.language);
            ArrayAdapter<CharSequence> interestadapter = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
            interestadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            typesSpinner.setAdapter(interestadapter);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (editText.getText().toString().isEmpty() && editText2.getText().toString().isEmpty() && editText3.getText().toString().isEmpty()) {
                        Toast.makeText(LoginActivity.this, "Please Enter data!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("username", editText.getText().toString());
                    editor.putString("block", editText2.getText().toString());
                    editor.putString("mobile_no", editText3.getText().toString());
                    editor.putString("language", spinner.getSelectedItem().toString());
                    editor.putBoolean("first_usage", false);
                    editor.commit();

                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    finish();
                }
            });
        }
        else{
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        }
    }
}
