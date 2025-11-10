package CuaHangSach;
import java.util.Scanner;
public abstract class Product implements INhapXuat {
	public abstract void nhap(Scanner reader);
	public abstract void xuat();
	public abstract double GiaBan();
}
class Book extends Product{
	private String book_id;
	private String book_name;
	private String author;
	private double giagoc;
	private double laisuat;
	public Book() {
		book_id="";
		book_name="";
		author="";
		giagoc=0;
		laisuat=0;
	}
	public Book(String book_id,String book_name,String author,double giagoc,double laisuat) {
		this.book_id=book_id;
		this.book_name=book_name;
		this.author=author;
		this.giagoc=giagoc;
		this.laisuat=laisuat;
	}
	@Override public void nhap(Scanner reader) {
		System.out.print("Nhập mã sách:");
		book_id=reader.nextLine();
		System.out.print("Nhập tên sách:");
		book_name=reader.nextLine();
		System.out.print("Nhập tác giả:");
		author=reader.nextLine();
		System.out.print("Nhập giá:");
		giagoc=reader.nextDouble();
		System.out.print("Nhập lãi suất:");
		laisuat=reader.nextDouble();
		reader.nextLine();
	}
	@Override public double GiaBan() {
		return giagoc*(1+laisuat/100);
		
	}
	@Override public void xuat() {
		System.out.println("Mã sách:"+book_id);
		System.out.println("Tên sách:"+book_name);
		System.out.println("Tác giả:"+author);
		System.out.println("Giá:"+GiaBan());
	}
	public void setbookid(String book_id) {
		this.book_id=book_id;
	}
	public void setbook_name(String book_name) {
		this.book_name=book_name;
	}
	public void setauthor(String author) {
		this.author=author;
	}
	public void setgiagoc(double giagoc) {
		this.giagoc=giagoc;
	}
	public void setlaisuat(double laisuat) {
		this.laisuat=laisuat;
	}
	public String getbook_id() {
		return book_id;
	}
	public String getbook_name() {
		return book_name;
	}
	public String getauthor() {
		return author;
	}
	public double getgiagoc() {
		return giagoc;
	}
	public double getlaisuat() {
		return laisuat;
	}
}
class Student_Book extends Book{
	private String khoihoc;
	public Student_Book() {
		super();
		khoihoc="";
	}
	public Student_Book(String book_id,String book_name,String author,String khoihoc,double giagoc,double laisuat) {
		super(book_id,book_name,author,giagoc,laisuat);
		this.khoihoc=khoihoc;
	}
	public void nhap(Scanner reader) {
		super.nhap(reader);
		System.out.print("Nhập khối lớp:");
		khoihoc=reader.nextLine();
	}
	public void xuat() {
		super.xuat();
		System.out.println("Khối lớp:"+khoihoc+"\n-------------");
	}
	public void setkhoihoc(String khoihoc) {
		this.khoihoc=khoihoc;
	}
	public String getkhoihoc() {
		return khoihoc;
	}
}
class Literary_Book extends Book{
	private String language;
	public Literary_Book() {
		super();
		language="";
	}
	public Literary_Book(String book_id,String book_name,String author,double giagoc,double laisuat,String language) {
		super(book_id,book_name,author,giagoc,laisuat);
		this.language=language;
	}
	public void nhap(Scanner reader) {
		super.nhap(reader);
		System.out.print("Nhập ngôn ngữ:");
		language=reader.nextLine();
	}
	public void xuat() {
		super.xuat();
		System.out.println("Ngôn ngữ:"+language+"\n-------------");
	}
	public void setlanguage(String language) {
		this.language=language;
	}
	public String getlanguage() {
		return language;
	}
}
class Kid_Book extends Book{
	private int age;
	public Kid_Book() {
		super();
		age=0;
	}
	public Kid_Book(String book_id,String book_name,String author,double giagoc,double laisuat,int age) {
		super(book_id,book_name,author,giagoc,laisuat);
		this.age=age;
	}
	public void nhap(Scanner reader) {
		super.nhap(reader);
		System.out.print("Nhập tuổi:");
		age=reader.nextInt();
		reader.nextLine();
	}
	public void xuat() {
		super.xuat();
		System.out.println("Khối tuổi:"+age+"\n-------------");
	}
	public void setage(int age) {
		this.age=age;
	}
	public int getage() {
		return age;
	}
}