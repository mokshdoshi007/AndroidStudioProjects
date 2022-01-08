package tops.technologies.readotp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"));
        {
            Toast.makeText(context, "SMS Received", Toast.LENGTH_SHORT).show();
            Bundle bundle = intent.getExtras();
            SmsMessage[] smsMessages = null;
            String msg_from;
            try {
                if (bundle != null) {
                    final Object[] pdusobj = (Object[]) bundle.get("pdus");
                    for (Object o : pdusobj) {
                        SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) o);
                        String phonenumber = currentMessage.getDisplayOriginatingAddress();
                        String message = currentMessage.getMessageBody();
                        Log.i("SmsReceiver", phonenumber + ":" + message);
                        Toast.makeText(context, phonenumber + ":" + message, Toast.LENGTH_SHORT).show();
                    }
                }
            }
                /*try
                {
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    smsMessages = new SmsMessage[pdus.length];

                    for (int i=0; i<smsMessages.length; i++)
                    {
                        smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                        msg_from=smsMessages[i].getOriginatingAddress();
                        String msgbody = smsMessages[i].getMessageBody();
                        Toast.makeText(context, msg_from+":"+msgbody, Toast.LENGTH_SHORT).show();
                        Log.d("moksh",msg_from+":"+msgbody);
                    }
                }*/
                catch (Exception e)
                {
                    e.printStackTrace();
                }
        }
    }
}
