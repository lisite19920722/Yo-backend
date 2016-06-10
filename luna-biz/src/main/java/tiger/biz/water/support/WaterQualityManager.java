package tiger.biz.water.support;


import tiger.core.basic.BaseResult;
import tiger.core.domain.water.WaterQualityDomain;

/**
 * Created by lisite on 16/5/21.
 */
public interface WaterQualityManager {
    /**
     * 获取一条水质量记录
     *
     * @return
     */
    BaseResult read();

    /**
     * 删除一条水质量记录
     *
     * @param id
     * @return
     */
    BaseResult<Boolean> delete(Long id);

    /**
     * 更新一条记录
     *
     * @param waterQuality
     * @return
     */
    BaseResult<Boolean> update(WaterQualityDomain waterQuality);

    /**
     * 增加一条记录
     *
     * @param waterQualityDomain
     * @return
     */
    BaseResult<WaterQualityDomain> create(WaterQualityDomain waterQualityDomain);

}
