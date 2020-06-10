package id.agusibrahim.sinchcallsimple;

import android.app.Application;
import android.os.Build;

import com.sinch.android.rtc.Sinch;
import com.sinch.android.rtc.SinchClient;
import com.sinch.android.rtc.calling.CallClient;

public class Apps extends Application {
    public static String USER_ID;
    public static SinchClient sinchClient;
    public static CallClient callClient;

    @Override
    public void onCreate() {
        super.onCreate();
        USER_ID=(""+(Build.FINGERPRINT+Build.MODEL).hashCode()).replace("-","");
        sinchClient = Sinch.getSinchClientBuilder().context(this)
                .applicationKey("334a7736-b6d7-4551-8306-a8b554a9642a")
                .applicationSecret("i/2kmUz5okeTThHMya1x5A==")
                .environmentHost("clientapi.sinch.com")
                .userId(USER_ID)
                .build();
        sinchClient.setSupportActiveConnectionInBackground(true);
        sinchClient.startListeningOnActiveConnection();
        sinchClient.setSupportCalling(true);
    }
}
