package cc3002;
import java.util.HashMap;
class EnergyContainer {
    private HashMap<String, Integer> container = new HashMap<>();

    EnergyContainer(int el, int fig, int fir, int gr, int psy, int wa){
        container.put("Electric", el);
        container.put("Fighting", fig);
        container.put("Fire", fir);
        container.put("Grass", gr);
        container.put("Psychic", psy);
        container.put("Water", wa);
    }
    int getElectric(){return container.get("Electric"); }
    int getFighting(){return container.get("Fighting");}
    int getFire(){return container.get("Fire");}
    int getGrass(){return container.get("Grass");}
    int getPsychic(){return container.get("Psychic");}
    int getWater(){return container.get("Water");}
}
