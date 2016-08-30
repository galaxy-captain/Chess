package chinesechess.piece;

import chinesechess.rule.XiangRule;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.AbsPiece;
import chinesechess.board.PieceType;
import org.ddd.rule.impl.IRule;

/**
 * Created by ddd on 16/8/27.
 */
public class XiangPiece extends AbsPiece {

    public XiangPiece(int group, BoardPoint point) {
        super(group, point);
    }

    @Override
    protected int pieceType() {
        return PieceType.XIANG;
    }

    @Override
    protected IRule pieceRule() {
        return new XiangRule();
    }

    @Override
    public String getView() {
        return "象";
    }

}
