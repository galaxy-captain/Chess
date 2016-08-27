package chinesechess.piece;

import chinesechess.rule.KingRule;
import chinesechess.rule.ShiRule;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.AbsPiece;
import org.ddd.piece.impl.PieceType;
import org.ddd.rule.impl.IRule;

/**
 * Created by ddd on 16/8/27.
 */
public class KingPiece extends AbsPiece {

    public KingPiece(int group, BoardPoint point) {
        super(group, point);
    }

    @Override
    protected int pieceType() {
        return PieceType.KING;
    }

    @Override
    protected IRule pieceRule() {
        return new KingRule();
    }

    @Override
    public String getView() {
        return "将";
    }

}
