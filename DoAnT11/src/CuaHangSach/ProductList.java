package CuaHangSach;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class ProductList {
	Book[] bl;//sách trong cửa hàng
	private int soluongsach;
 	public ProductList() {
 		soluongsach=0;
		bl=new Book[0];
	}
	public ProductList(int soluongsach_nv,int soluongsach,Book[] bl) {
		this.soluongsach=soluongsach;
		this.bl=bl;
		}
	public void nhapsp(Scanner s) {
		System.out.print("Nhập số lượng sách trong cửa hàng:");
		soluongsach=s.nextInt();
		s.nextLine();
		bl=new Book[soluongsach];
		int chon=0;
		for(int i=0;i<soluongsach;i++) {
			System.out.println("1.Thêm sách thiếu nhi");
			System.out.println("2.Thêm sách giáo khoa");
			System.out.println("3.Thêm sách văn học\n Chọn loại sách:");
			chon=s.nextInt();
			s.nextLine();
				switch(chon)
				{
					case 1:
					{
						bl[i]=new Kid_Book();
						bl[i].nhap(s);
						break;
					}
					case 2:
					{
						bl[i]=new Student_Book();
						bl[i].nhap(s);
						break;
					}
					case 3:
					{
						bl[i]=new Literary_Book();
						bl[i].nhap(s);
						break;
					}
					default:
					{
						System.out.println("Không hợp lệ.");
					}
			}
		}

		// Hỏi có muốn lưu vào file không
		System.out.print("Bạn có muốn lưu danh sách sách vào file không? (Y/N): ");
		String ansSave = s.nextLine();
		if (ansSave.equalsIgnoreCase("Y")) {
			xuat_file();
			System.out.println("Đã lưu danh sách sách vào book.txt");
		}
	}

	public void xuat() {
		System.out.println("Danh sách tất cả loại sách:");
		for(int i=0;i<soluongsach;i++) {
			bl[i].xuat();
		}
	}
	public void them(Scanner reader) {
		int chon;
		char yn;
		do {
			System.out.println("1.Thêm sách thiếu nhi");
			System.out.println("2.Thêm sách giáo khoa");
			System.out.println("3.Thêm sách văn học");
			System.out.println("0.Thoát+\n Chọn loại sách cần thêm:");
			chon=reader.nextInt();
			reader.nextLine();
			if(chon==0) break;
				switch(chon) {
					case 1->{
						Kid_Book kd=new Kid_Book();
						kd.nhap(reader);
						them(kd);
						break;
					}
					case 2->{
						Student_Book sb=new Student_Book();
						sb.nhap(reader);
						them(sb);
						break;
					}
					case 3->{
						Literary_Book lb=new Literary_Book();
						lb.nhap(reader);
						them(lb);
						break;
					}
					default->{
						System.out.println("Lỗi: lựa chọn không hợp lệ.");
						break;
					}
				}
				System.out.print("Tiếp tục không? (Y/N): ");
				yn = reader.next().charAt(0);
				reader.nextLine();
		} while(yn=='Y' || yn=='y');

			// Hỏi có muốn lưu vào file không
			System.out.print("Bạn có muốn lưu danh sách sách vào file không? (Y/N): ");
			String ans = reader.nextLine();
			if (ans.equalsIgnoreCase("Y")) {
				xuat_file();
				System.out.println("Đã lưu danh sách sách vào book.txt");
			}
	}
	public void them(Kid_Book kd) {
		bl=Arrays.copyOf(bl,soluongsach+1);
		Kid_Book temp=new Kid_Book();
		temp.setbookid(kd.getbook_id());
		temp.setbook_name(kd.getbook_name());
		temp.setauthor(kd.getauthor());
		temp.setage(kd.getage());
		temp.setgiagoc(kd.getgiagoc());
		temp.setlaisuat(kd.getlaisuat());
		bl[soluongsach]=temp;
		soluongsach++;
	}
	public void them(Student_Book sb) {
		bl=Arrays.copyOf(bl,soluongsach+1);
		Student_Book temp=new Student_Book();
		temp.setbookid(sb.getbook_id());
		temp.setbook_name(sb.getbook_name());
		temp.setauthor(sb.getauthor());
		temp.setkhoihoc(sb.getkhoihoc());
		temp.setgiagoc(sb.getgiagoc());
		temp.setlaisuat(sb.getlaisuat());
		bl[soluongsach]=temp;
		soluongsach++;
	}
	public void them(Literary_Book lb) {
		bl=Arrays.copyOf(bl,soluongsach+1);
		Literary_Book temp=new Literary_Book();
		temp.setbookid(lb.getbook_id());
		temp.setbook_name(lb.getbook_name());
		temp.setauthor(lb.getauthor());
		temp.setlanguage(lb.getlanguage());
		temp.setgiagoc(lb.getgiagoc());
		temp.setlaisuat(lb.getlaisuat());
		bl[soluongsach]=temp;
		soluongsach++;
	}
	

	
	
	
	public Product timkiem(String k) {
		for(int i=0;i<soluongsach;i++) {
			if(bl[i].getbook_id().equalsIgnoreCase(k)) {
				return bl[i];
			}
		}
		return null;
	}
	
	
	public void sua(Scanner reader) {
		// Nhập mã sách cần sửa
		System.out.print("Nhập mã cần sửa: ");
		String k=reader.nextLine();
		sua(k,reader);
	}
	public void sua(String k, Scanner reader) {
		Product sa=timkiem(k);
		if(sa==null) {
			System.out.print("Error");
			return;
		}
		System.out.println("Sửa thông tin sách trong cửa hàng");
		reader.nextLine();
		sa.nhap(reader);
	}

	
	
	public void xoa(Scanner reader) {
		reader.nextLine();
		System.out.print("Ma muon xoa: ");
		String x=reader.nextLine();
		xoa(x);
	}
	public void xoa(String x) {
		for(int i=0;i<soluongsach;i++) {
			if(bl[i].getbook_id().equalsIgnoreCase(x)) {
				for(int j=i;j<soluongsach-1;j++) {
					bl[j]=bl[j+1];
				}
				bl=Arrays.copyOf(bl,soluongsach-1);
				soluongsach--;
				break;
			}
		}
		System.out.println("Xoa thanh cong");
	}
	

	
	public void search(Scanner reader) {
		System.out.print("Nhap ten can tim:");
		String t=reader.nextLine();
		for(int i=0;i<soluongsach;i++) {
			if(bl[i].getbook_name().toLowerCase().equals(t)) {
				bl[i].xuat();
			}
		}
	}
	
	public void doc_file()
	{
		try
		{
			FileReader fr= new FileReader("book.txt");
			BufferedReader br=new BufferedReader(fr);
			soluongsach=Integer.parseInt(br.readLine().trim());
			bl=new Book[soluongsach];
			for (int i=0;i<soluongsach;i++)
			{
				String line=br.readLine();
				if (line==null||line.isEmpty())
					break;
				
				String parts[]=line.split("-");
				int type=Integer.parseInt(parts[0]);
				String id=parts[1];
				String name=parts[2];
				String author=parts[3];
				Double giagoc=Double.parseDouble(parts[4]);
				Double laisuat=Double.parseDouble(parts[5]);
				
				switch(type)
				{
					case 1:
					{
						bl[i]= new Student_Book(id,name,author,parts[6],giagoc,laisuat);
						break;
					}
					case 2:
					{
						bl[i]=new Literary_Book(id,name,author,giagoc,laisuat,parts[6]);
						break;
					}
					case 3:
					{
						int age=Integer.parseInt(parts[6]);
						bl[i]=new Kid_Book(id,name,author,giagoc,laisuat,age);
						break;
					}
				}
			}
			br.close();
			fr.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	public void xuat_file()
	{
		try
		{
			FileWriter fw= new FileWriter("book.txt");
			fw.write(String.valueOf(soluongsach));
			fw.write(System.lineSeparator());

			for (int i=0;i<soluongsach;i++)
			{
				if (bl[i] instanceof Student_Book)
				{
					Student_Book sb= (Student_Book)bl[i];
					fw.write(1+" ");
					fw.write(sb.getbook_id()+"-");
					fw.write(sb.getbook_name()+"-");
					fw.write(sb.getauthor()+"-");
					fw.write(String.valueOf(sb.getgiagoc())+"-");
					fw.write(String.valueOf(sb.getlaisuat())+"-");
					fw.write(sb.getkhoihoc());
					fw.write(System.lineSeparator());
				}

				if (bl[i] instanceof Literary_Book)
				{
					Literary_Book sb= (Literary_Book)bl[i];
					fw.write(2+"-");
					fw.write(sb.getbook_id()+"-");
					fw.write(sb.getbook_name()+"-");
					fw.write(sb.getauthor()+" ");
					fw.write(String.valueOf(sb.getgiagoc())+"-");
					fw.write(String.valueOf(sb.getlaisuat())+"-");
					fw.write(sb.getlanguage());
					fw.write(System.lineSeparator());
				}

				if (bl[i] instanceof Kid_Book)
				{
					Kid_Book sb= (Kid_Book)bl[i];
					fw.write(3+"-");
					fw.write(sb.getbook_id()+"-");
					fw.write(sb.getbook_name()+"-");
					fw.write(sb.getauthor()+"-");
					fw.write(String.valueOf(sb.getgiagoc())+"-");
					fw.write(String.valueOf(sb.getlaisuat())+"-");
					fw.write(String.valueOf(sb.getage()));
					fw.write(System.lineSeparator());
				}
			}
			fw.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

}

