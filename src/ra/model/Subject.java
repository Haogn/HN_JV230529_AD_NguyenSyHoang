package ra.model;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Subject {
    private String subjectId ;
    private String subjectName ;

    public Subject() {

    }
    public Subject(String subjectId , String subjectName){
        this.subjectId = subjectId;
        this.subjectName= subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void inputData(Scanner sc, Subject[] arrSubject , int currenIndex) {
        // ma mon hoc
        boolean isDuplicateId = true;
        while (isDuplicateId) {
            System.out.println("Nhap vao ma mon hoc, Gồm 5 kí tự bắt đầu bằng “MH” và 3 kí tự số bất kì , không trùng lặp");
            String id = sc.nextLine();
            if (!id.matches("^MH\\\\d{3}$")) {
                if (currenIndex == 0 ) {
                    this.subjectId = id ;
                    isDuplicateId = false ;
                } else {
                    boolean isIdDuplicate = false;
                    for (int i = 0; i < currenIndex ; i++) {
                        if (arrSubject[i].getSubjectId().equalsIgnoreCase(id)) {
                            System.err.println("Ma mon hoc da ton tai , Vui long nhap lai ❤");
                            isIdDuplicate = true ;
                            break;
                        }
                    }
                    if ( !isIdDuplicate) {
                        this.subjectId = id ;
                        isDuplicateId = false ;
                    }
                }
            } else {
                System.err.println("Ma mon hoc chua dung dinh dang , vui long nhap lai ❤");
            }
        }

        // ten mon hoc
        boolean isDuplicateName = true;
        while (isDuplicateName) {
            System.out.println("Nhap vao ten mon hoc ");
            String name = sc.nextLine();
            if (!name.isEmpty()) {
                if (currenIndex == 0) {
                    this.subjectName = name;
                    isDuplicateName = false ;
                } else {
                    boolean isIdDuplicate = false;
                    for (int i = 0; i < currenIndex; i++) {
                        if (arrSubject[i].getSubjectName().equalsIgnoreCase(name)) {
                            System.err.println("Ten mon hoc da ton tai , vui long nhap lai");
                            isIdDuplicate = true ;
                            break;
                        }
                    }
                    if (!isIdDuplicate) {
                        this.subjectName = name;
                        isDuplicateName = false ;
                    }
                }
            } else {
                System.err.println("Ten mon hoc khong duoc de trong, Vui long nhap lai");
            }
        }
    }

    public void displayData() {
        System.out.println("_______THONG TIN VE MON HOC ________");
        System.out.println("Ma mon hoc: " + subjectId);
        System.out.println("Ten mon hoc " + subjectName) ;
    }

}
