package tiger.core.service.system;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.common.dal.persistence.system.query.FeedbackQuery;
import tiger.core.AbstractCoreTests;
import tiger.core.basic.PageResult;
import tiger.core.domain.system.FeedbackDomain;

import java.util.List;


/**
 * Created by zeyang on 16/4/17.
 */
public class FeedbackServiceTest extends AbstractCoreTests {

    @Autowired
    FeedbackService feedbackService;

    @Test
    public void testCreate () {
        logger.info("开始测试create(FeedbackDomain feedbackDomain)");
        FeedbackDomain feedbackDomain = new FeedbackDomain();
        feedbackDomain.setAccountId(Long.valueOf(1l));
        feedbackDomain.setTitle("Title");
        feedbackDomain.setContent("Content");
        feedbackDomain.setAttaches(null);
        feedbackDomain.setAttachRelateDomains(null);
        feedbackDomain.setEmail("testmail@163.com");
        feedbackDomain.setMobile("13512345678");
        FeedbackDomain feedbackDomainCreate = feedbackService.create(feedbackDomain);
        logger.info("插入: [" + feedbackDomainCreate + "]");
        //how to delete the record
        Assert.assertNotNull(feedbackDomainCreate);
        Assert.assertNotNull(feedbackDomainCreate.getId());
    }

    @Test
    public void testQuery () {
        logger.info("开始测试query(FeedbackQuery query)");
        FeedbackQuery feedbackQuery = new FeedbackQuery();
        feedbackQuery.setPageNum(1);
        feedbackQuery.setPageSize(1);
        PageResult<List<FeedbackDomain>> pageResult = feedbackService.query(feedbackQuery);
        Assert.assertNotNull(pageResult);
    }
}
