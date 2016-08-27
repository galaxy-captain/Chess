package chinesechess.board;

import org.ddd.board.AbsBoard;
import org.ddd.board.IBoardMap;
import org.ddd.piece.impl.IPiece;

import java.util.Map;
import java.util.Set;

/**
 * Created by ddd on 16/8/26.
 */
public class ChineseChess extends AbsBoard {

    int[][] mView = new int[][]{
            {0, 1, 2, 3, 4, 5, 6, 7, 8},
            {0, 1, 2, 3, 4, 5, 6, 7, 8},
            {0, 1, 2, 3, 4, 5, 6, 7, 8},
            {0, 1, 2, 3, 4, 5, 6, 7, 8},
            {0, 1, 2, 3, 4, 5, 6, 7, 8},
            {0, 1, 2, 3, 4, 5, 6, 7, 8},
            {0, 1, 2, 3, 4, 5, 6, 7, 8},
            {0, 1, 2, 3, 4, 5, 6, 7, 8},
            {0, 1, 2, 3, 4, 5, 6, 7, 8},
            {0, 1, 2, 3, 4, 5, 6, 7, 8},
    };

    public static ChineseChess createChess() {
        return new ChineseChess(new ChineseBoardMap());
    }

    private ChineseChess(ChineseBoardMap boardMap) {
        super(boardMap);
        boardMap.initPiece();
    }

    public ChineseChess() {
        this(new ChineseBoardMap());
    }

    @Override
    protected void savePieceMoveSetup(Map<String, IPiece> map) {
        System.out.println();
        System.out.println("保存棋盘成功");
        System.out.println();
    }

    public void view() {

        Map<String, IPiece> map = super.boardMap.getBoardMap();

        for (int x = 0; x < 10; x++) {

            for (int y = 0; y < 9; y++) {

                IPiece piece = map.get(x + "," + y);

                if (piece == null) {
                    System.out.print("十");
                } else {
                    System.out.print(piece.getView());
                }

                System.out.print(" ");
            }

            System.out.println();

            if (x == 4) {
                System.out.println("------------------------");
                System.out.println("\t\t汉界  楚河");
                System.out.println("------------------------");
            }
        }

    }

}
