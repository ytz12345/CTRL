package com.bupt.ctrl.model;

import java.util.ArrayList;
import java.util.List;

public class ChapterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChapterExample() {
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

        public Criteria andChapterIdIsNull() {
            addCriterion("Chapter_id is null");
            return (Criteria) this;
        }

        public Criteria andChapterIdIsNotNull() {
            addCriterion("Chapter_id is not null");
            return (Criteria) this;
        }

        public Criteria andChapterIdEqualTo(Integer value) {
            addCriterion("Chapter_id =", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotEqualTo(Integer value) {
            addCriterion("Chapter_id <>", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdGreaterThan(Integer value) {
            addCriterion("Chapter_id >", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Chapter_id >=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLessThan(Integer value) {
            addCriterion("Chapter_id <", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLessThanOrEqualTo(Integer value) {
            addCriterion("Chapter_id <=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdIn(List<Integer> values) {
            addCriterion("Chapter_id in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotIn(List<Integer> values) {
            addCriterion("Chapter_id not in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdBetween(Integer value1, Integer value2) {
            addCriterion("Chapter_id between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Chapter_id not between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterNumIsNull() {
            addCriterion("Chapter_Num is null");
            return (Criteria) this;
        }

        public Criteria andChapterNumIsNotNull() {
            addCriterion("Chapter_Num is not null");
            return (Criteria) this;
        }

        public Criteria andChapterNumEqualTo(Integer value) {
            addCriterion("Chapter_Num =", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumNotEqualTo(Integer value) {
            addCriterion("Chapter_Num <>", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumGreaterThan(Integer value) {
            addCriterion("Chapter_Num >", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("Chapter_Num >=", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumLessThan(Integer value) {
            addCriterion("Chapter_Num <", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumLessThanOrEqualTo(Integer value) {
            addCriterion("Chapter_Num <=", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumIn(List<Integer> values) {
            addCriterion("Chapter_Num in", values, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumNotIn(List<Integer> values) {
            addCriterion("Chapter_Num not in", values, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumBetween(Integer value1, Integer value2) {
            addCriterion("Chapter_Num between", value1, value2, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumNotBetween(Integer value1, Integer value2) {
            addCriterion("Chapter_Num not between", value1, value2, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNameIsNull() {
            addCriterion("Chapter_Name is null");
            return (Criteria) this;
        }

        public Criteria andChapterNameIsNotNull() {
            addCriterion("Chapter_Name is not null");
            return (Criteria) this;
        }

        public Criteria andChapterNameEqualTo(String value) {
            addCriterion("Chapter_Name =", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameNotEqualTo(String value) {
            addCriterion("Chapter_Name <>", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameGreaterThan(String value) {
            addCriterion("Chapter_Name >", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameGreaterThanOrEqualTo(String value) {
            addCriterion("Chapter_Name >=", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameLessThan(String value) {
            addCriterion("Chapter_Name <", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameLessThanOrEqualTo(String value) {
            addCriterion("Chapter_Name <=", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameLike(String value) {
            addCriterion("Chapter_Name like", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameNotLike(String value) {
            addCriterion("Chapter_Name not like", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameIn(List<String> values) {
            addCriterion("Chapter_Name in", values, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameNotIn(List<String> values) {
            addCriterion("Chapter_Name not in", values, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameBetween(String value1, String value2) {
            addCriterion("Chapter_Name between", value1, value2, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameNotBetween(String value1, String value2) {
            addCriterion("Chapter_Name not between", value1, value2, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterVideoIsNull() {
            addCriterion("Chapter_Video is null");
            return (Criteria) this;
        }

        public Criteria andChapterVideoIsNotNull() {
            addCriterion("Chapter_Video is not null");
            return (Criteria) this;
        }

        public Criteria andChapterVideoEqualTo(String value) {
            addCriterion("Chapter_Video =", value, "chapterVideo");
            return (Criteria) this;
        }

        public Criteria andChapterVideoNotEqualTo(String value) {
            addCriterion("Chapter_Video <>", value, "chapterVideo");
            return (Criteria) this;
        }

        public Criteria andChapterVideoGreaterThan(String value) {
            addCriterion("Chapter_Video >", value, "chapterVideo");
            return (Criteria) this;
        }

        public Criteria andChapterVideoGreaterThanOrEqualTo(String value) {
            addCriterion("Chapter_Video >=", value, "chapterVideo");
            return (Criteria) this;
        }

        public Criteria andChapterVideoLessThan(String value) {
            addCriterion("Chapter_Video <", value, "chapterVideo");
            return (Criteria) this;
        }

        public Criteria andChapterVideoLessThanOrEqualTo(String value) {
            addCriterion("Chapter_Video <=", value, "chapterVideo");
            return (Criteria) this;
        }

        public Criteria andChapterVideoLike(String value) {
            addCriterion("Chapter_Video like", value, "chapterVideo");
            return (Criteria) this;
        }

        public Criteria andChapterVideoNotLike(String value) {
            addCriterion("Chapter_Video not like", value, "chapterVideo");
            return (Criteria) this;
        }

        public Criteria andChapterVideoIn(List<String> values) {
            addCriterion("Chapter_Video in", values, "chapterVideo");
            return (Criteria) this;
        }

        public Criteria andChapterVideoNotIn(List<String> values) {
            addCriterion("Chapter_Video not in", values, "chapterVideo");
            return (Criteria) this;
        }

        public Criteria andChapterVideoBetween(String value1, String value2) {
            addCriterion("Chapter_Video between", value1, value2, "chapterVideo");
            return (Criteria) this;
        }

        public Criteria andChapterVideoNotBetween(String value1, String value2) {
            addCriterion("Chapter_Video not between", value1, value2, "chapterVideo");
            return (Criteria) this;
        }

        public Criteria andChapterPptIsNull() {
            addCriterion("Chapter_PPT is null");
            return (Criteria) this;
        }

        public Criteria andChapterPptIsNotNull() {
            addCriterion("Chapter_PPT is not null");
            return (Criteria) this;
        }

        public Criteria andChapterPptEqualTo(String value) {
            addCriterion("Chapter_PPT =", value, "chapterPpt");
            return (Criteria) this;
        }

        public Criteria andChapterPptNotEqualTo(String value) {
            addCriterion("Chapter_PPT <>", value, "chapterPpt");
            return (Criteria) this;
        }

        public Criteria andChapterPptGreaterThan(String value) {
            addCriterion("Chapter_PPT >", value, "chapterPpt");
            return (Criteria) this;
        }

        public Criteria andChapterPptGreaterThanOrEqualTo(String value) {
            addCriterion("Chapter_PPT >=", value, "chapterPpt");
            return (Criteria) this;
        }

        public Criteria andChapterPptLessThan(String value) {
            addCriterion("Chapter_PPT <", value, "chapterPpt");
            return (Criteria) this;
        }

        public Criteria andChapterPptLessThanOrEqualTo(String value) {
            addCriterion("Chapter_PPT <=", value, "chapterPpt");
            return (Criteria) this;
        }

        public Criteria andChapterPptLike(String value) {
            addCriterion("Chapter_PPT like", value, "chapterPpt");
            return (Criteria) this;
        }

        public Criteria andChapterPptNotLike(String value) {
            addCriterion("Chapter_PPT not like", value, "chapterPpt");
            return (Criteria) this;
        }

        public Criteria andChapterPptIn(List<String> values) {
            addCriterion("Chapter_PPT in", values, "chapterPpt");
            return (Criteria) this;
        }

        public Criteria andChapterPptNotIn(List<String> values) {
            addCriterion("Chapter_PPT not in", values, "chapterPpt");
            return (Criteria) this;
        }

        public Criteria andChapterPptBetween(String value1, String value2) {
            addCriterion("Chapter_PPT between", value1, value2, "chapterPpt");
            return (Criteria) this;
        }

        public Criteria andChapterPptNotBetween(String value1, String value2) {
            addCriterion("Chapter_PPT not between", value1, value2, "chapterPpt");
            return (Criteria) this;
        }

        public Criteria andCourseCourseIdIsNull() {
            addCriterion("Course_Course_Id is null");
            return (Criteria) this;
        }

        public Criteria andCourseCourseIdIsNotNull() {
            addCriterion("Course_Course_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCourseIdEqualTo(Integer value) {
            addCriterion("Course_Course_Id =", value, "courseCourseId");
            return (Criteria) this;
        }

        public Criteria andCourseCourseIdNotEqualTo(Integer value) {
            addCriterion("Course_Course_Id <>", value, "courseCourseId");
            return (Criteria) this;
        }

        public Criteria andCourseCourseIdGreaterThan(Integer value) {
            addCriterion("Course_Course_Id >", value, "courseCourseId");
            return (Criteria) this;
        }

        public Criteria andCourseCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Course_Course_Id >=", value, "courseCourseId");
            return (Criteria) this;
        }

        public Criteria andCourseCourseIdLessThan(Integer value) {
            addCriterion("Course_Course_Id <", value, "courseCourseId");
            return (Criteria) this;
        }

        public Criteria andCourseCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("Course_Course_Id <=", value, "courseCourseId");
            return (Criteria) this;
        }

        public Criteria andCourseCourseIdIn(List<Integer> values) {
            addCriterion("Course_Course_Id in", values, "courseCourseId");
            return (Criteria) this;
        }

        public Criteria andCourseCourseIdNotIn(List<Integer> values) {
            addCriterion("Course_Course_Id not in", values, "courseCourseId");
            return (Criteria) this;
        }

        public Criteria andCourseCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("Course_Course_Id between", value1, value2, "courseCourseId");
            return (Criteria) this;
        }

        public Criteria andCourseCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Course_Course_Id not between", value1, value2, "courseCourseId");
            return (Criteria) this;
        }

        public Criteria andChapterIntroIsNull() {
            addCriterion("Chapter_Intro is null");
            return (Criteria) this;
        }

        public Criteria andChapterIntroIsNotNull() {
            addCriterion("Chapter_Intro is not null");
            return (Criteria) this;
        }

        public Criteria andChapterIntroEqualTo(String value) {
            addCriterion("Chapter_Intro =", value, "chapterIntro");
            return (Criteria) this;
        }

        public Criteria andChapterIntroNotEqualTo(String value) {
            addCriterion("Chapter_Intro <>", value, "chapterIntro");
            return (Criteria) this;
        }

        public Criteria andChapterIntroGreaterThan(String value) {
            addCriterion("Chapter_Intro >", value, "chapterIntro");
            return (Criteria) this;
        }

        public Criteria andChapterIntroGreaterThanOrEqualTo(String value) {
            addCriterion("Chapter_Intro >=", value, "chapterIntro");
            return (Criteria) this;
        }

        public Criteria andChapterIntroLessThan(String value) {
            addCriterion("Chapter_Intro <", value, "chapterIntro");
            return (Criteria) this;
        }

        public Criteria andChapterIntroLessThanOrEqualTo(String value) {
            addCriterion("Chapter_Intro <=", value, "chapterIntro");
            return (Criteria) this;
        }

        public Criteria andChapterIntroLike(String value) {
            addCriterion("Chapter_Intro like", value, "chapterIntro");
            return (Criteria) this;
        }

        public Criteria andChapterIntroNotLike(String value) {
            addCriterion("Chapter_Intro not like", value, "chapterIntro");
            return (Criteria) this;
        }

        public Criteria andChapterIntroIn(List<String> values) {
            addCriterion("Chapter_Intro in", values, "chapterIntro");
            return (Criteria) this;
        }

        public Criteria andChapterIntroNotIn(List<String> values) {
            addCriterion("Chapter_Intro not in", values, "chapterIntro");
            return (Criteria) this;
        }

        public Criteria andChapterIntroBetween(String value1, String value2) {
            addCriterion("Chapter_Intro between", value1, value2, "chapterIntro");
            return (Criteria) this;
        }

        public Criteria andChapterIntroNotBetween(String value1, String value2) {
            addCriterion("Chapter_Intro not between", value1, value2, "chapterIntro");
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