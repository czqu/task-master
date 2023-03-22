package net.czqu.taskmaster.schedule;

import lombok.extern.slf4j.Slf4j;
import net.czqu.taskmaster.service.ExchangeService;
import net.czqu.taskmaster.dto.ExchangesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableAsync
@Slf4j
public class ScheduleConfig {
    private ExchangeService exchangeService;

    @Autowired
    public ScheduleConfig(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @Scheduled(cron = "0 0/30 * * * ?")
    @Async("scheduledTask")
    public void getExchange() {
        try {
            log.info("start run exchange");
            List<ExchangesDTO> icbcdtoList = exchangeService.getExchangeFormICBC();
            exchangeService.writeToDataBase(icbcdtoList);
            log.info(" exchange task end");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }

    }
}