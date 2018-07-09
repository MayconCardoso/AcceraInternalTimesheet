package br.com.accera.data.auth.datasource;

import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

import br.com.accera.data.auth.callback.AuthCompleteResponse;
import br.com.accera.data.auth.entity.UserLoginDto;

/**
 * Created by Rafael Spitaliere on 09/07/18.
 */
public class AuthFirebaseDataSourceImpl implements AuthRemoteDataSource {

    private FirebaseAuth mFirebaseAuth;

    @Inject
    public AuthFirebaseDataSourceImpl(FirebaseAuth mFirebaseAuth) {
        this.mFirebaseAuth = mFirebaseAuth;
    }

    @Override
    public void registerUser(UserLoginDto userLoginDto, AuthCompleteResponse authCompleteResponse) {
        mFirebaseAuth.createUserWithEmailAndPassword(userLoginDto.getUser(), userLoginDto.getPassword())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        authCompleteResponse.OnSuccess();
                    } else {
                        // If sign in fails, display a message to the user.
                        Exception exception = task.getException();
                        authCompleteResponse.OnFailure(exception);
                    }
                });
    }
}
