package net.czqu.taskmaster.dao.mapper;

import java.util.List;
import net.czqu.taskmaster.dao.example.ExchangesExample;
import net.czqu.taskmaster.dao.pojo.Exchanges;
import org.apache.ibatis.annotations.Param;

public interface ExchangesMapper {
    long countByExample(ExchangesExample example);

    int deleteByExample(ExchangesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Exchanges record);

    int insertSelective(@Param("record") Exchanges record, @Param("selective") Exchanges.Column ... selective);

    Exchanges selectOneByExample(ExchangesExample example);

    Exchanges selectOneByExampleSelective(@Param("example") ExchangesExample example, @Param("selective") Exchanges.Column ... selective);

    List<Exchanges> selectByExampleSelective(@Param("example") ExchangesExample example, @Param("selective") Exchanges.Column ... selective);

    List<Exchanges> selectByExample(ExchangesExample example);

    Exchanges selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Exchanges.Column ... selective);

    Exchanges selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Exchanges record, @Param("example") ExchangesExample example, @Param("selective") Exchanges.Column ... selective);

    int updateByExample(@Param("record") Exchanges record, @Param("example") ExchangesExample example);

    int updateByPrimaryKeySelective(@Param("record") Exchanges record, @Param("selective") Exchanges.Column ... selective);

    int updateByPrimaryKey(Exchanges record);

    int batchInsert(@Param("list") List<Exchanges> list);

    int batchInsertSelective(@Param("list") List<Exchanges> list, @Param("selective") Exchanges.Column ... selective);
}