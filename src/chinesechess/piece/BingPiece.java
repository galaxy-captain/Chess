package chinesechess.piece;

import chinesechess.rule.BingRule;
import chinesechess.rule.PaoRule;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.AbsPiece;
import org.ddd.piece.impl.PieceType;
import org.ddd.rule.impl.IRule;

/**
 * Created by ddd on 16/8/27.
 */
public class BingPiece extends AbsPiece {

    public BingPiece(int group, BoardPoint point) {
        super(group, point);
    }

    @Override
    protected int pieceType() {
        return PieceType.BING;
    }

    @Override
    protected IRule pieceRule() {
        return new BingRule();
    }

    @Override
    public String getView() {
        return "兵";
    }

}
