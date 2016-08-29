package org.ddd.board;

/**
 * Created by ddd on 16/8/26.
 * 棋盘坐标点
 */
public class BoardPoint {

    /**
     * 上下方向,X轴
     */
    private int x = -1;

    /**
     * 左右方向,Y轴
     */
    private int y = -1;

    public BoardPoint() {
        this(0, 0);
    }

    public BoardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "BoardPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        BoardPoint tmp = null;

        if (obj instanceof BoardPoint) tmp = (BoardPoint) obj;

        return tmp != null && tmp.x == this.x && tmp.y == this.y;

    }
}
