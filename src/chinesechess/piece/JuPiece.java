package chinesechess.piece;

import chinesechess.rule.JuRule;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.AbsPiece;
import chinesechess.board.PieceType;
import org.ddd.rule.impl.IRule;

/**
 * Created by ddd on 16/8/26.
 */
public class JuPiece extends AbsPiece {

    public JuPiece(int group, BoardPoint point) {
        super(group, point);
    }

    @Override
    protected int pieceType() {
        return PieceType.JU;
    }

    @Override
    protected IRule pieceRule() {
        return new JuRule();
    }

    @Override
    public String getView() {
        return "车";
    }
}
