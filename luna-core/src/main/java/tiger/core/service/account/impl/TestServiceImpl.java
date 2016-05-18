package tiger.core.service.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.account.TestDO;
import tiger.common.dal.persistence.mapper.TestMapper;
import tiger.core.domain.account.TestDomain;
import tiger.core.domain.account.convert.TestConvert;
import tiger.core.service.account.TestService;

/**
 * Created by zhao on 2016/4/18.
 */
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    TestMapper testMapper;

    @Override
    public TestDomain insert(TestDomain testDomain){
        TestDO testDO = TestConvert.convert2DO(testDomain);
        if(testMapper.insert(testDO)){
            return testDomain;
        }else{
            return null;
        }

    }

    @Override
    public String read(Long testId) {
        String ret = testMapper.findNameById(testId);
        return ret;
    }

    @Override
    public boolean delete(Long testId) {
        if(read(testId) != null) {
            return testMapper.deleteById(testId);
        }else{
            return false;
        }
    }
}
