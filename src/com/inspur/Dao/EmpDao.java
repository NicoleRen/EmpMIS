package com.inspur.Dao;
import java.sql.*;
import com.inspur.entity.Employee;
public class EmpDao {  //与数据库进行连接从而进行相应操作的类
	Connection conn=null;
	public boolean check(int id)  {	//ͨ查询当前数据库有没有这个用户
 		  Statement st=null;
		  ResultSet rs=null; 
		try{  
			  
			  conn=JDBC_Utils.getConnection();
			  st=conn.createStatement();
			  String sql="select*from employee where id="+id;
			  if (st.executeQuery(sql)==null)
				  return true;
		  }catch (Exception e) {
		}finally{
		  JDBC_Utils.release(conn,st,rs);}
		  return false;  //返回方法结果
	}
	//插入
	public void insertEmp(Employee emp){  //参数是封装好的实体
		  Connection conn=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		try{ 
	    	 conn=JDBC_Utils.getConnection();   //获取连接
	    	 String insertsql="insert into EMPLOYEE(eId,eName,eIdno,eTel,eDept,eJob,eMail) values(?,?,?,?,?,?,?)";
	    	 ps=conn.prepareStatement(insertsql);
				ps.setInt(1,emp.geteId());
				ps.setString(2, emp.geteName());
				ps.setString(3, emp.geteIdno());
				ps.setString(4, emp.geteTel());
				ps.setString(5, emp.geteDept());
				ps.setString(6, emp.geteJob());
				ps.setString(7, emp.geteMail());
	    	    int num=ps.executeUpdate();
			   if (num>0) {    //根据更新的行数判断是否插入成功
				  System.out.println("*************添加成功***************");
			   }  //if
			   }catch (Exception e) {
				e.printStackTrace();
			  }finally{
				JDBC_Utils.release(conn,ps,rs);   //释放数据库相关资源
			}  //finally
	}

	// 查询
	public void selectEmp(int id){ 
		Connection conn=null;
		  Statement st=null;
		  ResultSet rs=null;
		try{ 
			conn=JDBC_Utils.getConnection();   //获取连接
	    	 String selectsql="select*from employee where eid="+id;
	    	 st=conn.createStatement();
	    	 rs=st.executeQuery(selectsql);
	    	 if(rs.next()) {
	    		System.out.println("职工编号："+rs.getInt("eId")+"，职工姓名："+rs.getString("eName")+"，身份证号："+ 
	                       rs.getString("eIdno")+"，电话："+rs.getString("eTel")+"，部门：:"+rs.getString("eDept")+
	                      "，职务："+rs.getString("eJob")+"，Email:"+rs.getString("eMail")); 
			 }		else System.out.println("****************查询失败**************");	 
			   }catch (Exception e) {
				e.printStackTrace();
			  }finally{
				JDBC_Utils.release(conn,st,rs);   //释放数据库资源
			  }  //finally
	}
	// 更新
	public void updateEmp(Employee emp){ 
			  Connection conn=null;
			  PreparedStatement st=null;
			  ResultSet rs=null;
			  try{ 
					conn=JDBC_Utils.getConnection();   //数据库连接
			    	 String updatesql="update employee set eName=?,eIdno=?,eTel=?,eDept=?,eJob=?,eMail=? where eid=?";
			    	 st=conn.prepareStatement(updatesql);
					 st.setString(1, emp.geteName());
					 st.setString(2, emp.geteIdno());
					 st.setString(3, emp.geteTel());
					 st.setString(4, emp.geteDept());
					 st.setString(5, emp.geteJob());
					 st.setString(6, emp.geteMail());
					 st.setInt(7,emp.geteId()); //id对应第一个，但要最后一个设置(使用通配符的写法)
			    	  int num=st.executeUpdate();
					  if (num>0) {   
						  System.out.println("******更新成功！*******");
					   }  
					   }catch (Exception e) {
						e.printStackTrace();
					  }finally{
						JDBC_Utils.release(conn,st,rs);   //释放
					}  //finally
}
	//删除
  public void deleteEmp(int id){
	  Connection conn=null;
	  PreparedStatement st=null;
	  ResultSet rs=null;
	  try{ 
		  
		  conn=JDBC_Utils.getConnection();  
  	      String deletesql="delete from employee where eid=?";
  	      st=conn.prepareStatement(deletesql);
  	      st.setInt(1,id);
  	      int num=st.executeUpdate();
  
		  if (num>0) {   
			  System.out.println("*********删除成功********");
		   }  
		   }catch (Exception e) {
		  }finally{
			JDBC_Utils.release(conn,st,rs);   
		  } 
     }
  }