package com.gsitm.edu.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsitm.edu.example.dao.ExampleDAO;

//���� = dao ȣ��
@Service
public class ExampleService {
	@Autowired
	private ExampleDAO dao;
	//				//�̸� ������� �ص� �ȴ�. �׳� �Ȱ��� ��
	public List<Map<String, Object>> selectEmpList(Map<String, Object> paramMap){
		System.out.println("SERVICE ��");
		return dao.selectEmpList(paramMap);
	}
}

//@Transactional    Ʈ�������� ���Ҷ� ������̼Ǹ� �ٿ��ָ� ��
//������� �ѱ�� IoC
//Autowired ���� new ���ϰ� �ڵ����� ��������  --> di 