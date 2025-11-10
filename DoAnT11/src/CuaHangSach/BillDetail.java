package CuaHangSach;
import java.util.Scanner;
public class BillDetail {
	private String product_name;
	private int quantity;
	private double cost;
	public BillDetail() {
		product_name="";
		quantity=0;
		cost=0;
	}
	public BillDetail(String product_name,int quantity,double cost) {
		this.product_name=product_name;
		this.quantity=quantity;
		this.cost=cost;
	}
	public void nhap(Scanner reader, ProductList ds) {
		Product b=null;
		while(b==null) {
			System.out.print("Nhập tên sản phẩm");
			product_name=reader.nextLine();
			b=ds.timkiem(product_name);
			if(b==null) {
				System.out.print("Lỗi");
			}
		}
		System.out.print("Nhập số lượng:");
		quantity=reader.nextInt();
		reader.nextLine();
		cost=b.GiaBan()*quantity;
	}
	public void xuat() {
		System.out.println(product_name+"|"+quantity+"|"+cost);
	}
	public String getproduct_name() {
		return "-"+product_name+"-"+String.valueOf(quantity)+"-"+String.valueOf(cost);
	}
}
