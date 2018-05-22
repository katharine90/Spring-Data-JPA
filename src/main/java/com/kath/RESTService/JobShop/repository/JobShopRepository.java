package com.kath.RESTService.JobShop.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kath.RESTService.JobShop.model.JobShop;

@Repository
public interface JobShopRepository extends JpaRepository<JobShop, Long> {

	List<JobShop>findByYrkesomrade(String yrkesomrde);
}