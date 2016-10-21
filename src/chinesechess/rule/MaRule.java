package chinesechess.rule;

import chinesechess.rule.abs.ChineseChessRule;
import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;

/**
 * Created by ddd on 16/8/27.
 */
public class MaRule extends ChineseChessRule {

    @Override
    protected boolean moveRule() {

        int toPointX = getPoint().getX();
        int pointX = getPiece().getPoint().getX();

        int toPointY = getPoint().getY();
        int pointY = getPiece().getPoint().getY();

        if (!movePosition(toPointX, toPointY, pointX, pointY)) return false;

        if (hasMoveObstacle(toPointX, toPointY, pointX, pointY)) return false;

        if (getBoard().getPiece(getPoint()) != null &&
                getPiece().getGroup() == getBoard().getPiece(getPoint()).getGroup())
            return false;

        return true;
    }

    /**
     * 计算落点是否符合规则,即马走日
     */
    private boolean movePosition(int toPointX, int toPointY, int pointX, int pointY) {

        if (Math.abs(toPointX - pointX) == 1 && Math.abs(toPointY - pointY) == 2) return true;
        else if (Math.abs(toPointX - pointX) == 2 && Math.abs(toPointY - pointY) == 1) return true;

        return false;
    }

    /**
     * 检查移动路径上是否有棋子,即蹩马腿
     *
     * @param toPointX
     * @param toPointY
     * @param pointX
     * @param pointY
     * @return
     */
    private boolean hasMoveObstacle(int toPointX, int toPointY, int pointX, int pointY) {

        BoardPoint checkPoint = new BoardPoint();

        if (Math.abs(toPointX - pointX) == 2) {

            int x;
            int y;

            // 检查点的X坐标等于出发点和目标点的中点
            if (toPointX > pointX) {
                x = pointX + 1;
            } else {
                x = toPointX + 1;
            }

            // 检查点的Y坐标等于出发点的Y坐标
            y = pointY;

            checkPoint.setXY(x, y);

        } else if (Math.abs(toPointY - pointY) == 2) {

            int x;
            int y;

            // 检查点的X坐标等于出发点和目标点的中点
            if (pointY < toPointY) {
                y = pointY + 1;
            } else {
                y = toPointY + 1;
            }

            x = pointX;

            checkPoint.setXY(x, y);

        }

        return getBoard().getPiece(checkPoint) != null;
    }

}
