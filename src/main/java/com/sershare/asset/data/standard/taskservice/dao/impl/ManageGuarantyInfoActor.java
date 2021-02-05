package com.sershare.asset.data.standard.taskservice.dao.impl;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.GuarantyCarInfo;
import com.sershare.asset.data.standard.entity.GuarantyInfo;
import com.sershare.asset.data.standard.service.task.GuarantyInfoService;
import com.sershare.asset.data.standard.service.task.impl.GuarantyAnalysisService;
import com.sershare.asset.data.standard.taskservice.dao.EntityManager;
import com.sershare.asset.data.standard.utils.GsonUtils;
import com.sershare.asset.data.standard.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/1  14:35
 */
@Component("ManageGuarantyInfoActor")
public class ManageGuarantyInfoActor implements EntityManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    GuarantyInfoService guarantyInfoService;

    @Autowired
    private GuarantyAnalysisService guarantyAnalysisService;

    @Override
    public void insert(JsonObject jsonObject) {
        logger.info("开始执行GuarantyInfo数据插入");
        String entityObject = jsonObject.get("entityObject").getAsString();
        GuarantyInfo guarantyInfo = GsonUtils.fromString(entityObject, GuarantyInfo.class);
        GuarantyInfo exitgGuarantyInfo = guarantyInfoService.selectByCompositeKeys(guarantyInfo.getProjectId(), guarantyInfo.getAssetId(), guarantyInfo.getAgencyId(), guarantyInfo.getGuarantyType(), guarantyInfo.getGuarantyUmber());
        if (Objects.isNull(exitgGuarantyInfo)) {
            int result = guarantyInfoService.insert(guarantyInfo);
            if (result != 1) {
                logger.error("GuarantyInfo数据插入失败！数据ID:{}", guarantyInfo.getId());
            } else {
                logger.info("GuarantyInfo数据插入成功！数据ID:{}", guarantyInfo.getId());
            }
        } else {
            guarantyInfo.setId(exitgGuarantyInfo.getId());
            guarantyInfoService.updateByPrimaryKeySelective(guarantyInfo);
            logger.info("GuarantyInfo数据更新成功！数据ID:{}", guarantyInfo.getId());
        }

        //创建解析抵押物的任务，在任务里根据 抵押物类型写到不同的表中、Guaranty_car  Guaranty_house 、增加1个标识已经处理
        //历史数据，创建一个启动任务，对标识为未处理的，就创建处理任务
        String extraInfo = guarantyInfo.getExtraInfo();
        Integer id = guarantyInfo.getId();
        JsonObject json = JsonUtil.stringToJsonObject(extraInfo);
        GuarantyCarInfo guarantyCarInfo = guarantyAnalysisService.dataAssemble(json);
        guarantyAnalysisService.addRecordAndRefreshSign(guarantyCarInfo, id);
    }

    @Override
    public void mqPush(JsonObject jsonObject) {

    }

}
