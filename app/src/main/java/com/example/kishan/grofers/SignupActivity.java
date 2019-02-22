package com.example.kishan.grofers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private EditText name,mobile,country,email,pwd;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name=findViewById(R.id.nameET);
        mobile=findViewById(R.id.mobileET);
        country=findViewById(R.id.countryET);
        email=findViewById(R.id.emailET);
        pwd=findViewById(R.id.pwdET);
        submit=findViewById(R.id.submitBTN);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                //   startActivity(intent);



                boolean check = true;
                String namee = name.getText().toString();
                String mobilee = mobile.getText().toString();
                String countryy = country.getText().toString();
                String emaill = email.getText().toString();
                String pwdd = pwd.getText().toString();
                if (namee.length()<10) {
                    name.setError("Enter more than 15 character!!");
                    check = false;
                }

                if (mobilee.isEmpty()) {
                    mobile.setError("fields is empty");
                    check = false;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(emaill).matches())
                {
                    email.setError("Enter Valid email");
                    check = false;
                }





                if (pwdd.length()<8) {
                    pwd.setError("enter valid password");
                    check = false;
                }

                if (countryy.length()<4) {
                    country.setError("enter valid country");
                    check = false;

                }
                if (check == true) {

                    Toast.makeText(SignupActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignupActivity.this,Main2Activity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(SignupActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();


                }
            }




        });

    }
}
