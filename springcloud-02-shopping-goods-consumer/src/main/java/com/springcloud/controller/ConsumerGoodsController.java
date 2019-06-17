package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.Goods;
import com.springcloud.service.GoodsFeginService;
import com.springcloud.vo.ResultValue;

@RestController
public class ConsumerGoodsController {

	@Autowired
	private GoodsFeginService goodsFeginService;
	
	ResultValue rv=new ResultValue();
	@RequestMapping("/select")
	public ResultValue selectAllByType2(Goods goods,@RequestParam("pageNumber") Integer pageNumber) {
	  ResultValue selectAllByType2 = this.goodsFeginService.selectAllByType2(goods, pageNumber);
	  return selectAllByType2;
	}
	@PostMapping("/insert")
	public ResultValue insert(Goods goods) {
		ResultValue insert = this.goodsFeginService.insert(goods);
	    return insert;
	}

}
