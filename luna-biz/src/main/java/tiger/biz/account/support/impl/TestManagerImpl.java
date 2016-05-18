package tiger.biz.account.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.account.support.TestManager;
import tiger.core.domain.account.TestDomain;
import tiger.core.service.account.TestService;

/**
 * Created by zhao on 2016/4/19.
 */
@Service
public class TestManagerImpl implements TestManager {

    @Autowired
    TestService testService;

    @Override
    public TestDomain insertTest(TestDomain testDomain) {
        return testService.insert(testDomain);
    }

    @Override
    public String getNameById(Long testId) {
        return testService.read(testId);
    }

    @Override
    public boolean deleteById(Long testId) {
        return testService.delete(testId);
    }
}
