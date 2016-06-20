/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.core.service.dataMng.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.mapper.PowerGdpCorrelationMapper;
import tiger.common.dal.persistence.power.PowerGdpCorrelationDO;
import tiger.core.domain.power.PowerGdpCorrelationDomain;
import tiger.core.domain.power.convert.PowerGdpCorrelationConverter;
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
}
