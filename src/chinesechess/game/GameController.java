package chinesechess.game;

import chinesechess.board.ChineseChess;
import chinesechess.board.Groups;
import org.ddd.board.BoardPoint;
import org.ddd.piece.impl.IPiece;

import java.util.Map;

/**
 * Created by ddd on 16/8/27.
 */
public class GameController {

    private ChineseChess mGame;

    private int mGroup = Groups.GROUP_RED;

    public static GameController init() {
        return init(new ChineseChess());
    }

    public static GameController init(ChineseChess game) {
        return new GameController(game);
    }

    public GameController(ChineseChess game) {
        this.mGame = game;
    }

    public void view() {
        mGame.view();
    }

    public Map map() {
        return mGame.map();
    }

    /**
     * @param pointX 棋盘坐标X
     * @param pointY 棋盘坐标Y
     * @param pieceX 棋子棋盘坐标X
     * @param pieceY 棋子棋盘坐标Y
     * @return 是否移动成功
     */
    public boolean putPiece(int pointX, int pointY, int pieceX, int pieceY) {
        return mGame.putPiece(pointX, pointY, pieceX, pieceY);
    }

    public IPiece getPiece(BoardPoint point) {
        return mGame.getPiece(point);
    }

    /**
     * 切换执棋的人,红->蓝,蓝->红
     */
    private void changeGroup() {
        if (mGroup == Groups.GROUP_BLUE) mGroup = Groups.GROUP_RED;
        else if (mGroup == Groups.GROUP_RED) mGroup = Groups.GROUP_BLUE;
    }

    /**
     * 下棋
     *
     * @param pointX 棋盘坐标X
     * @param pointY 棋盘坐标Y
     * @param pieceX 棋子棋盘坐标X
     * @param pieceY 棋子棋盘坐标Y
     */
    public boolean step(int group, int pointX, int pointY, int pieceX, int pieceY) {

        if (group != this.mGroup) {
            System.out.println("没有执子权限\n");
            return false;
        }

        IPiece piece = mGame.getPiece(pieceX, pieceY);

        if (piece != null && piece.getGroup() != this.mGroup) {
            System.out.println("只能控制自己的棋子\n");
            return false;
        }

        boolean isMove = putPiece(pointX, pointY, pieceX, pieceY);

        if (isMove)
            changeGroup();

        return isMove;

    }

    public int group() {
        return this.mGroup;
    }

}
