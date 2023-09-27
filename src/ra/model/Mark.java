package ra.model;



import java.sql.SQLOutput;
import java.util.Scanner;

public class Mark {
    private static int nextId = 1 ;
    private int markId ;
    private Student student ;
    private Subject subject ;
    private double point ;

    public Mark() {
        this.markId = nextId++ ;
    }

    public Mark(int markId, Student student, Subject subject, double point) {
        this.markId = markId;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Mark.nextId = nextId;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public void inputData(Scanner sc, Student[] arrStudent, Subject[] arrSubject) {
        // Hiển thị danh sách học sinh và môn học
        System.out.println("Danh sách học sinh:");
        for (int i = 0; i < arrStudent.length; i++) {
            if (arrStudent[i] != null) {
                arrStudent[i].displayData();
            }
        }

        System.out.println("Danh sách môn học:");
        for (int i = 0; i < arrSubject.length; i++) {
            if (arrSubject[i] != null) {
                arrSubject[i].displayData();
            }
        }

        // Nhập ID học sinh
        System.out.println("Nhập ID học sinh:");
        int studentId = Integer.parseInt(sc.nextLine());

        // Tìm học sinh dựa trên ID
        Student selectedStudent = null;
        for (int i = 0; i < arrStudent.length; i++) {
            if (arrStudent[i] != null && arrStudent[i].getStudentId() == studentId) {
                selectedStudent = arrStudent[i];
                break;
            }
        }

        if (selectedStudent == null) {
            System.err.println("Không tìm thấy học sinh có ID " + studentId);
            return;
        }

        // Nhập tên môn học
        System.out.println("Nhập tên môn học:");
        String subjectName = sc.nextLine();

        // Tìm môn học dựa trên tên
        Subject selectedSubject = null;
        for (int i = 0; i < arrSubject.length; i++) {
            if (arrSubject[i] != null && arrSubject[i].getSubjectName().equalsIgnoreCase(subjectName)) {
                selectedSubject = arrSubject[i];
                break;
            }
        }

        if (selectedSubject == null) {
            System.err.println("Không tìm thấy môn học có tên " + subjectName);
            return;
        }

        // Nhập điểm số
        System.out.println("Nhập điểm số (từ 0 đến 10):");
        double inputPoint = Double.parseDouble(sc.nextLine());

        // Kiểm tra điểm số hợp lệ
        while (true) {
            if (inputPoint < 0 || inputPoint > 10) {
                System.err.println("Điểm số không hợp lệ. VUi long nhap lai");
            } else {
                this.point = inputPoint;
                break;
            }
        };


        // Gán thông tin vào đối tượng Mark
        this.student = selectedStudent;
        this.subject = selectedSubject;
    }


    public void displayData() {
        System.out.println("______ DIEN CUA HOC SINH THEO MON HOC _______");
        System.out.println("Id : " + markId );
        System.out.println("Ten hoc sinh " + student.getStudentName());
        System.out.println("Mon hoc " + subject.getSubjectName());
        System.out.println("Diem " + point);
    }
}
