package com.app.jpr.market.util;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * written by Shubham Dwivedi
 */


public class AppUtils {
   static ProgressDialog dialog;

    /**
     * method to check internet connection
     * @param context
     * @return
     */
    public static boolean isInternetConnected(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager)
                context.getSystemService(Service.CONNECTIVITY_SERVICE);

           if (connectivity != null){
               NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {

                    return true;
                }
            }
        }

        return false;
     }




     public static void showProgressDialog(Context context,String message){

            dialog=new ProgressDialog(context);
           dialog.setMessage(message);
           dialog.setCancelable(false);
           dialog.show();

     }


    public static void dismisDialog() {
        if (dialog!=null && dialog.isShowing()){
            dialog.dismiss();
        }
    }
}

