package net.czqu.taskmaster.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.czqu.taskmaster.dao.example.ExchangesExample;
import net.czqu.taskmaster.dao.mapper.ExchangesMapper;
import net.czqu.taskmaster.dao.pojo.Exchanges;
import net.czqu.taskmaster.dto.ExchangesDTO;
import net.czqu.taskmaster.dto.ICBCDTO;
import net.czqu.taskmaster.dto.ICBCGetDTO;
import net.czqu.taskmaster.utils.DateTimeParser;
import net.czqu.taskmaster.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static net.czqu.taskmaster.constant.enums.BankType.ICBC;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-15 21:31
 **/
@Slf4j
@Service
public class ExchangeService {
    private ExchangesMapper exchangesMapper;
    @Value("${exchanges.icbc_api_url:default}")
    private String icbcApiUrl = "";

    @Autowired
    public ExchangeService(ExchangesMapper exchangesMapper) {
        this.exchangesMapper = exchangesMapper;

    }


    public List<ExchangesDTO> getExchangeFormICBC() {
        ICBCDTO[] icbcdtoList = null;
        ICBCGetDTO response = null;
        List<ExchangesDTO> exchangesDTOList = new ArrayList<>();
        try {
            String responseBody = HttpClientUtil.httpGet(icbcApiUrl, null);

            ObjectMapper mapper = new ObjectMapper();
            response = mapper.readValue(responseBody, ICBCGetDTO.class);

        } catch (Exception e) {
            log.error(e.getMessage());
            return exchangesDTOList;
        }
        if (response == null || response.getCode() != 0) {
            return exchangesDTOList;
        }

        icbcdtoList = response.getData();

        for (ICBCDTO item : icbcdtoList) {
            exchangesDTOList.add(ICBCDTOToExchangesDTO(item));
        }

        return exchangesDTOList;
    }

    private ExchangesDTO ICBCDTOToExchangesDTO(ICBCDTO item) {

        ExchangesDTO exchangesDTO = new ExchangesDTO();
        exchangesDTO.setCashBuy(new BigDecimal(item.getCashBuy()));
        exchangesDTO.setCashSell(new BigDecimal(item.getCashSell()));
        exchangesDTO.setCurrencyCHName(item.getCurrencyCHName());
        exchangesDTO.setCurrencyENName(item.getCurrencyENName());
        exchangesDTO.setForeignBuy(new BigDecimal(item.getForeignBuy()));
        exchangesDTO.setForeignSell(new BigDecimal(item.getForeignSell()));
        exchangesDTO.setReference(new BigDecimal(item.getReference()));
        exchangesDTO.setCurrencyType(item.getCurrencyType());

        LocalDate publishDate = DateTimeParser.parseDate(item.getPublishDate(), "yyyy-MM-dd");
        LocalTime publishTime = DateTimeParser.parseTime(item.getPublishTime(), "HH:mm:ss");
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        exchangesDTO.setPublishTime(Date.from(LocalDateTime.of(publishDate, publishTime).atZone(zoneId).toInstant()));
        exchangesDTO.setBankId((byte) ICBC.getId());
        return exchangesDTO;
    }

    public void writeToDataBase(List<ExchangesDTO> exchangesDTOList) {

        for (ExchangesDTO exchangesDTO : exchangesDTOList) {
            if (exchangesMapper.countByExample(ExchangesExample.
                    newAndCreateCriteria().andCurrencyTypeEqualTo(Byte.valueOf(exchangesDTO.getCurrencyType()))
                    .andPublishTimeEqualTo(exchangesDTO.getPublishTime())
                    .andBankIdEqualTo((byte) exchangesDTO.getBankId())
                    .example()) > 0) {
                log.info("record repeat");
                continue;
            }
            Exchanges exchanges = new Exchanges();
            exchanges.setCashBuy(exchangesDTO.getCashBuy());
            exchanges.setCashSell(exchangesDTO.getCashSell());
            exchanges.setCurrencyType(Byte.valueOf(exchangesDTO.getCurrencyType()));
            exchanges.setForeignSell(exchangesDTO.getForeignSell());
            exchanges.setForeignBuy(exchangesDTO.getForeignBuy());
            exchanges.setPublishTime(exchangesDTO.getPublishTime());
            exchanges.setCreatTime(new Date());
            exchanges.setReference(exchangesDTO.getReference());
            exchanges.setBankId(exchangesDTO.getBankId());
            exchangesMapper.insert(exchanges);
        }


    }

    public List<Exchanges> getLastData(int num) {
        if (num < 0 || num > 1000) {
            return new ArrayList<>();
        }
        return exchangesMapper.selectByExample(ExchangesExample.newAndCreateCriteria()
                .example().limit(num).orderBy(Exchanges.Column.publishTime.desc()));

    }

}
