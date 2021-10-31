package com.dnslin.onemanager.pojo;

import java.util.ArrayList;
import java.util.List;

public class OnedriveconfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OnedriveconfigExample() {
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

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
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

        public Criteria andClientidIsNull() {
            addCriterion("clientId is null");
            return (Criteria) this;
        }

        public Criteria andClientidIsNotNull() {
            addCriterion("clientId is not null");
            return (Criteria) this;
        }

        public Criteria andClientidEqualTo(String value) {
            addCriterion("clientId =", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotEqualTo(String value) {
            addCriterion("clientId <>", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidGreaterThan(String value) {
            addCriterion("clientId >", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidGreaterThanOrEqualTo(String value) {
            addCriterion("clientId >=", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLessThan(String value) {
            addCriterion("clientId <", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLessThanOrEqualTo(String value) {
            addCriterion("clientId <=", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLike(String value) {
            addCriterion("clientId like", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotLike(String value) {
            addCriterion("clientId not like", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidIn(List<String> values) {
            addCriterion("clientId in", values, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotIn(List<String> values) {
            addCriterion("clientId not in", values, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidBetween(String value1, String value2) {
            addCriterion("clientId between", value1, value2, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotBetween(String value1, String value2) {
            addCriterion("clientId not between", value1, value2, "clientid");
            return (Criteria) this;
        }

        public Criteria andRedirecturlIsNull() {
            addCriterion("redirectUrl is null");
            return (Criteria) this;
        }

        public Criteria andRedirecturlIsNotNull() {
            addCriterion("redirectUrl is not null");
            return (Criteria) this;
        }

        public Criteria andRedirecturlEqualTo(String value) {
            addCriterion("redirectUrl =", value, "redirecturl");
            return (Criteria) this;
        }

        public Criteria andRedirecturlNotEqualTo(String value) {
            addCriterion("redirectUrl <>", value, "redirecturl");
            return (Criteria) this;
        }

        public Criteria andRedirecturlGreaterThan(String value) {
            addCriterion("redirectUrl >", value, "redirecturl");
            return (Criteria) this;
        }

        public Criteria andRedirecturlGreaterThanOrEqualTo(String value) {
            addCriterion("redirectUrl >=", value, "redirecturl");
            return (Criteria) this;
        }

        public Criteria andRedirecturlLessThan(String value) {
            addCriterion("redirectUrl <", value, "redirecturl");
            return (Criteria) this;
        }

        public Criteria andRedirecturlLessThanOrEqualTo(String value) {
            addCriterion("redirectUrl <=", value, "redirecturl");
            return (Criteria) this;
        }

        public Criteria andRedirecturlLike(String value) {
            addCriterion("redirectUrl like", value, "redirecturl");
            return (Criteria) this;
        }

        public Criteria andRedirecturlNotLike(String value) {
            addCriterion("redirectUrl not like", value, "redirecturl");
            return (Criteria) this;
        }

        public Criteria andRedirecturlIn(List<String> values) {
            addCriterion("redirectUrl in", values, "redirecturl");
            return (Criteria) this;
        }

        public Criteria andRedirecturlNotIn(List<String> values) {
            addCriterion("redirectUrl not in", values, "redirecturl");
            return (Criteria) this;
        }

        public Criteria andRedirecturlBetween(String value1, String value2) {
            addCriterion("redirectUrl between", value1, value2, "redirecturl");
            return (Criteria) this;
        }

        public Criteria andRedirecturlNotBetween(String value1, String value2) {
            addCriterion("redirectUrl not between", value1, value2, "redirecturl");
            return (Criteria) this;
        }

        public Criteria andClientsecretIsNull() {
            addCriterion("clientSecret is null");
            return (Criteria) this;
        }

        public Criteria andClientsecretIsNotNull() {
            addCriterion("clientSecret is not null");
            return (Criteria) this;
        }

        public Criteria andClientsecretEqualTo(String value) {
            addCriterion("clientSecret =", value, "clientsecret");
            return (Criteria) this;
        }

        public Criteria andClientsecretNotEqualTo(String value) {
            addCriterion("clientSecret <>", value, "clientsecret");
            return (Criteria) this;
        }

        public Criteria andClientsecretGreaterThan(String value) {
            addCriterion("clientSecret >", value, "clientsecret");
            return (Criteria) this;
        }

        public Criteria andClientsecretGreaterThanOrEqualTo(String value) {
            addCriterion("clientSecret >=", value, "clientsecret");
            return (Criteria) this;
        }

        public Criteria andClientsecretLessThan(String value) {
            addCriterion("clientSecret <", value, "clientsecret");
            return (Criteria) this;
        }

        public Criteria andClientsecretLessThanOrEqualTo(String value) {
            addCriterion("clientSecret <=", value, "clientsecret");
            return (Criteria) this;
        }

        public Criteria andClientsecretLike(String value) {
            addCriterion("clientSecret like", value, "clientsecret");
            return (Criteria) this;
        }

        public Criteria andClientsecretNotLike(String value) {
            addCriterion("clientSecret not like", value, "clientsecret");
            return (Criteria) this;
        }

        public Criteria andClientsecretIn(List<String> values) {
            addCriterion("clientSecret in", values, "clientsecret");
            return (Criteria) this;
        }

        public Criteria andClientsecretNotIn(List<String> values) {
            addCriterion("clientSecret not in", values, "clientsecret");
            return (Criteria) this;
        }

        public Criteria andClientsecretBetween(String value1, String value2) {
            addCriterion("clientSecret between", value1, value2, "clientsecret");
            return (Criteria) this;
        }

        public Criteria andClientsecretNotBetween(String value1, String value2) {
            addCriterion("clientSecret not between", value1, value2, "clientsecret");
            return (Criteria) this;
        }

        public Criteria andAccesstokenIsNull() {
            addCriterion("accessToken is null");
            return (Criteria) this;
        }

        public Criteria andAccesstokenIsNotNull() {
            addCriterion("accessToken is not null");
            return (Criteria) this;
        }

        public Criteria andAccesstokenEqualTo(String value) {
            addCriterion("accessToken =", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenNotEqualTo(String value) {
            addCriterion("accessToken <>", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenGreaterThan(String value) {
            addCriterion("accessToken >", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenGreaterThanOrEqualTo(String value) {
            addCriterion("accessToken >=", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenLessThan(String value) {
            addCriterion("accessToken <", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenLessThanOrEqualTo(String value) {
            addCriterion("accessToken <=", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenLike(String value) {
            addCriterion("accessToken like", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenNotLike(String value) {
            addCriterion("accessToken not like", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenIn(List<String> values) {
            addCriterion("accessToken in", values, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenNotIn(List<String> values) {
            addCriterion("accessToken not in", values, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenBetween(String value1, String value2) {
            addCriterion("accessToken between", value1, value2, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenNotBetween(String value1, String value2) {
            addCriterion("accessToken not between", value1, value2, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenIsNull() {
            addCriterion("refreshToken is null");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenIsNotNull() {
            addCriterion("refreshToken is not null");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenEqualTo(String value) {
            addCriterion("refreshToken =", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenNotEqualTo(String value) {
            addCriterion("refreshToken <>", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenGreaterThan(String value) {
            addCriterion("refreshToken >", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenGreaterThanOrEqualTo(String value) {
            addCriterion("refreshToken >=", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenLessThan(String value) {
            addCriterion("refreshToken <", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenLessThanOrEqualTo(String value) {
            addCriterion("refreshToken <=", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenLike(String value) {
            addCriterion("refreshToken like", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenNotLike(String value) {
            addCriterion("refreshToken not like", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenIn(List<String> values) {
            addCriterion("refreshToken in", values, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenNotIn(List<String> values) {
            addCriterion("refreshToken not in", values, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenBetween(String value1, String value2) {
            addCriterion("refreshToken between", value1, value2, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenNotBetween(String value1, String value2) {
            addCriterion("refreshToken not between", value1, value2, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andExpiresIsNull() {
            addCriterion("expires is null");
            return (Criteria) this;
        }

        public Criteria andExpiresIsNotNull() {
            addCriterion("expires is not null");
            return (Criteria) this;
        }

        public Criteria andExpiresEqualTo(Long value) {
            addCriterion("expires =", value, "expires");
            return (Criteria) this;
        }

        public Criteria andExpiresNotEqualTo(Long value) {
            addCriterion("expires <>", value, "expires");
            return (Criteria) this;
        }

        public Criteria andExpiresGreaterThan(Long value) {
            addCriterion("expires >", value, "expires");
            return (Criteria) this;
        }

        public Criteria andExpiresGreaterThanOrEqualTo(Long value) {
            addCriterion("expires >=", value, "expires");
            return (Criteria) this;
        }

        public Criteria andExpiresLessThan(Long value) {
            addCriterion("expires <", value, "expires");
            return (Criteria) this;
        }

        public Criteria andExpiresLessThanOrEqualTo(Long value) {
            addCriterion("expires <=", value, "expires");
            return (Criteria) this;
        }

        public Criteria andExpiresIn(List<Long> values) {
            addCriterion("expires in", values, "expires");
            return (Criteria) this;
        }

        public Criteria andExpiresNotIn(List<Long> values) {
            addCriterion("expires not in", values, "expires");
            return (Criteria) this;
        }

        public Criteria andExpiresBetween(Long value1, Long value2) {
            addCriterion("expires between", value1, value2, "expires");
            return (Criteria) this;
        }

        public Criteria andExpiresNotBetween(Long value1, Long value2) {
            addCriterion("expires not between", value1, value2, "expires");
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