package tiger.common.dal.persistence.mapper;

import org.apache.ibatis.annotations.Param;
import tiger.common.dal.persistence.account.TestDO;

import java.util.List;

/**
 * Created by zhao on 2016/4/18.
 */
public interface TestMapper {
    boolean insert(TestDO testDO);
    String findNameById(@Param("testId") Long id);
    boolean deleteById(@Param("testId") Long id);
}
