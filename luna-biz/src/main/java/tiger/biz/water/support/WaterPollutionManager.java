package tiger.biz.water.support;


import tiger.core.basic.BaseResult;
import tiger.core.domain.water.WaterPollutionDomain;

/**
 * Created by lisite on 16/5/21.
 */
public interface WaterPollutionManager {
    /**
     * 获取一条空气污染记录
     *
     * @param id
     * @return
     */
    BaseResult<WaterPollutionDomain> read(Long id);

    /**
     * 删除一条空气污染记录
     *
     * @param id
     * @return
     */
    BaseResult<Boolean> delete(Long id);

    /**
     * 更新一条消息
     *
     * @param waterPollution
     * @return
     */
    BaseResult<Boolean> update(WaterPollutionDomain waterPollution);

    /**
     * 更新一条消息
     *
     * @param waterPollutionDomain
     * @return
     */
    BaseResult<WaterPollutionDomain> create(WaterPollutionDomain waterPollutionDomain);

}
