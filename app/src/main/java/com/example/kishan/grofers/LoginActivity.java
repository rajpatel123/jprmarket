package com.example.kishan.grofers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kishan.grofers.models.LoginResponse;
import com.example.kishan.grofers.retrofit.RestClient;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
   private TextView signup;
   private EditText email,password;
   private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         signup=findViewById(R.id.register_tv);
         email=findViewById(R.id.edit_email);
        password=findViewById(R.id.edit_Passwword);
        login=findViewById(R.id.loginButton);







        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean check=true;

                String gmaill=email.getText().toString();
                String passworddd=password.getText().toString();




                if(!Patterns.EMAIL_ADDRESS.matcher(gmaill).matches())
                {
                    email.setError("Field is empty");
                    check=false;
                }


                if(passworddd.length()<10)
                {
                    password.setError("enter more than 10 charater");
                    check=false;
                }
                if (check==true)
                {

                    RequestBody email = RequestBody.create(MediaType.parse("text/plain"), gmaill);
                    RequestBody pwd = RequestBody.create(MediaType.parse("text/plain"), passworddd);
                    RestClient.loginUser(email, pwd, new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call call, Response response) {
                            switch (response.code()){
                             //case
                            }



                        }

                        @Override
                        public void onFailure(Call call, Throwable t) {

                        }
                    });


                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,Main2Activity.class);

                    intent.putExtra("USERNAME","gmail");
                    intent.putExtra("PASSWORD","password");
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }


            }
        });



        signup.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                 startActivity(intent);

             }
        });
    }
}
