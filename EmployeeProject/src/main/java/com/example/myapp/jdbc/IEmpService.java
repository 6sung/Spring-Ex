package com.example.myapp.jdbc;

import java.util.List;
import java.util.Map;

public interface IEmpService {
	int getEmpCount();
	int getEmpCount(int deptid);
	List<Emp> getEmpList();
	Emp getEmpInfo(int empid);
	void updateEmp(Emp emp);
	void insertEmp(Emp emp);
	int deleteEmp(int empid, String email);
	List<Map<String, Object>> getAllDeptId();
	List<Map<String, Object>> getAllJobId();
	List<Map<String, Object>> getAllManagerId();
}
