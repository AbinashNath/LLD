package com.example;

interface IPrint {
    void printEmp(String name);
}

class EvenPrint implements IPrint{
    @Override
    public void printEmp(String name) {
        System.out.println("Even print : "+name);
    }
}

class OddPrint implements IPrint{
    @Override
    public void printEmp(String name) {
        System.out.println("Odd print : "+name);
    }
}

class PrintAdapter implements PrintEmpName{
    private EvenPrint evenPrint;
    private OddPrint oddPrint;
    public PrintAdapter(){
        this.evenPrint = new EvenPrint();
        this.oddPrint = new OddPrint();
    }
    @Override
    public void printEmpName(int empId, String empName) {
        if(empId%2==0){
            evenPrint.printEmp(empName);
        }else {
            oddPrint.printEmp(empName);
        }
    }
}

interface PrintEmpName {
    void printEmpName(int empId, String empName);
}

class PrintEmpNameImpl implements PrintEmpName{
    @Override
    public void printEmpName(int empId, String empName) {
        System.out.println("Printing EmpId : "+empId+" EmpName : "+empName);
    }
}

public class Main {
    public static void main(String[] args) {
        PrintEmpName printEmpName = new PrintEmpNameImpl();
        printEmpName.printEmpName(1,"ABN");
        printEmpName.printEmpName(2, "BCN");
        // Now two separate Interface printEvent(empName), printOdd(empName)
        PrintEmpName printEmpName1 = new PrintAdapter();
        printEmpName1.printEmpName(1,"ABN");
        printEmpName1.printEmpName(2, "BCN");
    }
}
