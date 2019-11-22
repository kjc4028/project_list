package com.dev.jpa.usr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.jpa.usr.entity.UsrEntity;

public interface UsrRepository extends JpaRepository<UsrEntity, Long>{

	UsrEntity findByUsrNm(String name);
	
	Optional<UsrEntity> findByUsrId(String usrId);
	
}
