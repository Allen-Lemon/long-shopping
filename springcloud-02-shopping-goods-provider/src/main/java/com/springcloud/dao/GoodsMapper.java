package com.springcloud.dao;

import com.springcloud.entity.Goods;
import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);
    /**
     * 根据查询条件查询商品数据
     * @param goods :需要查询的条件
     * @return		 返回商品数据
     */
    public abstract List<Goods> select(Goods goods);

    public abstract Integer updateGoodsById(Goods goods);
    
    /**
     * 查找商品的TOP10的排行
     * @return
     */
    public abstract List<Goods> selectGoodsTotal();
}