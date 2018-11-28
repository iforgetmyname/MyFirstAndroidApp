package csc207project.gamecentre.MainMenu.LoginFragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import csc207project.gamecentre.R;
import csc207project.gamecentre.MainMenu.UserManager;

/**
 * The login activity for Game Centre.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * A user manager.
     */
    private UserManager userManager;

    /**
     * The FragmentManager that manages fragments.
     */
    private FragmentManager mFragmanager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.userManager = (UserManager) getIntent().getSerializableExtra("user_manager");

        this.mFragmanager = getFragmentManager();

        FragmentTransaction fragmentTransaction = this.mFragmanager.beginTransaction();
        SignInFragment fragment = new SignInFragment();
        fragmentTransaction.add(R.id.LoginActivity, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getIntent().putExtra("user_manager", this.userManager);
    }

    /**
     * Replace the current fragment with signinfragment.
     */
    public void replaceSignInFragment() {
        FragmentTransaction fragmentTransaction = this.mFragmanager.beginTransaction();
        SignInFragment fragment = new SignInFragment();
        fragmentTransaction.replace(R.id.LoginActivity, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Replace the current fragment with signupfragment.
     */
    public void replaceSignUpFragment() {
        FragmentTransaction fragmentTransaction = this.mFragmanager.beginTransaction();
        SignUpFragment fragment = new SignUpFragment();
        fragmentTransaction.replace(R.id.LoginActivity, fragment);
        fragmentTransaction.commit();
    }

    /**
     * @return get current user manager
     */
    public UserManager getUserManager() {
        return userManager;
    }
}
