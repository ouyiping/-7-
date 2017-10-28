package com.ydpay.business.dao.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ydpay.business.entity.base.Appversioncontent;
import com.ydpay.dao.MyBatisRepository;

/**
*
* @Author auto_gen_by_tool
* @CreatedTime 2017-08-20 16:17:13
*/
@Repository
@MyBatisRepository
public interface UserDao {
     public List<Map<String,Object>> select(@Param("wheres")Map<String,Object> wheres, @Param("selects")List<String> selects,@Param("orders")List<String> orders,@Param("orderkey")String orderkey);
     public long select_count(@Param("wheres")Appversioncontent wheres);
     public void insert(Map<String,Object> dataMap);
     public void update(Map<String,Object> dataMap);
     public void delete(Map<String,Object> dataMap);
}