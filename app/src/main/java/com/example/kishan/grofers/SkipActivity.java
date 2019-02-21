package com.example.kishan.grofers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SkipActivity extends AppCompatActivity {
    private TextView skip_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);

        skip_button=(TextView)findViewById(R.id.skip_tv);



      skip_button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(SkipActivity.this,LocationActivity.class);
              startActivity(intent);
          }
      });


    }
}


