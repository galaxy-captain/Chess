package chinesechess.board;

import chinesechess.piece.*;
import org.ddd.board.BoardPoint;
import org.ddd.board.IBoardMap;
import org.ddd.piece.impl.IPiece;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ddd on 16/8/26.
 */
public class ChineseBoardMap implements IBoardMap {

    private Map<String, IPiece> boardMap = new HashMap<>();

    public ChineseBoardMap() {
        initMap();
    }

    private void initMap() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 10; y++) {
                boardMap.put(autoKey(x, y), null);
            }
        }
    }

    /**
     * 初始化棋盘上的所有棋子
     */
    public void initPiece() {
        // 初始化蓝方棋子
        putPiece(new BoardPoint(0, 0), new JuPiece(Groups.GROUP_BLUE, new BoardPoint(0, 0)));
        putPiece(new BoardPoint(8, 0), new JuPiece(Groups.GROUP_BLUE, new BoardPoint(8, 0)));
        putPiece(new BoardPoint(1, 0), new MaPiece(Groups.GROUP_BLUE, new BoardPoint(1, 0)));
        putPiece(new BoardPoint(7, 0), new MaPiece(Groups.GROUP_BLUE, new BoardPoint(7, 0)));
        putPiece(new BoardPoint(2, 0), new XiangPiece(Groups.GROUP_BLUE, new BoardPoint(2, 0)));
        putPiece(new BoardPoint(6, 0), new XiangPiece(Groups.GROUP_BLUE, new BoardPoint(6, 0)));
        putPiece(new BoardPoint(3, 0), new ShiPiece(Groups.GROUP_BLUE, new BoardPoint(3, 0)));
        putPiece(new BoardPoint(5, 0), new ShiPiece(Groups.GROUP_BLUE, new BoardPoint(5, 0)));
        putPiece(new BoardPoint(4, 0), new KingPiece(Groups.GROUP_BLUE, new BoardPoint(4, 0)));
        putPiece(new BoardPoint(1, 2), new PaoPiece(Groups.GROUP_BLUE, new BoardPoint(1, 2)));
        putPiece(new BoardPoint(7, 2), new PaoPiece(Groups.GROUP_BLUE, new BoardPoint(7, 2)));
        putPiece(new BoardPoint(0, 3), new BingPiece(Groups.GROUP_BLUE, new BoardPoint(0, 3)));
        putPiece(new BoardPoint(2, 3), new BingPiece(Groups.GROUP_BLUE, new BoardPoint(2, 3)));
        putPiece(new BoardPoint(4, 3), new BingPiece(Groups.GROUP_BLUE, new BoardPoint(4, 3)));
        putPiece(new BoardPoint(6, 3), new BingPiece(Groups.GROUP_BLUE, new BoardPoint(6, 3)));
        putPiece(new BoardPoint(8, 3), new BingPiece(Groups.GROUP_BLUE, new BoardPoint(8, 3)));
        // 初始化红方棋子
        putPiece(new BoardPoint(0, 9), new JuPiece(Groups.GROUP_RED, new BoardPoint(0, 9)));
        putPiece(new BoardPoint(8, 9), new JuPiece(Groups.GROUP_RED, new BoardPoint(8, 9)));
        putPiece(new BoardPoint(1, 9), new MaPiece(Groups.GROUP_RED, new BoardPoint(1, 9)));
        putPiece(new BoardPoint(7, 9), new MaPiece(Groups.GROUP_RED, new BoardPoint(7, 9)));
        putPiece(new BoardPoint(2, 9), new XiangPiece(Groups.GROUP_RED, new BoardPoint(2, 9)));
        putPiece(new BoardPoint(6, 9), new XiangPiece(Groups.GROUP_RED, new BoardPoint(6, 9)));
        putPiece(new BoardPoint(3, 9), new ShiPiece(Groups.GROUP_RED, new BoardPoint(3, 9)));
        putPiece(new BoardPoint(5, 9), new ShiPiece(Groups.GROUP_RED, new BoardPoint(5, 9)));
        putPiece(new BoardPoint(4, 9), new KingPiece(Groups.GROUP_RED, new BoardPoint(4, 9)));
        putPiece(new BoardPoint(1, 7), new PaoPiece(Groups.GROUP_RED, new BoardPoint(1, 7)));
        putPiece(new BoardPoint(7, 7), new PaoPiece(Groups.GROUP_RED, new BoardPoint(7, 7)));
        putPiece(new BoardPoint(0, 6), new BingPiece(Groups.GROUP_RED, new BoardPoint(0, 6)));
        putPiece(new BoardPoint(2, 6), new BingPiece(Groups.GROUP_RED, new BoardPoint(2, 6)));
        putPiece(new BoardPoint(4, 6), new BingPiece(Groups.GROUP_RED, new BoardPoint(4, 6)));
        putPiece(new BoardPoint(6, 6), new BingPiece(Groups.GROUP_RED, new BoardPoint(6, 6)));
        putPiece(new BoardPoint(8, 6), new BingPiece(Groups.GROUP_RED, new BoardPoint(8, 6)));
    }

    private String autoKey(BoardPoint point) {
        return autoKey(point.getX(), point.getY());
    }

    private String autoKey(int x, int y) {
        return (x + "," + y);
    }

    @Override
    public void putPiece(BoardPoint point, IPiece piece) {
        boardMap.put(autoKey(point), piece);
    }

    @Override
    public IPiece getPiece(BoardPoint point) {
        return boardMap.get(autoKey(point));
    }

    @Override
    public Map<String, IPiece> getBoardMap() {
        return boardMap;
    }

}
