package com.tiketkereta.tiketkereta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PesanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        Button pesan = (Button) findViewById(R.id.btnpesan);
        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(PesanActivity.this, BayarActivity.class);
                startActivity(i);
            }
        });
    }
}
