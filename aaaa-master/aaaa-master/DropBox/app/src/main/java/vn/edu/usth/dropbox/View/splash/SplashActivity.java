package vn.edu.usth.dropbox.View.splash;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.dropbox.core.v2.sharing.UserInfo;

import vn.edu.usth.dropbox.R;
import vn.edu.usth.dropbox.View.authen.Author;
import vn.edu.usth.dropbox.View.home.HomeActivity;

/**
 *
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                checkLogin();
                goToAuthenScreen();
            }
        }, 1000);
    }

//    private void checkLogin() {
//        UserInfo userInfo = RealmContext.getInstance().getUser();
//        if (userInfo != null) {
//            goToHomeScreen();
//        } else {
//            goToAuthenScreen();
//        }
//    }

//    protected void goToHomeScreen() {
//        Intent intent = new Intent(this, HomeActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
//                | Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//    }

    protected void goToAuthenScreen() {
        Intent intent = new Intent(this, Author.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}