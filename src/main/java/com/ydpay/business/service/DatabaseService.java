package com.ydpay.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydpay.business.dao.database.DatabaseDao;
import com.ydpay.utils.MgException;

@Service
public class DatabaseService {

	@Autowired
	DatabaseDao databaseDao;

	// 查询数据库模式
	public List<Map<String, Object>> select_schema(String usename) {
		Map<String, Object> wheres = new HashMap<String, Object>();
		wheres.put("usename", usename);
		try {
			return databaseDao.select_schema(wheres);
		} catch (Exception e) {
			throw new MgException(330008, "查询数据库模式失败 ", e);
		}
	}

	public List<Map<String, Object>> select_table(String schemaname,
			String tablename, String tableowner) {
		Map<String, Object> wheres = new HashMap<String, Object>();
		wheres.put("schemaname", schemaname);
		wheres.put("tablename", tablename);
		wheres.put("tableowner", tableowner);
		try {
			return databaseDao.select_table(wheres);
		} catch (Exception e) {
			throw new MgException(330008, "查询数据库表失败 ", e);
		}
	}

	public List<Map<String, Object>> select_table_column(String schemaname,
			String tablename, String columnname) {
		Map<String, Object> wheres = new HashMap<String, Object>();
		wheres.put("schemaname", schemaname);
		wheres.put("tablename", tablename);
		wheres.put("columnname", columnname);
		try {
			return databaseDao.select_table_column(wheres);
		} catch (Exception e) {
			throw new MgException(330008, "查询数据库表列数据失败 ", e);
		}
	}

	public List<Map<String, Object>> select_table_primary_key(
			String schemaname, String tablename) {
		Map<String, Object> wheres = new HashMap<String, Object>();
		wheres.put("schemaname", schemaname);
		wheres.put("tablename", tablename);
		try {
			return databaseDao.select_table_primary_key(wheres);
		} catch (Exception e) {
			throw new MgException(330008, "查询数据库表主键失败 ", e);
		}
	}

	public Long select_max_id(String schemaname, String tablename,
			String primarykey) {
		Map<String, Object> wheres = new HashMap<String, Object>();
		wheres.put("primarykey", primarykey);
		wheres.put("tablename", schemaname + "." + tablename);

		try {
			return databaseDao.select_max_id(wheres);
		} catch (Exception e) {
			throw new MgException(330008, "查询数据库表主键id失败 ", e);
		}
	}

}
