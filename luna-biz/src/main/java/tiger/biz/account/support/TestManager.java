package tiger.biz.account.support;

import tiger.core.domain.account.TestDomain;

/**
 * Created by zhao on 2016/4/19.
 */
public interface TestManager {
    TestDomain insertTest(TestDomain testDomain);
    String getNameById(Long testId);
    boolean deleteById(Long testId);
}
