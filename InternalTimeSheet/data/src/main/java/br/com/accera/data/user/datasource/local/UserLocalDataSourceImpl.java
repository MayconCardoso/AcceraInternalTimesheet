package br.com.accera.data.user.datasource.local;

import android.os.Handler;
import android.os.Looper;

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
        new Thread(() -> {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Handler(Looper.getMainLooper()).post(() -> response.onComplete());
        }).start();
    }
}
