package com.sershare.asset.data.standard.service.task;



import com.sershare.asset.data.standard.common.QueryCondition;
import com.sershare.asset.data.standard.entity.ApiTaskBean;

import java.util.List;

public interface IApiTaskBeanService {

	/**保存任务**/
	void addApiTask(ApiTaskBean apiTaskBean);

	/**根据导入id查询任务**/
	ApiTaskBean getApiTaskByTaskId(int id);

    /**根据导入tid修改任务**/
    void updateApiTaskByTaskId(ApiTaskBean apiTaskBean);
    
    /**根据任务状态查询任务**/
    List<ApiTaskBean> findByStatus(String status, String host);
    /**
     * 根据修改任务Status
     * @param taskBean
     */
    void updateApiTaskStatus(ApiTaskBean taskBean);

    /**根据任务ParentTaskId查询任务**/
    List<ApiTaskBean> findByParentTaskId(String parentTaskId);

    ApiTaskBean findNextTaskByStatusToRun(String status);

    List<ApiTaskBean> findByGroupBatch(String groupBatch);

    List<ApiTaskBean> findListByQueryVo(QueryCondition queryCondition, Integer pageCurrent, Integer pageSize);

    void updateApiTaskById(ApiTaskBean apiTask);

    ApiTaskBean getApiTaskById(Integer id);

    ApiTaskBean getRepaymentSchTask(String taskClassName, String assetId);
}
