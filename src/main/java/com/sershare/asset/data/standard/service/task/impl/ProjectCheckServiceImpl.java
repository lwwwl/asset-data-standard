package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.ProjectCheck;
import com.sershare.asset.data.standard.mapper.ProjectCheckMapper;
import com.sershare.asset.data.standard.service.task.ProjectCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: AssertStatusProject
 * @description:
 * @author: xiongwei.zhu
 * @create: 2018-10-25 14:27
 **/
@Service
public class ProjectCheckServiceImpl implements ProjectCheckService {

    @Resource
    ProjectCheckMapper projectCheckMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return projectCheckMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProjectCheck record) {
        return projectCheckMapper.insert(record);
    }

    @Override
    public int insertSelective(ProjectCheck record) {
        return projectCheckMapper.insertSelective(record);
    }

    @Override
    public ProjectCheck selectByPrimaryKey(Integer id) {
        return projectCheckMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProjectCheck record) {
        return projectCheckMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProjectCheck record) {
        return projectCheckMapper.updateByPrimaryKey(record);
    }

    @Override
    public ProjectCheck selectByUnionKey(String projectId, String agencyId) {
        return projectCheckMapper.selectByUnionKey(projectId,agencyId);
    }

    @Override
    public ProjectCheck selectByExtractDate(String projectId, String agencyId, Date extractDate) {
        return projectCheckMapper.selectByExtractDate(projectId,agencyId,extractDate);
    }
}
