package net.czqu.taskmasterdao.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Exchanges implements Cloneable {
    private Integer id;

    private Byte bankId;

    private Byte currencyType;

    private BigDecimal reference;

    private BigDecimal foreignBuy;

    private BigDecimal foreignSell;

    private BigDecimal cashBuy;

    private BigDecimal cashSell;

    private Date publishTime;

    private Date creatTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getBankId() {
        return bankId;
    }

    public void setBankId(Byte bankId) {
        this.bankId = bankId;
    }

    public Byte getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Byte currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getReference() {
        return reference;
    }

    public void setReference(BigDecimal reference) {
        this.reference = reference;
    }

    public BigDecimal getForeignBuy() {
        return foreignBuy;
    }

    public void setForeignBuy(BigDecimal foreignBuy) {
        this.foreignBuy = foreignBuy;
    }

    public BigDecimal getForeignSell() {
        return foreignSell;
    }

    public void setForeignSell(BigDecimal foreignSell) {
        this.foreignSell = foreignSell;
    }

    public BigDecimal getCashBuy() {
        return cashBuy;
    }

    public void setCashBuy(BigDecimal cashBuy) {
        this.cashBuy = cashBuy;
    }

    public BigDecimal getCashSell() {
        return cashSell;
    }

    public void setCashSell(BigDecimal cashSell) {
        this.cashSell = cashSell;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Exchanges clone() throws CloneNotSupportedException {
        return (Exchanges) super.clone();
    }

    public static class Builder {
        private Exchanges obj;

        public Builder() {
            this.obj = new Exchanges();
        }

        public Builder id(Integer id) {
            obj.setId(id);
            return this;
        }

        public Builder bankId(Byte bankId) {
            obj.setBankId(bankId);
            return this;
        }

        public Builder currencyType(Byte currencyType) {
            obj.setCurrencyType(currencyType);
            return this;
        }

        public Builder reference(BigDecimal reference) {
            obj.setReference(reference);
            return this;
        }

        public Builder foreignBuy(BigDecimal foreignBuy) {
            obj.setForeignBuy(foreignBuy);
            return this;
        }

        public Builder foreignSell(BigDecimal foreignSell) {
            obj.setForeignSell(foreignSell);
            return this;
        }

        public Builder cashBuy(BigDecimal cashBuy) {
            obj.setCashBuy(cashBuy);
            return this;
        }

        public Builder cashSell(BigDecimal cashSell) {
            obj.setCashSell(cashSell);
            return this;
        }

        public Builder publishTime(Date publishTime) {
            obj.setPublishTime(publishTime);
            return this;
        }

        public Builder creatTime(Date creatTime) {
            obj.setCreatTime(creatTime);
            return this;
        }

        public Exchanges build() {
            return this.obj;
        }
    }

    public enum Column {
        id("id", "id", "INTEGER", false),
        bankId("bank_id", "bankId", "TINYINT", false),
        currencyType("currency_type", "currencyType", "TINYINT", false),
        reference("reference", "reference", "DECIMAL", false),
        foreignBuy("foreign_buy", "foreignBuy", "DECIMAL", false),
        foreignSell("foreign_sell", "foreignSell", "DECIMAL", false),
        cashBuy("cash_buy", "cashBuy", "DECIMAL", false),
        cashSell("cash_sell", "cashSell", "DECIMAL", false),
        publishTime("publish_time", "publishTime", "TIMESTAMP", false),
        creatTime("creat_time", "creatTime", "TIMESTAMP", false);

        private static final String BEGINNING_DELIMITER = "\"";

        private static final String ENDING_DELIMITER = "\"";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}