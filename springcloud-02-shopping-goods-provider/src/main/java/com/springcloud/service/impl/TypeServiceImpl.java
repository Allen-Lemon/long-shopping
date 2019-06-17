package com.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.dao.GoodsMapper;
import com.springcloud.dao.Type1Mapper;
import com.springcloud.dao.Type2Mapper;
import com.springcloud.entity.Type1;
import com.springcloud.entity.Type2;
import com.springcloud.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService{

	@Autowired
	private Type1Mapper type1Mapper;
	
	@Autowired
	private Type2Mapper type2Mapper;

	/**
	 * 查找所有的类别一的数据
	 */
	@Override
	public List<Type1> selectAllType1() {	
		return this.type1Mapper.selectAll();
	}

	/**
	 * 查找关于类比一中的所有的类别数据
	 */
	@Override
	public List<Type2> selectType2ByType1Id(Integer type1Id) {
		return this.type2Mapper.selectByType1Id(type1Id);
	}
}
