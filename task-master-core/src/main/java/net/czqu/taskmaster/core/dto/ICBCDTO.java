package net.czqu.taskmaster.core.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-19 13:48
 **/
@Getter
@Setter
public class ICBCDTO {

    private String currencyType;
    private String currencyCHName;
    private String currencyENName;
    private String reference;
    private String foreignBuy;
    private String foreignSell;
    private String cashBuy;
    private String cashSell;
    private String publishDate;
    private String publishTime;


}
