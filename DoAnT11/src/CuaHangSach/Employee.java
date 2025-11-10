package CuaHangSach;
import java.util.Scanner;
public class Employee implements INhapXuat{
	private String employee_id;
	private String employee_name;
	private int salary;
	private static int nextemployeeID =0;
	public Employee() {
		employee_id="";
		employee_name="";
		salary=0;
	}
	public Employee(String employee_id,String employee_name,int salary) {
		this.employee_id=employee_id;
		this.employee_name=employee_name;
		this.salary=salary;
	}
	@Override public void nhap(Scanner reader) {
		System.out.print("Nhập mã số nhân viên:");
		employee_id=reader.nextLine();
		System.out.print("Nhập tên nhân viên:");
		employee_name=reader.nextLine();
		System.out.print("Nhập lương:");
		salary=reader.nextInt();
		reader.nextLine();
		nextemployeeID++;
	}
	@Override public void xuat() {
		System.out.println("Mã số nhân viên:"+employee_id+"\nTên nhân viên:"+employee_name+"\nLương:"+salary+"\n-------------");
	}
	public void setemployee_id(String employee_id) {
		this.employee_id=employee_id;
	}
	public void setemployee_name(String employee_name) {
		this.employee_name=employee_name;
	}
	public void setsalary(int salary) {
		this.salary=salary;
	}
	public String getemployee_id() {
		return employee_id;
	}
	public String getemployee_name() {
		return employee_name;
	}
	public int getsalary() {
		return salary;
	}
	public static int getnextemployeeID() {
		return nextemployeeID;
	}
}

