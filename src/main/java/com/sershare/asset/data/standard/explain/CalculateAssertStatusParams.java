package com.sershare.asset.data.standard.explain;

import java.util.Date;

public class CalculateAssertStatusParams {
    public String importId;
    public String projectId;
    public String assertId;
    public Date   statusDate;

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getAssertId() {
        return assertId;
    }

    public void setAssertId(String assertId) {
        this.assertId = assertId;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
}
