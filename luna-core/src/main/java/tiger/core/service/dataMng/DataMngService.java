/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.core.service.dataMng;

import tiger.core.domain.power.PowerGdpCorrelationDomain;
import tiger.core.domain.power.PowerGdpCorrelationEnterpriseSoloDomain;
import tiger.core.domain.power.PowerGdpCorrelationIndustrySoloDomain;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/16 14:11]
 */
public interface DataMngService {
    /**
     * 用电 插入总体数据
     *
     * @param domain
     * @return
     */
    boolean createPowerTotal(PowerGdpCorrelationDomain domain);

    /**
     * 用电 插入行业数据
     *
     * @param domain
     * @return
     */
    boolean createPowerIndustry(PowerGdpCorrelationIndustrySoloDomain domain);

    /**
     * 用电 插入企业数据
     *
     * @param domain
     * @return
     */
    boolean createPowerEnterprise(PowerGdpCorrelationEnterpriseSoloDomain domain);
}
