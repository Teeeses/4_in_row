package com.explead.catchcage;

import android.util.Log;

/**
 * Created by Александр on 05.12.2016.
 */
public class UtilsGame {

    public static int I_MOVE = 1, YOU_MOVE = 2;
    private static int statusMove;
    private int numberPoint;

    private int[][] field;

    public UtilsGame() {
        field = new int[6][7];
    }

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

    public void addCircle(int x, int y, int value) {
        System.out.println(Integer.toString(x) + " " + Integer.toString(y));
        field[5 - x][y] = value;
    }

    public int checkWon(int[][] field) {
        for(int i = 5; i >= 0; i++) {
            for(int y = 0; y < 7; y++) {
                int count1 = checkPoint(i, y, field[i][y], "up");
                int count2 = checkPoint(i, y, field[i][y], "diagonal");
                int count3 = checkPoint(i, y, field[i][y], "right");
                if(count1 >= 4 || count2 >= 4 || count3 >= 4) {
                    System.out.println("Won: " + field[i][y]);
                    return field[i][y];
                }
            }
        }
        System.out.println("Won: " + 0);
        return 0;
    }

    public int checkPoint(int x, int y, int value, String str) {
        int count = 1;
        if(x-1 >= 0 && str.equals("up")) {
            if(value == field[x-1][y]) {
                checkPoint(x - 1, y, field[x - 1][y], "up");
                count++;
            }
        } else if(x-1 >= 0 && y+1 <= 6 && str.equals("diagonal")) {
            if(value == field[x - 1][y + 1]) {
                checkPoint(x - 1, y + 1, field[x - 1][y + 1], "diagonal");
                count++;
            }
        } else if(y+1 <= 6 && str.equals("right")) {
            if(value == field[x][y + 1]) {
                checkPoint(x, y + 1, field[x][y + 1], "right");
                count++;
            }
        }
        return count;
    }

    public void writeTable() {
        System.out.println("\n");
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
                System.out.print(Integer.toString(field[i][j]) + " ");
            }
            System.out.print("\n");
        }
    }

    public int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        this.field = field;
    }
}
