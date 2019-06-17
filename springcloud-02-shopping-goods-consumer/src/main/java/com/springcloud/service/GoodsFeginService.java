package com.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator.RequestType;
import com.springcloud.entity.Goods;
import com.springcloud.vo.ResultValue;

@FeignClient(name ="GOODS-PROVIDER")
public interface GoodsFeginService {
	
	@RequestMapping(value = "goods/select",method = RequestMethod.POST)
	public abstract ResultValue selectAllByType2(@RequestBody Goods goods,@RequestParam("pageNumber") Integer pageNumber);

	@PostMapping("goods/insert")
	public ResultValue insert(Goods goods);
}
