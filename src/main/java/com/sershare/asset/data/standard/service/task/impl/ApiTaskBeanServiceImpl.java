package com.sershare.asset.data.standard.service.task.impl;

import com.github.pagehelper.PageHelper;
import com.sershare.asset.data.standard.common.QueryCondition;
import com.sershare.asset.data.standard.config.MqConfig;
import com.sershare.asset.data.standard.entity.ApiTaskBean;
import com.sershare.asset.data.standard.mapper.ApiTaskBeanMapper;
import com.sershare.asset.data.standard.service.task.IApiTaskBeanService;
import com.sershare.asset.data.standard.utils.GsonUtils;
import com.sershare.asset.data.standard.utils.IpUtil;
import com.sershare.asset.data.standard.wsmq.wsmq.WsMqProducer;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiTaskBeanServiceImpl implements IApiTaskBeanService {


	@Autowired
	private ApiTaskBeanMapper apiTaskBeanMapper;

	@Autowired
	private WsMqProducer wsMqProducer;
	    
	@Autowired
	private MqConfig mqConfig;
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void addApiTask(ApiTaskBean apiTaskBean) {
		apiTaskBeanMapper.insertSelective(apiTaskBean);
		
		String topic = mqConfig.getTopicWithEnv(mqConfig.getTaskApiTaskTopic());
		Message message = wsMqProducer.createMqMessage(topic, GsonUtils.toString(apiTaskBean));
	    
		/*发送mq 需要重试*/
		int count = 0;
		boolean flag = false;
		while(true) {
			flag = wsMqProducer.send(message);
			logger.info("t_task_api添加任务，发送mq消息,topic|{},sendStatus|{}, message|{}", topic, flag, GsonUtils.toString(apiTaskBean));
			count++;
			
			if(flag || count >=3) {
				break;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public ApiTaskBean  getApiTaskByTaskId(int id){
		return apiTaskBeanMapper.selectByPrimaryKey(id);

	}

	@Override
	public void updateApiTaskByTaskId(ApiTaskBean apiTaskBean) {
		apiTaskBeanMapper.updateByPrimaryKeySelective(apiTaskBean);

	}

	@Override
	public List<ApiTaskBean> findByStatus(String status, String host) {
		return apiTaskBeanMapper.findByStatus(status, host);
	}


	@Override
	public void updateApiTaskStatus(ApiTaskBean taskBean) {
		taskBean.setHost(IpUtil.getLocalIp());
		apiTaskBeanMapper.updateByPrimaryKeySelective(taskBean);
	}

	@Override
	public List<ApiTaskBean> findByParentTaskId(String parentTaskId) {
		return apiTaskBeanMapper.findByParentTaskId(parentTaskId);
	}

	@Override
	public ApiTaskBean findNextTaskByStatusToRun(String status) {
		return apiTaskBeanMapper.findNextTaskByStatusToRun(status);
	}

	@Override
	public List<ApiTaskBean> findByGroupBatch(String groupBatch) {
		return apiTaskBeanMapper.findByGroupBatch(groupBatch);
	}

	@Override
	public List<ApiTaskBean> findListByQueryVo(QueryCondition queryCondition, Integer pageCurrent, Integer pageSize) {
		PageHelper.orderBy(queryCondition.getOrderBy());
		PageHelper.startPage(pageCurrent,pageSize);
		return apiTaskBeanMapper.findListByQueryVo(queryCondition);
	}

	@Override
	public void updateApiTaskById(ApiTaskBean apiTask) {
		apiTaskBeanMapper.updateApiTaskById(apiTask);
	}

	@Override
	public ApiTaskBean getApiTaskById(Integer id) {
		return apiTaskBeanMapper.getApiTaskById(id);
	}

	@Override
	public ApiTaskBean getRepaymentSchTask(String taskClassName, String assetId) {
		return apiTaskBeanMapper.getRepaymentSchTask(taskClassName,assetId);
	}
}
