package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.EconomyKeQiang.KeQiangDetailDO;

import java.util.List;

/**
 * Created by xy86 on 16/7/11.
 */
public interface KeQiangMapper {
    List<KeQiangDetailDO> getyearKeqiang(Long year);
}
