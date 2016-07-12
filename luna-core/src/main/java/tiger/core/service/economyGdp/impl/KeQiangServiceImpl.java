package tiger.core.service.economyGdp.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.EconomyKeQiang.KeQiangDetailDO;
import tiger.core.service.economyGdp.KeQiangService;
import tiger.common.dal.persistence.mapper.KeQiangMapper;
import java.util.List;

/**
 * Created by xy86 on 16/7/11.
 */
@Service
public class KeQiangServiceImpl implements KeQiangService{
    @Autowired
    private KeQiangMapper keQiangMapper;

    @Override
    public List<KeQiangDetailDO> getyearKeqiang(Long year){
        return keQiangMapper.getyearKeqiang(year);
    }
}
