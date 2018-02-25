package com.inspur.UI;
import java.util.Scanner;
import com.inspur.Dao.EmpDao;
import com.inspur.entity.Employee;
public class EmpUI {
	    EmpDao ed=new EmpDao();    
//增加新员工
	public void insertUI(){
		int eId=0;    
	    String eName=null,eIdno=null,eTel=null, eDept=null, eJob=null,eMail=null;    
		System.out.println("--------------------------添加新职工界面--------------------------");
		System.out.println("请输入新职工编号：");
		Scanner s=new Scanner(System.in);
		int i=s.nextInt();
		boolean b=ed.check(i);
		if (b) {
			System.out.println("该职工已存在！");
		}else {
			eId=i;
			System.out.println("请输入新职工的姓名： ");
			eName=new Scanner(System.in).next();   
			if (eName!=null) {  
				System.out.println("请输入新职工的身份证号： ");
				eIdno=new Scanner(System.in).next(); 
				    if (eIdno!=null) { 
						System.out.println("请输入新职工的电话： ");
						eTel=new Scanner(System.in).next();   
						if (eTel!=null) { 
							System.out.println("请输入新职工的部门： ");  
							eDept=new Scanner(System.in).next(); 
							if (eDept!=null) {
								System.out.println("请输入新职工的职务");
								eJob=new Scanner(System.in).next();
								if (eJob!=null) {
									System.out.println("请输入新职工的E-mail: ");
									eMail=new Scanner(System.in).next();
								 }else 
									 System.out.println("您输入的职务为空！请重新输入!");  
							}  else
								System.out.println("您输入的部门为空！请重新输入：");  
						}else 
							System.out.println("您输入的电话为空！请重新输入!");  
					}else
						System.out.println("您输入的职务为空！请重新输入!");  
						
			}else 
				System.out.println("您输入的姓名为空！请重新输入!");  
		}
		Employee emp=new Employee(eId, eName, eIdno, eTel, eDept, eJob, eMail);   //封装	
		new EmpDao().insertEmp(emp);
	}
	
//查询员工
	public void selectUI(){
		 System.out.println("--------------------------查询职工信息界面---------------------");
		 System.out.println("请输入要查询的职工编号：");
			int i=new Scanner(System.in).nextInt();
			boolean b=ed.check(i);
			if (b) {
				System.out.println("  该职工已存在！  ");
			}else {
				System.out.println(" 该职工的信息为： ");
				new EmpDao().selectEmp(i);			
			}
	}

	
//更新
	public void updateUI(){
		int eId=0;    
	    String eName=null,eIdno=null,eTel=null, eDept=null, eJob=null,eMail=null;    
		 System.out.println("--------------------------更新职工信息界面----------------");
		 System.out.println("请输入要更新的职工号：");
			int i=new Scanner(System.in).nextInt();
			boolean b=ed.check(i);
			if (b) {
				System.out.println("  该职工不存在！  ");
			}else {
				eId=i;
				System.out.println("请输入该职工的姓名：");
				eName=new Scanner(System.in).next();   
				if (eName!=null) {  
					System.out.println(" 请输入该职工的身份证号：  ");
					eIdno=new Scanner(System.in).next(); 
					    if (eIdno!=null) { 
							System.out.println(" 请输入该职工的电话：  ");
							eTel=new Scanner(System.in).next();   
							if (eTel!=null) { 
								System.out.println(" 请输入该职工的部门： ");  
								eDept=new Scanner(System.in).next(); 
								if (eDept!=null) {
									System.out.println("请输入该职工的职务：");
									eJob=new Scanner(System.in).next();
									if (eJob!=null) {
										System.out.println(" 请输入该职工的E-mail: ");
										eMail=new Scanner(System.in).next();
									 }  else 
										 System.out.println(" 您输入的职务为空！请重新输入：");  
								}  else
									System.out.println(" 您输入的部门为空！请重新输入："); 
							}else 
								System.out.println(" 您输入的电话为空！请重新输入：");  
						}else
							System.out.println(" 您输入的身份证号为空！请重新输入：");  
				}else 
					System.out.println(" 您输入的姓名为空！请重新输入：");  	 
			}
			Employee emp=new Employee(eId, eName, eIdno, eTel, eDept, eJob, eMail);   
			new EmpDao().updateEmp(emp);
			}
//删除
	public void deleteUI(){
		int eId=0;    
	    String eName=null,eIdno=null,eTel=null, eDept=null, eJob=null,eMail=null;  
		System.out.println("--------------------------删除职工信息界面----------------");
		 System.out.println(" 请输入要删除的职工编号：");
			int i=new Scanner(System.in).nextInt();
			boolean b=ed.check(i);
			if (b) {
				System.out.println("  该职工不存在 ");
			}
			Employee emp=new Employee(eId, eName, eIdno, eTel, eDept, eJob, eMail);  
			new EmpDao().deleteEmp(i);
	}
}
