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
        return false;
    }

}
