# 棋盘游戏

> 构建棋盘类型游戏的基本抽象类。

## 一、 棋盘类

>IBoard：棋盘接口类，指出棋盘应具有的核心功能。 <br>
AbsBoard：棋盘抽象类，对棋盘应具有的功能进行抽象。<br>
IBoardMap：棋盘棋子信息接口类，指出棋盘中棋子的集合应该如何进行操作。

#### 1. IBoard 棋盘接口类
* boolean putPiece(BoardPoint point, IPiece piece);<br>
移动棋子的方法，即“下棋”。参数point指移动到的位置的坐标点，参数piece指需要被移动的棋子。
* IPiece getPiece(BoardPoint point);<br>
在棋盘上获取棋子的方法，参数point指获取棋子的坐标点。

#### 2. AbsBoard 棋盘抽象类
* 继承自IBoard接口，实现putPiece和getPiece方法。
* 构造函数中要求传入IBoardMap类，即棋盘上全部棋子的信息。
* putPiece方法中，通过需要移动的棋子的规则进行棋子的移动。

#### 3. IBoardMap 棋盘棋子信息接口类
* void putPiece(BoardPoint point, IPiece piece);<br>
以棋子的坐标point为key，在Map集合中储存棋子piece。
*  IPiece getPiece(BoardPoint point);<br>
通过坐标获取Map集合中的棋子。
* Map<String, IPiece> getBoardMap();<br>
获取全部棋子的集合。
