package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.ContactPersonInfo;
import com.sershare.asset.data.standard.mapper.ContactPersonInfoMapper;
import com.sershare.asset.data.standard.service.task.ContactPersonInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: AssertStatusProject
 * @description:
 * @author: xiongwei.zhu
 * @create: 2018-10-25 14:12
 **/
@Service
public class ContactPersonInfoServiceImpl implements ContactPersonInfoService {

    @Resource
    ContactPersonInfoMapper contactPersonInfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return contactPersonInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ContactPersonInfo record) {
        return contactPersonInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ContactPersonInfo record) {
        return contactPersonInfoMapper.insertSelective(record);
    }

    @Override
    public ContactPersonInfo selectByPrimaryKey(Integer id) {
        return contactPersonInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ContactPersonInfo record) {
        return contactPersonInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ContactPersonInfo record) {
        return contactPersonInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public ContactPersonInfo selectByUnionKey(String projectId, String assetId,String documentNum) {
        return contactPersonInfoMapper.selectByUnionKey(projectId,assetId,documentNum);
    }

    @Override
    public List<ContactPersonInfo> selectByKey(String projectId, String assetId, String agencyId) {
        return contactPersonInfoMapper.selectByKey(projectId,assetId,agencyId);
    }
}
