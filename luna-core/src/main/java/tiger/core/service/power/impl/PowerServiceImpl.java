/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.core.service.power.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.mapper.PowerGdpCorrelationEnterpriseAverageMapper;
import tiger.common.dal.persistence.mapper.PowerGdpCorrelationEnterpriseSoloMapper;
import tiger.common.dal.persistence.mapper.PowerGdpCorrelationIndustryMapper;
import tiger.common.dal.persistence.mapper.PowerGdpCorrelationMapper;
import tiger.core.domain.power.*;
import tiger.core.domain.power.convert.*;
import tiger.core.service.power.PowerService;

import java.util.List;

/**
 * Created by Bongo on 16/3/1.
 */
@Service
public class PowerServiceImpl implements PowerService{

    @Autowired
    private PowerGdpCorrelationMapper totalMapper;
    @Autowired
    private PowerGdpCorrelationIndustryMapper industryMapper;
    @Autowired
    private PowerGdpCorrelationEnterpriseAverageMapper enterpriseAverageMapper;
    @Autowired
    private PowerGdpCorrelationEnterpriseSoloMapper enterpriseMapper;

    /**
     * @see PowerService#getPowerGdpCorrelationDomainList(String, String)
     */
    public List<PowerGdpCorrelationDomain> getPowerGdpCorrelationDomainList(String startYear, String endYear){
        return PowerGdpCorrelationConverter.convertByList(totalMapper.getPowerGdpCorrelationDOList(startYear, endYear));
    }

    /**
     * @see PowerService#getPowerGdpCorrelationIndustryDomainList(String, String)
     */
    public List<PowerGdpCorrelationIndustryDomain> getPowerGdpCorrelationIndustryDomainList(String year, String season){
        return PowerGdpCorrelationIndustryConverter.convertByList(industryMapper.getPowerGdpCorrelationIndustryDOList(year, season));
    }

    /**
     * @see PowerService#getPowerGdpCorrelationIndustrySoloDomainList(String, String, String, String)
     */
    public List<PowerGdpCorrelationIndustrySoloDomain> getPowerGdpCorrelationIndustrySoloDomainList(String industryId, String startYear, String endYear, String season){
        return PowerGdpCorrelationIndustrySoloConverter.convertByList(industryMapper.getPowerGdpCorrelationIndustrySoloDOList(industryId, startYear,endYear, season));
    }


    /**
     * @see PowerService#getEnterpriseAverageDomainList(String, String)
     */
    public List<PowerGdpCorrelationEnterpriseAverageDomain> getEnterpriseAverageDomainList(String startYear, String endYear){
        return PowerGdpCorrelationEnterpriseAverageConverter.convertByList(enterpriseAverageMapper.getPowerGdpCorrelationEnterpriseAverageDOList(startYear, endYear));
    }

    /**
     * @see PowerService#getPowerGdpCorrelationEnterpriseSoloDomainList(String, String, String, String)
     */
    public List<PowerGdpCorrelationEnterpriseSoloDomain> getPowerGdpCorrelationEnterpriseSoloDomainList(String industryId, String startYear, String endYear, String season){
        return PowerGdpCorrelationEnterpriseSoloConverter.convertByList(enterpriseMapper.getPowerGdpCorrelationEnterpriseSoloDOList(industryId, startYear, endYear, season));
    }
}
