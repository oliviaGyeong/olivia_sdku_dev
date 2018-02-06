package com.example.kcpsecutest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by olivia on 18. 1. 26.
 */

public class Utils {


    public static void SimpleDailog(Context mContext, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

    public static void showToastMessage(final Context context, final String tag, final String message) {
        Handler handler = new Handler(Looper.getMainLooper());

        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                Log.e(tag, message);
            }
        });
    }


    public static void debugTx(String tag, byte[] dataBuf, int len) {
        Log.d(tag, " len " + len);
        String str = "";
        for (int i = 1; i < len + 1; i++) {
            str += String.format("%02x", dataBuf[i - 1]) + " ";

            if ((i % 16) == 0) {
                Log.d(tag, str);
                str = "";
            }
        }
        Log.d(tag, str);
    }


    public static String convertCurrentDateToString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(new Date(System.currentTimeMillis()));

        return date;
    }

    public class RdiFormat {
        public static final int STX = 1;
        public static final int DATA_LENGTH = 2;
        public static final int COMMANDID = 1;
        public static final int ETX = 1;
        public static final int LRC = 1;

        public static final byte CMD_FS = (byte) 0x1c;
        public static final byte CMD_STX = (byte) 0x02;   // Start of Text
        public static final byte CMD_ETX = (byte) 0X03;   // End of Text
    }


}
