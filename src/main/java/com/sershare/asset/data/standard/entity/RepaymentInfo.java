package com.sershare.asset.data.standard.entity;

import com.google.gson.annotations.SerializedName;
import com.sershare.asset.data.standard.enums.AccountStatusEnum;
import com.sershare.asset.data.standard.enums.PaymentTypeEnum;
import com.sershare.asset.data.standard.utils.DateUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class RepaymentInfo {
    private Integer id;

    @SerializedName(value = "IMPORTID", alternate = {"importId"})
    private String importId;

    @SerializedName(value = "项目编号", alternate = {"projectId"})
    private String projectId;

    @SerializedName(value = "机构编号", alternate = {"agencyId"})
    private String agencyId;

    @SerializedName(value = "借据号", alternate = {"assetId"})
    private String assetId;

    @SerializedName(value = "应还款日", alternate = {"repayDate"})
    private Date repayDate;

    @SerializedName(value = "应还本金(元)", alternate = {"repayPrincipal"})
    private BigDecimal repayPrincipal;

    @SerializedName(value = "应还利息(元)", alternate = {"repayInterest"})
    private BigDecimal repayInterest;

    @SerializedName(value = "应还费用(元)", alternate = {"repayFee"})
    private BigDecimal repayFee;

    @SerializedName(value = "实际还清日期", alternate = {"relPayDate"})
    private Date relPayDate;

    @SerializedName(value = "实还本金(元)", alternate = {"relPrincipal"})
    private BigDecimal relPrincipal;

    @SerializedName(value = "实还利息(元)", alternate = {"relInterest"})
    private BigDecimal relInterest;

    @SerializedName(value = "实还费用(元)", alternate = {"relFee"})
    private BigDecimal relFee;

    @SerializedName(value = "期次", alternate = {"period"})
    private Integer period;

    @SerializedName(value = "TIMESTAMP", alternate = {"timestamp"})
    private Timestamp timestamp;

    @SerializedName(value = "免息金额", alternate = {"freeAmount"})
    private BigDecimal freeAmount;
    @SerializedName(value = "实还执行利率", alternate = {"realInterestRate"} )
    private BigDecimal realInterestRate;

    private String extraInfo;

    private Date createTime;

    private Date updateTime;

    // 当期贷款余额,资产放给的值
    @SerializedName(value = "当期贷款余额", alternate = {"currentLoanBalance"})
    private BigDecimal currentLoanBalance;

    // 增加计算扩展字段
    // 剩余本金
    @SerializedName(value = "剩余本金", alternate = {"remainderPrincipal"})
    private BigDecimal remainderPrincipal;

    // 剩余利息，指的是根据还款计划算出的总利息减去已还利息，如果已结清状态也为0。如果多还，等于还款计划期末剩余利息
    @SerializedName(value = "剩余利息", alternate = {"remainderInterest"})
    private BigDecimal remainderInterest;

    // 剩余费用，指的是根据还款计划算出的总费用减去已还费用，如果已结清状态也为0。如果多还，等于还款计划期末剩余费用
    @SerializedName(value = "剩余费用", alternate = {"remainderFee"})
    private BigDecimal remainderFee;


    // 剩余期次，如果当期本金被还清就等于余下期次，如果已结清为0
    @SerializedName(value = "剩余期次", alternate = {"remainderPeriods"})
    private int remainderPeriods;

    // 当期账户状态（资产现在的状态）： 提前还款（就是结清）、正常、逾期
    @SerializedName(value = "当期账户状态", alternate = {"accountStatus"})
    private String accountStatus;

    @SerializedName(value = "当期状态", alternate = {"currentStatus"})
    private String currentStatus;

    // 逾期天数： 逾期状态下， 应还日 实还日决定
    @SerializedName(value = "逾期天数", alternate = {"overdueDay"})
    private int overdueDay;

    // 还款类型: 提前还款 正常还款 逾期还款
    @SerializedName(value = "还款类型", alternate = {"repayType"})
    private String repayType;

    // 已还期数
    @SerializedName(value = "已还期数", alternate = {"finishPeriods"})
    private int finishPeriods;

    // 还款计划增加计算辅助字段，这些字段将在插入数据库的时候初始化，帮助实还信息计算
    // 期初剩余本金
    @SerializedName(value = "期初剩余本金", alternate = {"planBeginLoanPrincipal"})
    private BigDecimal planBeginLoanPrincipal;

    // 期末剩余本金
    @SerializedName(value = "期末剩余本金", alternate = {"planEndLoanPrincipal"})
    private BigDecimal planEndLoanPrincipal;

    // 期初剩余利息
    @SerializedName(value = "期初剩余利息", alternate = {"planBeginLoanInterest"})
    private BigDecimal planBeginLoanInterest;

    // 期末剩余利息
    @SerializedName(value = "期末剩余利息", alternate = {"planEndLoanInterest"})
    private BigDecimal planEndLoanInterest;

    // 期初剩余费用
    @SerializedName(value = "期初剩余费用", alternate = {"planBeginLoanFee"})
    private BigDecimal planBeginLoanFee;

    // 期末剩余费用
    @SerializedName(value = "期末剩余费用", alternate = {"planEndLoanFee"})
    private BigDecimal planEndLoanFee;

    // 期末剩余期数
    @SerializedName(value = "期末剩余期数", alternate = {"planRemainderPeriods"})
    private int planRemainderPeriods;

    // 下一个还款日
    @SerializedName(value = "下一个还款日", alternate = {"planNextRepayDate"})
    private Date planNextRepayDate;

    @SerializedName(value = "应还罚息(元)", alternate = {"repayPenalty"})
    private BigDecimal repayPenalty;

    @SerializedName(value = "实还罚息(元)", alternate = {"relPenalty"})
    private BigDecimal relPenalty;

    private String settleReason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId == null ? null : importId.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId == null ? null : agencyId.trim();
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId == null ? null : assetId.trim();
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public BigDecimal getRepayPrincipal() {
        return repayPrincipal;
    }

    public void setRepayPrincipal(BigDecimal repayPrincipal) {
        this.repayPrincipal = repayPrincipal;
    }

    public BigDecimal getRepayInterest() {
        return repayInterest;
    }

    public void setRepayInterest(BigDecimal repayInterest) {
        this.repayInterest = repayInterest;
    }

    public BigDecimal getRepayFee() {
        return repayFee;
    }

    public void setRepayFee(BigDecimal repayFee) {
        this.repayFee = repayFee;
    }

    public Date getRelPayDate() {
        return relPayDate;
    }

    public void setRelPayDate(Date relPayDate) {
        this.relPayDate = relPayDate;
    }

    public BigDecimal getRelPrincipal() {
        return relPrincipal;
    }

    public void setRelPrincipal(BigDecimal relPrincipal) {
        this.relPrincipal = relPrincipal;
    }

    public BigDecimal getRelInterest() {
        return relInterest;
    }

    public void setRelInterest(BigDecimal relInterest) {
        this.relInterest = relInterest;
    }

    public BigDecimal getRelFee() {
        return relFee;
    }

    public void setRelFee(BigDecimal relFee) {
        this.relFee = relFee;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo == null ? null : extraInfo.trim();
    }

    public BigDecimal getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(BigDecimal freeAmount) {
        this.freeAmount = freeAmount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getRemainderPrincipal() {
        return remainderPrincipal;
    }

    public void setRemainderPrincipal(BigDecimal remainderPrincipal) {
        this.remainderPrincipal = remainderPrincipal;
    }

    public BigDecimal getRemainderInterest() {
        return remainderInterest;
    }

    public void setRemainderInterest(BigDecimal remainderInterest) {
        this.remainderInterest = remainderInterest;
    }

    public BigDecimal getRemainderFee() {
        return remainderFee;
    }

    public void setRemainderFee(BigDecimal remainderFee) {
        this.remainderFee = remainderFee;
    }

    public int getRemainderPeriods() {
        return remainderPeriods;
    }

    public void setRemainderPeriods(int remainderPeriods) {
        this.remainderPeriods = remainderPeriods;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(int overdueDay) {
        this.overdueDay = overdueDay;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public BigDecimal getCurrentLoanBalance() {
        return currentLoanBalance;
    }

    public void setCurrentLoanBalance(BigDecimal currentLoanBalance) {
        this.currentLoanBalance = currentLoanBalance;
    }

    public BigDecimal getPlanBeginLoanPrincipal() {
        return planBeginLoanPrincipal;
    }

    public void setPlanBeginLoanPrincipal(BigDecimal planBeginLoanPrincipal) {
        this.planBeginLoanPrincipal = planBeginLoanPrincipal;
    }

    public BigDecimal getPlanEndLoanPrincipal() {
        return planEndLoanPrincipal;
    }

    public void setPlanEndLoanPrincipal(BigDecimal planEndLoanPrincipal) {
        this.planEndLoanPrincipal = planEndLoanPrincipal;
    }

    public BigDecimal getPlanBeginLoanInterest() {
        return planBeginLoanInterest;
    }

    public void setPlanBeginLoanInterest(BigDecimal planBeginLoanInterest) {
        this.planBeginLoanInterest = planBeginLoanInterest;
    }

    public BigDecimal getPlanEndLoanInterest() {
        return planEndLoanInterest;
    }

    public void setPlanEndLoanInterest(BigDecimal planEndLoanInterest) {
        this.planEndLoanInterest = planEndLoanInterest;
    }

    public BigDecimal getPlanBeginLoanFee() {
        return planBeginLoanFee;
    }

    public void setPlanBeginLoanFee(BigDecimal planBeginLoanFee) {
        this.planBeginLoanFee = planBeginLoanFee;
    }

    public BigDecimal getPlanEndLoanFee() {
        return planEndLoanFee;
    }

    public void setPlanEndLoanFee(BigDecimal planEndLoanFee) {
        this.planEndLoanFee = planEndLoanFee;
    }

    public int getPlanRemainderPeriods() {
        return planRemainderPeriods;
    }

    public void setPlanRemainderPeriods(int planRemainderPeriods) {
        this.planRemainderPeriods = planRemainderPeriods;
    }

    public Date getPlanNextRepayDate() {
        return planNextRepayDate;
    }

    public void setPlanNextRepayDate(Date planNextRepayDate) {
        this.planNextRepayDate = planNextRepayDate;
    }

    public int getFinishPeriods() {
        return finishPeriods;
    }

    public void setFinishPeriods(int finishPeriods) {
        this.finishPeriods = finishPeriods;
    }

    public BigDecimal getRealInterestRate() {
        return realInterestRate;
    }

    public void setRealInterestRate(BigDecimal realInterestRate) {
        this.realInterestRate = realInterestRate;
    }

    public BigDecimal getRepayPenalty() {
        return repayPenalty;
    }

    public void setRepayPenalty(BigDecimal repayPenalty) {
        this.repayPenalty = repayPenalty;
    }

    public BigDecimal getRelPenalty() {
        return relPenalty;
    }

    public void setRelPenalty(BigDecimal relPenalty) {
        this.relPenalty = relPenalty;
    }

    public String getSettleReason() {
        return settleReason;
    }

    public void setSettleReason(String settleReason) {
        this.settleReason = settleReason;
    }

    public void initByRepaymentSchedule(RepaymentSchedule repaymentSchedule) {
        setProjectId(repaymentSchedule.getProjectId());
        setAssetId(repaymentSchedule.getAssetId());
        setAgencyId(repaymentSchedule.getAgencyId());

        //还款计划基本信息
        setRepayDate(repaymentSchedule.getRepayDate());
        setRepayPrincipal(repaymentSchedule.getRepayPrincipal());
        setRepayInterest(repaymentSchedule.getRepayInterest());
        setRepayFee(repaymentSchedule.getRepayFee());
        setRepayPenalty(repaymentSchedule.getRepayPenalty());
        setPeriod(repaymentSchedule.getPeriod());

        //还款计划扩展
        setPlanBeginLoanPrincipal(repaymentSchedule.getBeginLoanPrincipal());
        setPlanEndLoanPrincipal(repaymentSchedule.getEndLoanPrincipal());
        setPlanBeginLoanInterest(repaymentSchedule.getBeginLoanInterest());
        setPlanEndLoanInterest(repaymentSchedule.getEndLoanInterest());
        setPlanBeginLoanFee(repaymentSchedule.getBeginLoanFee());
        setPlanEndLoanFee(repaymentSchedule.getEndLoanFee());
        setPlanRemainderPeriods(repaymentSchedule.getRemainderPeriods());
        setPlanNextRepayDate(repaymentSchedule.getNextRepayDate());
    }

    public void calcOnPerodStatus() {
        // 增加计算扩展字段
        // 剩余本金 = 期初贷款余额 - 当期实际还款本金
        remainderPrincipal = getPlanBeginLoanPrincipal().subtract(relPrincipal);

        // 剩余利息，指的是根据还款计划算出的总利息减去已还利息，如果已结清状态也为0。如果多还，等于还款计划期末剩余利息
        remainderInterest = getPlanBeginLoanInterest().subtract(relInterest);
        if (remainderInterest.compareTo(getPlanEndLoanInterest()) < 0) {
            remainderInterest = getPlanEndLoanInterest();
        }
        // 剩余费用，指的是根据还款计划算出的总费用减去已还费用，如果已结清状态也为0。如果多还，等于还款计划期末剩余费用
        remainderFee = getPlanBeginLoanFee().subtract(relFee);
        if (remainderFee.compareTo(getPlanEndLoanFee()) < 0) {
            remainderFee = getPlanEndLoanFee();
        }

        if (relPayDate.compareTo(repayDate) > 0) {
            repayType = PaymentTypeEnum.OVERDUEPAYMENT.getType();
        } else if (relPayDate.compareTo(repayDate) == 0 && remainderPrincipal.compareTo(getPlanEndLoanPrincipal()) > 0) {
            repayType = PaymentTypeEnum.OVERDUEPAYMENT.getType();
        } else if (relPayDate.compareTo(repayDate) == 0) {
            repayType = PaymentTypeEnum.NORMALPAYMENT.getType();
        } else {
            repayType = PaymentTypeEnum.PREPAYMENT.getType();
        }

        // 剩余期次，如果当期本金被还清就等于余下期次，如果已结清为0
        // 已还期数
        // 当期账户状态（资产现在的状态）： 提前还款（就是结清）、正常、逾期
        if (remainderPrincipal.compareTo(getPlanEndLoanPrincipal()) > 0) {
            finishPeriods = getPeriod() - 1;
            remainderPeriods = getPlanRemainderPeriods() + 1;
            if (relPayDate.compareTo(repayDate) >= 0) {
                accountStatus = AccountStatusEnum.OVERDUE.getDesc();
                currentStatus = AccountStatusEnum.OVERDUE.getDesc();
            } else {
                accountStatus = AccountStatusEnum.NORMAL.getDesc();
                currentStatus = AccountStatusEnum.NORMAL.getDesc();

            }
        } else {
            finishPeriods = getPeriod();
            remainderPeriods = getPlanRemainderPeriods();
            accountStatus = AccountStatusEnum.NORMAL.getDesc();

            //只要少于1块钱，都认为是结清
            if (remainderPrincipal.compareTo(BigDecimal.ONE) <= 0) {
                finishPeriods = getPeriod() + getPlanRemainderPeriods();
                remainderPeriods = 0;
                if(relPayDate.compareTo(repayDate) < 0){
                    accountStatus = AccountStatusEnum.PAYOFF.getDesc();
                    currentStatus = AccountStatusEnum.NORMAL.getDesc();
                }else if(relPayDate.compareTo(repayDate) == 0){
                    accountStatus = AccountStatusEnum.NORMAL.getDesc();
                    currentStatus = AccountStatusEnum.NORMAL.getDesc();
                }else {
                    accountStatus = AccountStatusEnum.OVERDUE.getDesc();
                    currentStatus = AccountStatusEnum.NORMAL.getDesc();
                }

//                // 还款类型: 只要是结清就是提前还款
//                repayType = PaymentTypeEnum.PREPAYMENT.getType();
                remainderPrincipal = BigDecimal.ZERO;
                remainderInterest = BigDecimal.ZERO;
                remainderFee = BigDecimal.ZERO;
            }
        }

        // 逾期天数： 逾期状态下， 应还日 实还日决定
        if (accountStatus.equals(AccountStatusEnum.OVERDUE.getDesc())) {
            overdueDay =  Math.max(0, DateUtils.subDay(relPayDate, repayDate)+1);
        } else {
            overdueDay =  Math.max(0, DateUtils.subDay(relPayDate, repayDate));
        }

        //应对部分还款
        if (relPrincipal.equals(repayPrincipal) &&  accountStatus.equals(AccountStatusEnum.OVERDUE.getDesc())) {
            accountStatus = AccountStatusEnum.NORMAL.getDesc();
            remainderPrincipal = planEndLoanPrincipal;
            remainderInterest = planEndLoanInterest;
            remainderFee = planEndLoanFee;
            if (planEndLoanPrincipal.equals(BigDecimal.ZERO)) {
                accountStatus = AccountStatusEnum.PAYOFF.getDesc();
            }
        }

    }

    public void fillRepaymentInfoPlanZero(){
        planBeginLoanPrincipal = BigDecimal.ZERO;
        planEndLoanPrincipal = BigDecimal.ZERO;
        planBeginLoanInterest = BigDecimal.ZERO;
        planEndLoanInterest = BigDecimal.ZERO;
        planBeginLoanFee = BigDecimal.ZERO;
        planEndLoanFee = BigDecimal.ZERO;
    }

}