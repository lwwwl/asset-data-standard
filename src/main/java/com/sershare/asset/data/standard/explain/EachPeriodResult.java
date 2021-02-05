package com.sershare.asset.data.standard.explain;


import com.weshare.assertstatus.common.enums.AssertStatusEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 当期对账数据
 */
public class EachPeriodResult {

    Date periodDate;

    int period = 0;

    int periodOverdueDayNum = 0;
    /**
     * 当期逾期本金
     */
    BigDecimal overduePrincipal = BigDecimal.ZERO;

    /**
     * 当期逾期利息
     */
    BigDecimal overdueInterest = BigDecimal.ZERO;

    /**
     * 当期逾期费用
     */
    BigDecimal overdueFee = BigDecimal.ZERO;

    String status = AssertStatusEnum.NORMAL.getDesc();
    /**当前逾期期数*/
    int currentOverduePeriod = 0;

    public Date getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(Date periodDate) {
        this.periodDate = periodDate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getPeriodOverdueDayNum() {
        return periodOverdueDayNum;
    }

    public void setPeriodOverdueDayNum(int periodOverdueDayNum) {
        this.periodOverdueDayNum = periodOverdueDayNum;
    }

    public BigDecimal getOverduePrincipal() {
        return overduePrincipal;
    }

    public void setOverduePrincipal(BigDecimal overduePrincipal) {
        this.overduePrincipal = overduePrincipal;
    }

    public BigDecimal getOverdueInterest() {
        return overdueInterest;
    }

    public void setOverdueInterest(BigDecimal overdueInterest) {
        this.overdueInterest = overdueInterest;
    }

    public BigDecimal getOverdueFee() {
        return overdueFee;
    }

    public void setOverdueFee(BigDecimal overdueFee) {
        this.overdueFee = overdueFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrentOverduePeriod() {
        return currentOverduePeriod;
    }

    public void setCurrentOverduePeriod(int currentOverduePeriod) {
        this.currentOverduePeriod = currentOverduePeriod;
    }
}
