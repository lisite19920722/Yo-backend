/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.core.service.dataMng.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.mapper.PowerGdpCorrelationEnterpriseSoloMapper;
import tiger.common.dal.persistence.mapper.PowerGdpCorrelationIndustryMapper;
import tiger.common.dal.persistence.mapper.PowerGdpCorrelationMapper;
import tiger.common.dal.persistence.power.PowerGdpCorrelationDO;
import tiger.common.dal.persistence.power.PowerGdpCorrelationEnterpriseSoloDO;
import tiger.common.dal.persistence.power.PowerGdpCorrelationIndustryDO;
import tiger.core.domain.power.PowerGdpCorrelationDomain;
import tiger.core.domain.power.PowerGdpCorrelationEnterpriseSoloDomain;
import tiger.core.domain.power.PowerGdpCorrelationIndustrySoloDomain;
import tiger.core.domain.power.convert.PowerGdpCorrelationConverter;
import tiger.core.domain.power.convert.PowerGdpCorrelationEnterpriseSoloConverter;
import tiger.core.domain.power.convert.PowerGdpCorrelationIndustrySoloConverter;
import tiger.core.service.dataMng.DataMngService;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/16 14:12]
 */
@Service
public class DataMngServiceImpl implements DataMngService {

    @Autowired
    PowerGdpCorrelationMapper mapper;
    @Autowired
    PowerGdpCorrelationIndustryMapper industryMapper;
    @Autowired
    PowerGdpCorrelationEnterpriseSoloMapper enterpriseSoloMapper;

    /**
     * @see DataMngService#createPowerTotal(PowerGdpCorrelationDomain)
     */
    @Override
    public boolean createPowerTotal(PowerGdpCorrelationDomain domain) {
        PowerGdpCorrelationDO powerGdpCorrelationDO = mapper.selectByYear(domain.getYear());
        if (powerGdpCorrelationDO != null) {
            powerGdpCorrelationDO.setRealGdpValue(domain.getGdpValue());
            powerGdpCorrelationDO.setRealPowerValue(domain.getPowerValue());
            return mapper.updateByPrimaryKey(powerGdpCorrelationDO) > 0;
        }
        return mapper.insertSelective(PowerGdpCorrelationConverter.convert2DO(domain)) > 0;
    }

    /**
     * @see DataMngService#createPowerIndustry(PowerGdpCorrelationIndustrySoloDomain)
     */
    @Override
    public boolean createPowerIndustry(PowerGdpCorrelationIndustrySoloDomain domain) {
        PowerGdpCorrelationIndustryDO powerGdpCorrelationIndustryDO = industryMapper.selectByYearSeasonId(domain.getYear(),domain.getSeason(),domain.getIndustryId());
        if (powerGdpCorrelationIndustryDO!= null) {
            powerGdpCorrelationIndustryDO.setRealIndustryGdp(domain.getGdpValue());
            powerGdpCorrelationIndustryDO.setRealIndustryPower(domain.getPowerValue());

            return industryMapper.updateByPrimaryKey(powerGdpCorrelationIndustryDO) >0;
        }
        return industryMapper.insertSelective(PowerGdpCorrelationIndustrySoloConverter.convert2DO(domain))> 0;
    }

    /**
     * @see DataMngService#createPowerEnterprise(PowerGdpCorrelationEnterpriseSoloDomain)
     */
    @Override
    public boolean createPowerEnterprise(PowerGdpCorrelationEnterpriseSoloDomain domain) {
        PowerGdpCorrelationEnterpriseSoloDO powerGdpCorrelationEnterpriseSoloDO= enterpriseSoloMapper.selectByYearSeasonId(domain.getYear(),domain.getSeason(),domain.getEnterpriseId());
        if (powerGdpCorrelationEnterpriseSoloDO!= null) {
            powerGdpCorrelationEnterpriseSoloDO.setRealEnterpriseGdp(domain.getGdpValue());
            powerGdpCorrelationEnterpriseSoloDO.setRealEnterprisePower(domain.getPowerValue());

            return enterpriseSoloMapper.updateByPrimaryKey(powerGdpCorrelationEnterpriseSoloDO) >0;
        }
        return enterpriseSoloMapper.insertSelective(PowerGdpCorrelationEnterpriseSoloConverter.convert2DO(domain))> 0;
    }
}
