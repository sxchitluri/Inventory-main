package DomainObjects;

import java.util.ArrayList;
import DataObjects.GameDataObject;
import Models.GameModel;
import restService.response.GameResponse;
import Models.BoardModel;

public class GameDomainObject {
    private int gameId;
    private int gameTypeId;
    private int player1Id;
    private int player2Id;
    private int currentTurnPlayer;
    private String status;
    private int winnerId;
    private BoardDomainObject board;

    public GameDomainObject(int gameId, int player1Id, int player2Id, int currentTurnPlayer, String status,
            int winnerId, BoardDomainObject board) {
        this.gameId = gameId;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.status = status;
        this.currentTurnPlayer = currentTurnPlayer;
        this.winnerId = winnerId;
        this.board = board;
    }


    public GameDomainObject(GameDataObject game) {
        this.gameId = game.id;
        this.player1Id = game.player1Id;
        this.player2Id = game.player2Id;
        this.currentTurnPlayer = game.currentTurnPlayer;
        this.status = game.status;
        this.winnerId = game.winnerId;
        this.board = game.board;
    }

    public GameDomainObject(GameDataObject game, BoardDomainObject board) {
        this.gameId = game.id;
        this.player1Id = game.player1Id;
        this.player2Id = game.player2Id;
        this.currentTurnPlayer = game.currentTurnPlayer;
        this.status = game.status;
        this.winnerId = game.winnerId;
        this.board = board;
    }

    public GameDomainObject(GameResponse response) {
        this.gameId = response.GetGameId();
        this.gameTypeId = response.GetGameTypeId();
        this.player1Id = response.GetPlayer1Id();
        this.player2Id = response.GetPlayer2Id();
        this.currentTurnPlayer = response.GetCurrentTurnPlayer();
        this.status = response.GetStatus();
        this.winnerId = response.GetWinnerId();
    }

    public static ArrayList<GameDomainObject> MapList(ArrayList<GameDataObject> gamedata) {
        ArrayList<GameDomainObject> gameDomain = new ArrayList<GameDomainObject>();
        for (GameDataObject game : gamedata) {
            gameDomain.add(new GameDomainObject(game));
        }
        return gameDomain;
    }

    public int GetGameId() {
        return this.gameId;
    }

    public int GetGameTypeId() {
        return this.gameTypeId;
    }

    public int GetPlayer1Id() {
        return this.player1Id;
    }

    public int GetPlayer2Id() {
        return this.player2Id;
    }

    public int GetCurrentTurnPlayer() {
        return this.currentTurnPlayer;
    }

    public String GetStatus() {
        return this.status;
    }

    public String SetStatus() {
        return this.status = "Completed";
    }

    public int GetWinnerId() {
        return this.winnerId;
    }


    public BoardDomainObject GetBoard() {
        System.out.println("Board state after update: " + board);
        if (this.board == null) {
            this.board = BoardModel.GetBoardById(board.GetId());
        }
        return this.board;
    }


    public void setBoard(BoardDomainObject board) {
        if (board == null) {
            throw new IllegalArgumentException("Board cannot be null.");
        }
        this.board = board;
        GameModel.Save(this);
    }

}
