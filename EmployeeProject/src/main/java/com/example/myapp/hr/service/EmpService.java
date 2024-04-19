package com.example.myapp.hr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.hr.dao.IEmpRepository;
import com.example.myapp.hr.model.Emp;

@Service
public class EmpService implements IEmpService{

	@Autowired
	IEmpRepository empRepository;
	@Override
	public int getEmpCount() {
		return empRepository.getEmpCount();
	}
	@Override
	public int getEmpCount(int deptid) {
		// TODO Auto-generated method stub
		return empRepository.getEmpCount(deptid);
	}
	@Override
	public Emp getEmpInfo(int empid) {
		// TODO Auto-generated method stub
		return empRepository.getEmpInfo(empid);
	}
	@Override
	public void updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		empRepository.updateEmp(emp);
	}
	@Override
	public void insertEmp(Emp emp) {
		// TODO Auto-generated method stub
		empRepository.insertEmp(emp);
	}
	@Override
	@Transactional("transactionManager")
	public int deleteEmp(int empid, String email) {
		// TODO Auto-generated method stub
		empRepository.deleteJobHistory(empid);
		return empRepository.deleteEmp(empid, email);
	}
	@Override
	public List<Map<String, Object>> getAllDeptId() {
		// TODO Auto-generated method stub
		return empRepository.getAllDeptId();
	}
	@Override
	public List<Map<String, Object>> getAllJobId() {
		// TODO Auto-generated method stub
		return empRepository.getAllJobId();
	}
	@Override
	public List<Map<String, Object>> getAllManagerId() {
		// TODO Auto-generated method stub
		return empRepository.getAllManagerId();
	}
	@Override
	public List<Emp> getEmpList() {
		// TODO Auto-generated method stub
		return empRepository.getEmpList();
	}

}
