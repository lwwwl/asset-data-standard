package com.sershare.asset.data.standard.taskservice.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public interface IFileParseActuator {
    JsonObject run(JsonElement jsonElement);
}
