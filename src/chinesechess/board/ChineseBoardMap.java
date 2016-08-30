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

    public void initPiece() {
        // 初始化蓝方棋子
        putPiece(new BoardPoint(0, 0), new JuPiece(Groups.GROUP_BLUE, new BoardPoint(0, 0)));
        putPiece(new BoardPoint(0, 8), new JuPiece(Groups.GROUP_BLUE, new BoardPoint(0, 8)));
        putPiece(new BoardPoint(0, 1), new MaPiece(Groups.GROUP_BLUE, new BoardPoint(0, 1)));
        putPiece(new BoardPoint(0, 7), new MaPiece(Groups.GROUP_BLUE, new BoardPoint(0, 7)));
        putPiece(new BoardPoint(0, 2), new XiangPiece(Groups.GROUP_BLUE, new BoardPoint(0, 2)));
        putPiece(new BoardPoint(0, 6), new XiangPiece(Groups.GROUP_BLUE, new BoardPoint(0, 6)));
        putPiece(new BoardPoint(0, 3), new ShiPiece(Groups.GROUP_BLUE, new BoardPoint(0, 3)));
        putPiece(new BoardPoint(0, 5), new ShiPiece(Groups.GROUP_BLUE, new BoardPoint(0, 5)));
        putPiece(new BoardPoint(0, 4), new KingPiece(Groups.GROUP_BLUE, new BoardPoint(0, 4)));
        putPiece(new BoardPoint(2, 1), new PaoPiece(Groups.GROUP_BLUE, new BoardPoint(2, 1)));
        putPiece(new BoardPoint(2, 7), new PaoPiece(Groups.GROUP_BLUE, new BoardPoint(2, 7)));
        putPiece(new BoardPoint(3, 0), new BingPiece(Groups.GROUP_BLUE, new BoardPoint(3, 0)));
        putPiece(new BoardPoint(3, 2), new BingPiece(Groups.GROUP_BLUE, new BoardPoint(3, 2)));
        putPiece(new BoardPoint(3, 4), new BingPiece(Groups.GROUP_BLUE, new BoardPoint(3, 4)));
        putPiece(new BoardPoint(3, 6), new BingPiece(Groups.GROUP_BLUE, new BoardPoint(3, 6)));
        putPiece(new BoardPoint(3, 8), new BingPiece(Groups.GROUP_BLUE, new BoardPoint(3, 8)));
        // 初始化红方棋子
        putPiece(new BoardPoint(9, 0), new JuPiece(Groups.GROUP_RED, new BoardPoint(9, 9)));
        putPiece(new BoardPoint(9, 8), new JuPiece(Groups.GROUP_RED, new BoardPoint(9, 8)));
        putPiece(new BoardPoint(9, 1), new MaPiece(Groups.GROUP_RED, new BoardPoint(9, 1)));
        putPiece(new BoardPoint(9, 7), new MaPiece(Groups.GROUP_RED, new BoardPoint(9, 7)));
        putPiece(new BoardPoint(9, 2), new XiangPiece(Groups.GROUP_RED, new BoardPoint(9, 2)));
        putPiece(new BoardPoint(9, 6), new XiangPiece(Groups.GROUP_RED, new BoardPoint(9, 6)));
        putPiece(new BoardPoint(9, 3), new ShiPiece(Groups.GROUP_RED, new BoardPoint(9, 3)));
        putPiece(new BoardPoint(9, 5), new ShiPiece(Groups.GROUP_RED, new BoardPoint(9, 5)));
        putPiece(new BoardPoint(9, 4), new KingPiece(Groups.GROUP_RED, new BoardPoint(9, 4)));
        putPiece(new BoardPoint(7, 1), new PaoPiece(Groups.GROUP_RED, new BoardPoint(7, 1)));
        putPiece(new BoardPoint(7, 7), new PaoPiece(Groups.GROUP_RED, new BoardPoint(7, 7)));
        putPiece(new BoardPoint(6, 0), new BingPiece(Groups.GROUP_RED, new BoardPoint(6, 0)));
        putPiece(new BoardPoint(6, 2), new BingPiece(Groups.GROUP_RED, new BoardPoint(6, 2)));
        putPiece(new BoardPoint(6, 4), new BingPiece(Groups.GROUP_RED, new BoardPoint(6, 4)));
        putPiece(new BoardPoint(6, 6), new BingPiece(Groups.GROUP_RED, new BoardPoint(6, 6)));
        putPiece(new BoardPoint(6, 8), new BingPiece(Groups.GROUP_RED, new BoardPoint(6, 8)));
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
