package tiger.core.domain.account.convert;

import tiger.common.dal.persistence.account.TestDO;
import tiger.common.util.BeanUtil;
import tiger.core.domain.account.TestDomain;

/**
 * Created by zhao on 2016/4/19.
 */
public class TestConvert {
    public static TestDomain convert2Domain(TestDO source){
        TestDomain target = new TestDomain();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }

    public static TestDO convert2DO(TestDomain source){
        if(null == source){
            return null;
        }
        TestDO target = new TestDO();
        BeanUtil.copyPropertiesWithIgnores(target,source);
        return target;
    }
}
