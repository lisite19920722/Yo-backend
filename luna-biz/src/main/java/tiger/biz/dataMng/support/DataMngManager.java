/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.biz.dataMng.support;

import tiger.core.domain.power.PowerGdpCorrelationDomain;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/16 13:48]
 */
public interface DataMngManager {

    /**
     * 总用电 插入数据
     *
     * @param domain
     * @return
     */
    boolean createPowerTotal(PowerGdpCorrelationDomain domain);
}
