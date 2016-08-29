package chinesechess.rule;

import chinesechess.board.Groups;
import chinesechess.rule.abs.ChineseChessRule;
import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;
import org.ddd.piece.impl.PieceType;

/**
 * 将(KING)的移动规则
 * <p>
 * Created by ddd on 16/8/27.
 */
public class KingRule extends ChineseChessRule {

    @Override
    protected boolean moveRule() {

        int toPointX = getPoint().getX();
        int pointX = getPiece().getPoint().getX();

        int toPointY = getPoint().getY();
        int pointY = getPiece().getPoint().getY();

        if (pointY != toPointY && pointX == toPointX) {
            // Y坐标不同,X坐标相同,在Y轴上移动
            return equalsLineInY(pointX, toPointY, pointY);
        } else if (pointX != toPointX && pointY == toPointY) {
            // X坐标不同,Y坐标相同,在X轴上移动
            return equalsLineInX(pointY, toPointX, pointX);
        }

        return false;
    }

    /**
     * 在X轴上移动
     *
     * @param coordinateY
     * @param toX
     * @param oldX
     * @return
     */
    private boolean equalsLineInX(int coordinateY, int toX, int oldX) {

        // 将每次只能移动一个单位
        if (Math.abs(toX - oldX) != 1) return false;

        // 蓝方的将只能在0-2移动
        if (Groups.GROUP_BLUE == getPiece().getGroup() && toX > 2) return false;
        // 红方的将只能在9-7移动
        if (Groups.GROUP_RED == getPiece().getGroup() && toX < 7) return false;

        // 是否对将
        if (otherKingAtLine(toX, coordinateY)) return false;

        if (getBoard().getPiece(getPoint()) != null &&
                getPiece().getGroup() == getBoard().getPiece(getPoint()).getGroup())
            return false;

        return true;

    }

    /**
     * 在Y轴上移动
     *
     * @param coordinateX
     * @param toY
     * @param oldY
     * @return
     */
    private boolean equalsLineInY(int coordinateX, int toY, int oldY) {

        // 将每次只能移动一个单位
        if (Math.abs(toY - oldY) != 1) return false;

        // 将在Y轴上,只能在3-5的范围能移动
        if (toY <= 3 && toY >= 5) return false;

        // 是否对将
        if (otherKingAtLine(coordinateX, toY)) return false;

        // 落点不能有自己的棋子
        if (getBoard().getPiece(getPoint()) != null &&
                getPiece().getGroup() == getBoard().getPiece(getPoint()).getGroup())
            return false;

        return true;
    }

    /**
     * 对将
     *
     * @param toX
     * @param toY
     * @return true对将, 不能移动;false不对将,可以移动。
     */
    private boolean otherKingAtLine(int toX, int toY) {

        BoardPoint tmpPoint = new BoardPoint(toX, toY);

        if (Groups.GROUP_BLUE == getPiece().getGroup()) {
            // 蓝方需要从0->9进行判断
            for (int i = toX + 1; i <= 9; i++) {

                tmpPoint.setX(i);

                IPiece pieceAtLine = getBoard().getPiece(tmpPoint);

                // X轴上有其他棋子,则可以移动,退出循环
                if (pieceAtLine != null && pieceAtLine.getType() != PieceType.KING) return false;

                // X轴上在将之前没有其他棋子,则不可移动
                if (pieceAtLine != null && pieceAtLine.getType() == PieceType.KING) return true;

            }

        } else if (Groups.GROUP_RED == getPiece().getGroup()) {

            // 红方需要从9->0进行判断
            for (int i = toX - 1; i >= 0; i--) {

                tmpPoint.setX(i);

                IPiece pieceAtLine = getBoard().getPiece(tmpPoint);

                // X轴上有其他棋子,则可以移动,退出循环
                if (pieceAtLine != null && pieceAtLine.getType() != PieceType.KING) return false;

                // X轴上在将之前没有其他棋子,则不可移动
                if (pieceAtLine != null && pieceAtLine.getType() == PieceType.KING) return true;

            }
        }

        // 前方没有其他棋子,可以移动
        return false;
    }


}
