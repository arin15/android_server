package com.gsitm.edu.example.dao;

import java.util.List;
import java.util.Map;

public interface ExampleDAO {
	public List<Map<String, Object>> selectEmpList(Map<String, Object> paramMap);
}
