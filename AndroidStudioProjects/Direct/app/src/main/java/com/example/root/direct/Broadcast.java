package com.example.root.direct;
import android.content.BroadcastReceiver;
import android.net.wifi.p2p.WifiP2pInfo;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
/**
 * Created by root on 17-5-21.
 */

public class Broadcast extends BroadcastReceiver{
    private WifiP2pManager manager;
    private Channel channel;
    private MainActivity activity;
    public Broadcast(WifiP2pManager manager, Channel channel, MainActivity activity) {
        super();
        this.manager = manager;
        this.channel = channel;
        this.activity = activity;
    }

     @Override
     public void onReceive(Context context, Intent intent) {
         String action = intent.getAction();
         if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
             // Determine if Wifi P2P mode is enabled or not, alert
             // the Activity.
             int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
             if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                 activity.setIsWifiP2pEnabled(true);
             } else {
                 activity.setIsWifiP2pEnabled(false);
             }
         } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {

             // The peer list has changed!  We should probably do something about
             // that.

         } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {

             // Connection state changed!  We should probably do something about
             // that.

         } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
             DeviceListFragment fragment = (DeviceListFragment) activity.getFragmentManager().findFragmentById(R.id.frag_list);
             fragment.updateThisDevice((WifiP2pDevice) intent.getParcelableExtra(WifiP2pManager.EXTRA_WIFI_P2P_DEVICE));

         }
     }
}
