package CuaHangSach;
import java.util.Arrays;
import java.util.Scanner;
public class Bill {
	private String bill_id;
	private String date;
	BillDetail[] dt;
	private int n;
	public Bill() {
		n=0;
		dt=new BillDetail[0];
		bill_id="";
		date="";
	}
	public Bill(int n,String bill_id,String date) {
		this.n=n;
		this.bill_id=bill_id;
		this.date=date;
		dt=new BillDetail[n];
	}
	public void Bill_detail(int a,String p,int q,Double c)
	{
		dt[a]=new BillDetail(p,q,c);
	}
	public void nhap(Scanner reader,ProductList pl) {
		System.out.print("Nhập mã hóa đơn:");
		bill_id=reader.nextLine();
		System.out.print("Nhập ngày lập:");
		date=reader.nextLine();
		System.out.print("Nhập số lượng chi tiết sản phẩm:");
		n=reader.nextInt();
		reader.nextLine();
		dt=new BillDetail[n];
		for(int i=0;i<n;i++) {
			dt[i]=new BillDetail();
			dt[i].nhap(reader, pl);
		}
	}
	
	public String getbillid() {
		return bill_id;
	}
	
	public void them(Scanner reader) {
		char yn;
		do {
			dt=Arrays.copyOf(dt, n+1);
			dt[n]=new BillDetail();
			dt[n].nhap(reader,null);
			n++;
			yn=reader.next().charAt(0);
			}while(yn=='y'|| yn=='Y');
	}
	public void xuat() {
		System.out.println("Mã hóa đơn:"+bill_id);
		System.out.println("Ngày lập:"+date);
		for(int i=0;i<n;i++) {
			dt[i].xuat();
		}
		System.out.println("-------------");
	}
	public BillDetail timkiem(String k) {
		for(int i=0;i<n;i++) {
			if(dt[i].getproduct_name().equalsIgnoreCase(k)) {
				return dt[i];
			}
		}
		return null;
	}
	public void sua(Scanner reader) {
		System.out.print("Nhập tên thông tin muốn sửa:");
		String k=reader.nextLine();
		sua(reader,k);
	}
	public void sua(Scanner reader,String k) {
		BillDetail sa=timkiem(k);
		if(k==null) {
			System.out.print("Không tìm thấy:");
			return;
		}
		System.out.println("Sửa thông tin:");
		sa.nhap(reader, null);
	}
	public void xoa(Scanner reader) {
		System.out.print("Nhâp tên thông tin muốn xóa(tên sản phẩm):");
		String k=reader.nextLine();
		xoa(k);
	}
	public void xoa(String k) {
		for(int i=0;i<n;i++) {
			if(dt[i].getproduct_name().equalsIgnoreCase(k)) {
				for(int j=i;j<n-1;j++) {
					dt[j]=dt[j+1];
				}
					dt=Arrays.copyOf(dt, n-1);
					break;
			}
		}
	}
	public String getdate() {
		return date;
	}
	public int getsoluong()
	{
		return n;
	}
	public String xuatct(int a)
	{
		return dt[a].getproduct_name();
	}
}

