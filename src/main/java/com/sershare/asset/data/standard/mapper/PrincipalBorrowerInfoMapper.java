package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.entity.PrincipalBorrowerInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface PrincipalBorrowerInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrincipalBorrowerInfo record);

    int insertSelective(PrincipalBorrowerInfo record);

    PrincipalBorrowerInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrincipalBorrowerInfo record);

    int updateByPrimaryKey(PrincipalBorrowerInfo record);

    PrincipalBorrowerInfo selectByCompositeKeys(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId")String agencyId);

    PrincipalBorrowerInfo selectByUnionKey(@Param("projectId") String projectId, @Param("assetId") String assetId);

    int deleteByCompositeKeys(@Param("projectId") String projectId,  @Param("agencyId")String agencyId,@Param("assetId") String assetId);

    String selectExtraInfoByCardNo(@Param("cardNo") String cardNo);

    List<Map<String, Object>> selectCustomerInfoByEcifNo();

    int updateEcifNoByCardNo(@Param("ecifNo") String ecifNo, @Param("ecifCardNo") String ecifCardNo,
                             @Param("ecifPhoneNo") String ecifPhoneNo, @Param("cardNo") String cardNo);

    List<PrincipalBorrowerInfo> selectByProject(String projectId);

    List<Map<String, Object>> selectExtraInfoBySign();

    int updateSignById(@Param("education") String education, @Param("annualIncome") BigDecimal annualIncome, @Param("Id") Integer Id);

    Map<String, Object> selectExtraInfoByAssetIdAndSign(@Param("assetId") String assetId);

    Map<String, Object> selectCustomerInfoByAssetIdAndEcifNo(@Param("assetId") String assetId);
}