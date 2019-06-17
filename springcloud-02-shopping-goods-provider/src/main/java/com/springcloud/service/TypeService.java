package com.springcloud.service;

import java.util.List;

import com.springcloud.entity.Goods;
import com.springcloud.entity.Type1;
import com.springcloud.entity.Type2;

public interface TypeService {
	/**
	 * 查找类别的所有数据
	 * @return
	 */
	public abstract List<Type1> selectAllType1(); 

	/**
	 * 查找所有以类别1type1的数据
	 * @return
	 */
	public abstract List<Type2> selectType2ByType1Id(Integer type1Id);
	
	
}
