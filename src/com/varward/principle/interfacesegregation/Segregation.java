package com.varward.principle.interfacesegregation;

/**
 * 这个版本我们介绍结构隔离原则
 * 首先给一个模拟场景
 * Inteface1 里面有5个方法  分别是12345，
 * B和D就会去实现这个接口 就要实现里面的五个方法
 * A通过依赖B这个类用到Interface1 B实现的123方法
 * C通过依赖D这个类用到Interface1 D实现的145方法
 * 下面根据上面的描述写出代码
 */
public class Segregation {
    public static void main(String[] args) {

        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        System.out.println("-----------我是一个分割线------------");
        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());
        System.out.println("-----------我是一个分割线------------");
        //对于A这个类来说 只会用到接口中的123方法
        //对于C这个类来说 只会用到接口中的145方法
        //所以就产生了对于A来说45方法多余，对于C类来说23多余
        //这就是上面这个需求面临的问题 接下来就是根据接口隔离原则设计一个更好的
        //仔细看interface2  需求还是不变
        //测试我们根据隔离原则写好的新接口和类
        StrongA strongA = new StrongA();
        strongA.depend1(new StrongB());
        strongA.depend2(new StrongB());
        strongA.depend3(new StrongB());
        System.out.println("-----------我是一个分割线------------");
        StrongC strongC = new StrongC();
        strongC.depend1(new StrongD());
        strongC.depend2(new StrongD());
        strongC.depend3(new StrongD());

        //以上就是通过接口隔离原则 拆分大接口分成三个小接口  同样达到目的的另外方式 仔细看
    }


}
