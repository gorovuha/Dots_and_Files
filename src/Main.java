import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        /* задание 1
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число: ");
        double x = scanner.nextDouble();
        System.out.println("Введенное число деленное на два: " + (x / 2));

        System.out.println("Введите ваше имя, фамилию и отчество через пробел: ");
        String name = scanner.next();
        String surname = scanner.next();
        String name2 = scanner.next();
        System.out.println("Введенное имя: " + name + ", фамилия: " + surname + ", отчество: " + name2);
        */


        /* задание 2
        File file = new File("H:\\Для прогр.txt");     //здесь могут быть проблемы.... дело в кодировке файла. Нужно открыть nopade++ и сохранить файл в кодировке UTF-8 без BOM//// или нужно не использовать русские буквы
        Scanner scanner = new Scanner(file);

        double x = scanner.nextDouble();
        String name = scanner.next();
        String surname = scanner.next();
        String name2 = scanner.next();
        System.out.println("Введенное имя: " + name + ", фамилия: " + surname + ", отчество: " + name2);
        System.out.println("Введенное число деленное на два: " + (x / 2));
        */

        /* задание 3-4
        FileDialog dialog = new FileDialog((Frame) null);
        dialog.setVisible(true);                  // Показали окно и данный вызов не завершиться, пока пользователь не выберет файл или не закроет окно
        String directory = dialog.getDirectory(); // Узнали папку выбранную пользователем (может быть null)
        String filename = dialog.getFile();       // Узнали файл выбранный пользователем (может быть null)
        dialog.dispose();                         // Сказали что все ресурсы связанные с диалоговым окном можно освободить
        if (directory == null || filename == null) {
            System.out.println("Файл не выбран!");
            return;
        }
        String path = directory + filename;       // Сложив папку и название файла - получает полный путь к файлу
        System.out.println("Выбранный файл: " + path);

        File file = new File(path);
        Scanner scanner = new Scanner(file);

        double x = scanner.nextDouble();
        String name = scanner.next();
        String surname = scanner.next();
        String name2 = scanner.next();
        System.out.println("Введенное имя: " + name + ", фамилия: " + surname + ", отчество: " + name2);
        System.out.println("Введенное число деленное на два: " + (x / 2));
        */


        // Создаем окно
        JFrame frame = new JFrame();

        // Создаем нашу основную панель, в которой будет нарисовано что-то красивое
        MyPanel panel = new MyPanel();


        JButton kn = new JButton("сохранить");



        kn.addActionListener(new MyActionListener(panel));




        // Создаем панель, в которой будт лежать кнопка
        JPanel controls = new JPanel();
        // Настраиваем layout этой панели
        controls.setLayout(new GridLayout(1, 1));
        // Добавляем кнопки
        controls.add(kn);

        frame.add(panel, BorderLayout.CENTER);  // по центру будет панель рисующая красоту
        frame.add(controls, BorderLayout.NORTH); // справа будет панель с управлением
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);




        //ДЛЯ ВЫБОРА ФАЙЛА, ОТКУДА ВОЗЬМЁМ НАЧАЛЬНЫЕ ТОЧКИ, ЧЕРЕЗ ДИАЛОГОВОЕ ОКНО
        FileDialog dialog = new FileDialog((Frame) null);
        dialog.setVisible(true);                  // Показали окно и данный вызов не завершиться, пока пользователь не выберет файл или не закроет окно
        String directory = dialog.getDirectory(); // Узнали папку выбранную пользователем (может быть null)
        String filename = dialog.getFile();       // Узнали файл выбранный пользователем (может быть null)
        dialog.dispose();                         // Сказали что все ресурсы связанные с диалоговым окном можно освободить
        if (directory == null || filename == null) {
            System.out.println("Файл не выбран!");
            return;
        }
        String path1 = directory + filename;       // Сложив папку и название файла - получает полный путь к файлу
        //----------------

        File file = new File(path1);
        Scanner scanner = new Scanner(file);




        while (scanner.hasNextInt()) {        // = пока (больше нечего считывать)
           int a = scanner.nextInt();          //считывание для x
           int b = scanner.nextInt();          //считывание для x

            panel.x.add (a);                  //добавляем считанные координаты в ArrayList
            panel.y.add (b);


        }




        panel.addMouseListener(new MyMouseListener (panel));



       while (true) {          //обновляем панель
            panel.repaint();
            Thread.sleep(10);
        }




    }
}
