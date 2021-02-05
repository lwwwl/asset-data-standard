package com.sershare.asset.data.standard.taskservice.parser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.AssetDisposal;
import com.sershare.asset.data.standard.explain.File08Head;
import com.sershare.asset.data.standard.explain.FileShareHead;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/1/29  10:07
 */

@Component("ParseAssetDisposalActor")
public class ParseAssetDisposalActor implements IFileParseActuator{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public JsonObject run(JsonElement jsonElement) {
        logger.info("开始执行文件解析");
        if (Objects.isNull(jsonElement)) {
            logger.info("参数错误！");
            return null;
        }
        AssetDisposal assetDisposal = parseAssetDisposal(jsonElement);
        return GsonUtils.objectToJsonTree(assetDisposal).getAsJsonObject();
    }

    public AssetDisposal parseAssetDisposal(JsonElement jsonElement){
        AssetDisposal assetDisposal = null;
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        assetDisposal = new AssetDisposal();
        assetDisposal.setAgencyId(jsonObject.get(FileShareHead.agencyId).getAsString());
        assetDisposal.setAssetId(jsonObject.get(FileShareHead.assetId).getAsString());
        assetDisposal.setProjectId(jsonObject.get(FileShareHead.projectId).getAsString());
        assetDisposal.setDisposiType(jsonObject.get(File08Head.disposiType).getAsString());
        assetDisposal.setDisposiStatus(jsonObject.get(File08Head.disposiStatus).getAsString());
        assetDisposal.setDisposiEsult(jsonObject.get(File08Head.disposiResult).getAsString());
        assetDisposal.setLitigateNode(jsonObject.get(File08Head.litigateNode).getAsString());
        assetDisposal.setLitigateNodeTime(jsonObject.get(File08Head.litigateNodeTime).getAsString());

        return assetDisposal;
    }

}
