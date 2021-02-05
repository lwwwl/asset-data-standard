package com.sershare.asset.data.standard.batch.writer;

import com.sershare.asset.data.standard.entity.AssetCheckInfo;
import com.sershare.asset.data.standard.service.task.AssetCheckInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/3  15:02
 */
@Component("assetCheckInfoWriter")
public class AssetCheckInfoWriter implements ItemWriter<AssetCheckInfo> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    AssetCheckInfoService assetCheckInfoService;

    @Override
    public void write(List<? extends AssetCheckInfo> list) {
        for (AssetCheckInfo assetCheckInfo : list) {
            if (Objects.isNull(assetCheckInfo)) {
                continue;
            }
            insert(assetCheckInfo);
//            mqPush(assetCheckInfo);
        }
    }

    public void insert(AssetCheckInfo assetCheckInfo) {
        logger.info("开始执行AssetCheckInfo数据插入");
        int result = assetCheckInfoService.insertSelective(assetCheckInfo);
        if (result != 1) {
            logger.error("AssetCheckInfo数据插入失败！数据ID:{}", assetCheckInfo.getId());
        } else {
            logger.info("AssetCheckInfo数据插入成功！数据ID:{}", assetCheckInfo.getId());
        }
    }

    public void mqPush(AssetCheckInfo assetCheckInfo) {
        logger.info("");
        //todo mq推送
    }

}
