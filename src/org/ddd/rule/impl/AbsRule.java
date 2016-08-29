package org.ddd.rule.impl;

import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;

/**
 * Created by ddd on 16/8/28.
 */
public abstract class AbsRule implements IRule {

    protected AbsBoard board;
    protected BoardPoint point;
    protected IPiece piece;

    @Override
    public boolean move(AbsBoard board, BoardPoint point, IPiece piece) {

        this.board = board;
        this.point = point;
        this.piece = piece;

        boolean enableMove = moveRule();

        movePiece(enableMove);

        return enableMove;
    }

    protected abstract boolean moveRule();

    protected abstract void movePiece(boolean isMove);

    public AbsBoard getBoard() {
        return board;
    }

    public BoardPoint getPoint() {
        return point;
    }

    public IPiece getPiece() {
        return piece;
    }

}
