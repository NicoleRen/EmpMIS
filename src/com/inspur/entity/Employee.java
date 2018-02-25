package com.inspur.entity;
// ����ְ�����ʵ��
public class Employee {
     private int eId;    //职工编号
     private String eName;     //职工姓名
     private String eIdno;     //身份证号
     private String eTel;   //电话
     private String eDept;   //部门
     private String eJob;  //职务
     private String eMail;  //email  
     public Employee(int eId, String eName,String eIdno,String  eTel,String eDept,String eJob,String eMail){
         this.eId=eId;
         this.eName=eName;
         this.eIdno=eIdno;
         this.eTel=eTel;
         this.eDept=eDept;
         this.eJob=eJob;
         this.eMail=eMail;
     }  

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteIdno() {
		return eIdno;
	}

	public void seteIdno(String eIdno) {
		this.eIdno = eIdno;
	}

	public String geteTel() {
		return eTel;
	}

	public void seteTel(String  eTel) {
		this.eTel = eTel;
	}

	public String geteDept() {
		return eDept;
	}

	public void seteDept(String eDept) {
		this.eDept = eDept;
	}

	public String geteJob() {
		return eJob;
	}

	public void seteJob(String eJob) {
		this.eJob = eJob;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
}
