package chinesechess.rule;

import chinesechess.rule.abs.ChineseChessRule;
import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;

/**
 * Created by ddd on 16/8/26.
 */
public class BingRule extends ChineseChessRule {

    @Override
    public boolean move(AbsBoard board, BoardPoint point, IPiece piece) {
        super.move(board, point, piece);

        movePiece(false);

        return true;
    }

}
