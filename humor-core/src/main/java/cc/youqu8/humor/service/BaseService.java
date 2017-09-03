package cc.youqu8.humor.service;

import cc.youqu8.humor.dao.BaseMapper;
import cc.youqu8.humor.entity.BaseEntity;
import cc.youqu8.humor.entity.PayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author panyi on 17-8-27.
 * @since V0.0.1
 */
@Service
public  class BaseService {
    BaseMapper baseMapper;

    public PayType selectOne(int id){
        return baseMapper.selectByPrimaryKey(id);
    }
}
