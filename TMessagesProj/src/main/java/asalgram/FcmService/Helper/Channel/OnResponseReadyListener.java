package asalgram.FcmService.Helper.Channel;

import org.json.JSONObject;

/**
 * Created by DeVe on 12/6/2016.
 */
public interface OnResponseReadyListener {

    void OnResponseReady(boolean error, JSONObject data, String message);
}
