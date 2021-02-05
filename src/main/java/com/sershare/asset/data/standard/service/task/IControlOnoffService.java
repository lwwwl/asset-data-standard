package com.sershare.asset.data.standard.service.task;

import com.sershare.asset.data.standard.entity.ControlOnoff;

import java.util.List;

public interface IControlOnoffService {
    /**get ControlOnoff by name*/
    ControlOnoff getControlOnoffByName(String name);

    /**find ControlOnoff list by groupName*/
    List<ControlOnoff> findControlOnoffListByGroupName(String groupName);
}
