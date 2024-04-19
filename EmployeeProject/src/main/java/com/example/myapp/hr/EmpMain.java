package com.example.myapp.hr;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.myapp.hr.service.IEmpService;

public class EmpMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		IEmpService empService = context.getBean(IEmpService.class);
		System.out.println("사원의 수 조회");
		System.out.println("모든 사원의 수 : "+empService.getEmpCount());
		
		System.out.println("50번부서사원의 수 : " + empService.getEmpCount(50));
		
		System.out.println("사원 전체 정보 조회");
		System.out.println(empService.getEmpList());
		
		/*System.out.println("새로운 사원 정보 입력");
		Emp emp = new Emp();
		emp.setEmployeeId(250);
		emp.setFirstName("JinKyoung");
		emp.setLastName("heo");
		emp.setEmail("HEOJK1112");
		emp.setPhoneNumber("222-222");
		emp.setHireDate(new java.sql.Date(System.currentTimeMillis()));
		emp.setJobId("IT_PROG");
		emp.setSalary(8000);
		emp.setCommissionPct(0.2);
		emp.setManagerId(100);
		emp.setDepartmentId(10);
		try {
			empService.insertEmp(emp);
			System.out.println("insert ok");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("신규사원정보를 조회합니다");
		Emp emp250 = empService.getEmpInfo(250);
		System.out.println(emp250);
		
		System.out.println("250번 사원의 급여를 10% 인상시킵니다.");
		emp250.setSalary(emp250.getSalary()*1.1);
		empService.updateEmp(emp250);
		
		System.out.println("수정된 사원의 정보를 조회합니다.");
		emp250 = empService.getEmpInfo(250);
		System.out.println(emp250);*/
		
		empService.deleteEmp(101, "NYANG");
		context.close();
	}
}
