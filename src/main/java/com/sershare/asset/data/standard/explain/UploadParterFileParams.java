package com.sershare.asset.data.standard.explain;

import java.util.Date;

public class UploadParterFileParams {
	private String projectNo;
	private Date date;
	private Integer businessType;
	private String applicationId;
	private String loanNo;
	private Integer parterFileTaskRecordId;
	private String parterId;
	private String investigationPath;
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getBusinessType() {
		return businessType;
	}
	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getLoanNo() {
		return loanNo;
	}
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	public Integer getParterFileTaskRecordId() {
		return parterFileTaskRecordId;
	}
	public void setParterFileTaskRecordId(Integer parterFileTaskRecordId) {
		this.parterFileTaskRecordId = parterFileTaskRecordId;
	}
	public String getParterId() {
		return parterId;
	}
	public void setParterId(String parterId) {
		this.parterId = parterId;
	}
	public String getInvestigationPath() {
		return investigationPath;
	}
	public void setInvestigationPath(String investigationPath) {
		this.investigationPath = investigationPath;
	}
}
