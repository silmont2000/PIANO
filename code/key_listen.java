package code;//事件监听
//键盘事件监听，写了一个小案例，按上下左右，改变圆形的位置，圆形可以移动

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class key_listen extends JFrame {

    //设置面板
    Wdmb wdmb = new Wdmb();


    public static void main(String[] args) throws Exception {
        //实例化当前类
        key_listen index = new key_listen();
    }

    //自动执行
    public key_listen() {

        this.add(wdmb);


        //添加键盘监听事件
        this.addKeyListener(wdmb);

        this.setSize(500, 500);
        this.setLocation(300, 200);
        this.setTitle("绘图");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


}

//面板方法
class Wdmb extends JPanel implements KeyListener {

    int x = 50;
    int y = 50;
    int i = 50;

    //方法覆盖
    //JPanel自带方法,下面格式是固定的
    //paint 会在三种情况下自动被调用
    //1、启动程序  2、窗口大小发生变化时  3、运行repaint函数时
    public void paint(Graphics g) {
        //覆盖父类的方法
        super.paint(g);
        g.setColor(Color.black);
        g.fillOval(20, 20, i, i);
    }

    public void keyTyped(KeyEvent e) {
        //有字符输出函数
        System.out.println("按下了能输入内容的按键");
    }

    public void keyPressed(KeyEvent e) {
        //全部按键，响应
        System.out.println("键盘被按下，数字为：" + e.getKeyCode() + "，按键是：" + KeyEvent.getKeyText(e.getKeyCode()));

        new music_player(e);
        //方向键，上下左右
        if (e.getKeyCode() == 38) {
            //上
            y -= 10;
        } else if (e.getKeyCode() == 40) {
            //下
            y += 10;
        } else if (e.getKeyCode() == 37) {
            //左
            x -= 10;
        } else if (e.getKeyCode() == 39) {
            //右
            x += 10;
        }
        i += 1;

        //重新调用界面
        this.repaint();

    }

    public void keyReleased(KeyEvent e) {
        //按键抬起
    }


}