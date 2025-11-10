package CuaHangSach;
import java.util.*;
import java.io.*;
public class DSNV {
	Employee el[];
	int soluongnv;
	
	public DSNV()
	{
		soluongnv=0;
		el=new Employee[0];
	}
	
	public void nhap(Scanner s)
	{
		
		System.out.print("Nhập số lượng nhân viên:");
		soluongnv=s.nextInt();
		s.nextLine();
		el=new Employee[soluongnv];
		for (int i=0;i<soluongnv;i++)
		{
			el[i]=new Employee();
			el[i].nhap(s);
		}

		// Hỏi người dùng có muốn lưu vào file không
		System.out.print("Bạn có muốn lưu danh sách nhân viên vào file không? (Y/N): ");
		String ans = s.nextLine();
		if (ans.equalsIgnoreCase("Y")) {
			xuat_file();
			System.out.println("Đã lưu danh sách nhân viên vào Employee.txt");
		}
	}
	public void them(Scanner s)
	{
		System.out.println("\n\nDanh sách nhân viên thêm:");
			el=Arrays.copyOf(el, soluongnv+1);
			el[soluongnv]=new Employee();
			el[soluongnv].nhap(s);
			soluongnv++;

		// Hỏi người dùng có muốn lưu ngay không
		System.out.print("Bạn có muốn lưu danh sách nhân viên vào file không? (Y/N): ");
		String ans = s.nextLine();
		if (ans.equalsIgnoreCase("Y")) {
			xuat_file();
			System.out.println("Đã lưu danh sách nhân viên vào Employee.txt");
		}
	}
	public void xuat()
	{
		if (soluongnv==0)
		{
			System.out.print("Danh sách trống");
			return;
		}
		System.out.println("Danh sách nhân viên:");
		for (int i=0;i<soluongnv;i++)
		{
			el[i].xuat();
		}
	}
	public void tim(Scanner s)
	{
		
		String m="";
		System.out.print("\nNhập mã nhân viên cần tìm:");
		m=s.nextLine();
		for (int i=0;i<soluongnv;i++)
		{
			if (el[i].getemployee_id().equalsIgnoreCase(m))
			{
				el[i].xuat();
				
				return;
			}
		}
		System.out.print("Không tìm thấy nhân viên.");
		
		return;
	}
	public void sua(Scanner s)
	{
		String m="";
		System.out.print("\nNhập mã nhân viên cần sửa:");
		m=s.nextLine();
		for (int i=0;i<soluongnv;i++)
		{
			if (el[i].getemployee_id().equalsIgnoreCase(m))
			{
				el[i].nhap(s);
				System.out.println("Đã sửa nhân viên có mã " + m);
				return;
			}
		}
		System.out.print("Không tìm thấy nhân viên.");
		return;
	}
	public void xoa(Scanner s)
	{
		String m="";
		System.out.print("Nhập mã nhân viên cần xóa:");
		m=s.nextLine();
		for (int i=0;i<soluongnv;i++)
		{
			if (el[i].getemployee_id().equalsIgnoreCase(m))
			{
				for (int j=i;j<soluongnv-1;j++)
					el[j]=el[j+1];
				el=Arrays.copyOf(el, soluongnv--);
				System.out.println("Đã xóa nhân viên có mã " + m);
				return;
			}
		}
		System.out.print("Không tìm thấy nhân viên.");
		return;
	}
	public void xuat_file()
	{
		try
		{
			FileWriter fr=new FileWriter("Employee.txt");
			fr.write(String.valueOf(soluongnv));
			fr.write(System.lineSeparator());
			for (int i=0;i<soluongnv;i++)
			{
				fr.write(el[i].getemployee_id()+"-");
				fr.write(el[i].getemployee_name()+"-");
				fr.write(String.valueOf(el[i].getsalary()));
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
			FileReader fr=new FileReader("Employee.txt");
			BufferedReader br=new BufferedReader(fr);
			soluongnv=Integer.parseInt(br.readLine().trim());
			el=new Employee[soluongnv];
			for (int i=0;i<soluongnv;i++)
			{
				
				String line = br.readLine();
	            if (line == null || line.trim().isEmpty())
	                break;

	            String[] parts = line.split("-");
	            if (parts.length < 3)
	                continue; // skip malformed lines

	            String id = parts[0];
	            String name = parts[1];
	            int salary = Integer.parseInt(parts[2]);

	            el[i] = new Employee(id, name, salary);
			}
			br.close();
		}
		catch(Exception e)
		{
			System.out.print("Lỗi: "+e);
		}
	}
}
