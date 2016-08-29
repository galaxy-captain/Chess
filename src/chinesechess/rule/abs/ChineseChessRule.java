package chinesechess.rule.abs;

import org.ddd.rule.impl.AbsRule;


/**
 * Created by ddd on 16/8/27.
 */
public abstract class ChineseChessRule extends AbsRule {

    @Override
    protected void movePiece(boolean isMove) {

        if (!isMove) {
            System.out.println("\n移动失败\n");
            return;
        }

        // 将棋子移动到指定位置
        board.putPieceOnMap(point, piece);
        // 将棋子原所在位置置空
        board.putPieceOnMap(piece.getPoint(), null);
        // 改变棋子中记录的位置
        piece.setPoint(point);

        System.out.println("\n移动成功\n");

    }

}
