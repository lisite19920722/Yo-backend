package tiger.biz.water.support;


import tiger.core.basic.BaseResult;
import tiger.core.domain.water.WaterQualityDomain;

/**
 * Created by lisite on 16/5/21.
 */
public interface WaterQualityManager {
    /**
     * 获取一条空气污染记录
     *
     * @param id
     * @return
     */
    BaseResult<WaterQualityDomain> read(Long id);

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
     * @param waterQuality
     * @return
     */
    BaseResult<Boolean> update(WaterQualityDomain waterQuality);

    /**
     * 更新一条消息
     *
     * @param waterQualityDomain
     * @return
     */
    BaseResult<WaterQualityDomain> create(WaterQualityDomain waterQualityDomain);

}
