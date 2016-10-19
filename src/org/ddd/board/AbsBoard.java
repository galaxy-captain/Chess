package org.ddd.board;

import chinesechess.board.ChineseBoardMap;
import org.ddd.piece.impl.IPiece;

import java.util.Map;

/**
 * 抽象棋盘类
 * <p>
 * Created by ddd on 16/8/26.
 */
public abstract class AbsBoard implements IBoard {

    /**
     * 棋盘数据集合
     */
    protected IBoardMap boardMap;

    public AbsBoard(IBoardMap boardMap) {
        this.boardMap = boardMap;
    }

    /**
     *
     * @param pointX 棋盘坐标X
     * @param pointY 棋盘坐标Y
     * @param pieceX 棋子棋盘坐标X
     * @param pieceY 棋子棋盘坐标Y
     * @return 是否移动成功
     */
    public boolean putPiece(int pointX, int pointY, int pieceX, int pieceY) {
        return putPiece(new BoardPoint(pointX, pointY), getPiece(new BoardPoint(pieceX, pieceY)));
    }

    /**
     * 移动棋子
     *
     * @param point 移动棋盘坐标
     * @param piece 棋子棋盘坐标
     * @return 是否移动成功
     */
    @Override
    public boolean putPiece(BoardPoint point, IPiece piece) {

        if (piece == null) {
            System.out.println("坐标点没有获取到棋子,移动失败");
            return false;
        }

        // 根据棋子的规则在棋盘上进行移动
        boolean isMove = piece.getRule().move(this, point, piece);

        // 如果移动成功
        if (isMove) {
            savePieceMoveSetup(boardMap.getBoardMap());
        }

        return isMove;
    }

    /**
     * 获取棋子
     * @param pointX 棋盘坐标X
     * @param pointY 棋盘坐标Y
     * @return 棋盘坐标上的棋子
     */
    public IPiece getPiece(int pointX, int pointY) {
        return getPiece(new BoardPoint(pointX, pointY));
    }

    /**
     * 获取一颗棋盘上的棋子
     *
     * @param point 棋盘坐标
     * @return 坐标处棋子
     */
    @Override
    public IPiece getPiece(BoardPoint point) {
        return boardMap.getPiece(point);
    }

    /**
     * 在指定棋盘坐标放置一颗棋子
     *
     * @param point 指定棋盘坐标
     * @param piece 棋子
     */
    public void putPieceOnMap(BoardPoint point, IPiece piece) {
        boardMap.putPiece(point, piece);
    }

    /**
     * 棋子移动成功后,保存棋盘回调
     *
     * @param boardMap 棋盘数据
     */
    protected abstract void savePieceMoveSetup(Map<String, IPiece> boardMap);

}
