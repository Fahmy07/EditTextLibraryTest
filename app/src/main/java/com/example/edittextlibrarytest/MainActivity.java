package com.example.edittextlibrarytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.dd.processbutton.iml.ActionProcessButton;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
//    private Pattern atLeastOneNumberPattern = Pattern.compile(".*[0-9].*");

    MaterialEditText mIDField, mPasswordField;
    ActionProcessButton mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIDField = (MaterialEditText) findViewById(R.id.id_field);
        mPasswordField = (MaterialEditText) findViewById(R.id.password_field);
        mLoginButton = (ActionProcessButton) findViewById(R.id.login_button);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidIDDNumber(mIDField.getText().toString())) {
                    mIDField.setError("Please enter valid ID number");
                    mLoginButton.setProgress(-1);
                } else if (!isValidPassword(mPasswordField.getText().toString())) {
                    mPasswordField.setError("Please enter valid password");
                    mLoginButton.setProgress(-1);
                }
                else {
                    // We'll add it later...
                    mLoginButton.setMode(ActionProcessButton.Mode.PROGRESS);
//                    mLoginButton.setProgress(25);
//                    mLoginButton.setProgress(50);
//                    mLoginButton.setProgress(75);
                    mLoginButton.setProgress(100);
                }
            }
        });
    }

    public static boolean isValidIDDNumber(String idNumber) {
        return idNumber.length() == 10;
    }

//    public static boolean isValidEmail(CharSequence target) {
//        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
//    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (password.length() > 15) {
            return false;
        }
//        if (!atLeastOneNumberPattern.matcher(password).find()) {
//            return false;
//        }
        return true;
    }
}
