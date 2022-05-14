
public class Pakudex {
    private Pakuri[] pakudex;
    private int capacity, size = 0;

    // default constructer that sets the default capacity to 0
    public Pakudex() {
        capacity = 20;
        pakudex = new Pakuri[capacity];

    }

    // sets capacity from main class to Pakudex
    public Pakudex(int capacity) {
        this.capacity = capacity;
        pakudex = new Pakuri[capacity];

    }
    //returns the size
    public int getSize() {
        return size;
    }
    // returns the capacity
    public int getCapacity() {
        return capacity;
    }
    // returns pakudex array
    public String[] getSpeciesArray() {
        if (size <= 0) {
            return null;
        }
        String[] speciesArr = new String[size];
        for (int i = 0; i < size; i++) {
            speciesArr[i] = pakudex[i].getSpecies();
        }
        return speciesArr;
    }

    // returns the stats of a given pakuri
    public int[] getStats(String species) {
        int[] stats = new int[3];
        if (pakudex != null) {
            for (int i = 0; i < size; i++) {
                if (pakudex[i].getSpecies().equals(species)) {
                    stats[0] = pakudex[i].getAttack();
                    stats[1] = pakudex[i].getDefense();
                    stats[2] = pakudex[i].getSpeed();
                    return stats;
                }
            }
        }
        return null;
    }

    //function that sorts the pakuri into lexicographical order
    public void sortPakuri() {
        Pakuri temp;
        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                if(pakudex[j].getSpecies().compareTo(pakudex[i].getSpecies())<0){
                    temp = pakudex[i];
                    pakudex[i] = pakudex[j];
                    pakudex[j] = temp;
                }
            }
        }
    }
    // function that adds Pakuri to the Pakudex
    public boolean addPakuri(String species) {
        if (capacity != size) {
            for (int i = 0; i < pakudex.length; i++) {
                if (pakudex[i] == null) {
                    pakudex[i] = new Pakuri(species);
                    size++;
                    return true;
                } else if (pakudex[i].getSpecies().equals(species)) {
                    return false;
                }
            }
        }else {
            return false;
        }
        return false;
    }
    // Function that evolves the pakuri
    public boolean evolveSpecies(String species) {
        for (int i = 0; i < size; i++) {
            if (pakudex[i].getSpecies().equals(species)) {
                pakudex[i].evolve();
                return true;
            }
        }
        return false;
    }
}
