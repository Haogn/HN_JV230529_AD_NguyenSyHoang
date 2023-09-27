package ra.run;

import ra.model.Mark;
import ra.model.Student;
import ra.model.Subject;

import java.util.Scanner;

public class SchoolManagement {
    Student[] arrStudent = new Student[100] ;
    Subject[] arrSubject = new Subject[100] ;

    Mark[] arrMark = new Mark[100] ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        SchoolManagement schoolManagement =new SchoolManagement();

        int choice ;
        do {
            System.out.println("_________ SCHOOL-MANAGEMENT _________");
            System.out.println("1. Quan ly hoc sinh");
            System.out.println("2. Quan ly mon hoc ");
            System.out.println("3. QUan ly diem");
            System.out.println("4. ❌ Thoat");
            System.out.println("Lua chon chuc nang de quan ly danh muc ");
            choice = Integer.parseInt(sc.nextLine()) ;
            switch (choice) {
                case 1 :
                    schoolManagement.studentManagement(sc);
                   break;
                case 2 :
                    schoolManagement.subjectManagement(sc);
                    break;
                case 3 :
                    schoolManagement.markManagement(sc);
                    break;
                case 4 :
                    System.out.println("Thoat khoi chuong trinh");
                    sc.close();
                    break;
            }
        } while (choice != 4) ;
    }

    public void studentManagement(Scanner sc) {

        int currenIndex = 0 ;
        int selectStudent  ;

        do {
            System.out.println("___________ STUDENT-MANAGEMENT _________");
            System.out.println("1. Them moi hoc sinh");
            System.out.println("2. Hien thi danh sach hoc sinh");
            System.out.println("3. Thay doi thong tin hoc sinh");
            System.out.println("4. Xoa hoc sinh");
            System.out.println("5. Thoat");
            System.out.println("Lua chon de quan ly hoc sinh ");
            selectStudent = Integer.parseInt(sc.nextLine()) ;
            switch (selectStudent) {
                case 1 :
                    System.out.println("Nhap so luong hoc sinh muon them ");
                    int n = Integer.parseInt(sc.nextLine()) ;
                    for (int i = 0; i < n; i++) {
                        arrStudent[currenIndex] = new Student() ;
                        arrStudent[currenIndex].inputData(sc);
                        currenIndex++ ;
                    }
                    break;
                case 2 :
                    for (int i = 0; i < currenIndex; i++) {
                        arrStudent[i].displayData();
                    }
                    break;
                case 3 :
                    System.out.println("Nhap id hoc sinh can thay doi thong tin ");
                    int idUpdate = Integer.parseInt(sc.nextLine()) ;
                    int indexUpdate = -1 ;
                    for (int i = 0; i < currenIndex; i++) {
                        if (arrStudent[i].getStudentId() == idUpdate) {
                            indexUpdate = i ;
                            break;
                        }
                    }
                    if (indexUpdate != -1 ) {
                        arrStudent[indexUpdate].inputData(sc);
                    } else {
                        System.err.println("Hoc sinh khong ton tai trong danh sach");
                    }
                    break;
                case 4 :
                    System.out.println("Nhap id hoc sinh can xoa");
                    int idDelete = Integer.parseInt(sc.nextLine()) ;
                    int indexDelete = -1 ;
                    for (int i = 0; i < currenIndex; i++) {
                        if (arrStudent[i].getStudentId() == idDelete) {
                            indexDelete = i ;
                            break;
                        }
                    }
                    if (indexDelete != -1 ) {
                        for (int i = indexDelete; i < currenIndex ; i++) {
                            arrStudent[i] = arrStudent[i+1] ;
                        }
                        arrStudent[currenIndex -1 ] = null;
                        currenIndex-- ;
                    } else {
                        System.err.println("Hoc sinh khong ton tai trong danh sach");
                    }
                    break;
                case 5 :
                    System.err.println("Da thoat khoi chuong trinh");
                    return;
                default:
                    System.err.println("Lua chon khong phu hop , vui long chon lai ");
            }
        } while (true );
    }

    public void subjectManagement(Scanner sc) {
        int currenIndex = 0 ;
        int selectSubject  ;
        do {
            System.out.println("__________ SUBJECT-MANAGEMENT __________");
            System.out.println("1. Thêm mới môn học");
            System.out.println("2. Hiển thị danh sách tất cả môn học đã lưu trữ");
            System.out.println("3. Thay đổi thông tin học môn học theo mã id");
            System.out.println("4. Xóa môn học theo mã id");
            System.out.println("5. ❌ Thoat");
            System.out.println("Lua chon de quan ly mon hoc");
            selectSubject = Integer.parseInt(sc.nextLine()) ;
            switch (selectSubject) {
                case 1 :
                    System.out.println("Nhap so khoa hoc muon them ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        arrSubject[currenIndex] = new Subject() ;
                        arrSubject[currenIndex].inputData(sc, arrSubject, currenIndex);
                        currenIndex++ ;
                    }
                    break;
                case 2 :
                    for (int i = 0; i < currenIndex; i++) {
                        arrSubject[i].displayData();
                    }
                    break;
                case 3 :
                    System.out.println("Nhap id khoa hoc can thay doi thong tin ");
                    String  idUpdate = sc.nextLine() ;
                    int indexUpdate = -1 ;
                    for (int i = 0; i < currenIndex; i++) {
                        if (arrSubject[i].getSubjectId().equalsIgnoreCase(idUpdate)) {
                            indexUpdate = i ;
                            break;
                        }
                    }
                    if (indexUpdate != -1 ) {
                        arrSubject[indexUpdate].inputData(sc,arrSubject, currenIndex);
                    } else {
                        System.err.println("Hoc sinh khong ton tai trong danh sach");
                    }
                    break;
                case 4 :
                    System.out.println("Nhap id hoc sinh can xoa");
                    String  idDelete = sc.nextLine() ;
                    int indexDelete = -1 ;
                    for (int i = 0; i < currenIndex; i++) {
                        if (arrSubject[i].getSubjectId().equalsIgnoreCase(idDelete)) {
                            indexDelete = i ;
                            break;
                        }
                    }
                    if (indexDelete != -1 ) {
                        for (int i = indexDelete; i < currenIndex ; i++) {
                            arrSubject[i] = arrSubject[i+1] ;
                        }
                        arrSubject[currenIndex -1 ] = null;
                        currenIndex-- ;
                    } else {
                        System.err.println("Hoc sinh khong ton tai trong danh sach");
                    }
                    break;
                case 5 :
                    System.err.println("Thoat khoi chuong trinh");
                    return;
            }
        } while (true ) ;
    }

    public void markManagement(Scanner sc) {
        int currenIndex = 0 ;
        int selectMark  ;
        Mark mark = new Mark();
        do {
            System.out.println("________ MARK-MANAGEMENT ________");
            System.out.println("1. Thêm mới điểm thi cho 1 sinh viên");
            System.out.println("2. Hiển thị danh sách tất cả điểm thi theo thứ tự điểm tăng dần");
            System.out.println("3. Thay đổi điểm theo mã id");
            System.out.println("4. Xóa điểm theo mã id");
            System.out.println("5. Hiển thị danh sách điểm thi theo mã môn học");
            System.out.println("6. Hiển thị đánh giá học lực của từng học sinh theo mã môn học");
            System.out.println("7. ❌ Thoat");
            selectMark = Integer.parseInt(sc.nextLine()) ;
            switch (selectMark) {
                case 1 :
                    mark.inputData(sc, arrStudent, arrSubject);
                    break;
                case 2 :
                    for (int i = 0; i < currenIndex - 1; i++) {
                        for (int j = i + 1; j < currenIndex; j++) {
                            if (arrMark[i].getPoint() < arrMark[j].getPoint()) {
                                Mark temp = arrMark[i];
                                arrMark[i] = arrMark[j];
                                arrMark[j] = temp;
                            }
                        }
                    }
                    System.out.println("Danh sách điểm thi theo thứ tự điểm tăng dần:");
                    for (int i = 0; i < currenIndex; i++) {
                        arrMark[i].displayData();
                    }
                    break;
                case 3 :
                    System.out.println("Nhập mã id điểm cần thay đổi:");
                    int idToUpdate = Integer.parseInt(sc.nextLine());

                    // Tìm điểm cần thay đổi trong mảng arrMark
                    boolean found = false;
                    for (int i = 0; i < currenIndex; i++) {
                        if (arrMark[i].getMarkId() == idToUpdate) {
                            System.out.println("Nhập điểm mới (từ 0 đến 10):");
                            double newPoint = Double.parseDouble(sc.nextLine());
                            arrMark[i].setPoint(newPoint);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.err.println("Không tìm thấy điểm có mã id " + idToUpdate);
                    }
                    break;
                case 4 :
                    System.out.println("Nhập mã id điểm cần xóa:");
                    int idToDelete = Integer.parseInt(sc.nextLine());

                    // Tìm và xóa điểm có mã id cần xóa
                    boolean deleted = false;
                    for (int i = 0; i < currenIndex; i++) {
                        if (arrMark[i].getMarkId() == idToDelete) {
                            // Xóa điểm bằng cách gán null cho phần tử tương ứng
                            arrMark[i] = null;
                            deleted = true;
                            break;
                        }
                    }

                    if (deleted) {
                        System.out.println("Điểm có mã id " + idToDelete + " đã bị xóa.");
                    } else {
                        System.err.println("Không tìm thấy điểm có mã id " + idToDelete);
                    }
                    break;
                case 5 :
                    break;
                case 6 :

                    break;
                case 7 :
                    System.out.println("Thoat khoi chuong trinh");
                  return;
                default:
                    System.err.println("Lua chon khong phu hop , Vui long chon lai ❤");
            }
        } while (true ) ;
    }
}
