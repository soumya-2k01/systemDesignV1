import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    Floor floor;
    public ParkingLot(int entranceCount, int exitCount){
        this.floor = new Floor();
        createEntrances(entranceCount);
        createExits(exitCount);
    }
    public void createEntrances(int entranceCount){
        List<Entrance> entrances = new ArrayList<>();
        for(int i=0; i<entranceCount; i++){
            Entrance entrance = new Entrance();
            entrances.add(entrance);
        }
        floor.setEntrances(entrances);
    }
    public void createExits(int exitCount){
        List<Exit> exits = new ArrayList<>();
        for(int i=0; i<exitCount; i++){
            Exit exit = new Exit();
            exits.add(exit);
        }
        floor.setExits(exits);
    }

}
