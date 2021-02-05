package com.sershare.asset.data.standard.service.task.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.GuarantyCarInfo;
import com.sershare.asset.data.standard.mapper.GuarantyCarInfoMapper;
import com.sershare.asset.data.standard.mapper.GuarantyInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class GuarantyAnalysisService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GuarantyInfoMapper guarantyInfoMapper;

    @Autowired
    private GuarantyCarInfoMapper guarantyCarInfoMapper;

    public GuarantyCarInfo dataAssemble(JsonObject jsonObject) {
        GuarantyCarInfo guarantyCarInfo = new GuarantyCarInfo();
        try {
            guarantyCarInfo.setBillNo(jsonObject.get("借据号") == null ? null : jsonObject.get("借据号").getAsString());
            guarantyCarInfo.setFrameNum(jsonObject.get("车架号") == null ? null : jsonObject.get("车架号").getAsString());
            guarantyCarInfo.setCarBrand(jsonObject.get("车辆品牌") == null ? null : jsonObject.get("车辆品牌").getAsString());
            guarantyCarInfo.setCarModel(jsonObject.get("车型") == null ? null : jsonObject.get("车型").getAsString());
            guarantyCarInfo.setCarColour(jsonObject.get("车辆颜色") == null ? null : jsonObject.get("车辆颜色").getAsString());
            guarantyCarInfo.setLicenseNum(jsonObject.get("车牌号码") == null ? null : jsonObject.get("车牌号码").getAsString());
            guarantyCarInfo.setRegisterDate(jsonObject.get("注册日期") == null ? null : jsonObject.get("注册日期").getAsString());
            guarantyCarInfo.setPawnValue(checkIsBlank(jsonObject.get("评估价格(元)")));
            guarantyCarInfo.setCarSeries(jsonObject.get("车系") == null ? null : jsonObject.get("车系").getAsString());
            guarantyCarInfo.setDriveYears(jsonObject.get("车龄") == null ? null : jsonObject.get("车龄").getAsString());
            guarantyCarInfo.setImportId(jsonObject.get("IMPORTID") == null ? null : jsonObject.get("IMPORTID").getAsString());
            guarantyCarInfo.setGpsCode(jsonObject.get("GPS编号") == null ? null : jsonObject.get("GPS编号").getAsString());
            guarantyCarInfo.setGpsFee(checkIsBlank(jsonObject.get("GPS费用")));
            guarantyCarInfo.setTimestamp(jsonObject.get("TIMESTAMP") == null ? null : jsonObject.get("TIMESTAMP").getAsString());
            guarantyCarInfo.setCarType(jsonObject.get("车类型") == null ? null : jsonObject.get("车类型").getAsString());
            guarantyCarInfo.setMilage(jsonObject.get("里程数") == null ? null : jsonObject.get("里程数").getAsString());
            guarantyCarInfo.setInsuranceType(jsonObject.get("保险种类") == null ? null : jsonObject.get("保险种类").getAsString());
            guarantyCarInfo.setEngineNum(jsonObject.get("发动机号") == null ? null : jsonObject.get("发动机号").getAsString());
            guarantyCarInfo.setMortgageOrder(jsonObject.get("抵押顺位") == null ? null : jsonObject.get("抵押顺位").getAsString());
            guarantyCarInfo.setGuaranteeMethod(jsonObject.get("担保方式") == null ? null : jsonObject.get("担保方式").getAsString());
            guarantyCarInfo.setOrgCode(jsonObject.get("机构编号") == null ? null : jsonObject.get("机构编号").getAsString());
            guarantyCarInfo.setProductDate(jsonObject.get("生产日期") == null ? null : jsonObject.get("生产日期").getAsString());
            guarantyCarInfo.setFinancing(jsonObject.get("融资方式") == null ? null : jsonObject.get("融资方式").getAsString());
            guarantyCarInfo.setCarNature(jsonObject.get("车辆性质") == null ? null : jsonObject.get("车辆性质").getAsString());
            guarantyCarInfo.setProjectNum(jsonObject.get("项目编号") == null ? null : jsonObject.get("项目编号").getAsString());
            guarantyCarInfo.setImportFiletype(jsonObject.get("IMPORTFILETYPE") == null ? null : jsonObject.get("IMPORTFILETYPE").getAsString());
            guarantyCarInfo.setMortageNum(jsonObject.get("抵押物编号") == null ? null : jsonObject.get("抵押物编号").getAsString());
            guarantyCarInfo.setPurchasePlace(jsonObject.get("车辆购买地") == null ? null : jsonObject.get("车辆购买地").getAsString());
            guarantyCarInfo.setFeeOne(checkIsBlank(jsonObject.get("责信保费用1")));
            guarantyCarInfo.setFeeTwo(checkIsBlank(jsonObject.get("责信保费用2")));
            guarantyCarInfo.setTotalInvestment(checkIsBlank(jsonObject.get("投资总额(元)")));
            guarantyCarInfo.setMortageStatus(jsonObject.get("抵押办理状态") == null ? null : jsonObject.get("抵押办理状态").getAsString());
            guarantyCarInfo.setEnergyType(jsonObject.get("车辆能源类型") == null ? null : jsonObject.get("车辆能源类型").getAsString());
            guarantyCarInfo.setFormalitiesFee(checkIsBlank(jsonObject.get("手续总费用(元)")));
            guarantyCarInfo.setGuidePrice(checkIsBlank(jsonObject.get("新车指导价(元)")));
            guarantyCarInfo.setPurchaseTax(checkIsBlank(jsonObject.get("购置税金额(元)")));
            guarantyCarInfo.setInsuranceFee(checkIsBlank(jsonObject.get("汽车保险总费用")));
            guarantyCarInfo.setSalesPrice(checkIsBlank(jsonObject.get("车辆销售价格(元)")));
            guarantyCarInfo.setTotalTransTimes(jsonObject.get("累计车辆过户次数") == null ? 0 : jsonObject.get("累计车辆过户次数").getAsInt());
            guarantyCarInfo.setYearTransTimes(jsonObject.get("一年内车辆过户次数") == null ? 0 : jsonObject.get("一年内车辆过户次数").getAsInt());
        } catch (Exception e){
            logger.error("抵押物解析错误:{}", e);
        }

        return guarantyCarInfo;
    }

    @Transactional
    public void addRecordAndRefreshSign(GuarantyCarInfo guarantyCarInfo, Integer id) {
        List<GuarantyCarInfo> carInfoList = guarantyCarInfoMapper.selectByBillNo(guarantyCarInfo.getBillNo(), guarantyCarInfo.getLicenseNum());
        if (carInfoList == null || carInfoList.size() == 0) {
            guarantyCarInfoMapper.insert(guarantyCarInfo);
        } else {
            guarantyCarInfo.setId(carInfoList.get(0).getId());
            guarantyCarInfoMapper.updateByPrimaryKey(guarantyCarInfo);
        }
        guarantyInfoMapper.updateSignById(id);
    }

    public BigDecimal checkIsBlank(JsonElement jsonElement) {
        if(Objects.isNull(jsonElement) || jsonElement.getAsString().equals("")) {
            return BigDecimal.ZERO;
        }
        return jsonElement.getAsBigDecimal();
    }
}
