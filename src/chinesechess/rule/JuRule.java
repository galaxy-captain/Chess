package chinesechess.rule;

import org.ddd.board.AbsBoard;
import org.ddd.board.BoardPoint;
import org.ddd.board.IBoard;
import org.ddd.piece.impl.IPiece;
import org.ddd.rule.impl.IRule;

/**
 * Created by ddd on 16/8/26.
 */
public class JuRule implements IRule {

    @Override
    public boolean move(AbsBoard board, BoardPoint point, IPiece piece) {

        // 将棋子移动到指定位置
        board.putPieceOnMap(point, piece);
        // 将棋子原所在位置置空
        board.putPieceOnMap(piece.getPoint(), null);
        // 改变棋子中记录的位置
        piece.setPoint(point);

        return true;
    }

}
