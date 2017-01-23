package com.qcm.learnSB13.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.qcm.learnSB13.entity.Word;

/**
 * 
 * @author Congmin Qiu 
 */
@Mapper
public interface WordMapper {

	@Results({ @Result(property = "word", column = "word"),
			@Result(property = "usedNumber", column = "usednumber"),
			@Result(property = "details", column = "details"),
			@Result(property = "date", column = "date"),
			@Result(property = "synonym", column = "synonym") })
	@Select("select * from vocabulary_tab where usednumber = #{usedNumber}")
	List<Word> findByUsedNumber(@Param("usedNumber") Integer usedNumber);

	@Results({ @Result(property = "word", column = "word"),
			@Result(property = "usedNumber", column = "usednumber"),
			@Result(property = "details", column = "details"),
			@Result(property = "date", column = "date"),
			@Result(property = "synonym", column = "synonym") })
	@Select("select * from vocabulary_tab where word = #{word}")
	Word findByWord(@Param("word") String word);

	@Results({ @Result(property = "word", column = "word"),
			@Result(property = "usedNumber", column = "usednumber"),
			@Result(property = "details", column = "details"),
			@Result(property = "date", column = "date"),
			@Result(property = "synonym", column = "synonym") })
	@Select("select * from vocabulary_tab where word = #{word} or synonym like concat('%',#{word},'%') or details like concat('%',#{word},'%')")
	List<Word> findSynonymsByWord(@Param("word") String word);




}
