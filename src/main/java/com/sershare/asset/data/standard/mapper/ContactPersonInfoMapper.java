package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.entity.ContactPersonInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactPersonInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContactPersonInfo record);

    int insertSelective(ContactPersonInfo record);

    ContactPersonInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContactPersonInfo record);

    int updateByPrimaryKey(ContactPersonInfo record);

    ContactPersonInfo selectByUnionKey(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("documentNum")String documentNum);

    List<ContactPersonInfo> selectByKey(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId")String documentNum);
}