package com.sershare.asset.data.standard.batch.taskstep;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.enums.FileToManagerEnum;
import com.sershare.asset.data.standard.explain.FileShareHead;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.taskservice.parser.impl.*;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: processor
 * @author: i_laowei
 * @date: 2021/1/26  15:32
 */

@Component
public class TaskProcessor implements ItemProcessor<JsonObject, JsonObject>, InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParseLoanContractActor parseLoanContractActor;

    @Autowired
    private ParseRepaymentScheduleActor parseRepaymentScheduleActor;

    @Autowired
    private ParseContactPersonInfoActor parseContactPersonInfoActor;

    @Autowired
    private ParsePrincipalBorrowerInfoActor parsePrincipalBorrowerInfoActor;

    @Autowired
    private ParseGuarantyInfoActor parseGuarantyInfoActor;

    @Autowired
    private ParseAssetFlowInfoActor parseAssetFlowInfoActor;

    @Autowired
    private ParseAssetDisposalActor parseAssetDisposalActor;

    @Autowired
    private ParseAssetSupplementActor parseAssetSupplementActor;

    @Autowired
    private ParseProjectCheckActor parseProjectCheckActor;

    @Autowired
    private ParserAssetCheckInfoActor parserAssetCheckInfoActor;

    @Autowired
    private ParseRepaymentInfoSecActor parseRepaymentInfoSecActor;

    @Autowired
    private ParseEnterpriseInfoActor parseEnterpriseInfoActor;

    private Map<String, Object> excuterMap = new HashMap<>();

    @Override
    public JsonObject process(JsonObject jsonObject) {
        if (Objects.isNull(jsonObject)) {
            return null;
        }
        JsonObject processResult = null;
        JsonObject parseObject;
        String fileType = jsonObject.get(FileShareHead.fileType).getAsString();
        IFileParseActuator fileInsertActuator = (IFileParseActuator) excuterMap.get(fileType);
        if (fileInsertActuator != null) {
            parseObject = fileInsertActuator.run(jsonObject);
        } else {
            logger.info("文件类型不存在，不进行处理！fileType:{}", fileType);
            return null;
        }
        if (Objects.isNull(parseObject)) {
            return null;
        }
        String managerName = FileToManagerEnum.valueOf(fileType.toUpperCase()).getManagerName();
        processResult.add("parseObject", parseObject);
        processResult.add("managerName", GsonUtils.stringToJson(managerName));

        return processResult;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        excuterMap.put("file01", parseLoanContractActor);
        excuterMap.put("file02", parsePrincipalBorrowerInfoActor);
        excuterMap.put("file03", parseContactPersonInfoActor);
        excuterMap.put("file04", parseGuarantyInfoActor);
        excuterMap.put("file05", parseRepaymentScheduleActor);
        excuterMap.put("file06", parseAssetFlowInfoActor);
        excuterMap.put("file07", parseRepaymentInfoSecActor);
        excuterMap.put("file08", parseAssetDisposalActor);
        excuterMap.put("file09", parseAssetSupplementActor);
        excuterMap.put("file10", parserAssetCheckInfoActor);
        excuterMap.put("file11", parseProjectCheckActor);
        excuterMap.put("file12", parseEnterpriseInfoActor);
        excuterMap.put("file13", parseGuarantyInfoActor);
    }

}
