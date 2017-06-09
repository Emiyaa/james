package com.miku.po;

import java.util.ArrayList;
import java.util.List;

public class MailFlagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MailFlagExample() {
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

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
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

        public Criteria andMessageNameIsNull() {
            addCriterion("message_name is null");
            return (Criteria) this;
        }

        public Criteria andMessageNameIsNotNull() {
            addCriterion("message_name is not null");
            return (Criteria) this;
        }

        public Criteria andMessageNameEqualTo(String value) {
            addCriterion("message_name =", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameNotEqualTo(String value) {
            addCriterion("message_name <>", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameGreaterThan(String value) {
            addCriterion("message_name >", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameGreaterThanOrEqualTo(String value) {
            addCriterion("message_name >=", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameLessThan(String value) {
            addCriterion("message_name <", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameLessThanOrEqualTo(String value) {
            addCriterion("message_name <=", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameLike(String value) {
            addCriterion("message_name like", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameNotLike(String value) {
            addCriterion("message_name not like", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameIn(List<String> values) {
            addCriterion("message_name in", values, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameNotIn(List<String> values) {
            addCriterion("message_name not in", values, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameBetween(String value1, String value2) {
            addCriterion("message_name between", value1, value2, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameNotBetween(String value1, String value2) {
            addCriterion("message_name not between", value1, value2, "messageName");
            return (Criteria) this;
        }

        public Criteria andIsdraftIsNull() {
            addCriterion("isdraft is null");
            return (Criteria) this;
        }

        public Criteria andIsdraftIsNotNull() {
            addCriterion("isdraft is not null");
            return (Criteria) this;
        }

        public Criteria andIsdraftEqualTo(Integer value) {
            addCriterion("isdraft =", value, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftNotEqualTo(Integer value) {
            addCriterion("isdraft <>", value, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftGreaterThan(Integer value) {
            addCriterion("isdraft >", value, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdraft >=", value, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftLessThan(Integer value) {
            addCriterion("isdraft <", value, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftLessThanOrEqualTo(Integer value) {
            addCriterion("isdraft <=", value, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftIn(List<Integer> values) {
            addCriterion("isdraft in", values, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftNotIn(List<Integer> values) {
            addCriterion("isdraft not in", values, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftBetween(Integer value1, Integer value2) {
            addCriterion("isdraft between", value1, value2, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftNotBetween(Integer value1, Integer value2) {
            addCriterion("isdraft not between", value1, value2, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
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
}