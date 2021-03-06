package com.polyvi.xface.extension.trafficstats;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * ????????????????????????? ??????????????????
 */
public class XTrafficStatsExt extends CordovaPlugin {

    private static final String COMMAND_GETMOBILETRAFFIC = "getMobileTraffic";
    private static final String COMMAND_GETWIFITRAFFIC = "getWifiTraffic";
    private static final String COMMAND_GETPACKAGEUSAGE = "getPackageUsage";
    /** ??????????? */
    private XTrafficStats mTrafficStatic;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        mTrafficStatic = new XTrafficStats(cordova
                .getActivity().getApplicationContext());
    }

    @Override
    public boolean execute(String action, String rawArgs, CallbackContext callbackContext) throws JSONException {

        if (action.equals(COMMAND_GETMOBILETRAFFIC)) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, mTrafficStatic.getMobileTraffic()));
            return true;
        }
        else if (action.equals(COMMAND_GETWIFITRAFFIC)) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, mTrafficStatic.getWifiTraffic()));
            return true;
        }
        else if (action.equals(COMMAND_GETPACKAGEUSAGE)) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, mTrafficStatic.getPackageUsageFromBoot()));
            return true;
        }
        return false;
    }

    @Override
    public void onDestroy() {
        mTrafficStatic.destroy();
    }

}
