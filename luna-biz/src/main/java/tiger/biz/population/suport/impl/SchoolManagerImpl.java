package tiger.biz.population.suport.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tiger.biz.population.suport.SchoolManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.population.SchoolDomain;
import tiger.core.service.population.SchoolService;

/**
 * Created by Winter on 2016/6/30.
 */
public class SchoolManagerImpl implements SchoolManager {

    @Autowired
    private SchoolService schoolService;
    @Override
    public BaseResult <SchoolDomain> create(SchoolDomain schoolDomain){
        SchoolDomain resultDomain= schoolService.createSchool(schoolDomain);
        return new BaseResult<>(resultDomain);
    }
}
