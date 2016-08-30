package chinesechess.piece;

import chinesechess.rule.ShiRule;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.AbsPiece;
import chinesechess.board.PieceType;
import org.ddd.rule.impl.IRule;

/**
 * Created by ddd on 16/8/27.
 */
public class ShiPiece extends AbsPiece {

    public ShiPiece(int group, BoardPoint point) {
        super(group, point);
    }

    @Override
    protected int pieceType() {
        return PieceType.SHI;
    }

    @Override
    protected IRule pieceRule() {
        return new ShiRule();
    }

    @Override
    public String getView() {
        return "士";
    }

}
