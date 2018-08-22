package com.example.rd_softwaredeveloper.mydialog1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private SelfDialog selfDialog;
    private Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = (Button)findViewById(R.id.test);

        test.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                selfDialog = new SelfDialog(MainActivity.this);
                selfDialog.setTitle("提示");
                selfDialog.setMessage("確定退出?");
                selfDialog.setYesOnclickListener("确定", new SelfDialog.onYesOnclickListener()
                {
                    @Override
                    public void onYesClick()
                    {
                        Toast.makeText(MainActivity.this,"點選了確定",Toast.LENGTH_LONG).show();
                        selfDialog.dismiss();
                    }
                });

                selfDialog.setNoOnclickListener("取消", new SelfDialog.onNoOnclickListener()
                {
                    @Override
                    public void onNoClick()
                    {
                        Toast.makeText(MainActivity.this,"點選了取消",Toast.LENGTH_LONG).show();
                        selfDialog.dismiss();
                    }
                });
                selfDialog.show();
            }
        });
    }
}
