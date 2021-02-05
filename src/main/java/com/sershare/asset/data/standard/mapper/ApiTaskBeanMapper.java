package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.common.QueryCondition;
import com.sershare.asset.data.standard.entity.ApiTaskBean;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ApiTaskBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApiTaskBean record);

    int insertSelective(ApiTaskBean record);

    ApiTaskBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApiTaskBean record);

    int updateByPrimaryKey(ApiTaskBean record);

    List<ApiTaskBean> findByStatus(@Param("status") String status, @Param("host") String host);

    List<ApiTaskBean> findByParentTaskId(String parentTaskId);

    ApiTaskBean findNextTaskByStatusToRun(@Param("status") String status);

    List<ApiTaskBean> findCalculateTask(@Param("taskClassName")String taskClassName,@Param("assetId") String assetId,@Param("statusDate") String statusDate);

    List<ApiTaskBean> findByGroupBatch(String groupBatch);

    List<ApiTaskBean> findListByQueryVo(QueryCondition queryCondition);

    void updateApiTaskById(ApiTaskBean apiTask);

    ApiTaskBean getApiTaskById(Integer id);

    ApiTaskBean getRepaymentSchTask(@Param("taskClassName")String taskClassName,@Param("assetId") String assetId);

    void updateRepaymentInfoTask(@Param("status") String status,@Param("fileType")String fileType,@Param("assetId")String assetId);

    List<ApiTaskBean> selectDataByCreateDate(@Param("createDate") Date date, @Param("start") int start, @Param("end") int end);

    int countDataByCreateDate(@Param("createDate") Date date);

    void deleteByPrimaryKeyBatch(List<ApiTaskBean> list);
}