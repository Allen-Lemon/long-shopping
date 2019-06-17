package com.springcloud.dao;

import com.springcloud.entity.Type2;
import java.util.List;

public interface Type2Mapper {
    int deleteByPrimaryKey(Integer type2Id);

    int insert(Type2 record);

    Type2 selectByPrimaryKey(Integer type2Id);

    List<Type2> selectAll();

    int updateByPrimaryKey(Type2 record);
    
    List<Type2> selectByType1Id(Integer type1Id);
}