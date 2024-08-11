import java.util.List;

public class Floor {
    int floorNo;
    List<Entrance> entrances;
    List<Exit> exits;

    public void setEntrances(List<Entrance> entrances){
        this.entrances = entrances;
    }

    public void setExits(List<Exit> exits){
        this.exits = exits;
    }
}
