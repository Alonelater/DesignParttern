package com.varward.principle.openclosed.improve;

/**
 * 这是开闭原则的增强版 新增了画三角形的功能 改善了之前那个案例出现的问题
 * 改进的思路分析
 * 思路：把创建Shape类做成抽象类，并提供一个抽象的draw方法，让子类去实现即可，
 * 这样我们有新的图形种类时，只需要让新的图形类继承Shape，并实现draw方法即可，
 * 使用方的代码就不需要修 ->  满足了开闭原则
 */
public class OpenClosedStrong {
    public static void main(String[] args) {


        //根据这样的方式设计类 我想我们在扩展功能的时候会显得优秀很多 我们既不会影响到别的代码 也能符合开闭原则
        GiaphicEditor editor = new GiaphicEditor(new Circle());
        GiaphicEditor editor2 = new GiaphicEditor(new Rectangle());
        GiaphicEditor editor3 = new GiaphicEditor(new Tritangle());


    }
}
//设计一个形状类  这个类是只有一个用来简单描述的属性

abstract class Shape {
    int shape_type;

    public abstract void draw();
}

//设计一个矩形类 还有一个圆形类

class Circle extends Shape {
    public Circle() {
        super.shape_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

class Rectangle extends Shape {
    public Rectangle() {
        super.shape_type = 2;

    }

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}


class Tritangle extends Shape {
    public Tritangle() {
        super.shape_type = 3;

    }

    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }
}

//设计方法用来画图形
class GiaphicEditor {//使用方

    public GiaphicEditor(Shape shape) {
        shape.draw();
    }


}