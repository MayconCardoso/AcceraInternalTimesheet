package br.com.accera.callback;

/**
 * Created by LuisAlmeida on 28/05/18.
 */

public interface DataResponse<RESPONSE> {
    void onResult(RESPONSE response);
}
