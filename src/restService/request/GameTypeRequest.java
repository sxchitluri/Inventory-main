package restService.request;

public class GameTypeRequest {

    private final int id;
    private final String name;

    public GameTypeRequest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
