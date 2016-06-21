package tiger.common.dal.persistence.population;


import tiger.common.dal.persistence.BaseDO;

public class PopulationStructurePreDO extends BaseDO {

    private int  preyear;

    private int sexType_id;

    private int ageType_id;
    
    private int preResidentPopulation;

    public int getSexType_id() {
        return sexType_id;
    }

    public void setSexType_id(int sexType_id) {
        this.sexType_id = sexType_id;
    }

    public int getAgeType_id() {
        return ageType_id;
    }

    public void setAgeType_id(int ageType_id) {
        this.ageType_id = ageType_id;
    }

    public double getPreResidentPopulation() {
        return preResidentPopulation;
    }

    public void setPreResidentPopulation(int preResidentPopulation) {
        this.preResidentPopulation = preResidentPopulation;
    }

    

    public int getPreYear() {
        return preyear;
    }

    public void setPreYear(int preyear) {
        this.preyear = preyear;
    }

    
}
