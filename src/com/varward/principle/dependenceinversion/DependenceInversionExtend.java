package com.varward.principle.dependenceinversion;

/**
 * 刚才的两个案例已经介绍完了依赖倒转原则的思想 接下来我们介绍一下依赖关系传递的三种方式
 */
public class DependenceInversionExtend {


    //1.通过接口传递  最重要的就是将接口作为参数进行传递
    public static void main(String[] args) {
        //
        //准备电视
        ChangHong changHong = new ChangHong();

        //测试第一种方案
        //准备电视开关的实现类
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.tvOpen(changHong);

        System.out.println("-----------分割线----------");
        //测试第二种方案
        //准备电视开关的实现类
        SecondOpenAndClose secondOpenAndClose = new SecondOpenAndClose(changHong);
        secondOpenAndClose.tvOpen();

        System.out.println("-----------分割线----------");
        //测试第三种方案
        //准备电视开关的实现类
        ThreeOpenAndClose threeOpenAndClose = new ThreeOpenAndClose();
        //先得设置tv 不然空指针
        threeOpenAndClose.setTv(changHong);
        threeOpenAndClose.open();
    }

}
//1.通过接口传递依赖关系

//准备工作  准备类和接口
//我们就用看电视的开和关电视为例
//准备开和关的顶级接口
interface TVOpenAndClose {
    //开关有两个方法
    public void tvOpen(Tv tv);

}

//准备电视的接口
interface Tv {
    //电视播放
    public void play();
}

//准备实现类
class OpenAndClose implements TVOpenAndClose {

    //将接口传递下去  调用具体实现类实现的方法
    @Override
    public void tvOpen(Tv tv) {
        //谁传进来调用谁的
        tv.play();
    }

}

class ChangHong implements Tv {

    @Override
    public void play() {
        System.out.println("长虹电视在播放");
    }
}

//上面是第一种方式准备的实现类
//2.通过构造方法传递依赖
//下面在准备一个新的接口和对应的实现类
interface SecondTVOpenAndClose {
    public void tvOpen();
}

class SecondOpenAndClose implements SecondTVOpenAndClose {
    private Tv tv;//将接口作为成员进行传递

    public SecondOpenAndClose(Tv tv) {//这个是构造器
        this.tv = tv;
    }

    @Override
    public void tvOpen() {//调用方法
        tv.play();
    }
}


//下面准备第三种方式进行依赖传递
//3.通过setter方法传递依赖 这个有点像是组合第一个和二个

// 准备新接口和实现类
interface ThreeTVOpenAndClose{
    //准备两个抽象方法  默认抽象
     void open();
     void setTv(Tv tv);
}

//准备实现类
class ThreeOpenAndClose implements ThreeTVOpenAndClose{

    //准备成员
    private Tv tv;

    @Override
    public void open() {
        tv.play();
    }

    @Override
    public void setTv(Tv tv) {
        this.tv = tv;

    }
}
