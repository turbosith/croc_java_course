package ru.croc.task19;

import java.awt.*;

import javax.swing.*;

public class Window extends JFrame {

    private Image img;

    /**
     * Создаёт окно и выводит надпись
     */
    public Window() {
        setSize(230, 190);
        setTitle("Привет мир!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        JLabel label = new JLabel("Hello, world!");
        getContentPane().add(label, BorderLayout.NORTH);
        setVisible(true);

    }

    /**
     * Загружает изображение из файла
     *
     * @param imagePath - путь до изображения
     */
    public void loadImage(String imagePath) {
        img = new ImageIcon(imagePath).getImage();
        if (img == null) System.out.println("Нет изображения");
    }

    /**
     * Выводит изображение на окно
     */
    public void drawIcon() {
        Graphics g = getGraphics();
        g.drawImage(img, 0, 50, null);
    }
}
