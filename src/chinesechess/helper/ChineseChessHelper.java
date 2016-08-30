package chinesechess.helper;

import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;

/**
 * Created by ddd on 16/8/30.
 */
public class ChineseChessHelper {

    /**
     * @param toX
     * @param toY
     * @param oldX
     * @param oldY
     * @return
     */
    public static int getPieceNumAtLine(AbsBoard board, int toX, int toY, int oldX, int oldY) {

        if (toX == oldX) {
            return getPieceNumBetweenOTAtLineY(board, oldY, oldX, toX);
        } else if (toY == oldY) {
            return getPieceNumBetweenOTAtLineX(board, oldX, oldY, toY);
        }

        return 0;

    }

    public static int getPieceNumBetweenOTAtLineX(AbsBoard board, int coordinateY, int oldX, int toX) {

        int count = 0;

        if (toX > oldX) {

            BoardPoint tmpPoint = new BoardPoint(oldX, coordinateY);

            for (int i = oldX + 1; i < toX; i++) {
                tmpPoint.setX(i);
                count += getPieceAtMap(board, tmpPoint) == null ? 0 : 1;
            }

        } else if (toX < oldX) {

            BoardPoint tmpPoint = new BoardPoint(oldX, coordinateY);

            for (int i = oldX - 1; i > toX; i--) {
                tmpPoint.setX(i);
                count += getPieceAtMap(board, tmpPoint) == null ? 0 : 1;
            }

        }

        return count;
    }

    /**
     * @param board
     * @param coordinateX Y轴的X坐标
     * @param oldY
     * @param toY
     * @return
     */
    public static int getPieceNumBetweenOTAtLineY(AbsBoard board, int coordinateX, int oldY, int toY) {

        int count = 0;

        if (toY > oldY) {

            BoardPoint tmpPoint = new BoardPoint(coordinateX, oldY);

            for (int i = oldY + 1; i < toY; i++) {
                tmpPoint.setY(i);
                count += getPieceAtMap(board, tmpPoint) != null ? 1 : 0;
            }

        } else if (toY < oldY) {

            BoardPoint tmpPoint = new BoardPoint(coordinateX, oldY);

            for (int i = oldY - 1; i > toY; i--) {
                tmpPoint.setY(i);
                count += getPieceAtMap(board, tmpPoint) != null ? 1 : 0;
            }

        }

        return count;
    }

    public static IPiece getPieceAtMap(AbsBoard board, BoardPoint point) {
        return board == null ? null : board.getPiece(point);
    }

}
