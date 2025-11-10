package CuaHangSach;

import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        DSNV dsnv = new DSNV();
        BillList billList = new BillList();
        ProductList plist = new ProductList(); // Quản lý sách
        int choice;
        do {
            showMenu();
            choice = readInt(reader, " Nhập lựa chọn của bạn: ");
            System.out.println(" Đang đọc dữ liệu từ tệp...");
            plist.doc_file();
            dsnv.doc_file();
            billList.doc_file();
            System.out.println(" Đọc dữ liệu hoàn tất!\n");

            switch (choice) {
                case 1:
                    quanLySach(reader, plist);
                    break;
                case 2:
                    quanLyNhanVien(reader, dsnv);
                    break;
                case 3:
                    quanLyHoaDon(reader, billList, plist);
                    break;
                case 4:
                    runSelfDestruct();
                    break;
                case 0:
                    System.out.println(" Hẹn gặp lại!");
                    break;
                default:
                    System.out.println(" Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        } while (choice != 0);

        reader.close();
    }

    // Menu chính
    private static void showMenu() {
        System.out.println("\n===== QUẢN LÝ CỬA HÀNG SÁCH =====");
        System.out.println("1.  Quản lý sách");
        System.out.println("2.  Quản lý nhân viên");
        System.out.println("3.  Quản lý hóa đơn");
        System.out.println("4.  Chế độ Tự Hủy (SelfDestruct Mode)");
        System.out.println("0.  Thoát chương trình");
    }

    // Đọc số nguyên 
    private static int readInt(Scanner reader, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(reader.nextLine()); 
                break;
            } catch (NumberFormatException e) {
                System.out.println(" Dữ liệu nhập không hợp lệ. Vui lòng nhập lại!");
            }
        }
        return value;
    }

    private static void runSelfDestruct() {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", "CuaHangSach.SelfDestruct");
            pb.inheritIO(); // kế thừa console
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Quản lý nhân viên
    private static void quanLyNhanVien(Scanner reader, DSNV dsnv) {
        int choice;
        do {
            System.out.println("\n---  QUẢN LÝ NHÂN VIÊN ---");
            System.out.println("1. Nhập danh sách nhân viên");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Xuất danh sách nhân viên");
            System.out.println("4. Tìm kiếm nhân viên");
            System.out.println("5. Sửa thông tin nhân viên");
            System.out.println("6. Xóa nhân viên");
            System.out.println("0.  Trở về menu chính");

            choice = readInt(reader, " Nhập lựa chọn: ");

            switch (choice) {
                case 1: dsnv.nhap(reader); break;
                case 2: dsnv.them(reader); break;
                case 3: dsnv.xuat(); break;
                case 4: dsnv.tim(reader); break;
                case 5: dsnv.sua(reader); break;
                case 6: dsnv.xoa(reader); break;
                case 7: dsnv.xuat_file(); break;
                case 8: dsnv.doc_file(); break;
                case 0: break;
                default: System.out.println(" Lựa chọn không hợp lệ!"); break;
            }
        } while (choice != 0);
    }

    // Quản lý sách
    private static void quanLySach(Scanner reader, ProductList plist) {
        int choice;
        do {
            System.out.println("\n---  QUẢN LÝ SÁCH ---");
            System.out.println("1. Nhập danh sách sách");
            System.out.println("2. Thêm sách mới");
            System.out.println("3. Xuất danh sách sách");
            System.out.println("4. Tìm kiếm sách");
            System.out.println("5. Sửa thông tin sách");
            System.out.println("6. Xóa sách");
            System.out.println("0. Trở về menu chính");

            choice = readInt(reader, " Nhập lựa chọn: ");

            switch (choice) {
                case 1: plist.nhapsp(reader); break;
                case 2: plist.them(reader); break;
                case 3: plist.xuat(); break;
                case 4: plist.search(reader); break;
                case 5: plist.sua(reader); break;
                case 6: plist.xoa(reader); break;
                case 7:	plist.xuat_file(); break;
                case 8:	plist.doc_file(); break;
                case 0: break;
                default: System.out.println(" Lựa chọn không hợp lệ!"); break;
            }
        } while (choice != 0);
    }

    // Quản lý hóa đơn
    private static void quanLyHoaDon(Scanner reader, BillList billList, ProductList plist) {
        int choice;
        do {
            System.out.println("\n--- QUẢN LÝ HÓA ĐƠN ---");
            System.out.println("1. Nhập danh sách hóa đơn");
            System.out.println("2. Thêm hóa đơn mới");
            System.out.println("3. Xuất danh sách hóa đơn");
            System.out.println("4. Sửa thông tin hóa đơn");
            System.out.println("5. Xóa hóa đơn");
            System.out.println("0. Trở về menu chính");

            choice = readInt(reader, "Nhập lựa chọn: ");

            switch (choice) {
                case 1: billList.nhap(reader, plist); break;
                case 2: billList.them(reader, plist); break;
                case 3: billList.xuat(); break;
                case 4: billList.sua(reader, plist); break;
                case 5: billList.xoa(reader); break;
                case 6: billList.xuat_file(); break;
                case 7: billList.doc_file(); break;
                case 0: break;
                default: System.out.println("Lựa chọn không hợp lệ!"); break;
            }
        } while (choice != 0);
    }
}
    