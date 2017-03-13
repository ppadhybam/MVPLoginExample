package com.priyabrat.mvp.login;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.priyabrat.mvp.R;
import com.priyabrat.mvp.home.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.Views {

    private EditText editTextUserName;
    private EditText editTextuserPass;
    private Button btnLogin;
    private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextuserPass = (EditText) findViewById(R.id.editTextuserPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(btnLoginClick);
        loginPresenter = new LoginPresenter(this,new LoginAPI());
    }

    private View.OnClickListener btnLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            loginPresenter.onLoginButtonClick();
        }
    };

    @Override
    public String getUserName() {
        return editTextUserName.getText().toString().trim();
    }

    @Override
    public String getUserPass() {
        return editTextuserPass.getText().toString().trim();
    }

    @Override
    public void setEmptyUserNameMessage(@StringRes int resId) {
        editTextUserName.setError(getString(resId));
    }

    @Override
    public void setEmptyUserPassword(@StringRes int resId) {
        editTextuserPass.setError(getString(resId));
    }

    @Override
    public void setLoginfailed(@StringRes int resId) {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setLoginSuccessfull() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
