package chinesechess.piece;

import chinesechess.rule.JuRule;
import org.ddd.piece.impl.AbsPiece;
import org.ddd.piece.impl.PieceType;
import org.ddd.rule.impl.IRule;

/**
 * Created by ddd on 16/8/26.
 */
public class JuPiece extends AbsPiece {

    public JuPiece(int group) {
        super(group);
    }

    @Override
    protected int pieceType() {
        return PieceType.JU;
    }

    @Override
    protected IRule pieceRule() {
        return new JuRule();
    }

}
