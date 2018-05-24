package br.com.accera.core.providers.network;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

/**
 * The type Network info provider.
 *
 * @author MAYCON CARDOSO on 23/05/2018.
 */
public class NetworkInfoProviderImpl implements NetworkInfoProvider {

    private final ConnectivityManager connectivityManager;

    /**
     * Instantiates a new Network info provider.
     *
     * @param connectivityManager the connectivity manager
     */
    public NetworkInfoProviderImpl( ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    @Override
    public boolean isConnected() {
        return isWifiConnected() || isMobileConnected();
    }

    @Override
    public boolean isWifiConnected() {
        return isCoonected( ConnectivityManager.TYPE_WIFI);
    }

    @Override
    public boolean isMobileConnected() {
        return isCoonected( ConnectivityManager.TYPE_MOBILE);
    }

    private boolean isCoonected(int typeConnection) {
        if ( Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            @SuppressWarnings("deprecation")
            NetworkInfo networkInfoWifi = connectivityManager.getNetworkInfo(typeConnection);
            return networkInfoWifi != null && networkInfoWifi.isConnectedOrConnecting();
        } else {
            Network[] networks = connectivityManager.getAllNetworks();
            NetworkInfo networkInfo;
            Network network;
            for (Network network1 : networks) {
                network = network1;
                networkInfo = connectivityManager.getNetworkInfo(network);
                if ((networkInfo.getType() == typeConnection) && (networkInfo.getState().equals( NetworkInfo.State.CONNECTED))) {
                    return true;
                }
            }
        }
        return false;
    }
}