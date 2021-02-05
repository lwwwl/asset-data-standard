package com.sershare.asset.data.standard.service.task;



import com.sershare.asset.data.standard.entity.PrincipalBorrowerInfo;

import java.util.List;

public interface PrincipalBorrowerInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(PrincipalBorrowerInfo record);

    int insertSelective(PrincipalBorrowerInfo record);

    PrincipalBorrowerInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrincipalBorrowerInfo record);

    int updateByPrimaryKey(PrincipalBorrowerInfo record);

    PrincipalBorrowerInfo selectByCompositeKeys(String projectId,  String assetId,String agencyId);

    PrincipalBorrowerInfo selectByUnionKey(String projectId, String assetId);

    int deleteByCompositeKeys(String projectId, String agencyId, String assetId);

    List<PrincipalBorrowerInfo> selectByProject(String projectId);
}