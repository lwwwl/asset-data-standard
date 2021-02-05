package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.common.QueryCondition;
import com.sershare.asset.data.standard.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> findAllProject();

    Project findProjectId(@Param("projectId") String projectId);

    Project findByChainId(String chainId);

    List<Project> findListByQueryVo(QueryCondition queryCondition);

    /**
     * 根据projectId 查询 Project
     * @author wangpeng
     * @param projectId  项目编号
     * @return  项目信息
     */
    Project getProjectByProjectId(@Param("projectId") String projectId);

    /**
     * 根据主键ID查找项目信息
     * @author wangpeng
     * @param id 主键ID
     * @return 项目信息
     **/
    Project getProjectById(@Param("id") Integer id);
}