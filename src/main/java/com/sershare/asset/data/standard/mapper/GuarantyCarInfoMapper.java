package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.entity.GuarantyCarInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuarantyCarInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GuarantyCarInfo record);

    int insertSelective(GuarantyCarInfo record);

    GuarantyCarInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GuarantyCarInfo record);

    int updateByPrimaryKey(GuarantyCarInfo record);

    List<GuarantyCarInfo> selectByBillNo(@Param("billNo") String billNo, @Param("licenseNum") String licenseNum);
}