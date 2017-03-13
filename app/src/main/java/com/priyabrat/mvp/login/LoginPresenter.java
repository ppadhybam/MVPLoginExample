package com.priyabrat.mvp.login;

import com.priyabrat.mvp.R;

/**
 * Created by Priyabrat on 14-03-2017.
 */
public class LoginPresenter {
    private final LoginContract.Views views;
    private final LoginAPI loginAPI;

    public LoginPresenter(LoginContract.Views views, LoginAPI loginAPI) {
        this.views = views;
        this.loginAPI = loginAPI;
    }


    public void onLoginButtonClick() {
        String userName = views.getUserName();
        if(userName.isEmpty()){
            views.setEmptyUserNameMessage(R.string.error_message_username_empty);
            return;
        }
        String userPass = views.getUserPass();
        if(userPass.isEmpty()){
            views.setEmptyUserPassword(R.string.error_message_pass_empty);
            return;
        }

        boolean success = loginAPI.isAuthenticatedUser(userName,userPass);
        if(success)
            views.setLoginSuccessfull();
        else
            views.setLoginfailed(R.string.login_failed_message);
    }
}
