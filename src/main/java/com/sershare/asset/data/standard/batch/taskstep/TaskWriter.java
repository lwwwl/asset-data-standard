package com.sershare.asset.data.standard.batch.taskstep;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.taskservice.dao.EntityManager;
import com.sershare.asset.data.standard.wsmq.util.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @Description: writer
 * @author: i_laowei
 * @date: 2021/1/27  14:24
 */

@Component
public class TaskWriter implements ItemWriter<JsonObject> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void write(List<? extends JsonObject> list) {
        for (JsonObject jsonObject : list){
            if (Objects.isNull(jsonObject)) {
                continue;
            }
            String managerName = jsonObject.get("managerName").getAsString();
            logger.info("batch writer 当前处理类 managerName:{}", managerName);
            EntityManager entityManager = (EntityManager) SpringContextUtils.getBean(managerName);
            entityManager.insert(jsonObject);
            entityManager.mqPush(jsonObject);
        }
    }

}