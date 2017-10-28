package com.ydpay.business.dao.database;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ydpay.dao.MyBatisRepository;

@Repository
@MyBatisRepository
public interface DatabaseDao {
	//查询数据库模式
	public List<Map<String, Object>> select_schema(@Param("wheres")Map<String, Object> wheres);
	
	public List<Map<String, Object>> select_table(@Param("wheres")Map<String, Object> wheres);
	public List<Map<String, Object>> select_table_column(@Param("wheres")Map<String, Object> wheres);
	public List<Map<String, Object>> select_table_primary_key(@Param("wheres")Map<String, Object> wheres);
	
	public long select_max_id(@Param("wheres")Map<String, Object> wheres);
}
