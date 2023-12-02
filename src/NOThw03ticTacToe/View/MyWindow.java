package NOThw03ticTacToe.View;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.GREEN;

public class MyWindow {
    public MyWindow(String name, int size) {
        this.name = name;
        this.size = size;
    }

    private String name;
    private int size;


    public static JFrame createWindow (String name, int size) {
        JFrame window = new JFrame(name); // главное окно
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //кнопка закрытия
        window.setSize(size, size);
        window.setLayout(new BorderLayout()); // менеджер компоновки
        window.setLocationRelativeTo(null); // центрирование окна на экране
        window.setVisible(true);//видимость окна
        window.getContentPane().setBackground(GREEN);
        return window;
    }




}
