package restService.request;

import DataAccess.BoardDataAccess;
import DataObjects.BoardDataObject;

public class PlayGameRequest {
    
    private final int gameId;
    private final int gameTypeId;
    private final int player1Id;
    private final int player2Id;
    private final  String status;
    private final  int currentTurnPlayer;
    private final int winnerId;
    private final BoardDataObject board;

    //GET BACK TO DO ING THIS AND ADDING ALL THE GETS FOR EACH VARIABLE
    
    // default playgame request that has default values and creates a new board
    public PlayGameRequest(int gameId, int gameTypeId, int player1Id, int player2Id, String status, int currentTurnPlayer, int winnerId, BoardDataObject board) {
        this.gameId = gameId;
        this.gameTypeId = gameTypeId; 
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.currentTurnPlayer = player2Id; // Always Player 2's turn initially
        this.status ="Playing"; // Status is "Playing" when game starts
        this.winnerId = 0; // Default winner is 0 indicating no winner yet
        this.board = new BoardDataObject(board); //create new instance of board
    }

    public int GetItemTypeId() {
        return this.itemTypeId;
    }
}
