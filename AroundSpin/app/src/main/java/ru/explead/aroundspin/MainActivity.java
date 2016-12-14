package ru.explead.aroundspin;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.explead.aroundspin.fragments.BannerFragment;
import ru.explead.aroundspin.fragments.GameFragment;
import ru.explead.aroundspin.fragments.StartFragment;


public class MainActivity extends AppCompatActivity {

    private static Activity activity;
    private static Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;

        openStartFragment();
    }

    public void openBannerFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fragment = new BannerFragment();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }

    public void openStartFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fragment = new StartFragment();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }

    public void openGameFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fragment = new GameFragment();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }





    public static Activity getActivity() {
        return activity;
    }

    public static Fragment getFragment() {
        return fragment;
    }
}
