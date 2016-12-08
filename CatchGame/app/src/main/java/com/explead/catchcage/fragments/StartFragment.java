package com.explead.catchcage.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.explead.catchcage.MainActivity;
import com.explead.catchcage.R;
import com.explead.catchcage.UtilsGame;

/**
 * Created by Александр on 05.12.2016.
 */
public class StartFragment extends Fragment {

    private Button btnOne;
    private Button btnTwo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        btnOne = (Button) view.findViewById(R.id.btnOne);
        btnTwo = (Button) view.findViewById(R.id.btnTwo);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilsGame.setStatusMove(1);
                ((MainActivity)getActivity()).openGameFragment();
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilsGame.setStatusMove(2);
                ((MainActivity)getActivity()).openGameFragment();
            }
        });

        return view;
    }
}
