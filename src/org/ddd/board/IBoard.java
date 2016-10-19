package org.ddd.board;

import org.ddd.piece.impl.IPiece;

/**
 * 棋盘类接口
 *
 * Created by dxl584327830 on 16/8/26.
 */
public interface IBoard {

    boolean putPiece(BoardPoint point, IPiece piece);

    IPiece getPiece(BoardPoint point);

}
