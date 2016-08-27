package chinesechess.rule.abs;

import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;
import org.ddd.rule.impl.IRule;

/**
 * Created by ddd on 16/8/27.
 */
public class ChineseChessRule implements IRule {

    private AbsBoard board;
    private BoardPoint point;
    private IPiece piece;

    @Override
    public boolean move(AbsBoard board, BoardPoint point, IPiece piece) {

        this.board = board;
        this.point = point;
        this.piece = piece;

        return false;
    }

    protected void movePiece(boolean move) {

        if (!move) return;

        // 将棋子移动到指定位置
        board.putPieceOnMap(point, piece);
        // 将棋子原所在位置置空
        board.putPieceOnMap(piece.getPoint(), null);
        // 改变棋子中记录的位置
        piece.setPoint(point);
    }

    public AbsBoard getBoard() {
        return board;
    }

    public BoardPoint getPoint() {
        return point;
    }

    public IPiece getPiece() {
        return piece;
    }
}
