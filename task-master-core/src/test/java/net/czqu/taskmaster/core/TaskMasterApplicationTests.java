package net.czqu.taskmaster.core;


import net.czqu.taskmaster.core.service.ExchangeService;
import net.czqu.taskmaster.dao.example.ExchangesExample;
import net.czqu.taskmaster.dao.mapper.ExchangesMapper;
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
