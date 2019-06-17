package com.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Goods;

/**
 * 模型层的接口，用于定义商品模块的方法
* 项目名称：springcloud-02-shopping-goods-provider   
* 类名称：GoodsService   
* 类描述：   
* 创建人：admin   
* 创建时间：2019年5月24日 下午3:36:10     
* @version    
*
 */
public interface GoodsService {
	/**
	 *				 添加商品信息
	 * @param goods  新的商品信息
	 * @return 		成功返回大于0的整数，失败返回0
	 */
	public Integer insert(Goods goods);
	
	/**
	 * 根据条件查询商品数据
	 * @param goods 		查询的数据
	 * @param pageNumber	查询的页数
	 * @return
	 */
	public PageInfo<Goods> select(Goods goods,Integer pageNumber);

	/**
	 * 				根据商品id修改商品信息
	 * @param goods 商品信息,商品图片，商品属性（热卖、新品、状态）
	 * @return
	 */
	public abstract Integer updateGoodsById(Goods goods);
	
	/**
	 * 根据商品的id来修改商品的信息
	 * @param goods 商品名称、等级、价格
	 * @return
	 */
	public abstract Integer updateGoodsMessage(Goods goods);
	
	/**
	 * 查找商品销售的TOP10
	 * @return
	 */
	public abstract List<Goods> selectGoodsTotalTop10();
}
