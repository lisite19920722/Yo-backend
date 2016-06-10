package tiger.biz.water.support;


import tiger.core.basic.BaseResult;
import tiger.core.domain.water.WaterPollutionDomain;

/**
 * Created by lisite on 16/5/21.
 */
public interface WaterPollutionManager {
    /**
     * 获取一条水污染记录
     *
     * @return
     */
    BaseResult read();

    /**
     * 删除一条水污染记录
     *
     * @param id
     * @return
     */
    BaseResult<Boolean> delete(Long id);

    /**
     * 更新一条记录
     *
     * @param waterPollution
     * @return
     */
    BaseResult<Boolean> update(WaterPollutionDomain waterPollution);

    /**
     * 增加一条记录
     *
     * @param waterPollutionDomain
     * @return
     */
    BaseResult<WaterPollutionDomain> create(WaterPollutionDomain waterPollutionDomain);

}
