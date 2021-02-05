package com.sershare.asset.data.standard.service.task;


import com.sershare.asset.data.standard.common.QueryCondition;
import com.sershare.asset.data.standard.entity.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    /**
     * 新增项目
     * @param project
     */
    void addProject(Project project);

    /**
     * 查询所有项目
     * @return
     */
    List<Project> findAllProject();

    void updateProject(Project project);

    Project findByProjectId(String projectId);

    Project findByChainId(String chainId);

    /**行为控制 从顶层到项目*/
    Boolean actionControl(String controlKey);

    /**行为控制 从顶层到项目*/
    Boolean actionControl(String projectId,String controlKey);

    /**行为控制 从顶层到项目 对账*/
    Map actionControlAccount(String projectId, String controlKey);

    List<Project> findListByQueryVo(QueryCondition queryCondition, Integer pageCurrent, Integer pageSize);

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
