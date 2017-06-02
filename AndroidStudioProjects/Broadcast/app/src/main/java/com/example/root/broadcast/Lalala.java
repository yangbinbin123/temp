package com.example.root.broadcast;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.File;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.*;
import java.net.*;
import java.util.*;
public class Lalala extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lalala);
        final EditText keywordText = (EditText) findViewById(R.id.keyword);
        Button button = (Button) findViewById(R.id.button);
        final TextView result = (TextView) findViewById(R.id.result);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String keyword = keywordText.getText().toString();

                if (keyword.equals("")) {
                    result.setText("请勿输入空白的关键词!!");
                } else {
                    result.setText(searchFile(keyword));
                }
                String ipaddress = getLocalHostIp();
            }
        });
    }
    private String searchFile(String keyword) {
        String result = "";
        String temp = Environment.getRootDirectory().getPath();
        File[] files = new File(temp).listFiles();
        for (File file : files) {
            if (file.getName().indexOf(keyword) >= 0) {
                result += file.getPath() + "\n";
            }}
        if (result.equals("")) {
            result = "No File";
        }
        return result;
    }

    public String getLocalHostIp()
    {
        String ipaddress = "";
        try
        {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            // 遍历所用的网络接口
            while (en.hasMoreElements())
            {
                NetworkInterface nif = en.nextElement();// 得到每一个网络接口绑定的所有ip
                Enumeration<InetAddress> inet = nif.getInetAddresses();
                // 遍历每一个接口绑定的所有ip
                while (inet.hasMoreElements())
                {
                    InetAddress ip = inet.nextElement();
                    if (!ip.isLoopbackAddress() && (ip instanceof Inet4Address))
                    {
                        String finalre =  ipaddress = "本机的ip是" + "：" + ip.getHostAddress();
                        setmessage(finalre);
                    }
                }

            }
        }
        catch (SocketException e)
        {
            setmessage("获取本地ip地址失败");
            e.printStackTrace();
        }
        return ipaddress;
    }


    public void setmessage(String msg){
        TextView view = (TextView)findViewById(R.id.ip);
        String result = msg;
        view.setText(result);
    }

}
