package chinesechess.board;

import org.ddd.board.AbsBoard;
import org.ddd.board.IBoardMap;
import org.ddd.piece.impl.IPiece;

import java.util.Map;
import java.util.Set;

/**
 * 中国象棋
 * <p>
 * Created by ddd on 16/8/26.
 */
public class ChineseChess extends AbsBoard {

    public static ChineseChess newGame() {
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

    }

    public Map map() {
        return super.boardMap.getBoardMap();
    }

    public void view() {

        Map<String, IPiece> map = super.boardMap.getBoardMap();

        for (int x = 0; x < 10; x++) {

            for (int y = 0; y < 9; y++) {

                IPiece piece = map.get(x + "," + y);

                if (piece == null) {

                    if (x == 4 || x == 5) {
                        System.out.print("一");
                    } else {
                        System.out.print("十");
                    }

                } else {
                    System.out.print(piece.getView());
                }

                System.out.print(" ");
            }

            System.out.println();

            if (x == 4) {
//                System.out.println("------------------------");
                System.out.println("\t\t汉界  楚河");
//                System.out.println("------------------------");
            }
        }

    }

}
