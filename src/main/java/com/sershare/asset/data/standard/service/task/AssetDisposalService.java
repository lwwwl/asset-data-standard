package com.sershare.asset.data.standard.service.task;

import com.sershare.asset.data.standard.entity.AssetDisposal;

/**
 * @program: AssertStatusProject
 * @description: 资产处置信息
 * @author: xiongwei.zhu
 * @create: 2018-10-25 11:22
 **/
public interface AssetDisposalService {

    int deleteByPrimaryKey(Integer id);

    int insert(AssetDisposal record);

    int insertSelective(AssetDisposal record);

    AssetDisposal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetDisposal record);

    int updateByPrimaryKey(AssetDisposal record);

    AssetDisposal selectByUnionKey(String projectId, String assetId,String agencyId);
}
