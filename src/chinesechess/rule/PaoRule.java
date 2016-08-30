package chinesechess.rule;

import chinesechess.helper.ChineseChessHelper;
import chinesechess.rule.abs.ChineseChessRule;
import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;

/**
 * 炮(PAO)的移动规则
 * Created by ddd on 16/8/26.
 */
public class PaoRule extends ChineseChessRule {

    @Override
    protected boolean moveRule() {

        int toPointX = getPoint().getX();
        int pointX = getPiece().getPoint().getX();

        int toPointY = getPoint().getY();
        int pointY = getPiece().getPoint().getY();

        if (pointX != toPointX && pointY == toPointY) {
            return equalsLineInX(pointY, toPointX, pointX);
        } else if (pointX == toPointX && pointY != toPointY) {
            return equalsLineInY(pointX, toPointY, pointY);
        }

        return false;
    }

    private boolean equalsLineInX(int coordinateY, int toX, int oldX) {

        IPiece toPiece = getBoard().getPiece(getPoint());

        int count = ChineseChessHelper.getPieceNumBetweenOTAtLineX(getBoard(), coordinateY, oldX, toX);

        // 如果落点有棋子,并且不是同一队伍的,并且落点棋子到炮之间有且只有一颗棋子,则可以开炮
        if (toPiece != null && toPiece.getGroup() != getPiece().getGroup() && count == 1) return true;

        // 如果落点没有棋子,并且炮到落点之前没有棋子,则可以移动
        if (toPiece == null && count == 0) return true;

        return false;
    }

    private boolean equalsLineInY(int coordinateX, int toY, int oldY) {

        IPiece toPiece = getBoard().getPiece(getPoint());

        int count = ChineseChessHelper.getPieceNumBetweenOTAtLineY(getBoard(), coordinateX, oldY, toY);

        // 如果落点有棋子,并且不是同一队伍的,并且落点棋子到炮之间有且只有一颗棋子,则可以开炮
        if (toPiece != null && toPiece.getGroup() != getPiece().getGroup() && count == 1) return true;

        // 如果落点没有棋子,并且炮到落点之前没有棋子,则可以移动
        if (toPiece == null && count == 0) return true;

        return false;
    }


}
