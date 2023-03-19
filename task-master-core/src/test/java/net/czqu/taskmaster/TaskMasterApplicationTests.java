package net.czqu.taskmaster;


import net.czqu.taskmaster.service.ExchangeService;
import net.czqu.taskmasterdao.example.ExchangesExample;
import net.czqu.taskmasterdao.mapper.ExchangesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootTest
class TaskMasterApplicationTests {

    @Autowired
    ExchangesMapper exchangesMapper;
    @Autowired
    ExchangeService exchangeService;
    @Test
    void contextLoads() throws IOException, URISyntaxException {
    exchangesMapper.countByExample(ExchangesExample.newAndCreateCriteria().example());
        exchangeService.getExchangeFormICBC();
    }

}
