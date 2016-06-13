package tiger.common.dal.persistence.population;


import tiger.common.dal.persistence.BaseDO;

public class BirthrateDO extends BaseDO {

    private int  year;

    private char town;

    private int town_id;
    
    private double bornPopulation;
    
    private double deadPopulation;
    
    private double population;

    public char getTown() {
        return town;
    }

    public void setTown(char town) {
        this.town = town;
    }

    public int getTown_id() {
        return town_id;
    }

    public void setTown_id(int town_id) {
        this.town_id = town_id;
    }
    
    public double getBornPopulation() {
        return bornPopulation;
    }

    public void setBornPopulation(double bornPopulation) {
        this.bornPopulation = bornPopulation;
    }

    public double getDeadPopulation() {
        return deadPopulation;
    }

    public void setDeadPopulation(double deadPopulation) {
        this.deadPopulation = deadPopulation;
    }
      
    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    
}
