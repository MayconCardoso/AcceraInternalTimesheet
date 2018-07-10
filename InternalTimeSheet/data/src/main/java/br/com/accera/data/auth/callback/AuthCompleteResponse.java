package br.com.accera.data.auth.callback;

/**
 * Created by Rafael Spitaliere on 09/07/18.
 */
public interface AuthCompleteResponse {
    void OnSuccess();
    void OnFailure(Exception exception);
}
