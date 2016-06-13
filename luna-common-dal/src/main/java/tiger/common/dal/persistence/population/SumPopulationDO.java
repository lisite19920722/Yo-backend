package tiger.common.dal.persistence.population;


import tiger.common.dal.persistence.BaseDO;

public class SumPopulationDO extends BaseDO {

    private int  year;

    
    private double sumPopulation;
    
    private double popRate;
    
    
   
    
    public double getSumPopulation() {
        return sumPopulation;
    }

    public void setSumPopulation(double sumPopulation) {
        this.sumPopulation = sumPopulation;
    }

    public double getPopRate() {
        return popRate;
    }

    public void setPopRate(double popRate) {
        this.popRate = popRate;
    }
      
   

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    
}
