package com.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Goods;
import com.springcloud.service.GoodsService;
import com.springcloud.vo.ResultValue;

@RestController
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	// 返回前端的整合类
	ResultValue rv = new ResultValue();

	@PostMapping("/insert")
	public ResultValue insert(Goods goods) {

		try {
			Integer insert = goodsService.insert(goods);
			if (insert > 0) {
				rv.setCode(0);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 插入数据失败
		rv.setCode(1);
		rv.setMessage("插入数据失败！！！");
		return rv;
	}

	/***
	 * 根据前台传入的商品信息来查询商品数据
	 * 
	 * @param goods      查询商品的条件
	 * @param pageNumber 查询商品的页数
	 * @return
	 */
	@RequestMapping("/select")
	public ResultValue selectAllByType2(Goods goods, @RequestParam("pageNumber") Integer pageNumber) {

		try {
			PageInfo<Goods> select = this.goodsService.select(goods, pageNumber);
			// 从分页信息中获得商品数据
			List<Goods> list = select.getList();
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				// 把商品数据存入到map中
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("goodsList", list);
				// 设置分页
				PageUtils pageUtils = new PageUtils(select.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				map.put("pageUtils", pageUtils);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("没查到数据");
		return rv;
	}

	@RequestMapping("/updateById")
	public ResultValue updateById(Goods goods) {

		try {
			Integer updateGoodsById = this.goodsService.updateGoodsById(goods);

			if (updateGoodsById > 0) {
				rv.setCode(0);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 更新失败
		rv.setCode(1);
		rv.setMessage("更新失败");
		return rv;
	}

	@RequestMapping("/updateGoodsMessageById")
	public ResultValue updateGoodsMessageById(Goods goods) {
		try {
			Integer updateGoodsMessage = this.goodsService.updateGoodsMessage(goods);
			// 更新成功
			if (updateGoodsMessage > 0) {
				rv.setCode(0);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("更新模态框中商品的信息失败");
		return rv;
	}
	@RequestMapping("/selctGoodsTop10")
	public ResultValue selctGoodsTop10() {
		try {
			List<Goods> selectGoodsTotalTop10 = this.goodsService.selectGoodsTotalTop10();
			//查找成功
			if (selectGoodsTotalTop10!=null&&selectGoodsTotalTop10.size()>0) {
				rv.setCode(0);
				//创建两个集合来保存x轴y轴的数据保存
				List<String> x=new ArrayList<String>();
				List<Integer> y=new ArrayList<>();
				for (Goods goods : selectGoodsTotalTop10) {
					x.add(goods.getGoodsName().substring(0,4)+"...");
					y.add(goods.getGoodsSum());
				}
				
				Map<String, Object> map=new HashMap<>();
				map.put("x", x);
				map.put("y", y);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//查找为空的时候
		rv.setCode(1);
		rv.setMessage("没查找到数据");
		return rv;
	}
}
