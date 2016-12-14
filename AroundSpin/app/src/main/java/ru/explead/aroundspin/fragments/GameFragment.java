package ru.explead.aroundspin.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.explead.aroundspin.R;
import ru.explead.aroundspin.UtilsGame;


/**
 * Created by Александр on 05.12.2016.
 */
public class GameFragment extends Fragment {

    private UtilsGame utils;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        return view;
    }

}