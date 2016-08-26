package chinesechess.board;

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
