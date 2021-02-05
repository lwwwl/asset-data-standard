package com.sershare.asset.data.standard.batch.taskstep;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Queue;

/**
 * @Description: reader
 * @author: i_laowei
 * @date: 2021/1/25  16:33
 */

@Component
public class TaskReader implements ItemReader<JsonObject> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "tempStorageQueue")
    private Queue<JsonObject> tempStorageQueue;

    @Override
    public synchronized JsonObject read() throws Exception {
        JsonObject jsonObject = tempStorageQueue.poll();
        if (Objects.isNull(jsonObject)) {
            return null;
        }
        logger.info("batch read 读取到数据...");
        return jsonObject;
    }

}
