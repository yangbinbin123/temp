package com.example.root.direct;

/**
 * Created by root on 17-5-17.
 */
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
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import android.view.View.OnClickListener;
import android.util.*;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        TextView test = (TextView) findViewById(R.id.test);
        test.setText(data);
//        Button button2 = (Button) findViewById(R.id.button_1);
//        button2.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent();
//                intent1.putExtra("data_return","Hello from YANGLINBIN");
//                setResult(RESULT_OK,intent1);
//                finish();
//            }
//        });
    }
}
