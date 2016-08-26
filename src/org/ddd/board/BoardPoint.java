package org.ddd.board;

/**
 * Created by ddd on 16/8/26.
 * 棋盘坐标点
 */
public class BoardPoint {

    private int x = -1;
    private int y = -1;

    public BoardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
