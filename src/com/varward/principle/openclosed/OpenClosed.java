package com.varward.principle.openclosed;

/**
 * 这个主要的就是介绍开闭原则  开闭原则其实是最重要的原则  所有的设计模式和之前的介绍的几大法则 在一定程度上都是实现了开闭原则
 * 下面看看概念介绍：
 * 1） 开闭原则（Open Closed Principle）是编程中最基础、最重要的设计原则
 * 2) 一个软件实体如类，模块和函数应该对扩展开放(对提供方)，对修改关闭(对使用 方)。用抽象构建框架，用实现扩展细节。
 * 3) 当软件需要变化时，尽量通过扩展软件实体的行为来实现变化，而不是通过修改已 有的代码来实现变化。
 * 4) 编程中遵循其它原则，以及使用设计模式的目的就是遵循开闭原则。
 * 还有模拟的相关案例
 * <p>
 * 我们要设计一个类用来画一个画图形的功能
 */
public class OpenClosed {
    public static void main(String[] args) {

        GiaphicEditor editor = new GiaphicEditor();
        editor.drawShape(new Circle());
        editor.drawShape(new Rectangle());

        //仔细看这个类 你会发现很多问题 那就是设计起来容易 添加起来太麻烦了  完全违反了开闭原则 只要改代码
        //很多的地方都要改 比如现在增加一个功能  画一个三角形
        //那这个类就是要重新添加三角形类 然后让它继承Shape 添加父类的成员变量 然后到GiaphicEditor 判断增加方法 所有的代码都要改
        //不仅是提供方要改 还有使用方也就是GiaphicEditor  都要改  这显然不合理 所以接下来我们使用面向接口或者

    }
}
//设计一个形状类  这个类是只有一个用来简单描述的属性

class Shape {
    int shape_type;
}

//设计一个矩形类 还有一个圆形类

class Circle extends Shape {
    public Circle() {
        super.shape_type = 1;
    }
}

class Rectangle extends Shape {
    public Rectangle() {
        super.shape_type = 2;
    }
}

//设计方法用来画图形
class GiaphicEditor {//使用方
    public void drawShape(Shape s) {
        if (s.shape_type == 1) {
            drawCircle();
        } else if (s.shape_type == 2) {
            drawRectangle();
        }
    }

    private void drawCircle() {
        System.out.println("画图方法在画圆形");
    }

    private void drawRectangle() {
        System.out.println("画图方法在画矩形");

    }


}