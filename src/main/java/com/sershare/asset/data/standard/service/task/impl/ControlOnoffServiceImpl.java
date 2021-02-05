package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.ControlOnoff;
import com.sershare.asset.data.standard.mapper.ControlOnoffMapper;
import com.sershare.asset.data.standard.service.task.IControlOnoffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlOnoffServiceImpl implements IControlOnoffService {
    @Autowired
    private ControlOnoffMapper controlOnoffDao;
    @Override
    public ControlOnoff getControlOnoffByName(String name) {
        return controlOnoffDao.getControlOnoffByName(name);
    }

    @Override
    public List<ControlOnoff> findControlOnoffListByGroupName(String groupName) {
        return controlOnoffDao.findControlOnoffListByGroupName(groupName);
    }
}
