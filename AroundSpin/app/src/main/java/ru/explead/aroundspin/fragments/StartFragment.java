package ru.explead.aroundspin.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.explead.aroundspin.MainActivity;
import ru.explead.aroundspin.R;


/**
 * Created by Александр on 05.12.2016.
 */
public class StartFragment extends Fragment {

    private Button btnStart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        btnStart = (Button) view.findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).openGameFragment();
            }
        });


        return view;
    }
}
