package com.example.rd_softwaredeveloper.mydialog1;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
* 創建自訂義的 Dialog ，主要學習其實現原理
*/
public class SelfDialog extends Dialog
{
    private Button yes;//確定按鈕
    private Button no;//取消按鈕
    private TextView titleTv;//消息標題
    private TextView messageTv;//消息提示
    private String titleStr;//自訂 title
    private String messageStr;//自訂消息
    //確定和取消顯示的內容
    private String yesStr, noStr;

    private onNoOnclickListener noOnclickListener;//取消傾廳事件
    private onYesOnclickListener yesOnclickListener;//確定傾聽事件

    /**
     *設置取消按鈕的內容以及事件
     * @param str
     * @param onNoOnclickListener
     */
    public void setNoOnclickListener(String str, onNoOnclickListener onNoOnclickListener)
    {
        if (str != null)
        {
            noStr = str;
        }
        this.noOnclickListener = onNoOnclickListener;
    }

    /**
     *設置確定的內容和事件
     * @param str
     * @param onYesOnclickListener
     */
    public void setYesOnclickListener(String str, onYesOnclickListener onYesOnclickListener)
    {
        if (str != null)
        {
            yesStr = str;
        }
        this.yesOnclickListener = onYesOnclickListener;
    }

    public SelfDialog(Context context)
    {
        super(context, R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydialog);
        //點擊空白處不可以取消畫面
        setCanceledOnTouchOutside(false);

        //初始化界面
        initView();
        //初始化參數
        initData();
        //初始化事件
        initEvent();

    }

    /**
     * 初始化確定和取消的事件
     */
    private void initEvent()
    {
        //設置確定按鈕被點擊後，向外部提供監聽
        yes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (yesOnclickListener != null)
                {
                    yesOnclickListener.onYesClick();
                }
            }
        });

        //設置取消按鈕被點擊後，向外部提供監聽
        no.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (noOnclickListener != null)
                {
                    noOnclickListener.onNoClick();
                }
            }
        });
    }

    /**
     *  初始化界面顯示的數值
     */
    private void initData()
    {
        //如果使用者自訂 title 和 message
        if (titleStr != null)
        {
            titleTv.setText(titleStr);
        }
        if (messageStr != null)
        {
            messageTv.setText(messageStr);
        }

        //如果設定按鈕文字
        if (yesStr != null)
        {
            yes.setText(yesStr);
        }
        if (noStr != null)
        {
            no.setText(noStr);
        }
    }

    /**
     * 初始化界面控件
     */
    private void initView()
    {
        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);
        titleTv = (TextView) findViewById(R.id.title);
        messageTv = (TextView) findViewById(R.id.message);
    }

    /**
     *從外部 Activity 為 Dialog 設置標題
     * @param title
     */
    public void setTitle(String title)
    {
        titleStr = title;
    }

    /**
     *從外部 Activity 為 Dialog 設置 message
     * @param message
     */
    public void setMessage(String message)
    {
        messageStr = message;
    }

    /**
     * 設置確定按鈕和取消被點擊的接口
     */
    public interface onYesOnclickListener
    {
        public void onYesClick();
    }

    public interface onNoOnclickListener
    {
        public void onNoClick();
    }
}
