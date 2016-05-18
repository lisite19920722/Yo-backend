package tiger.common.dal.persistence.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import tiger.common.dal.persistence.wechat.WechatTemplateDO;
import tiger.common.dal.persistence.wechat.example.WechatTemplateExample;

public interface WechatTemplateMapper {
    int countByExample(WechatTemplateExample example);

    int deleteByExample(WechatTemplateExample example);

    List<WechatTemplateDO> selectByExample(WechatTemplateExample example);

    int updateByExampleSelective(@Param("record") WechatTemplateDO record, @Param("example") WechatTemplateExample example);

    int updateByExample(@Param("record") WechatTemplateDO record, @Param("example") WechatTemplateExample example);

    List<WechatTemplateDO> selectByExampleAndPage(WechatTemplateExample example, RowBounds rowBound);

    int deleteByPrimaryKey(Long id);

    int insert(WechatTemplateDO record);

    int insertSelective(WechatTemplateDO record);

    WechatTemplateDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WechatTemplateDO record);

    int updateByPrimaryKey(WechatTemplateDO record);
}