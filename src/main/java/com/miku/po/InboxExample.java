package com.miku.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InboxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InboxExample() {
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

        public Criteria andRepositoryNameIsNull() {
            addCriterion("repository_name is null");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameIsNotNull() {
            addCriterion("repository_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameEqualTo(String value) {
            addCriterion("repository_name =", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameNotEqualTo(String value) {
            addCriterion("repository_name <>", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameGreaterThan(String value) {
            addCriterion("repository_name >", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("repository_name >=", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameLessThan(String value) {
            addCriterion("repository_name <", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameLessThanOrEqualTo(String value) {
            addCriterion("repository_name <=", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameLike(String value) {
            addCriterion("repository_name like", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameNotLike(String value) {
            addCriterion("repository_name not like", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameIn(List<String> values) {
            addCriterion("repository_name in", values, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameNotIn(List<String> values) {
            addCriterion("repository_name not in", values, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameBetween(String value1, String value2) {
            addCriterion("repository_name between", value1, value2, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameNotBetween(String value1, String value2) {
            addCriterion("repository_name not between", value1, value2, "repositoryName");
            return (Criteria) this;
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

        public Criteria andMessageStateIsNull() {
            addCriterion("message_state is null");
            return (Criteria) this;
        }

        public Criteria andMessageStateIsNotNull() {
            addCriterion("message_state is not null");
            return (Criteria) this;
        }

        public Criteria andMessageStateEqualTo(String value) {
            addCriterion("message_state =", value, "messageState");
            return (Criteria) this;
        }

        public Criteria andMessageStateNotEqualTo(String value) {
            addCriterion("message_state <>", value, "messageState");
            return (Criteria) this;
        }

        public Criteria andMessageStateGreaterThan(String value) {
            addCriterion("message_state >", value, "messageState");
            return (Criteria) this;
        }

        public Criteria andMessageStateGreaterThanOrEqualTo(String value) {
            addCriterion("message_state >=", value, "messageState");
            return (Criteria) this;
        }

        public Criteria andMessageStateLessThan(String value) {
            addCriterion("message_state <", value, "messageState");
            return (Criteria) this;
        }

        public Criteria andMessageStateLessThanOrEqualTo(String value) {
            addCriterion("message_state <=", value, "messageState");
            return (Criteria) this;
        }

        public Criteria andMessageStateLike(String value) {
            addCriterion("message_state like", value, "messageState");
            return (Criteria) this;
        }

        public Criteria andMessageStateNotLike(String value) {
            addCriterion("message_state not like", value, "messageState");
            return (Criteria) this;
        }

        public Criteria andMessageStateIn(List<String> values) {
            addCriterion("message_state in", values, "messageState");
            return (Criteria) this;
        }

        public Criteria andMessageStateNotIn(List<String> values) {
            addCriterion("message_state not in", values, "messageState");
            return (Criteria) this;
        }

        public Criteria andMessageStateBetween(String value1, String value2) {
            addCriterion("message_state between", value1, value2, "messageState");
            return (Criteria) this;
        }

        public Criteria andMessageStateNotBetween(String value1, String value2) {
            addCriterion("message_state not between", value1, value2, "messageState");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIsNull() {
            addCriterion("error_message is null");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIsNotNull() {
            addCriterion("error_message is not null");
            return (Criteria) this;
        }

        public Criteria andErrorMessageEqualTo(String value) {
            addCriterion("error_message =", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotEqualTo(String value) {
            addCriterion("error_message <>", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageGreaterThan(String value) {
            addCriterion("error_message >", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageGreaterThanOrEqualTo(String value) {
            addCriterion("error_message >=", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLessThan(String value) {
            addCriterion("error_message <", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLessThanOrEqualTo(String value) {
            addCriterion("error_message <=", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLike(String value) {
            addCriterion("error_message like", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotLike(String value) {
            addCriterion("error_message not like", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIn(List<String> values) {
            addCriterion("error_message in", values, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotIn(List<String> values) {
            addCriterion("error_message not in", values, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageBetween(String value1, String value2) {
            addCriterion("error_message between", value1, value2, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotBetween(String value1, String value2) {
            addCriterion("error_message not between", value1, value2, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("sender is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("sender is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("sender =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("sender <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("sender >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("sender >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("sender <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("sender <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("sender like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("sender not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("sender in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("sender not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("sender between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("sender not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andRemoteHostIsNull() {
            addCriterion("remote_host is null");
            return (Criteria) this;
        }

        public Criteria andRemoteHostIsNotNull() {
            addCriterion("remote_host is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteHostEqualTo(String value) {
            addCriterion("remote_host =", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostNotEqualTo(String value) {
            addCriterion("remote_host <>", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostGreaterThan(String value) {
            addCriterion("remote_host >", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostGreaterThanOrEqualTo(String value) {
            addCriterion("remote_host >=", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostLessThan(String value) {
            addCriterion("remote_host <", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostLessThanOrEqualTo(String value) {
            addCriterion("remote_host <=", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostLike(String value) {
            addCriterion("remote_host like", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostNotLike(String value) {
            addCriterion("remote_host not like", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostIn(List<String> values) {
            addCriterion("remote_host in", values, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostNotIn(List<String> values) {
            addCriterion("remote_host not in", values, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostBetween(String value1, String value2) {
            addCriterion("remote_host between", value1, value2, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostNotBetween(String value1, String value2) {
            addCriterion("remote_host not between", value1, value2, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrIsNull() {
            addCriterion("remote_addr is null");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrIsNotNull() {
            addCriterion("remote_addr is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrEqualTo(String value) {
            addCriterion("remote_addr =", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrNotEqualTo(String value) {
            addCriterion("remote_addr <>", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrGreaterThan(String value) {
            addCriterion("remote_addr >", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrGreaterThanOrEqualTo(String value) {
            addCriterion("remote_addr >=", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrLessThan(String value) {
            addCriterion("remote_addr <", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrLessThanOrEqualTo(String value) {
            addCriterion("remote_addr <=", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrLike(String value) {
            addCriterion("remote_addr like", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrNotLike(String value) {
            addCriterion("remote_addr not like", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrIn(List<String> values) {
            addCriterion("remote_addr in", values, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrNotIn(List<String> values) {
            addCriterion("remote_addr not in", values, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrBetween(String value1, String value2) {
            addCriterion("remote_addr between", value1, value2, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrNotBetween(String value1, String value2) {
            addCriterion("remote_addr not between", value1, value2, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIsNull() {
            addCriterion("last_updated is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIsNotNull() {
            addCriterion("last_updated is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedEqualTo(Date value) {
            addCriterion("last_updated =", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotEqualTo(Date value) {
            addCriterion("last_updated <>", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThan(Date value) {
            addCriterion("last_updated >", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("last_updated >=", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThan(Date value) {
            addCriterion("last_updated <", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("last_updated <=", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIn(List<Date> values) {
            addCriterion("last_updated in", values, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotIn(List<Date> values) {
            addCriterion("last_updated not in", values, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedBetween(Date value1, Date value2) {
            addCriterion("last_updated between", value1, value2, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("last_updated not between", value1, value2, "lastUpdated");
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