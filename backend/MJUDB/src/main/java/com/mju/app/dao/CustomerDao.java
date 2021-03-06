package com.mju.app.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mju.app.domain.Customer;

@Repository
@Transactional
public class CustomerDao {
	private final String NAMESPACE = "com.mju.app.mapper.CustomerMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Customer> getAllCustomers() {
		return this.sqlSession.selectList(NAMESPACE + "getAllCustomers");
	}
	
	public Customer getCustomer(int id) {
		return this.sqlSession.selectOne(NAMESPACE + "getCustomer", id);
	}
}
