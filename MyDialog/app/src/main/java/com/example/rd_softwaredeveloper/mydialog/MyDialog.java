package com.example.rd_softwaredeveloper.mydialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

public class MyDialog extends Dialog
{
	public MyDialog(Context context)
    {
        super(context, android.R.style.Theme_Light);
        setContentView(R.layout.dialog_layout);
    }
}
