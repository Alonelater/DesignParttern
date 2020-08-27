package com.varward.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * 在这里我们将介绍迪米特法则 首先看看什么是迪米特法则
 * 基本介绍：
 * 1) 一个对象应该对其他对象保持最少的了解
 * 2) 类与类关系越密切，耦合度越大
 * 3) 迪米特法则(Demeter Principle)又叫最少知道原则，即一个类对自己依赖的类知道的 越少越好。
 * 也就是说，对于被依赖的类不管多么复杂，都尽量将逻辑封装在类的内部。对外除了提供的public 方法，不对外泄露任何信息
 * 4) 迪米特法则还有个更简单的定义：只与直接的朋友通信
 * 5) 直接的朋友：
 * 每个对象都会与其他对象有耦合关系，只要两个对象之间有耦合关系，
 * 我们就说这两个对象之间是朋友关系。耦合的方式很多，依赖，关联，组合，聚合 等。
 * 其中，我们称出现成员变量，方法参数，方法返回值中的类为直接的朋友，而 出现在局部变量中的类不是直接的朋友。
 * 也就是说，陌生的类最好不要以局部变量 的形式出现在类的内部。
 * <p>
 * <p>
 * 案例模拟
 * 1) 有一个学校，下属有各个学院和 总部，现要求打印出学校总部员工ID和学院员工的id
 */
public class Demeter {
    public static void main(String[] args) {

        SchoolEmpolyeeManager manager = new SchoolEmpolyeeManager();
        manager.printAllEmployee(new EmpolyeeManager());
        //好了上面要求我们得到员工和学院员工的id 我们都已经得到了 现在我们分析一下问题
        //1.分析上面的SchoolEmpolyeeManager 的直接朋友 有哪些  根据上面基本介绍的规则
        // 我们发现直接朋友有SchoolEmployee还有EmpolyeeManager  但是Employee  不是直接朋友 但是他直接出现在了类的内部 这就违反了迪米特法则
        //现在我们根据发现的问题进行改进

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

        List<Employee> list1 = empolyeeManager.getAllEmployee();
        System.out.println("------------学院员工------------");
        for (Employee e : list1) {
            System.out.println("学院员工为" + e.getId());
        }
        List<SchoolEmployee> list2 = this.getAllSchoolEmployee();
        System.out.println("------------学校总部员工------------");
        for (SchoolEmployee e : list2) {
            System.out.println("学校员工为" + e.getId());
        }
    }
}
