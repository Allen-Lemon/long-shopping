package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.Type1;
import com.springcloud.entity.Type2;
import com.springcloud.service.TypeService;
import com.springcloud.vo.ResultValue;

@RestController
public class TypeContrller {

	@Autowired
	private TypeService typeService;

	@RequestMapping("/selectAll")
	public ResultValue selectType1() {
		ResultValue rv = new ResultValue();
		try {
			// 调用模型层查找
			List<Type1> selectAllType1 = this.typeService.selectAllType1();
			// 判断数据是否为空
			if (selectAllType1 != null && selectAllType1.size() != 0) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("type1", selectAllType1);
				rv.setCode(0);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 查找失败
		rv.setCode(1);
		rv.setMessage("查找类别一出错！！！");
		return rv;
	}

	@RequestMapping("/selectByType1")
	public ResultValue selectByType1(@RequestParam("type1Id") Integer type1Id) {
		ResultValue rv = new ResultValue();
		try {
			List<Type2> selectType2ByType1Id = this.typeService.selectType2ByType1Id(type1Id);
			if (selectType2ByType1Id != null && selectType2ByType1Id.size() != 0) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("type2", selectType2ByType1Id);

				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 当查找为空的时候，或者出错时
		rv.setCode(1);
		rv.setMessage("查找类别二出错！！");
		return rv;
	}
}
