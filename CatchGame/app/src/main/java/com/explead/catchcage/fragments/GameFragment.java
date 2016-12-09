package com.explead.catchcage.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.explead.catchcage.R;
import com.explead.catchcage.UtilsGame;

/**
 * Created by Александр on 05.12.2016.
 */
public class GameFragment extends Fragment {

    private UtilsGame utils;

    private StackLayout[] stackLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        utils = new UtilsGame();

        stackLayout = new StackLayout[7];
        stackLayout[0] = new StackLayout((LinearLayout) view.findViewById(R.id.layoutOne), 0);
        stackLayout[1] = new StackLayout((LinearLayout) view.findViewById(R.id.layoutTwo), 1);
        stackLayout[2] = new StackLayout((LinearLayout) view.findViewById(R.id.layoutThree), 2);
        stackLayout[3] = new StackLayout((LinearLayout) view.findViewById(R.id.layoutFour), 3);
        stackLayout[4] = new StackLayout((LinearLayout) view.findViewById(R.id.layoutFive), 4);
        stackLayout[5] = new StackLayout((LinearLayout) view.findViewById(R.id.layoutSex), 5);
        stackLayout[6] = new StackLayout((LinearLayout) view.findViewById(R.id.layoutSeven), 6);

        for(final StackLayout layout : stackLayout) {
            layout.getLayout().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //if(UtilsGame.getStatusMove() == UtilsGame.I_MOVE) {
                    if(layout.getNumberCircle() < 6) {
                        utils.addCircle(layout.getNumberCircle(), layout.getNumber(), utils.getStatusMove());
                        setCircleMove(layout.getNumber());
                        utils.changeStatusMove();
                        utils.checkWon(utils.getField());
                    }
                    //}
                }
            });
        }

        return view;
    }


    public void setCircleMove(int m) {
        if(UtilsGame.getStatusMove() == UtilsGame.I_MOVE) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            ImageView view = (ImageView)inflater.inflate(R.layout.red_circle, null, false);
            setCircle(m, view);
        } else {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            ImageView view = (ImageView)inflater.inflate(R.layout.green_circle, null, false);
            setCircle(m, view);
        }
    }

    public void setCircle(int m, ImageView view) {
        stackLayout[m].getLayout().addView(view, 0);
        stackLayout[m].addNumberCircle();
    }


    class StackLayout {

        private LinearLayout layout;
        private int number;
        private int numberCircle = 0;

        public StackLayout(LinearLayout layout, int number) {
            this.layout = layout;
            this.number = number;
        }

        public LinearLayout getLayout() {
            return layout;
        }

        public int getNumber() {
            return number;
        }

        public int getNumberCircle() {
            return numberCircle;
        }

        public void addNumberCircle() {
            numberCircle += 1;
        }
    }
}