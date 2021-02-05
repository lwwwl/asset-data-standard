package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.ApiTaskBean;
import com.sershare.asset.data.standard.service.task.IApiTaskStartService;
import com.sershare.asset.data.standard.service.task.ITaskActuator;
import com.sershare.asset.data.standard.wsmq.util.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ApiTaskStartServiceImpl implements IApiTaskStartService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void startTask(ApiTaskBean apiTaskBean) {
        ITaskActuator taskActuator = (ITaskActuator) SpringContextUtils.getBean(
                apiTaskBean.getTaskClassName());
        if (taskActuator == null) {
            logger.error(apiTaskBean.getTaskClassName() + "is not exiting.");
        } else {
            taskActuator.run(apiTaskBean);
        }
    }
}
