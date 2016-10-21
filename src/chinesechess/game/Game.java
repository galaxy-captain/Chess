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

        GameController game = GameController.init();
//        ChineseChess game = new ChineseChess();


        // 马(MA)移动测试
        game.step(Groups.GROUP_RED, 6, 0, 9, 0);
//        game.step(Groups.GROUP_BLUE, 0, 1, 0, 0);
//        game.putPiece(new BoardPoint(2, 4), game.getPiece(new BoardPoint(0, 2)));
//        game.putPiece(new BoardPoint(6, 3), game.getPiece(new BoardPoint(1,3)));
//        game.putPiece(new BoardPoint(6, 2), game.getPiece(new BoardPoint(6,3)));

//        game.putPiece(new BoardPoint(4,0),game.getPiece(new BoardPoint(3,0)));
//        game.putPiece(new BoardPoint(5,0),game.getPiece(new BoardPoint(6,0)));
//        game.putPiece(new BoardPoint(4,0),game.getPiece(new BoardPoint(5,0)));
//        game.putPiece(new BoardPoint(4,1),game.getPiece(new BoardPoint(4,0)));

//        game.putPiece(new BoardPoint(0,5),game.getPiece(new BoardPoint(0,4)));

//        game.putPiece(new BoardPoint(2,4),game.getPiece(new BoardPoint(2,1)));
//        game.putPiece(new BoardPoint(6,4),game.getPiece(new BoardPoint(2,4)));
//        game.putPiece(new BoardPoint(7,4),game.getPiece(new BoardPoint(6,4)));

//        game.putPiece(new BoardPoint(8, 4), game.getPiece(new BoardPoint(9, 3)));
//        game.putPiece(new BoardPoint(7, 5), game.getPiece(new BoardPoint(8, 4)));
//        game.putPiece(new BoardPoint(6, 6), game.getPiece(new BoardPoint(7, 5)));

//        game.putPiece(new BoardPoint(1, 0), game.getPiece(new BoardPoint(0, 0)));
//        game.putPiece(new BoardPoint(1, 2), game.getPiece(new BoardPoint(1, 0)));
//        game.putPiece(new BoardPoint(2, 0), game.getPiece(new BoardPoint(0, 2)));

        game.view();

        System.out.println(game.map().toString());

    }

}
