package com.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.dao.GoodsMapper;
import com.springcloud.entity.Goods;
import com.springcloud.service.GoodsService;

/**
 * 实现商品模块的操作
* 项目名称：springcloud-02-shopping-goods-provider   
* 类名称：GoodsServiceImpl   
* 类描述：   
* 创建人：admin   
* 创建时间：2019年5月24日 下午4:31:48     
* @version    
*
 */
@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper goodsMapper;

	/**
	 * 添加商品的信息,并添加事务
	 */
	@Transactional
	@Override
	public Integer insert(Goods goods) {
		return goodsMapper.insert(goods);
	}

	@Override
//	@Cacheable(cacheNames = "goodsList",key = "#pageNumber")
	public PageInfo<Goods> select(Goods goods, Integer pageNumber) {
		goods.setGoodsName("%"+goods.getGoodsName()+"%");
		
		//设置pagehelper来分页
		PageHelper.startPage(pageNumber+1, PageUtils.PAGE_ROW_COUNT);
		List<Goods> select = this.goodsMapper.select(goods);
		
		return new PageInfo<>(select);
	}

	/**
	 * 更新商品信息根据商品id
	 */
	@Transactional
	@Override
	public Integer updateGoodsById(Goods goods) {
				return this.goodsMapper.updateGoodsById(goods);
	}

	/**
	 * 修改商品的价格信息跟等级
	 */
	@Override
	@Transactional
	public Integer updateGoodsMessage(Goods goods) {
		return this.goodsMapper.updateByPrimaryKey(goods);
	}

	/**
	 * 查找商品销售的top10
	 */
	@Override
	public List<Goods> selectGoodsTotalTop10() {
		return this.goodsMapper.selectGoodsTotal();
	}

	
 }
