package com.example.root.direct;

import java.io.File;
import android.net.Uri;
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
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import android.view.View.OnClickListener;
public class MainActivity extends AppCompatActivity {

    private final IntentFilter intentFilter = new IntentFilter();
    Channel mChannel;
    private WifiP2pManager mManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this,getMainLooper(),null);
        Button button1 = (Button) findViewById(R.id.button_1);
//        button1.setOnClickListener(new OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Toast.makeText(MainActivity.this,"You Click Button!",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//        button1.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                startActivity(intent);
//            }
//        });
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "YANGLINBIN";
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivityForResult(intent,1);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You click add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You click remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
