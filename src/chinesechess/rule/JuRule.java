package chinesechess.rule;

import chinesechess.rule.abs.ChineseChessRule;
import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;

/**
 * 车(JU)的移动规则
 *
 * Created by ddd on 16/8/26.
 */
public class JuRule extends ChineseChessRule {

    @Override
    protected boolean moveRule() {

        int toPointX = getPoint().getX();
        int pointX = getPiece().getPoint().getX();

        int toPointY = getPoint().getY();
        int pointY = getPiece().getPoint().getY();

        if (pointX == toPointX && pointY != toPointY) {
            return equalsLineInY(pointX, toPointY, pointY);

        } else if (pointX != toPointX && pointY == toPointY) {
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

        // 不能原地移动
        if(toX == oldX) return false;

        BoardPoint tmpPoint = new BoardPoint(oldX, coordinateY);

        if (toX > oldX) {

            // 棋子走向的点,X坐标比棋子的X坐标大
            for (int i = oldX + 1; i < toX; i++) {

                tmpPoint.setX(i);
                if (equalsPiece(getBoard().getPiece(tmpPoint))) return false;

            }

            if (getBoard().getPiece(getPoint()) != null &&
                    getPiece().getGroup() == getBoard().getPiece(getPoint()).getGroup())
                return false;

        } else if (toX < oldX) {

            for (int i = oldX - 1; i > toX; i--) {

                tmpPoint.setX(i);
                if (equalsPiece(getBoard().getPiece(tmpPoint))) return false;

            }

            if (getBoard().getPiece(getPoint()) != null &&
                    getPiece().getGroup() == getBoard().getPiece(getPoint()).getGroup())
                return false;

        }

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

        // 不能原地移动
        if(toY == oldY) return false;

        BoardPoint tmpPoint = new BoardPoint(coordinateX, oldY);

        if (toY > oldY) {
            // 棋子走向的点,Y坐标比棋子的Y坐标大
            for (int i = oldY + 1; i < toY; i++) {

                tmpPoint.setY(i);
                if (equalsPiece(getBoard().getPiece(tmpPoint))) return false;
            }

        } else if (toY < oldY) {

            for (int i = oldY - 1; i > toY; i--) {

                tmpPoint.setY(i);
                if (equalsPiece(getBoard().getPiece(tmpPoint))) return false;

            }

        }

        if (getBoard().getPiece(getPoint()) != null &&
                getPiece().getGroup() == getBoard().getPiece(getPoint()).getGroup())
            return false;

        return true;
    }

    /**
     * 有棋子,则不能前进
     *
     * @param toPiece
     * @return
     */
    private boolean equalsPiece(IPiece toPiece) {
        return toPiece != null;
    }

}
