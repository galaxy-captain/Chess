package chinesechess.game;

import chinesechess.board.ChineseBoardMap;
import chinesechess.board.ChineseChess;
import chinesechess.board.Groups;
import chinesechess.piece.JuPiece;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;

/**
 * Created by ddd on 16/8/26.
 */
public class Game {

    public static void main(String[] args) {

        ChineseChess game = new ChineseChess();

        IPiece ju = new JuPiece(Groups.GROUP_BLUE);

        game.putPiece(new BoardPoint(4, 0), ju);

        game.putPiece(new BoardPoint(4, 5), ju);

        game.view();

    }

}
