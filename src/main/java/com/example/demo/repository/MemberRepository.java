package com.example.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Member;

@Mapper
public interface MemberRepository {
	/*
	 * @Insert(""" INSERT INTO `member` SET regDate = NOW(), updateDate = NOW(),
	 * loginId = #{loginId}, loginPw = #{loginPw}, `name` = #{name}, nickname =
	 * #{nickname}, cellphoneNum = #{cellphoneNum}, email = #{email} """)
	 */
	public void join(String loginId, String loginPw, String name, String nickname, String cellphoneNum, String email);

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();

	@Select("SELECT * FROM `member` WHERE id = #{id}")
	public Member getMember(int id);

	@Select("SELECT COUNT(*) FROM `member` WHERE loginId= #{loginId}")
	public int DuplicateId(String loginId);
}