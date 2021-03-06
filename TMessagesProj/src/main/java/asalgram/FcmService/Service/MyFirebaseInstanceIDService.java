package asalgram.FcmService.Service;

/**
 * Created by DeVe on 1/12/2017.
 */

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import asalgram.FcmService.Helper.Packet.SendRegidPacket;
import asalgram.FcmService.Setting.Setting;


public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        storeRegIdInPref(refreshedToken);
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(final String token) {
        // sending gcm token to server
        Log.e(TAG, "sendRegistrationToServer: " + token);
        if(Setting.isJoined()){
            new SendRegidPacket().Send();
        }
    }

    private void storeRegIdInPref(String token) {
        Setting.setRegId(token);
    }
}
