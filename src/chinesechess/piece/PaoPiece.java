package chinesechess.piece;

import chinesechess.rule.KingRule;
import chinesechess.rule.PaoRule;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.AbsPiece;
import org.ddd.piece.impl.PieceType;
import org.ddd.rule.impl.IRule;

/**
 * Created by ddd on 16/8/27.
 */
public class PaoPiece extends AbsPiece {

    public PaoPiece(int group, BoardPoint point) {
        super(group, point);
    }

    @Override
    protected int pieceType() {
        return PieceType.PAO;
    }

    @Override
    protected IRule pieceRule() {
        return new PaoRule();
    }

    @Override
    public String getView() {
        return "炮";
    }

}
