package chinesechess.rule;

import chinesechess.board.Groups;
import chinesechess.rule.abs.ChineseChessRule;
import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;

/**
 * 士(SHI)的移动规则
 * <p>
 * Created by ddd on 16/8/27.
 */
public class ShiRule extends ChineseChessRule {

    @Override
    protected boolean moveRule() {

        int toPointX = getPoint().getX();
        int pointX = getPiece().getPoint().getX();

        int toPointY = getPoint().getY();
        int pointY = getPiece().getPoint().getY();

        // 只能斜着移动一个格子
        if (!(Math.abs(toPointX - pointX) == 1 && Math.abs(toPointY - pointY) == 1)) return false;

        // 只能在范围内移动
        if (!moveRange(toPointX, toPointY)) return false;

        if (getBoard().getPiece(getPoint()) != null &&
                getPiece().getGroup() == getBoard().getPiece(getPoint()).getGroup())
            return false;

        return true;
    }

    /**
     * 士的移动范围
     *
     * @param toX
     * @param toY
     * @return
     */
    private boolean moveRange(int toX, int toY) {

        if (getPiece().getGroup() == Groups.GROUP_BLUE && toY <= 2 && toX >= 3 && toX <= 5) return true;
        else if (getPiece().getGroup() == Groups.GROUP_RED && toY >= 7 && toX >= 3 && toX <= 5) return true;

        return false;

    }

}
