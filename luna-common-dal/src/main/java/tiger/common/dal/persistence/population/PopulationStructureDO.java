package tiger.common.dal.persistence.population;

import tiger.common.dal.persistence.BaseDO;



/**
 * Created by Winter on 2016/6/10.
 */
public class PopulationStructureDO extends BaseDO {


    private static final long serialVersionUID = -1555319420593916855L;


    private int year;
    private long ageTypeId;
    private long sexTypeId;
    private int residentPopulation;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getAgeTypeId() {
        return ageTypeId;
    }

    public void setAgeTypeId(long ageTypeId) {
        this.ageTypeId = ageTypeId;
    }

    public long getSexTypeId() {
        return sexTypeId;
    }

    public void setSexTypeId(long sexTypeId) {
        this.sexTypeId = sexTypeId;
    }

    public int getResidentPopulation() {
        return residentPopulation;
    }

    public void setResidentPopulation(int residentPopulation) {
        this.residentPopulation = residentPopulation;
    }
}
