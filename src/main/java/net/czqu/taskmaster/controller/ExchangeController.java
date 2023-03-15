package net.czqu.taskmaster.controller;

import net.czqu.taskmaster.dao.pojo.Exchanges;
import net.czqu.taskmaster.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public List<Exchanges> getList(
            @RequestParam(value = "num", defaultValue = "10")
            @Min(value = 1, message = "must >1")
            @Max(value = 1000, message = "must <1000")
            int num
    ) {

        return exchangeService.getLastData(num);
    }


}
