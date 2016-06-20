/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.core.service.dataMng;

import tiger.core.domain.power.PowerGdpCorrelationDomain;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/16 14:11]
 */
public interface DataMngService {
    boolean createPowerTotal(PowerGdpCorrelationDomain domain);
}
