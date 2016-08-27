package chinesechess.piece;

import chinesechess.rule.MaRule;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.AbsPiece;
import org.ddd.piece.impl.PieceType;
import org.ddd.rule.impl.IRule;

/**
 * Created by ddd on 16/8/27.
 */
public class MaPiece extends AbsPiece {

    public MaPiece(int group, BoardPoint point) {
        super(group, point);
    }

    @Override
    protected int pieceType() {
        return PieceType.MA;
    }

    @Override
    protected IRule pieceRule() {
        return new MaRule();
    }

    @Override
    public String getView() {
        return "马";
    }
}
