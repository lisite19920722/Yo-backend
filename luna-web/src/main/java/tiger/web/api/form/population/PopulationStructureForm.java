package tiger.web.api.form.population;

import tiger.common.util.BeanUtil;
import tiger.core.domain.population.PopulationStructureDomain;
import tiger.web.api.form.BaseForm;
import tiger.web.api.form.FormInterface;

/**
 * Created by Winter on 2016/6/27.
 */
public class PopulationStructureForm extends BaseForm implements FormInterface {

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

    public long getAgeTypeId() {
        return ageTypeId;
    }

    public void setAgeTypeId(long ageTypeId) {
        this.ageTypeId = ageTypeId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public PopulationStructureDomain convert2Domain(){
        PopulationStructureDomain target=new PopulationStructureDomain();
        BeanUtil.copyPropertiesWithIgnores(this,target);
        return target;
    }

}
