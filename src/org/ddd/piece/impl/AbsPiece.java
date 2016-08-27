package org.ddd.piece.impl;

import org.ddd.board.BoardPoint;
import org.ddd.rule.impl.IRule;

/**
 * Created by ddd on 16/8/26.
 */
public abstract class AbsPiece implements IPiece {

    protected PieceEntity entity = new PieceEntity();

    public AbsPiece(int group, BoardPoint point) {
        intiPiece(group, point);
    }

    private void intiPiece(int group, BoardPoint point) {
        entity.group = group;
        entity.point = point;
        entity.type = pieceType();
        entity.rule = pieceRule();
    }

    /**
     * 棋子的类型,如:将,士,象,马,车
     *
     * @return
     */
    protected abstract int pieceType();

    /**
     * 棋子的规则
     *
     * @return
     */
    protected abstract IRule pieceRule();

    public void setPiecePoint(BoardPoint point) {
        entity.point = point;
    }

    @Override
    public BoardPoint getPoint() {
        return entity.point;
    }

    @Override
    public int getGroup() {
        return entity.group;
    }

    @Override
    public int getType() {
        return entity.type;
    }

    @Override
    public IRule getRule() {
        return entity.rule;
    }

    @Override
    public void setPoint(BoardPoint point) {
        entity.point = point;
    }

    @Override
    public String toString() {
        return entity.toString();
    }
}
