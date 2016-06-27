package tiger.core.domain.population;

import tiger.core.domain.BaseDomain;
import java.util.Date;

/**
 * Created by Winter on 2016/6/10.
 */
public class PopulationStructureDomain extends BaseDomain {


    private static final long serialVersionUID = 4883585406620375724L;

    private int year;
    private long ageTypeId;
    private long sexTypeId;
    private int residentPopulation;


    public int getResidentPopulation() {
        return residentPopulation;
    }

    public void setResidentPopulation(int residentPopulation) {
        this.residentPopulation = residentPopulation;
    }

    public long getSexTypeId() {
        return sexTypeId;
    }

    public void setSexTypeId(long sexTypeId) {
        this.sexTypeId = sexTypeId;
    }

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

    //下面和无参数的构造函数
    public PopulationStructureDomain() {
    }

    //下面是一个有参数的构造函数
    public PopulationStructureDomain(int residentPopulation, long sexTypeId, long ageTypeId, int year) {

        this.residentPopulation = residentPopulation;
        this.sexTypeId = sexTypeId;
        this.ageTypeId = ageTypeId;
        this.year = year;

    }
}
