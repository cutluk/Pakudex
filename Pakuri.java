public class Pakuri {
    private String species;
    private int attackValue;
    private int defenseValue;
    private int speed;

    //Sets the default stats value for each pakuri
    public Pakuri(String species){
        this.species = species;
        attackValue = (species.length()*7)+9;
        defenseValue = (species.length()*5)+17;
        speed = (species.length()*6)+13;
    }
    // return the species
    public String getSpecies(){
        return species;
    }
    // returns the attack value
    public int getAttack(){
        return attackValue;
    }
    // returns the defense value
    public int getDefense(){
        return defenseValue;
    }
    // returns the speed value
    public int getSpeed(){
        return speed;
    }
    // should set Attack but isn't being used
    public void setAttack(int newAttack){
        attackValue = newAttack;
    }
    // evolves the pakuri when called
    public void evolve(){
        attackValue = attackValue*2;
        defenseValue = defenseValue*4;
        speed = speed*3;
    }

}
