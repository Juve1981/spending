package com.spending.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spending.beans.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
}
