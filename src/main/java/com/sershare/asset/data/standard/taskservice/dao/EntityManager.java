package com.sershare.asset.data.standard.taskservice.dao;

import com.google.gson.JsonObject;

/**
 * @Description: TODO
 * @author: i_laowei
 * @date: 2021/1/28  16:53
 */
public interface EntityManager {

    void insert(JsonObject jsonObject);

    void mqPush(JsonObject jsonObject);

}
