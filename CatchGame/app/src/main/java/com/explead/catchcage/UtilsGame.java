package com.explead.catchcage;

/**
 * Created by Александр on 05.12.2016.
 */
public class UtilsGame {

    public static int I_MOVE = 1, YOU_MOVE = 2;
    private static int statusMove;

    private int[][] field = new int[6][7];

    public static void setStatusMove(int status) {
        statusMove = status;
    }

    public static int getStatusMove() {
        return statusMove;
    }

    public void changeStatusMove() {
        if(statusMove == I_MOVE) {
            statusMove = YOU_MOVE;
        } else {
            statusMove = I_MOVE;
        }
    }


}
