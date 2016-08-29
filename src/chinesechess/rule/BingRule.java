package chinesechess.rule;

import chinesechess.board.Groups;
import chinesechess.rule.abs.ChineseChessRule;
import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;

/**
 * 兵(BING)的移动规则
 * <p>
 * Created by ddd on 16/8/26.
 */
public class BingRule extends ChineseChessRule {

    @Override
    protected boolean moveRule() {

        int pointX = getPiece().getPoint().getX();
        int toPointX = getPoint().getX();

        int pointY = getPiece().getPoint().getY();
        int toPointY = getPoint().getY();

        if (pointX == toPointX && pointY != toPointY) {
            return equalsLineInY(pointX, toPointY, pointY);

        } else if (pointX != toPointX && pointY == toPointY) {
            return equalsLineInX(toPointX, pointX);
        }

        return false;
    }

    /**
     * 在X轴上移动,Y坐标不变
     *
     * @param toX
     * @param oldX
     * @return
     */
    private boolean equalsLineInX(int toX, int oldX) {

        // 兵每次只能移动一个单位
        if (Math.abs(toX - oldX) != 1) return false;

        // 蓝方的兵只能由0->9移动
        if (Groups.GROUP_BLUE == getPiece().getGroup() && toX < oldX) return false;
        // 红方的兵只能由9->0移动
        if (Groups.GROUP_RED == getPiece().getGroup() && toX > oldX) return false;

        if (getBoard().getPiece(getPoint()) != null &&
                getPiece().getGroup() == getBoard().getPiece(getPoint()).getGroup())
            return false;

        return true;

    }

    /**
     * 在Y轴上移动,X坐标不变
     *
     * @param coordinateX
     * @param toY
     * @param oldY
     * @return
     */
    private boolean equalsLineInY(int coordinateX, int toY, int oldY) {

        // 兵每次只能移动一个单位
        if (Math.abs(toY - oldY) != 1) return false;

        // 蓝方的兵只能在过河(X轴坐标大于5)以后才能横向移动
        if (Groups.GROUP_BLUE == getPiece().getGroup() && coordinateX < 5) return false;
        // 蓝方的兵只能在过河(X轴坐标小于5)以后才能横向移动
        if (Groups.GROUP_RED == getPiece().getGroup() && coordinateX > 5) return false;

        if (getBoard().getPiece(getPoint()) != null &&
                getPiece().getGroup() == getBoard().getPiece(getPoint()).getGroup())
            return false;

        return true;
    }

}
