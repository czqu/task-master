package net.czqu.taskmaster.core.controller;


import io.micrometer.core.annotation.Timed;
import net.czqu.taskmaster.core.service.ExchangeService;
import net.czqu.taskmaster.dao.pojo.Exchanges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-15 22:58
 **/
@RestController
@RequestMapping("/exchange")
public class ExchangeController {
    private ExchangeService exchangeService;

    @Autowired
    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping
    @Timed(value = "exchange.response.time")
    public List<Exchanges> getList(
            @RequestParam(value = "num", defaultValue = "10")
            @Min(value = 1, message = "must >1")
            @Max(value = 100000, message = "must <100000")
            int num
    ) {

        return exchangeService.getLastData(num);
    }



}