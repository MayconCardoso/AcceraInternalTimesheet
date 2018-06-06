package br.com.accera.data.user.datasource.local;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import javax.inject.Inject;

import br.com.accera.callback.DataCompleteResponse;
import br.com.accera.data.user.UserDto;

/**
 * Created by LuisAlmeida on 28/05/18.
 */

public class UserLocalDataSourceImpl implements UserLocalDataSource{

    @Inject
    public UserLocalDataSourceImpl() {
    }

    @Override
    public void saveUser(UserDto user, DataCompleteResponse response) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("Teste2", user.Nome);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        response.onComplete();
                    }
                });
            }
        }).start();
    }
}
