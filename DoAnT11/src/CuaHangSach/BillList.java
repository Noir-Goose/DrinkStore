package CuaHangSach;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class BillList{
	private int soluonghd;
	Bill[] dshd;
	public BillList() {
		soluonghd=0;
		dshd=new Bill[0];
	}
	public BillList(int soluonghd,Bill[] dshd) {
		this.soluonghd=soluonghd;
		this.dshd=dshd;
	}
	public void nhap(Scanner reader,ProductList pl) {

		System.out.print("Nhập số lượng hóa đơn:");
		soluonghd=reader.nextInt();
		reader.nextLine();
		dshd=new Bill[soluonghd];
		for(int i=0;i<soluonghd;i++) {
			dshd[i]=new Bill();
			dshd[i].nhap(reader,pl);
		}
		// Hỏi có muốn lưu vào file không
		System.out.print("Bạn có muốn lưu danh sách hóa đơn vào file không? (Y/N): ");
		String ans = reader.nextLine();
		if (ans.equalsIgnoreCase("Y")) {
			xuat_file();
			System.out.println("Đã lưu danh sách hóa đơn vào Bill.txt");
		}
	}
	
	
	public void them(Scanner reader,ProductList pl) {
		char yn;
		do {
			dshd=Arrays.copyOf(dshd, soluonghd+1);
			dshd[soluonghd]=new Bill();
			dshd[soluonghd].nhap(reader,pl);
			soluonghd++;
			System.out.print("Tiếp tục không?(Y/N)");
			yn=reader.next().charAt(0);
		}while(yn=='y'||yn=='Y');
		// Hỏi có muốn lưu vào file không
		reader.nextLine();
		System.out.print("Bạn có muốn lưu danh sách hóa đơn vào file không? (Y/N): ");
		String ans = reader.nextLine();
		if (ans.equalsIgnoreCase("Y")) {
			xuat_file();
			System.out.println("Đã lưu danh sách hóa đơn vào Bill.txt");
		}
	}
	

	
	
	public void xuat() {
		System.out.println("Danh sách hóa đơn:");
		for(int i=0;i<soluonghd;i++) {
			dshd[i].xuat();
		}
	}
	

	
	public Bill timkiem(String k) {
		for(int i=0;i<soluonghd;i++) {
			if(dshd[i].getbillid().equalsIgnoreCase(k)) {
				return dshd[i];
			}
		}return null;
	}
	public void sua(Scanner reader,ProductList pl) {
		System.out.print("Nhập mã hóa đơn muốn sửa");
		String k=reader.nextLine();
		sua(k,reader,pl);
	}
	public void sua(String k,Scanner reader,ProductList pl) {
		Bill dt=timkiem(k);
		if(dt==null) {
			System.out.println("Không tìm thấy hóa đơn.");
			return;
		}
		System.out.print("Sửa thông tin hóa đơn:");
		dt.nhap(reader,pl);
	}
	
	

	
	public void xoa(Scanner reader) {
		System.out.print("Nhập mã hóa đơn:");
		String k=reader.nextLine();
		xoa(k);
	}
	public void xoa(String k) {
		for(int i=0;i<soluonghd;i++) {
			if(dshd[i].getbillid().equalsIgnoreCase(k)) {
				for(int j=i;j<soluonghd-1;j++) {
					dshd[j]=dshd[j+1];
				}
				dshd=Arrays.copyOf(dshd,soluonghd-1);
				soluonghd--;
				break;
			}
		}
	}
	
	public void xuat_file()
	{
		try
		{
			FileWriter fr=new FileWriter("Bill.txt");
			fr.write(String.valueOf(soluonghd));
			fr.write(System.lineSeparator());
			for (int i=0;i<soluonghd;i++)
			{
				fr.write(dshd[i].getbillid()+"-");
				fr.write(dshd[i].getdate()+"-");
				fr.write(String.valueOf(dshd[i].getsoluong()));
				for (int j=0;j<dshd[i].getsoluong();j++)
				{
					fr.write(dshd[i].xuatct(j));
				}
				fr.write(System.lineSeparator());
			}
			fr.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	public void doc_file()
	{
		try
		{
			FileReader fr=new FileReader("Bill.txt");
			BufferedReader br= new BufferedReader(fr);
			soluonghd=Integer.parseInt(br.readLine().trim());
			dshd=new Bill[soluonghd];
			for (int i=0;i<soluonghd;i++)
			{
				String line=br.readLine();
				if(line==null||line.isEmpty())
					continue;
				String parts[]=line.split("-");
				String id=parts[0];
				String date=parts[1];
				int n=Integer.parseInt(parts[2]);
				dshd[i]=new Bill(n,id,date);
				for (int j=0;j<n;j++)
				{
					if (j==0)
					{
						String name=parts[3];
						int quantity=Integer.parseInt(parts[4]);
						double cost=Double.parseDouble(parts[5]);
						dshd[i].Bill_detail(j,name,quantity,cost);
					}
					else
					{
						String name=parts[3+3*j];
						int quantity=Integer.parseInt(parts[3+3*j+1]);
						double cost=Double.parseDouble(parts[3+3*j+2]);
						dshd[i].Bill_detail(j,name,quantity,cost);
					}
				}
			}
			
			br.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}
