package com.example.rd_softwaredeveloper.mydialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button showDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.show_dialog);
        showDialog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new MyDialog(MainActivity.this).show();
            }
        });
    }
}
