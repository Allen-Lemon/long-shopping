package com.springcloud.dao;

import com.springcloud.entity.Type1;
import java.util.List;

public interface Type1Mapper {
    int deleteByPrimaryKey(Integer type1Id);

    int insert(Type1 record);

    Type1 selectByPrimaryKey(Integer type1Id);

    List<Type1> selectAll();

    int updateByPrimaryKey(Type1 record);
}