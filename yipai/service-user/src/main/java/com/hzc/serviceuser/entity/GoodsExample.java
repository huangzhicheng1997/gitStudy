package com.hzc.serviceuser.entity;

import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIsNull() {
            addCriterion("good_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIsNotNull() {
            addCriterion("good_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodPriceEqualTo(String value) {
            addCriterion("good_price =", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotEqualTo(String value) {
            addCriterion("good_price <>", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceGreaterThan(String value) {
            addCriterion("good_price >", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceGreaterThanOrEqualTo(String value) {
            addCriterion("good_price >=", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLessThan(String value) {
            addCriterion("good_price <", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLessThanOrEqualTo(String value) {
            addCriterion("good_price <=", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLike(String value) {
            addCriterion("good_price like", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotLike(String value) {
            addCriterion("good_price not like", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIn(List<String> values) {
            addCriterion("good_price in", values, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotIn(List<String> values) {
            addCriterion("good_price not in", values, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceBetween(String value1, String value2) {
            addCriterion("good_price between", value1, value2, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotBetween(String value1, String value2) {
            addCriterion("good_price not between", value1, value2, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeIsNull() {
            addCriterion("good_describe is null");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeIsNotNull() {
            addCriterion("good_describe is not null");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeEqualTo(String value) {
            addCriterion("good_describe =", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeNotEqualTo(String value) {
            addCriterion("good_describe <>", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeGreaterThan(String value) {
            addCriterion("good_describe >", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("good_describe >=", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeLessThan(String value) {
            addCriterion("good_describe <", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeLessThanOrEqualTo(String value) {
            addCriterion("good_describe <=", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeLike(String value) {
            addCriterion("good_describe like", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeNotLike(String value) {
            addCriterion("good_describe not like", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeIn(List<String> values) {
            addCriterion("good_describe in", values, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeNotIn(List<String> values) {
            addCriterion("good_describe not in", values, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeBetween(String value1, String value2) {
            addCriterion("good_describe between", value1, value2, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeNotBetween(String value1, String value2) {
            addCriterion("good_describe not between", value1, value2, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andImgSrcIsNull() {
            addCriterion("img_src is null");
            return (Criteria) this;
        }

        public Criteria andImgSrcIsNotNull() {
            addCriterion("img_src is not null");
            return (Criteria) this;
        }

        public Criteria andImgSrcEqualTo(String value) {
            addCriterion("img_src =", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcNotEqualTo(String value) {
            addCriterion("img_src <>", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcGreaterThan(String value) {
            addCriterion("img_src >", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcGreaterThanOrEqualTo(String value) {
            addCriterion("img_src >=", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcLessThan(String value) {
            addCriterion("img_src <", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcLessThanOrEqualTo(String value) {
            addCriterion("img_src <=", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcLike(String value) {
            addCriterion("img_src like", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcNotLike(String value) {
            addCriterion("img_src not like", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcIn(List<String> values) {
            addCriterion("img_src in", values, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcNotIn(List<String> values) {
            addCriterion("img_src not in", values, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcBetween(String value1, String value2) {
            addCriterion("img_src between", value1, value2, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcNotBetween(String value1, String value2) {
            addCriterion("img_src not between", value1, value2, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNull() {
            addCriterion("good_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNotNull() {
            addCriterion("good_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodNameEqualTo(String value) {
            addCriterion("good_name =", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotEqualTo(String value) {
            addCriterion("good_name <>", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThan(String value) {
            addCriterion("good_name >", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("good_name >=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThan(String value) {
            addCriterion("good_name <", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThanOrEqualTo(String value) {
            addCriterion("good_name <=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLike(String value) {
            addCriterion("good_name like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotLike(String value) {
            addCriterion("good_name not like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameIn(List<String> values) {
            addCriterion("good_name in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotIn(List<String> values) {
            addCriterion("good_name not in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameBetween(String value1, String value2) {
            addCriterion("good_name between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotBetween(String value1, String value2) {
            addCriterion("good_name not between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceIsNull() {
            addCriterion("auction_price is null");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceIsNotNull() {
            addCriterion("auction_price is not null");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceEqualTo(String value) {
            addCriterion("auction_price =", value, "auctionPrice");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceNotEqualTo(String value) {
            addCriterion("auction_price <>", value, "auctionPrice");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceGreaterThan(String value) {
            addCriterion("auction_price >", value, "auctionPrice");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceGreaterThanOrEqualTo(String value) {
            addCriterion("auction_price >=", value, "auctionPrice");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceLessThan(String value) {
            addCriterion("auction_price <", value, "auctionPrice");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceLessThanOrEqualTo(String value) {
            addCriterion("auction_price <=", value, "auctionPrice");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceLike(String value) {
            addCriterion("auction_price like", value, "auctionPrice");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceNotLike(String value) {
            addCriterion("auction_price not like", value, "auctionPrice");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceIn(List<String> values) {
            addCriterion("auction_price in", values, "auctionPrice");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceNotIn(List<String> values) {
            addCriterion("auction_price not in", values, "auctionPrice");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceBetween(String value1, String value2) {
            addCriterion("auction_price between", value1, value2, "auctionPrice");
            return (Criteria) this;
        }

        public Criteria andAuctionPriceNotBetween(String value1, String value2) {
            addCriterion("auction_price not between", value1, value2, "auctionPrice");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDetailImg1IsNull() {
            addCriterion("detail_img1 is null");
            return (Criteria) this;
        }

        public Criteria andDetailImg1IsNotNull() {
            addCriterion("detail_img1 is not null");
            return (Criteria) this;
        }

        public Criteria andDetailImg1EqualTo(String value) {
            addCriterion("detail_img1 =", value, "detailImg1");
            return (Criteria) this;
        }

        public Criteria andDetailImg1NotEqualTo(String value) {
            addCriterion("detail_img1 <>", value, "detailImg1");
            return (Criteria) this;
        }

        public Criteria andDetailImg1GreaterThan(String value) {
            addCriterion("detail_img1 >", value, "detailImg1");
            return (Criteria) this;
        }

        public Criteria andDetailImg1GreaterThanOrEqualTo(String value) {
            addCriterion("detail_img1 >=", value, "detailImg1");
            return (Criteria) this;
        }

        public Criteria andDetailImg1LessThan(String value) {
            addCriterion("detail_img1 <", value, "detailImg1");
            return (Criteria) this;
        }

        public Criteria andDetailImg1LessThanOrEqualTo(String value) {
            addCriterion("detail_img1 <=", value, "detailImg1");
            return (Criteria) this;
        }

        public Criteria andDetailImg1Like(String value) {
            addCriterion("detail_img1 like", value, "detailImg1");
            return (Criteria) this;
        }

        public Criteria andDetailImg1NotLike(String value) {
            addCriterion("detail_img1 not like", value, "detailImg1");
            return (Criteria) this;
        }

        public Criteria andDetailImg1In(List<String> values) {
            addCriterion("detail_img1 in", values, "detailImg1");
            return (Criteria) this;
        }

        public Criteria andDetailImg1NotIn(List<String> values) {
            addCriterion("detail_img1 not in", values, "detailImg1");
            return (Criteria) this;
        }

        public Criteria andDetailImg1Between(String value1, String value2) {
            addCriterion("detail_img1 between", value1, value2, "detailImg1");
            return (Criteria) this;
        }

        public Criteria andDetailImg1NotBetween(String value1, String value2) {
            addCriterion("detail_img1 not between", value1, value2, "detailImg1");
            return (Criteria) this;
        }

        public Criteria andDetailImg2IsNull() {
            addCriterion("detail_img2 is null");
            return (Criteria) this;
        }

        public Criteria andDetailImg2IsNotNull() {
            addCriterion("detail_img2 is not null");
            return (Criteria) this;
        }

        public Criteria andDetailImg2EqualTo(String value) {
            addCriterion("detail_img2 =", value, "detailImg2");
            return (Criteria) this;
        }

        public Criteria andDetailImg2NotEqualTo(String value) {
            addCriterion("detail_img2 <>", value, "detailImg2");
            return (Criteria) this;
        }

        public Criteria andDetailImg2GreaterThan(String value) {
            addCriterion("detail_img2 >", value, "detailImg2");
            return (Criteria) this;
        }

        public Criteria andDetailImg2GreaterThanOrEqualTo(String value) {
            addCriterion("detail_img2 >=", value, "detailImg2");
            return (Criteria) this;
        }

        public Criteria andDetailImg2LessThan(String value) {
            addCriterion("detail_img2 <", value, "detailImg2");
            return (Criteria) this;
        }

        public Criteria andDetailImg2LessThanOrEqualTo(String value) {
            addCriterion("detail_img2 <=", value, "detailImg2");
            return (Criteria) this;
        }

        public Criteria andDetailImg2Like(String value) {
            addCriterion("detail_img2 like", value, "detailImg2");
            return (Criteria) this;
        }

        public Criteria andDetailImg2NotLike(String value) {
            addCriterion("detail_img2 not like", value, "detailImg2");
            return (Criteria) this;
        }

        public Criteria andDetailImg2In(List<String> values) {
            addCriterion("detail_img2 in", values, "detailImg2");
            return (Criteria) this;
        }

        public Criteria andDetailImg2NotIn(List<String> values) {
            addCriterion("detail_img2 not in", values, "detailImg2");
            return (Criteria) this;
        }

        public Criteria andDetailImg2Between(String value1, String value2) {
            addCriterion("detail_img2 between", value1, value2, "detailImg2");
            return (Criteria) this;
        }

        public Criteria andDetailImg2NotBetween(String value1, String value2) {
            addCriterion("detail_img2 not between", value1, value2, "detailImg2");
            return (Criteria) this;
        }

        public Criteria andDetailImg3IsNull() {
            addCriterion("detail_img3 is null");
            return (Criteria) this;
        }

        public Criteria andDetailImg3IsNotNull() {
            addCriterion("detail_img3 is not null");
            return (Criteria) this;
        }

        public Criteria andDetailImg3EqualTo(String value) {
            addCriterion("detail_img3 =", value, "detailImg3");
            return (Criteria) this;
        }

        public Criteria andDetailImg3NotEqualTo(String value) {
            addCriterion("detail_img3 <>", value, "detailImg3");
            return (Criteria) this;
        }

        public Criteria andDetailImg3GreaterThan(String value) {
            addCriterion("detail_img3 >", value, "detailImg3");
            return (Criteria) this;
        }

        public Criteria andDetailImg3GreaterThanOrEqualTo(String value) {
            addCriterion("detail_img3 >=", value, "detailImg3");
            return (Criteria) this;
        }

        public Criteria andDetailImg3LessThan(String value) {
            addCriterion("detail_img3 <", value, "detailImg3");
            return (Criteria) this;
        }

        public Criteria andDetailImg3LessThanOrEqualTo(String value) {
            addCriterion("detail_img3 <=", value, "detailImg3");
            return (Criteria) this;
        }

        public Criteria andDetailImg3Like(String value) {
            addCriterion("detail_img3 like", value, "detailImg3");
            return (Criteria) this;
        }

        public Criteria andDetailImg3NotLike(String value) {
            addCriterion("detail_img3 not like", value, "detailImg3");
            return (Criteria) this;
        }

        public Criteria andDetailImg3In(List<String> values) {
            addCriterion("detail_img3 in", values, "detailImg3");
            return (Criteria) this;
        }

        public Criteria andDetailImg3NotIn(List<String> values) {
            addCriterion("detail_img3 not in", values, "detailImg3");
            return (Criteria) this;
        }

        public Criteria andDetailImg3Between(String value1, String value2) {
            addCriterion("detail_img3 between", value1, value2, "detailImg3");
            return (Criteria) this;
        }

        public Criteria andDetailImg3NotBetween(String value1, String value2) {
            addCriterion("detail_img3 not between", value1, value2, "detailImg3");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeIsNull() {
            addCriterion("limited_time is null");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeIsNotNull() {
            addCriterion("limited_time is not null");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeEqualTo(String value) {
            addCriterion("limited_time =", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeNotEqualTo(String value) {
            addCriterion("limited_time <>", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeGreaterThan(String value) {
            addCriterion("limited_time >", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("limited_time >=", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeLessThan(String value) {
            addCriterion("limited_time <", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeLessThanOrEqualTo(String value) {
            addCriterion("limited_time <=", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeLike(String value) {
            addCriterion("limited_time like", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeNotLike(String value) {
            addCriterion("limited_time not like", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeIn(List<String> values) {
            addCriterion("limited_time in", values, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeNotIn(List<String> values) {
            addCriterion("limited_time not in", values, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeBetween(String value1, String value2) {
            addCriterion("limited_time between", value1, value2, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeNotBetween(String value1, String value2) {
            addCriterion("limited_time not between", value1, value2, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSearchStatusIsNull() {
            addCriterion("search_status is null");
            return (Criteria) this;
        }

        public Criteria andSearchStatusIsNotNull() {
            addCriterion("search_status is not null");
            return (Criteria) this;
        }

        public Criteria andSearchStatusEqualTo(String value) {
            addCriterion("search_status =", value, "searchStatus");
            return (Criteria) this;
        }

        public Criteria andSearchStatusNotEqualTo(String value) {
            addCriterion("search_status <>", value, "searchStatus");
            return (Criteria) this;
        }

        public Criteria andSearchStatusGreaterThan(String value) {
            addCriterion("search_status >", value, "searchStatus");
            return (Criteria) this;
        }

        public Criteria andSearchStatusGreaterThanOrEqualTo(String value) {
            addCriterion("search_status >=", value, "searchStatus");
            return (Criteria) this;
        }

        public Criteria andSearchStatusLessThan(String value) {
            addCriterion("search_status <", value, "searchStatus");
            return (Criteria) this;
        }

        public Criteria andSearchStatusLessThanOrEqualTo(String value) {
            addCriterion("search_status <=", value, "searchStatus");
            return (Criteria) this;
        }

        public Criteria andSearchStatusLike(String value) {
            addCriterion("search_status like", value, "searchStatus");
            return (Criteria) this;
        }

        public Criteria andSearchStatusNotLike(String value) {
            addCriterion("search_status not like", value, "searchStatus");
            return (Criteria) this;
        }

        public Criteria andSearchStatusIn(List<String> values) {
            addCriterion("search_status in", values, "searchStatus");
            return (Criteria) this;
        }

        public Criteria andSearchStatusNotIn(List<String> values) {
            addCriterion("search_status not in", values, "searchStatus");
            return (Criteria) this;
        }

        public Criteria andSearchStatusBetween(String value1, String value2) {
            addCriterion("search_status between", value1, value2, "searchStatus");
            return (Criteria) this;
        }

        public Criteria andSearchStatusNotBetween(String value1, String value2) {
            addCriterion("search_status not between", value1, value2, "searchStatus");
            return (Criteria) this;
        }
    }

    /**
     */
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