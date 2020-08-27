package com.varward.principle.interfacesegregation;


/**
 * 为了把握接口隔离原则：
 * 客户端不应该依赖它不需要的接 口，即一个类对另一个类的依赖 应该建立在最小的接口上
 * 按隔离原则应当这样处理：
 * 改进方案
 * 将接口Interface1拆分为独立的几个接口， 类A和类C分别与他们需要的接口建立依赖 关系。也就是采用接口隔离原则
 */
public interface InterfaceStrong1 {
    void method1();
}

interface InterfaceStrong23 {
    void method2();

    void method3();
}

interface InterfaceStrong45 {
    void method4();

    void method5();
}

//上面将大接口拆开 接下来就是B也就是现在的StrongB   D也就是StrongD (因为已经有了BD 我们用StrongB，StrongD替代)分别实现他们要的方法
class StrongB implements InterfaceStrong1, InterfaceStrong23 {

    @Override
    public void method1() {
        System.out.println("B实现了拆分后接口InterfaceStrong1中的方法1，");
        System.out.println("这也是StrongA将通过依赖StrongB，得到StrongB实现接口InterfaceStrong1后的方法1");
    }

    @Override
    public void method2() {
        System.out.println("B实现了拆分后接口InterfaceStrong23中的方法2，");
        System.out.println("这也是StrongA将通过依赖StrongB，得到StrongB实现接口InterfaceStrong23后的方法2");
    }

    @Override
    public void method3() {
        System.out.println("B实现了拆分后接口InterfaceStrong23中的方法3，");
        System.out.println("这也是StrongA将通过依赖StrongB，得到StrongB实现接口InterfaceStrong23后的方法3");
    }
}

class StrongD implements InterfaceStrong1, InterfaceStrong45 {

    @Override
    public void method1() {
        System.out.println("StrongD实现了拆分后接口InterfaceStrong1中的方法1，");
        System.out.println("这也是StrongC将通过依赖StrongD，得到StrongD实现接口InterfaceStrong1后的方法1");
    }

    @Override
    public void method4() {
        System.out.println("StrongD实现了拆分后接口InterfaceStrong45中的方法4，");
        System.out.println("这也是StrongC将通过依赖StrongD，得到StrongD实现接口InterfaceStrong45后的方法4");
    }

    @Override
    public void method5() {
        System.out.println("StrongD实现了拆分后接口InterfaceStrong45中的方法5，");
        System.out.println("这也是StrongC将通过依赖StrongD，得到StrongD实现接口InterfaceStrong45后的方法5");
    }
}