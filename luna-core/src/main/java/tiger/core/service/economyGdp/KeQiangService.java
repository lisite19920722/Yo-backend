package tiger.core.service.economyGdp;

import tiger.common.dal.persistence.EconomyKeQiang.KeQiangDetailDO;

import java.util.List;

/**
 * Created by xy86 on 16/7/11.
 */
public interface KeQiangService {
    List<KeQiangDetailDO> getyearKeqiang(Long year);
}
