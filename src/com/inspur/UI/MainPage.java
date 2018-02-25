package com.inspur.UI;
import java.sql.SQLException;
import java.util.*;
public class MainPage {
	public static void menu(){     //主界面
		System.out.println("欢迎进入职工信息管理系统(EMPLOYEE-CRUD)");
		System.out.println();
		System.out.println("请输入1-5进行相应操作");
		System.out.println("1. 添加新职工");
		System.out.println("2. 检索职工信息");
		System.out.println("3. 更新职工信息");
		System.out.println("4. 删除职工信息");
		System.out.println("5. 退出系统");
		System.out.println(" 请输入您的选择： ");
	}
	public static void main(String[] args) throws SQLException {
		while(true){  //使用while循环使界面一直停留在主界面	
			MainPage.menu();
			Scanner scanner=new Scanner(System.in);
			int num=scanner.nextInt();
			if (num>=1&&num<=5) {
				switch (num) {
				case 1:
					new EmpUI().insertUI();
					break;
                case 2:
					new EmpUI().selectUI();
					break;
                case 3:
                	new EmpUI().updateUI();
                	 break;
                case 4:
                	new EmpUI().deleteUI();
                	break;
                case 5:
                	System.exit(0); //强制退出系统 
				default:
					System.out.println("请输入正确的1-5的数字！");
					break;
				}
			}
		}
		
	}	
}
