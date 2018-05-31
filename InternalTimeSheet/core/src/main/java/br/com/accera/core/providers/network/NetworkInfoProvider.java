package br.com.accera.core.providers.network;

/**
 * The interface Network info provider.
 *
 * @author MAYCON CARDOSO on 23/05/2018.
 */
public interface NetworkInfoProvider {

    /**
     * Is wifi connected boolean.
     *
     * @return the boolean
     */
    boolean isWifiConnected();

    /**
     * Is mobile connected boolean.
     *
     * @return the boolean
     */
    boolean isMobileConnected();

    /**
     * Is connected boolean.
     *
     * @return the boolean
     */
    boolean isConnected();

}