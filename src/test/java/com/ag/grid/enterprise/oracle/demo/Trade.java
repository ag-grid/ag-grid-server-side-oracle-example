package com.ag.grid.enterprise.oracle.demo;

public class Trade {
    private String product;
    private String portfolio;
    private String book;
    private Long tradeId;
    private Long submitterId;
    private Long submitterDealId;
    private String dealType;
    private String bidType;
    private Double currentValue;
    private Double previousValue;
    private Long pl1;
    private Long pl2;
    private Long gainDx;
    private Long sxPx;
    private Long x99Out;
    private Long batch;

    public Trade(String product, String portfolio, String book, Long tradeId, Long submitterId, Long submitterDealId, String dealType, String bidType, Double currentValue, Double previousValue, Long pl1, Long pl2, Long gainDx, Long sxPx, Long x99Out, Long batch) {
        this.product = product;
        this.portfolio = portfolio;
        this.book = book;
        this.tradeId = tradeId;
        this.submitterId = submitterId;
        this.submitterDealId = submitterDealId;
        this.dealType = dealType;
        this.bidType = bidType;
        this.currentValue = currentValue;
        this.previousValue = previousValue;
        this.pl1 = pl1;
        this.pl2 = pl2;
        this.gainDx = gainDx;
        this.sxPx = sxPx;
        this.x99Out = x99Out;
        this.batch = batch;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Long getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(Long submitterId) {
        this.submitterId = submitterId;
    }

    public Long getSubmitterDealId() {
        return submitterDealId;
    }

    public void setSubmitterDealId(Long submitterDealId) {
        this.submitterDealId = submitterDealId;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getBidType() {
        return bidType;
    }

    public void setBidType(String bidType) {
        this.bidType = bidType;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public Double getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(Double previousValue) {
        this.previousValue = previousValue;
    }

    public Long getPl1() {
        return pl1;
    }

    public void setPl1(Long pl1) {
        this.pl1 = pl1;
    }

    public Long getPl2() {
        return pl2;
    }

    public void setPl2(Long pl2) {
        this.pl2 = pl2;
    }

    public Long getGainDx() {
        return gainDx;
    }

    public void setGainDx(Long gainDx) {
        this.gainDx = gainDx;
    }

    public Long getSxPx() {
        return sxPx;
    }

    public void setSxPx(Long sxPx) {
        this.sxPx = sxPx;
    }

    public Long getX99Out() {
        return x99Out;
    }

    public void setX99Out(Long x99Out) {
        this.x99Out = x99Out;
    }

    public Long getBatch() {
        return batch;
    }

    public void setBatch(Long batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "product='" + product + '\'' +
                ", portfolio='" + portfolio + '\'' +
                ", book='" + book + '\'' +
                ", tradeId=" + tradeId +
                ", submitterId=" + submitterId +
                ", submitterDealId=" + submitterDealId +
                ", dealType='" + dealType + '\'' +
                ", bidType='" + bidType + '\'' +
                ", currentValue=" + currentValue +
                ", previousValue=" + previousValue +
                ", pl1=" + pl1 +
                ", pl2=" + pl2 +
                ", gainDx=" + gainDx +
                ", sxPx=" + sxPx +
                ", x99Out=" + x99Out +
                ", batch=" + batch +
                '}';
    }
}