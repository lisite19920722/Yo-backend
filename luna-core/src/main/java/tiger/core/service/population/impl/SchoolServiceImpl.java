package tiger.core.service.population.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.mapper.SchoolMapper;
import tiger.common.dal.persistence.population.SchoolDO;
import tiger.core.domain.population.SchoolDomain;
import tiger.core.domain.population.convert.SchoolConvert;
import tiger.core.service.population.SchoolService;

/**
 * Created by Winter on 2016/6/30.
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public SchoolDomain createSchool (SchoolDomain schoolDomain)
    {
        if(schoolDomain==null)
        {
            return null;
        }

        SchoolDO schoolDO= SchoolConvert.convertDomainToDO(schoolDomain);
        if(schoolMapper.insertSelective(schoolDO)>0)
        {
            return SchoolConvert.convertDOToDomain(schoolDO);
        }
        return null;
    }
}
