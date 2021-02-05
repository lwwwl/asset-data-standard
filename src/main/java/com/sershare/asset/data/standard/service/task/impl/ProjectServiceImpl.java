package com.sershare.asset.data.standard.service.task.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sershare.asset.data.standard.common.QueryCondition;
import com.sershare.asset.data.standard.common.SysConstant;
import com.sershare.asset.data.standard.entity.Project;
import com.sershare.asset.data.standard.enums.ControlOnoffEnum;
import com.sershare.asset.data.standard.mapper.ProjectMapper;
import com.sershare.asset.data.standard.service.task.ProjectService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public void addProject(Project project) {
        projectMapper.insert(project);
    }

    @Override
    public List<Project> findAllProject() {
        return projectMapper.findAllProject();
    }

    @Override
    public void updateProject(Project project) {
        projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public Project findByProjectId(String projectId) {
        return projectMapper.findProjectId(projectId);
    }

    @Override
    public Project findByChainId(String chainId) {
        return projectMapper.findProjectId(chainId);
    }

    @Override
    public Boolean actionControl(String controlKey){
        try{
            Project globalProject = this.findByProjectId(SysConstant.GLOBAL_ID);
            return actionHandle(controlKey,globalProject.getActionData(),SysConstant.GLOBAL_ID);
        }catch (Exception e){
            logger.error("action control,return false!controlKey={}",controlKey,e);
            return false;
        }
    }

    @Override
    public Boolean actionControl(String projectId,String controlKey){
        try{
            Project globalProject = this.findByProjectId(SysConstant.GLOBAL_ID);
            if(!actionHandle(controlKey,globalProject.getActionData(),SysConstant.GLOBAL_ID)){
                return false;
            }
            Project project = this.findByProjectId(projectId);
            return actionHandle(controlKey,project.getActionData(),projectId);
        }catch (Exception e){
            logger.error("action control,return false!projectId={},controlKey={}",projectId,controlKey,e);
            return false;
        }
    }

    private Boolean actionHandle(String controlKey,String controlJson,String projectId)throws Exception{
        if(StringUtils.isBlank(controlJson)){
            logger.error("action_data is blank,return false!projectId={},controlKey={}",projectId,controlKey);
            return false;
        }
        JsonObject jsonObject = new JsonParser().parse(controlJson).getAsJsonObject();
        if(!jsonObject.has(controlKey)){
            logger.error("controlKey not exist,return false!projectId={},controlKey={}",projectId,controlKey);
            return false;
        }
        String controlValue = jsonObject.get(controlKey).getAsString();
        if(ControlOnoffEnum.ON.name().equals(controlValue)){
            return true;
        }
        return false;
    }

    @Override
    public List<Project> findListByQueryVo(QueryCondition queryCondition, Integer pageCurrent, Integer pageSize) {
        PageHelper.orderBy(queryCondition.getOrderBy());
        PageHelper.startPage(pageCurrent,pageSize);
        return projectMapper.findListByQueryVo(queryCondition);
    }

    @Override
    public Project getProjectByProjectId(String projectId) {
        return projectMapper.getProjectByProjectId(projectId);
    }

    @Override
    public Project getProjectById(Integer id) {
        return projectMapper.getProjectById(id);
    }

    /**
     * 获取对账文件内外映射字段
     * @param projectId     项目
     * @param accountType   对账类型
     * @return
     */
    @Override
    public Map actionControlAccount(String projectId, String accountType) {

        Project project = projectMapper.getProjectByProjectId(projectId);
        if (project == null) {
            return Collections.EMPTY_MAP;
        }
        String action = project.getActionData();
        if (action == null) {
            return Collections.EMPTY_MAP;
        }
        JSONObject actionJson = JSONObject.parseObject(action);
        if(!actionJson.containsKey(accountType)){
            return Collections.EMPTY_MAP;
        }
        return actionJson.getJSONObject(accountType);
    }
}
