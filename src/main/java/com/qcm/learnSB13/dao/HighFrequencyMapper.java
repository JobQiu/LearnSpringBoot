package com.qcm.learnSB13.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 
 * @author Congmin Qiu 
 */
@Mapper
public interface HighFrequencyMapper {

	@Select("select count(word) from highfrequency_tab where word=#{word}")
	public Integer isExisted(@Param("word") String word);
}
