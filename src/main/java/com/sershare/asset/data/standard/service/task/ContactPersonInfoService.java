package com.sershare.asset.data.standard.service.task;

import com.sershare.asset.data.standard.entity.ContactPersonInfo;

import java.util.List;

public interface ContactPersonInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(ContactPersonInfo record);

    int insertSelective(ContactPersonInfo record);

    ContactPersonInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContactPersonInfo record);

    int updateByPrimaryKey(ContactPersonInfo record);

    ContactPersonInfo selectByUnionKey(String projectId, String assetId,String documentNum);

    List<ContactPersonInfo> selectByKey(String projectId, String assetId, String agencyId);
}