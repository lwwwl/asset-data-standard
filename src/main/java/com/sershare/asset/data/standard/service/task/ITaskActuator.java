package com.sershare.asset.data.standard.service.task;


import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.ApiTaskBean;

public interface ITaskActuator {
    JsonObject run(ApiTaskBean apiTaskBean);
}
