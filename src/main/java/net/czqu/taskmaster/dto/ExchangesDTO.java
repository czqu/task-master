package net.czqu.taskmaster.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-15 21:32
 **/
@Getter
@Setter
public class ExchangesDTO {
    private String currencyENName;
    private byte bankId;
    private String currencyType;
    private String currencyCHName;
    private BigDecimal foreignBuy;
    private BigDecimal reference;
    private BigDecimal foreignSell;
    private BigDecimal cashBuy;
    private BigDecimal cashSell;

    private Date publishTime;
}
