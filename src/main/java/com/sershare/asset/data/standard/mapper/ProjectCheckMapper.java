package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.entity.ProjectCheck;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface ProjectCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectCheck record);

    int insertSelective(ProjectCheck record);

    ProjectCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectCheck record);

    int updateByPrimaryKey(ProjectCheck record);

    ProjectCheck selectByUnionKey(@Param("projectId") String projectId, @Param("agencyId")String agencyId);

    ProjectCheck selectByExtractDate(@Param("projectId") String projectId, @Param("agencyId")String agencyId,@Param("extractDate") Date extractDate);
}