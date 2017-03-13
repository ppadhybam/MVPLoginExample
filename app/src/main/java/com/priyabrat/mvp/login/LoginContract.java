package com.priyabrat.mvp.login;

import android.support.annotation.StringRes;

/**
 * Created by Priyabrat on 14-03-2017.
 */

public class LoginContract {

    public interface Views {

        String getUserName();

        String getUserPass();

        void setEmptyUserNameMessage(@StringRes int resId);

        void setEmptyUserPassword(@StringRes int resId);

        void setLoginfailed(@StringRes  int resId);

        void setLoginSuccessfull();
    }
}
