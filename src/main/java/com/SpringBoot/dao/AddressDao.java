package com.SpringBoot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SpringBoot.model.Address;
import com.SpringBoot.model.User;


@Transactional
@Repository
public interface AddressDao extends JpaRepository<Address, Integer>{

	@Modifying
	@Query("delete from Address a where a.id not in (:ids) and a.user=:userData")
	int deleteByIdIn(@Param("ids") List<Integer> ids,@Param("userData") User userData);
	
}
