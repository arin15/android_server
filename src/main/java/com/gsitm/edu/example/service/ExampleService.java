package com.gsitm.edu.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsitm.edu.example.dao.ExampleDAO;

//서비스 = dao 호출
@Service
public class ExampleService {
	@Autowired
	private ExampleDAO dao;
	//				//이름 마음대로 해도 된다. 그냥 똑같이 함
	public List<Map<String, Object>> selectEmpList(Map<String, Object> paramMap){
		System.out.println("SERVICE 단");
		return dao.selectEmpList(paramMap);
	}
}

//@Transactional    트랜젝션을 원할때 어노테이션만 붙여주면 됨
//제어권을 넘긴것 IoC
//Autowired 내가 new 안하고 자동으로 생성해줌  --> di 