package com.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wuyang on 2017/4/7.
 */
@Mapper
public interface TBItemMapper {

    @Select("SELECT item_id,item_title,price from tb_item limit 3")
//    @ResultMap("TBItem")
    List<TBItem> getTb();

    @Select("SELECT count(*) from tb_item ")
//    @ResultMap("TBItem")
    Long getCnt();
}
