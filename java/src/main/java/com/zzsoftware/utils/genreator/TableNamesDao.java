package com.zzsoftware.utils.genreator;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 功能说明:
 *		1.查询所有表名
 */
@Mapper
@Repository
public interface TableNamesDao {
	@Select("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES")
	public List<String> findTableNames();
}
