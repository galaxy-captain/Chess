package org.ddd.rule.impl;

import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.board.IBoard;
import org.ddd.piece.impl.IPiece;

/**
 * Created by ddd on 16/8/26.
 */
public interface IRule {
    /**
     * 棋子移动的规则
     *
     * @param board 棋盘
     * @param point 移动到指定位置的坐标
     * @param piece 棋子
     * @return
     */
    boolean move(final AbsBoard board,final BoardPoint point,final IPiece piece);

}
