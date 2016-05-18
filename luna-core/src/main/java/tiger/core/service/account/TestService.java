package tiger.core.service.account;

import tiger.core.domain.account.TestDomain;

/**
 * Created by zhao on 2016/4/18.
 */
public interface TestService {

    //增加记录
    TestDomain insert(TestDomain testDomain);

    //通过id得到name
    String read(Long testId);

    //通过id删除记录
    boolean delete(Long testId);
}
