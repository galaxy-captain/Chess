package org.ddd.piece.impl;

import org.ddd.board.BoardPoint;
import org.ddd.rule.impl.IRule;

import java.io.Serializable;

/**
 * Created by ddd on 16/8/26.
 */
class PieceEntity implements Serializable {

    BoardPoint point;

    int group;

    int type;

    IRule rule;

    @Override
    public String toString() {
        return "PieceEntity{" +
                "point=" + point +
                ", group=" + group +
                ", type=" + type +
                ", rule=" + rule +
                '}';
    }

}
