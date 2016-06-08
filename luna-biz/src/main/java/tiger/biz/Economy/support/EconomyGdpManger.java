package tiger.biz.Economy.support;

import tiger.core.basic.BaseResult;

import java.util.List;
import java.util.Map;

/**
 * Created by xy86 on 16/6/9.
 */
public interface EconomyGdpManger {

    Map<String,double[]> getGdpDetail(Long year);
}
