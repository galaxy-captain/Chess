package chinesechess.rule;

import chinesechess.board.Groups;
import chinesechess.rule.abs.ChineseChessRule;
import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;

/**
 * 象(XIANG)的移动规则
 * Created by ddd on 16/8/27.
 */
public class XiangRule extends ChineseChessRule {

    @Override
    protected boolean moveRule() {

        int toPointX = getPoint().getX();
        int pointX = getPiece().getPoint().getX();

        int toPointY = getPoint().getY();
        int pointY = getPiece().getPoint().getY();

        // 只能在2x2的格子上移动,既象走田
        if (!(Math.abs(toPointX - pointX) == 2 && Math.abs(toPointY - pointY) == 2)) return false;

        if (hasMoveObstacle(toPointX, toPointY, pointX, pointY)) return false;

        // 只能在范围内移动
        if (!moveRange(toPointY)) return false;

        if (getBoard().getPiece(getPoint()) != null &&
                getPiece().getGroup() == getBoard().getPiece(getPoint()).getGroup())
            return false;

        return true;
    }

    /**
     * 象的移动范围,象不能过河
     *
     * @param toY
     * @return
     */
    private boolean moveRange(int toY) {

        if (getPiece().getGroup() == Groups.GROUP_BLUE && toY <= 4) return true;
        else if (getPiece().getGroup() == Groups.GROUP_RED && toY >= 7) return true;

        return false;

    }

    /**
     * 移动路径上,是否有棋子,既蹩象腿
     *
     * @param toX
     * @param toY
     * @param oldX
     * @param oldY
     * @return true有棋子,不能移动;false没有棋子,可以移动
     */
    private boolean hasMoveObstacle(int toX, int toY, int oldX, int oldY) {

        BoardPoint checkPoint = new BoardPoint();

        if (toX > oldX) checkPoint.setX(oldX + 1);
        else if (toX < oldX) checkPoint.setX(oldX - 1);

        if (toY > oldY) checkPoint.setY(oldY + 1);
        else if (toY < oldY) checkPoint.setY(oldY - 1);

        return getBoard().getPiece(checkPoint) != null;
    }


}
