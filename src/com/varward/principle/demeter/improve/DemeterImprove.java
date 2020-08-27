package com.varward.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;

/**
 * 改进版本
 * 方案：上面出现的问题是我们将自己类的具体实现细节暴露在别人类里面 所以违反了迪米特法则 换句话说 我只要放在自己所属的类就没错了
 应用实例改进
 1) 前面设计的问题在于SchoolManager中，CollegeEmployee类并不是 SchoolManager类的直接朋友 (分析)
 2) 按照迪米特法则，应该避免类中出现这样非直接朋友关系的耦合 3) 对代码按照迪米特法则 进行改进.


 迪米特法则注意事项和细节
 1) 迪米特法则的核心是降低类之间的耦合
 2) 但是注意：由于每个类都减少了不必要的依赖，因此迪米特法则只是要求降低 类间(对象间)耦合关系， 并不是要求完全没有依赖关系


 */
public class DemeterImprove {
    public static void main(String[] args) {


        SchoolEmpolyeeManager manager = new SchoolEmpolyeeManager();
        manager.printAllEmployee(new EmpolyeeManager());

    }


}

//首先按照要求创建学院员工类和学校员工类
class Employee {
    //学院的员工id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class SchoolEmployee {
    //学校的员工id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


class EmpolyeeManager {

    //设计一个方法用来设置学院员工并返回
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployeeList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            Employee employee = new Employee();
            employee.setId(i + 1);
            allEmployeeList.add(employee);
        }
        return allEmployeeList;
    }

    //输出学院员工的id
    void printEmployee() {
        List<Employee> list1 = this.getAllEmployee();
        System.out.println("------------学院员工------------");
        for (Employee e : list1) {
            System.out.println("学院员工为" + e.getId());
        }
    }
}

//接下来在设计两个类 用来管理学校员工id和学院员工id
class SchoolEmpolyeeManager {

    //设计一个方法用来设置学校员工并返回所有员工
    public List<SchoolEmployee> getAllSchoolEmployee() {
        List<SchoolEmployee> allEmployeeList = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            SchoolEmployee employee = new SchoolEmployee();
            employee.setId(i + 1);
            allEmployeeList.add(employee);
        }
        return allEmployeeList;
    }

    void printAllEmployee(EmpolyeeManager empolyeeManager) {

        //将自己要做的事情封装在自己的类中
        //这样就完全灭有暴露Employee这个类的细节在别人的类中了  就没有违反迪米特法则了
        empolyeeManager.printEmployee();

        List<SchoolEmployee> list2 = this.getAllSchoolEmployee();
        System.out.println("------------学校总部员工------------");
        for (SchoolEmployee e : list2) {
            System.out.println("学校员工为" + e.getId());
        }
    }
}
