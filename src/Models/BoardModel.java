package Models;

import java.util.ArrayList;

import DataAccess.BoardDataAccess;
import DataObjects.BoardDataObject;
import DomainObjects.BoardDomainObject;

public class BoardModel {

    public static BoardDomainObject GetBoardById(int id) {
        BoardDataObject boardData = BoardDataAccess.GetBoardById(id);
        return new BoardDomainObject(boardData);
    }

    public static BoardDomainObject GetBoardByGameId(int gameid) {
        BoardDataObject boardData = BoardDataAccess.GetBoardByGameId(gameid);
        return new BoardDomainObject(boardData);
    }

    public static ArrayList<BoardDomainObject> GetAllBoards() {
        ArrayList<BoardDataObject> boardDataList = BoardDataAccess.GetAllBoards();
        return BoardDomainObject.MapList(boardDataList);
    }

    public static BoardDomainObject AddBoard(BoardDomainObject board) {

        BoardDataObject boardData = new BoardDataObject(board);
        BoardDataAccess.AddBoard(boardData);
        return new BoardDomainObject(boardData);

    }
    

    public static void Save (BoardDomainObject boardToSave) {
        BoardDataObject boardDataObject = new BoardDataObject(boardToSave);
        BoardDataAccess.Save(boardDataObject);
    }

    
}
