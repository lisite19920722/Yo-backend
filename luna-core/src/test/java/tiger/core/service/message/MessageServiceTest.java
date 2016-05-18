package tiger.core.service.message;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import tiger.common.dal.enums.BizObjectTypeEnum;
import tiger.common.dal.enums.MessageTypeEnum;
import tiger.common.dal.persistence.message.query.MessageQuery;
import tiger.core.AbstractCoreTests;
import tiger.core.basic.PageResult;
import tiger.core.domain.message.MessageDomain;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/4/17 02:43]
 */
public class MessageServiceTest extends AbstractCoreTests {

    Logger logger = Logger.getLogger(MessageServiceTest.class);

    @Autowired
    MessageService messageService;

    /**
     * 测试 MessageDomain属性
     *
     * */
    @Test
    public void fieldTest() {
        MessageDomain messageDomain = createMessageDomain(1000l);
        messageDomain.setIsRead(false);
        Assert.assertTrue(messageService.sendMessage(2000l, messageDomain));
        Long id = messageService.getUnreadMessageIds(2000l).get(0);
        MessageDomain messageDomainAdd = messageService.getMessageById(id);

        logger.info("messageDomainAdd测试前属性:"+messageDomainAdd);

        messageDomainAdd.setIsRead(true);
        messageDomainAdd.setIsArchived(true);
        messageDomainAdd.setIsDeleted(true);
        messageDomainAdd.setSenderName("sender");
        messageDomainAdd.setTitle("title");
        messageDomainAdd.setDescription("description");
        messageDomainAdd.setContent("content");
        messageDomainAdd.setBizId(8888l);
        messageDomainAdd.setBizName("bizName");
        messageDomainAdd.setBizType(BizObjectTypeEnum.CUSTOMER);
        messageDomainAdd.setType(MessageTypeEnum.SYSTEM);
        messageDomainAdd.setWorkspaceId(9999l);

        Assert.assertTrue(messageService.updateMessage(messageDomainAdd));
        logger.info("messageDomainAdd测试后属性:"+messageService.getMessageById(id));
    }

    /**
     * 测试 发送消息
     *
     * */
    @Test
    public void sendMessageTest() {
        MessageDomain messageDomain = createMessageDomain(1000l);

        //测试 发送消息到单个客户
        Assert.assertTrue(messageService.sendMessage(2000l, messageDomain));

        //测试 发送消息到多个客户
        List<Long> ids = new ArrayList<>();
        ids.add(2001l);ids.add(2002l);
        Assert.assertTrue(messageService.sendMessages(ids, messageDomain));

        //测试 发送多条消息
        List<MessageDomain> messageDomains = new ArrayList<>();
        MessageDomain messageDomain_1 = createMessageDomain(1001l),
                      messageDomain_2 = createMessageDomain(1002l);
        messageDomain_1.setReceiverId(2000l);
        messageDomain_2.setReceiverId(2000l);
        messageDomains.add(messageDomain_1);messageDomains.add(messageDomain_2);
        Assert.assertTrue(messageService.sendMessages(messageDomains));
    }

    /**
     * 测试 查询
     *
     * */
    @Test
    public void queryTest() {
        //接受者id:2xxx 发送者id:1xxx
        MessageDomain messageDomain = createMessageDomain(1000l);
        messageDomain.setIsRead(false);
        Assert.assertTrue(messageService.sendMessage(2000l, messageDomain));

        //测试 getUnreadMessageIds
        Assert.assertEquals(1, messageService.getUnreadMessageIds(2000l).size());

        //测试 countMessages
        MessageQuery messageQuery = new MessageQuery();
        messageQuery.setReceiverId(2000l);
        Assert.assertEquals(1, messageService.countMessages(messageQuery));
        messageQuery.setSenderId(1001l);
        Assert.assertEquals(0, messageService.countMessages(messageQuery));

        //测试 分页列出站内消息
        Assert.assertTrue(messageService.sendMessage(2001l, messageDomain));
        messageQuery.setSenderId(1000l);
        messageQuery.setReceiverId(null);
        messageQuery.setPageSize(1);
        messageQuery.setPageNum(1);
        PageResult<List<MessageDomain>> result = messageService.listMessages(messageQuery);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
        Assert.assertEquals(2, result.getPaginator().getLastPage());
    }
    /**
     * 测试 更新
     *
     * */
    @Test
    public void updateTest() {
        //1001->2001 1002->2002
        MessageDomain messageDomain_1 = createMessageDomain(1001l),
                      messageDomain_2 = createMessageDomain(1002l);
        messageDomain_1.setIsRead(false);messageDomain_2.setIsRead(false);
        Assert.assertTrue(messageService.sendMessage(2001l, messageDomain_1));
        Assert.assertTrue(messageService.sendMessage(2002l, messageDomain_2));

        Long id_1 = messageService.getUnreadMessageIds(2001l).get(0),
             id_2 = messageService.getUnreadMessageIds(2002l).get(0);
        MessageDomain messageDomainAdd_1 = messageService.getMessageById(id_1);

        //测试 updateMessage
        messageDomainAdd_1.setIsArchived(true);
        Assert.assertTrue(messageService.updateMessage(messageDomainAdd_1));
        logger.info("更新后的messageDomain为:"+messageService.getMessageById(id_1));

        //测试 updateMessages
        List<Long> ids = new ArrayList<>();
        ids.add(id_1);ids.add(id_2);
        MessageDomain messageDomain_3 = messageDomain_3 = createMessageDomain(1003l);
        messageDomain_3.setIsRead(true);
        Assert.assertTrue(messageService.updateMessages(messageDomain_3,ids));
        logger.info("更新后的id_1 message为:"+messageService.getMessageById(id_1));
        logger.info("更新后的id_2 message为:"+messageService.getMessageById(id_2));
    }
    /**
     * 测试 getMessageById & 删除
     *
     * */
    @Test
    public void deleteTest() {
        MessageDomain messageDomain = createMessageDomain(1000l);
        messageDomain.setIsRead(false);
        Assert.assertTrue(messageService.sendMessage(2000l, messageDomain));
        Long id = messageService.getUnreadMessageIds(2000l).get(0);

        //测试 getMessageById
        MessageDomain messageDomainAdd = messageService.getMessageById(id);
        Assert.assertNotNull(messageDomainAdd);
        logger.info("查询到id为"+id+"的记录为:"+messageDomainAdd);

        //deleteMessageByID
        Assert.assertTrue(messageService.deleteMessageByID(id));
        Assert.assertNull(messageService.getMessageById(id));
    }
    /**
     * 测试 是否判断
     *
     * */
    @Test
    public void isCorrectTest() {
        //测试 检查用户是否为该消息的接收者
        MessageDomain messageDomain = createMessageDomain(1000l);
        messageDomain.setIsRead(false);
        Assert.assertTrue(messageService.sendMessage(2000l, messageDomain));
        Assert.assertTrue(messageService.sendMessage(2001l, messageDomain));
        Long id_yes = messageService.getUnreadMessageIds(2000l).get(0);
        Long id_no = messageService.getUnreadMessageIds(2001l).get(0);
        List<Long> list_right = new ArrayList<>(),
                   list_wrong = new ArrayList<>();
        list_right.add(id_yes);list_wrong.add(id_no);

        Assert.assertTrue(messageService.isReceiver(list_right, 2000l));
        Assert.assertFalse(messageService.isReceiver(list_wrong, 2000l));
    }

    //~ private methods
    private MessageDomain createMessageDomain(Long senderId) {
        MessageDomain messageDomain = new MessageDomain();
        messageDomain.setSenderId(senderId);
        return messageDomain;
    }
}