package com.sershare.asset.data.standard.service.task;

import com.sershare.asset.data.standard.entity.ProjectCheck;

import java.util.Date;

public interface ProjectCheckService {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectCheck record);

    int insertSelective(ProjectCheck record);

    ProjectCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectCheck record);

    int updateByPrimaryKey(ProjectCheck record);

    ProjectCheck selectByUnionKey(String projectId, String agencyId);

    ProjectCheck selectByExtractDate(String projectId, String agencyId, Date extractDate);
}