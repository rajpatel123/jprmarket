package com.app.jpr.market;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.jpr.market.models.LoginResponse;
import com.app.jpr.market.models.RegResponce;
import com.app.jpr.market.retrofit.RestClient;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private EditText name, mobile, country, email, pwd;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        name = findViewById(R.id.nameET);
        mobile = findViewById(R.id.mobileET);
        country = findViewById(R.id.countryET);
        email = findViewById(R.id.emailET);
        pwd = findViewById(R.id.pwdET);
        submit = findViewById(R.id.submitBTN);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                //   startActivity(intent);


                String namee = name.getText().toString();
                String mobilee = mobile.getText().toString();
                String countryy = country.getText().toString();
                String emaill = email.getText().toString();
                String pwdd = pwd.getText().toString();
                boolean check = validateInputs(namee, mobilee, countryy, emaill, pwdd);


                if (check) {
                    RequestBody name = RequestBody.create(MediaType.parse("text/plain"), namee);
                    RequestBody mobile = RequestBody.create(MediaType.parse("text/plain"), mobilee);
                    RequestBody country = RequestBody.create(MediaType.parse("text/plain"), countryy);
                    RequestBody email = RequestBody.create(MediaType.parse("text/plain"), emaill);
                    RequestBody password = RequestBody.create(MediaType.parse("text/plain"), pwdd);

                    RestClient.registerUser(name, mobile, country, email, password, new Callback<RegResponce>() {
                        @Override
                        ////
                        public void onResponse(Call<RegResponce> call, Response<RegResponce> response) {

                                RegResponce regResponce=response.body();
                                if(regResponce.getStatus().equals("true")){
                                    Toast.makeText(SignupActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                               Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                                }else {

                                }

                        }

                        @Override
                        public void onFailure(Call<RegResponce> call, Throwable t) {
                            Log.d("Fail",call.toString());
                            Toast.makeText(SignupActivity.this, "failed ", Toast.LENGTH_SHORT).show();

                        }
                    });


                } else {
                    Toast.makeText(SignupActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
//                if (check == true) {
//
//                    Toast.makeText(SignupActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(SignupActivity.this,Main2Activity.class);
//                    startActivity(intent);
//
//                } else {
//                    Toast.makeText(SignupActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
//
//
//                }
//            }
//
//
//
//
//        });
//
//    }

        private boolean validateInputs (String namee, String mobilee, String gmaill, String pwdd, String countryy){
            boolean check = true;


            if (namee.length() < 3) {
                name.setError("Enter more than 15 character!!");
                check = false;
            }
            if (mobilee.isEmpty()) {
                mobile.setError("fields is empty");
                check = false;
            }

//           if (!Patterns.EMAIL_ADDRESS.matcher(gmaill).matches()) {
//               email.setError("Field is empty");
//                check = false;
//            }


            if (pwdd.length() < 4) {
                pwd.setError("enter more than 10 charater");
                check = false;
            }
            if (countryy.length() < 4) {
                country.setError("enter valid country");
                check = false;

            }
            return check;
        }

}
