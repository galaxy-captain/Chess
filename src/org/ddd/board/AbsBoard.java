package org.ddd.board;

import chinesechess.board.ChineseBoardMap;
import org.ddd.piece.impl.IPiece;

import java.util.Map;

/**
 * Created by ddd on 16/8/26.
 */
public abstract class AbsBoard implements IBoard {

    protected IBoardMap boardMap;

    public AbsBoard(IBoardMap boardMap){
        this.boardMap = boardMap;
    }

    @Override
    public boolean putPiece(BoardPoint point, IPiece piece) {

        // 根据棋子的规则在棋盘上进行移动
        boolean isMove = piece.getRule().move(this, point, piece);

        // 如果移动成功
        if (isMove) {
            savePieceMoveSetup(boardMap.getBoardMap());
        }

        return isMove;
    }

    @Override
    public IPiece getPiece(BoardPoint point) {
        return boardMap.getPiece(point);
    }

    public void putPieceOnMap(BoardPoint point, IPiece piece) {
        boardMap.putPiece(point, piece);
    }

    protected abstract void savePieceMoveSetup(Map<String,IPiece> boardMap);

}
