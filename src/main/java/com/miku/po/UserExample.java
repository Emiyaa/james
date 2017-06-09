package com.miku.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernicknameIsNull() {
            addCriterion("usernickname is null");
            return (Criteria) this;
        }

        public Criteria andUsernicknameIsNotNull() {
            addCriterion("usernickname is not null");
            return (Criteria) this;
        }

        public Criteria andUsernicknameEqualTo(String value) {
            addCriterion("usernickname =", value, "usernickname");
            return (Criteria) this;
        }

        public Criteria andUsernicknameNotEqualTo(String value) {
            addCriterion("usernickname <>", value, "usernickname");
            return (Criteria) this;
        }

        public Criteria andUsernicknameGreaterThan(String value) {
            addCriterion("usernickname >", value, "usernickname");
            return (Criteria) this;
        }

        public Criteria andUsernicknameGreaterThanOrEqualTo(String value) {
            addCriterion("usernickname >=", value, "usernickname");
            return (Criteria) this;
        }

        public Criteria andUsernicknameLessThan(String value) {
            addCriterion("usernickname <", value, "usernickname");
            return (Criteria) this;
        }

        public Criteria andUsernicknameLessThanOrEqualTo(String value) {
            addCriterion("usernickname <=", value, "usernickname");
            return (Criteria) this;
        }

        public Criteria andUsernicknameLike(String value) {
            addCriterion("usernickname like", value, "usernickname");
            return (Criteria) this;
        }

        public Criteria andUsernicknameNotLike(String value) {
            addCriterion("usernickname not like", value, "usernickname");
            return (Criteria) this;
        }

        public Criteria andUsernicknameIn(List<String> values) {
            addCriterion("usernickname in", values, "usernickname");
            return (Criteria) this;
        }

        public Criteria andUsernicknameNotIn(List<String> values) {
            addCriterion("usernickname not in", values, "usernickname");
            return (Criteria) this;
        }

        public Criteria andUsernicknameBetween(String value1, String value2) {
            addCriterion("usernickname between", value1, value2, "usernickname");
            return (Criteria) this;
        }

        public Criteria andUsernicknameNotBetween(String value1, String value2) {
            addCriterion("usernickname not between", value1, value2, "usernickname");
            return (Criteria) this;
        }

        public Criteria andUsermailIsNull() {
            addCriterion("usermail is null");
            return (Criteria) this;
        }

        public Criteria andUsermailIsNotNull() {
            addCriterion("usermail is not null");
            return (Criteria) this;
        }

        public Criteria andUsermailEqualTo(String value) {
            addCriterion("usermail =", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailNotEqualTo(String value) {
            addCriterion("usermail <>", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailGreaterThan(String value) {
            addCriterion("usermail >", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailGreaterThanOrEqualTo(String value) {
            addCriterion("usermail >=", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailLessThan(String value) {
            addCriterion("usermail <", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailLessThanOrEqualTo(String value) {
            addCriterion("usermail <=", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailLike(String value) {
            addCriterion("usermail like", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailNotLike(String value) {
            addCriterion("usermail not like", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailIn(List<String> values) {
            addCriterion("usermail in", values, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailNotIn(List<String> values) {
            addCriterion("usermail not in", values, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailBetween(String value1, String value2) {
            addCriterion("usermail between", value1, value2, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailNotBetween(String value1, String value2) {
            addCriterion("usermail not between", value1, value2, "usermail");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayIsNull() {
            addCriterion("userbirthday is null");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayIsNotNull() {
            addCriterion("userbirthday is not null");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("userbirthday =", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("userbirthday <>", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("userbirthday >", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("userbirthday >=", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayLessThan(Date value) {
            addCriterionForJDBCDate("userbirthday <", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("userbirthday <=", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("userbirthday in", values, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("userbirthday not in", values, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("userbirthday between", value1, value2, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("userbirthday not between", value1, value2, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUsermobileIsNull() {
            addCriterion("usermobile is null");
            return (Criteria) this;
        }

        public Criteria andUsermobileIsNotNull() {
            addCriterion("usermobile is not null");
            return (Criteria) this;
        }

        public Criteria andUsermobileEqualTo(String value) {
            addCriterion("usermobile =", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileNotEqualTo(String value) {
            addCriterion("usermobile <>", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileGreaterThan(String value) {
            addCriterion("usermobile >", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileGreaterThanOrEqualTo(String value) {
            addCriterion("usermobile >=", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileLessThan(String value) {
            addCriterion("usermobile <", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileLessThanOrEqualTo(String value) {
            addCriterion("usermobile <=", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileLike(String value) {
            addCriterion("usermobile like", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileNotLike(String value) {
            addCriterion("usermobile not like", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileIn(List<String> values) {
            addCriterion("usermobile in", values, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileNotIn(List<String> values) {
            addCriterion("usermobile not in", values, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileBetween(String value1, String value2) {
            addCriterion("usermobile between", value1, value2, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileNotBetween(String value1, String value2) {
            addCriterion("usermobile not between", value1, value2, "usermobile");
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