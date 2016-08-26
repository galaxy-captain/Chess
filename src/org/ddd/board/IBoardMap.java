package org.ddd.board;

import org.ddd.piece.impl.IPiece;

import java.util.Map;

/**
 * Created by ddd on 16/8/26.
 */
public interface IBoardMap {
    /**
     * 在棋盘图上记录棋子
     *
     * @param point 指定记录的位置
     * @param piece 棋子
     */
    void putPiece(BoardPoint point, IPiece piece);

    /**
     * 获取棋盘图中指定位置的棋子
     *
     * @param point 指定获取棋子的位置
     * @return 指定坐标的棋子
     */
    IPiece getPiece(BoardPoint point);

    /**
     * 获取存储棋子位置的图形数据结构
     *
     * @return
     */
    Map<String, IPiece> getBoardMap();

}
