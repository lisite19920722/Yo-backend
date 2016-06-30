package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.population.PeopleEmployInsuranceDO;

/**
 * Created by Winter on 2016/6/29.
 */
public interface PeopleEmployInsuranceMapper {

    int insertSelective(PeopleEmployInsuranceDO record);

}
