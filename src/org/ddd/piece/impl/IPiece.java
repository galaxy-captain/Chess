package org.ddd.piece.impl;

import org.ddd.board.BoardPoint;
import org.ddd.rule.impl.IRule;

/**
 * Created by ddd on 16/8/26.
 */
public interface IPiece {

    BoardPoint getPoint();

    int getType();

    IRule getRule();

    int getGroup();

    void setPoint(BoardPoint point);

}
