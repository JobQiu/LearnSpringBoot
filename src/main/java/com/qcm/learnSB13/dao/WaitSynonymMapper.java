package com.qcm.learnSB13.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 
 * @author Congmin Qiu 
 */
@Mapper
public interface WaitSynonymMapper {

	@Insert("insert into wait_synonym(word,gmt_create,gmt_modified) values(#{word},now(6),now(6))")
	public void insertByWaitSynonym(@Param("word") String word);

	@Delete("delete from wait_synonym where word=#{word}")
	public void deleteByWord(@Param("word") String word);
	
	@Select("select word from wait_synonym")
	public Set<String> getAllWaitSynonym();

}
