package net.czqu.taskmasterdao.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.czqu.taskmasterdao.pojo.Exchanges;

public class ExchangesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public ExchangesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public ExchangesExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public ExchangesExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        rows = null;
        offset = null;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getRows() {
        return this.rows;
    }

    public ExchangesExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public ExchangesExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public ExchangesExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
    }

    public static Criteria newAndCreateCriteria() {
        ExchangesExample example = new ExchangesExample();
        return example.createCriteria();
    }

    public ExchangesExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public ExchangesExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public ExchangesExample distinct(boolean distinct) {
        this.setDistinct(distinct);
        return this;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBankIdIsNull() {
            addCriterion("bank_id is null");
            return (Criteria) this;
        }

        public Criteria andBankIdIsNotNull() {
            addCriterion("bank_id is not null");
            return (Criteria) this;
        }

        public Criteria andBankIdEqualTo(Byte value) {
            addCriterion("bank_id =", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("bank_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBankIdNotEqualTo(Byte value) {
            addCriterion("bank_id <>", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("bank_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBankIdGreaterThan(Byte value) {
            addCriterion("bank_id >", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdGreaterThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("bank_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBankIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("bank_id >=", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdGreaterThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("bank_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBankIdLessThan(Byte value) {
            addCriterion("bank_id <", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdLessThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("bank_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBankIdLessThanOrEqualTo(Byte value) {
            addCriterion("bank_id <=", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdLessThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("bank_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBankIdIn(List<Byte> values) {
            addCriterion("bank_id in", values, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotIn(List<Byte> values) {
            addCriterion("bank_id not in", values, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdBetween(Byte value1, Byte value2) {
            addCriterion("bank_id between", value1, value2, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotBetween(Byte value1, Byte value2) {
            addCriterion("bank_id not between", value1, value2, "bankId");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeIsNull() {
            addCriterion("currency_type is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeIsNotNull() {
            addCriterion("currency_type is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeEqualTo(Byte value) {
            addCriterion("currency_type =", value, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("currency_type = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeNotEqualTo(Byte value) {
            addCriterion("currency_type <>", value, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeNotEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("currency_type <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeGreaterThan(Byte value) {
            addCriterion("currency_type >", value, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeGreaterThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("currency_type > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("currency_type >=", value, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeGreaterThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("currency_type >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeLessThan(Byte value) {
            addCriterion("currency_type <", value, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeLessThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("currency_type < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeLessThanOrEqualTo(Byte value) {
            addCriterion("currency_type <=", value, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeLessThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("currency_type <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeIn(List<Byte> values) {
            addCriterion("currency_type in", values, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeNotIn(List<Byte> values) {
            addCriterion("currency_type not in", values, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeBetween(Byte value1, Byte value2) {
            addCriterion("currency_type between", value1, value2, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("currency_type not between", value1, value2, "currencyType");
            return (Criteria) this;
        }

        public Criteria andReferenceIsNull() {
            addCriterion("reference is null");
            return (Criteria) this;
        }

        public Criteria andReferenceIsNotNull() {
            addCriterion("reference is not null");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(BigDecimal value) {
            addCriterion("reference =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("reference = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReferenceNotEqualTo(BigDecimal value) {
            addCriterion("reference <>", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceNotEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("reference <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReferenceGreaterThan(BigDecimal value) {
            addCriterion("reference >", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceGreaterThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("reference > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReferenceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reference >=", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceGreaterThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("reference >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReferenceLessThan(BigDecimal value) {
            addCriterion("reference <", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceLessThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("reference < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReferenceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reference <=", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceLessThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("reference <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReferenceIn(List<BigDecimal> values) {
            addCriterion("reference in", values, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceNotIn(List<BigDecimal> values) {
            addCriterion("reference not in", values, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reference between", value1, value2, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reference not between", value1, value2, "reference");
            return (Criteria) this;
        }

        public Criteria andForeignBuyIsNull() {
            addCriterion("foreign_buy is null");
            return (Criteria) this;
        }

        public Criteria andForeignBuyIsNotNull() {
            addCriterion("foreign_buy is not null");
            return (Criteria) this;
        }

        public Criteria andForeignBuyEqualTo(BigDecimal value) {
            addCriterion("foreign_buy =", value, "foreignBuy");
            return (Criteria) this;
        }

        public Criteria andForeignBuyEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("foreign_buy = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andForeignBuyNotEqualTo(BigDecimal value) {
            addCriterion("foreign_buy <>", value, "foreignBuy");
            return (Criteria) this;
        }

        public Criteria andForeignBuyNotEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("foreign_buy <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andForeignBuyGreaterThan(BigDecimal value) {
            addCriterion("foreign_buy >", value, "foreignBuy");
            return (Criteria) this;
        }

        public Criteria andForeignBuyGreaterThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("foreign_buy > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andForeignBuyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("foreign_buy >=", value, "foreignBuy");
            return (Criteria) this;
        }

        public Criteria andForeignBuyGreaterThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("foreign_buy >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andForeignBuyLessThan(BigDecimal value) {
            addCriterion("foreign_buy <", value, "foreignBuy");
            return (Criteria) this;
        }

        public Criteria andForeignBuyLessThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("foreign_buy < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andForeignBuyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("foreign_buy <=", value, "foreignBuy");
            return (Criteria) this;
        }

        public Criteria andForeignBuyLessThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("foreign_buy <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andForeignBuyIn(List<BigDecimal> values) {
            addCriterion("foreign_buy in", values, "foreignBuy");
            return (Criteria) this;
        }

        public Criteria andForeignBuyNotIn(List<BigDecimal> values) {
            addCriterion("foreign_buy not in", values, "foreignBuy");
            return (Criteria) this;
        }

        public Criteria andForeignBuyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("foreign_buy between", value1, value2, "foreignBuy");
            return (Criteria) this;
        }

        public Criteria andForeignBuyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("foreign_buy not between", value1, value2, "foreignBuy");
            return (Criteria) this;
        }

        public Criteria andForeignSellIsNull() {
            addCriterion("foreign_sell is null");
            return (Criteria) this;
        }

        public Criteria andForeignSellIsNotNull() {
            addCriterion("foreign_sell is not null");
            return (Criteria) this;
        }

        public Criteria andForeignSellEqualTo(BigDecimal value) {
            addCriterion("foreign_sell =", value, "foreignSell");
            return (Criteria) this;
        }

        public Criteria andForeignSellEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("foreign_sell = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andForeignSellNotEqualTo(BigDecimal value) {
            addCriterion("foreign_sell <>", value, "foreignSell");
            return (Criteria) this;
        }

        public Criteria andForeignSellNotEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("foreign_sell <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andForeignSellGreaterThan(BigDecimal value) {
            addCriterion("foreign_sell >", value, "foreignSell");
            return (Criteria) this;
        }

        public Criteria andForeignSellGreaterThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("foreign_sell > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andForeignSellGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("foreign_sell >=", value, "foreignSell");
            return (Criteria) this;
        }

        public Criteria andForeignSellGreaterThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("foreign_sell >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andForeignSellLessThan(BigDecimal value) {
            addCriterion("foreign_sell <", value, "foreignSell");
            return (Criteria) this;
        }

        public Criteria andForeignSellLessThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("foreign_sell < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andForeignSellLessThanOrEqualTo(BigDecimal value) {
            addCriterion("foreign_sell <=", value, "foreignSell");
            return (Criteria) this;
        }

        public Criteria andForeignSellLessThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("foreign_sell <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andForeignSellIn(List<BigDecimal> values) {
            addCriterion("foreign_sell in", values, "foreignSell");
            return (Criteria) this;
        }

        public Criteria andForeignSellNotIn(List<BigDecimal> values) {
            addCriterion("foreign_sell not in", values, "foreignSell");
            return (Criteria) this;
        }

        public Criteria andForeignSellBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("foreign_sell between", value1, value2, "foreignSell");
            return (Criteria) this;
        }

        public Criteria andForeignSellNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("foreign_sell not between", value1, value2, "foreignSell");
            return (Criteria) this;
        }

        public Criteria andCashBuyIsNull() {
            addCriterion("cash_buy is null");
            return (Criteria) this;
        }

        public Criteria andCashBuyIsNotNull() {
            addCriterion("cash_buy is not null");
            return (Criteria) this;
        }

        public Criteria andCashBuyEqualTo(BigDecimal value) {
            addCriterion("cash_buy =", value, "cashBuy");
            return (Criteria) this;
        }

        public Criteria andCashBuyEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("cash_buy = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCashBuyNotEqualTo(BigDecimal value) {
            addCriterion("cash_buy <>", value, "cashBuy");
            return (Criteria) this;
        }

        public Criteria andCashBuyNotEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("cash_buy <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCashBuyGreaterThan(BigDecimal value) {
            addCriterion("cash_buy >", value, "cashBuy");
            return (Criteria) this;
        }

        public Criteria andCashBuyGreaterThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("cash_buy > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCashBuyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_buy >=", value, "cashBuy");
            return (Criteria) this;
        }

        public Criteria andCashBuyGreaterThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("cash_buy >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCashBuyLessThan(BigDecimal value) {
            addCriterion("cash_buy <", value, "cashBuy");
            return (Criteria) this;
        }

        public Criteria andCashBuyLessThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("cash_buy < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCashBuyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_buy <=", value, "cashBuy");
            return (Criteria) this;
        }

        public Criteria andCashBuyLessThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("cash_buy <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCashBuyIn(List<BigDecimal> values) {
            addCriterion("cash_buy in", values, "cashBuy");
            return (Criteria) this;
        }

        public Criteria andCashBuyNotIn(List<BigDecimal> values) {
            addCriterion("cash_buy not in", values, "cashBuy");
            return (Criteria) this;
        }

        public Criteria andCashBuyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_buy between", value1, value2, "cashBuy");
            return (Criteria) this;
        }

        public Criteria andCashBuyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_buy not between", value1, value2, "cashBuy");
            return (Criteria) this;
        }

        public Criteria andCashSellIsNull() {
            addCriterion("cash_sell is null");
            return (Criteria) this;
        }

        public Criteria andCashSellIsNotNull() {
            addCriterion("cash_sell is not null");
            return (Criteria) this;
        }

        public Criteria andCashSellEqualTo(BigDecimal value) {
            addCriterion("cash_sell =", value, "cashSell");
            return (Criteria) this;
        }

        public Criteria andCashSellEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("cash_sell = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCashSellNotEqualTo(BigDecimal value) {
            addCriterion("cash_sell <>", value, "cashSell");
            return (Criteria) this;
        }

        public Criteria andCashSellNotEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("cash_sell <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCashSellGreaterThan(BigDecimal value) {
            addCriterion("cash_sell >", value, "cashSell");
            return (Criteria) this;
        }

        public Criteria andCashSellGreaterThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("cash_sell > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCashSellGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_sell >=", value, "cashSell");
            return (Criteria) this;
        }

        public Criteria andCashSellGreaterThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("cash_sell >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCashSellLessThan(BigDecimal value) {
            addCriterion("cash_sell <", value, "cashSell");
            return (Criteria) this;
        }

        public Criteria andCashSellLessThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("cash_sell < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCashSellLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_sell <=", value, "cashSell");
            return (Criteria) this;
        }

        public Criteria andCashSellLessThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("cash_sell <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCashSellIn(List<BigDecimal> values) {
            addCriterion("cash_sell in", values, "cashSell");
            return (Criteria) this;
        }

        public Criteria andCashSellNotIn(List<BigDecimal> values) {
            addCriterion("cash_sell not in", values, "cashSell");
            return (Criteria) this;
        }

        public Criteria andCashSellBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_sell between", value1, value2, "cashSell");
            return (Criteria) this;
        }

        public Criteria andCashSellNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_sell not between", value1, value2, "cashSell");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("publish_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("publish_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("publish_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("publish_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("publish_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("publish_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("creat_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("creat_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("creat_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("creat_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("creat_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualToColumn(Exchanges.Column column) {
            addCriterion(new StringBuilder("creat_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private ExchangesExample example;

        protected Criteria(ExchangesExample example) {
            super();
            this.example = example;
        }

        public ExchangesExample example() {
            return this.example;
        }

        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria add);
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(ExchangesExample example);
    }
}