package com.sershare.asset.data.standard.taskservice.dao.impl;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.ProjectCheck;
import com.sershare.asset.data.standard.service.task.ProjectCheckService;
import com.sershare.asset.data.standard.taskservice.dao.EntityManager;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/1  15:23
 */
@Component("ManageProjectCheckActor")
public class ManageProjectCheckActor implements EntityManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProjectCheckService projectCheckService;

    @Override
    public void insert(JsonObject jsonObject) {
        logger.info("开始执行ProjectCheck数据插入");
        String entityObject = jsonObject.get("entityObject").getAsString();
        ProjectCheck projectCheck = GsonUtils.fromString(entityObject, ProjectCheck.class);
        ProjectCheck exitProjectCheck = projectCheckService.selectByExtractDate(projectCheck.getProjectId(), projectCheck.getAgencyId(),projectCheck.getExtractDate());
        if (Objects.isNull(exitProjectCheck)) {
            int result = projectCheckService.insert(projectCheck);
            if (result != 1) {
                logger.error("ProjectCheck数据插入失败！数据ID:{}", projectCheck.getId());
            } else {
                logger.info("ProjectCheck数据插入成功！数据ID:{}", projectCheck.getId());
            }
        } else {
            projectCheck.setId(exitProjectCheck.getId());
            projectCheckService.updateByPrimaryKeySelective(projectCheck);
            logger.info("ProjectCheck数据更新成功！数据ID:{}", projectCheck.getId());
        }
    }

    @Override
    public void mqPush(JsonObject jsonObject) {

    }

}
