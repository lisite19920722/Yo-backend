package tiger.biz.Economy.support;

import tiger.core.basic.BaseResult;
import tiger.common.dal.persistence.mapper.EconomyGDP.GdpDetailDO;
import java.util.List;

/**
 * Created by xy86 on 16/6/9.
 */
public interface EconomyGdpManger {

    List<GdpDetailDO> getGdpDetail(Long year);
}
