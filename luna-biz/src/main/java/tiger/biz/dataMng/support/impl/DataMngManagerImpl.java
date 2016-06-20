/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.biz.dataMng.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.dataMng.support.DataMngManager;
import tiger.core.domain.power.PowerGdpCorrelationDomain;
import tiger.core.service.dataMng.DataMngService;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/16 13:49]
 */
@Service
public class DataMngManagerImpl implements DataMngManager{
    @Autowired
    DataMngService dataMngService;

    @Override
    public boolean createPowerTotal(PowerGdpCorrelationDomain domain) {
        return dataMngService.createPowerTotal(domain);
    }
}
