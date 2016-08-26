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

    private IBoardMap boardMap;

    public static ChineseChess createChess() {
        return new ChineseChess(new ChineseBoardMap());
    }

    private ChineseChess(IBoardMap boardMap) {
        super(boardMap);
        this.boardMap = boardMap;
    }

    public ChineseChess() {
        this(new ChineseBoardMap());
    }

    @Override
    protected void savePieceMoveSetup() {

    }

    public void view() {

        Map<String, IPiece> map = boardMap.getBoardMap();

        int[][] view = new int[][]{
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

        for (int y = 0; y < 10; y++) {

            for (int x = 0; x < 9; x++) {

                IPiece piece = map.get(x + "," + y);

                if (piece == null)
                    System.out.print(-1);
                else
                    System.out.print("+" + piece.getType());

                System.out.print(" ");
            }

            System.out.println();
        }
    }

}
