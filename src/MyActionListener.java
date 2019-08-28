import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MyActionListener implements ActionListener {

    MyPanel panel;


    public MyActionListener(MyPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //ДЛЯ ВЫБОРА ФАЙЛА ЧЕРЕЗ ДИАЛОГОВОЕ ОКНО
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
        //----------------


        File file =  new File (path);          //создаём файл, который был выбран выше
        PrintWriter out = null;
        try {
            out = new PrintWriter(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        for (int i = 0; i < panel.x.size(); i += 1) {                //записываем точки ф файл (file)
            out.println(panel.x.get(i) + " " + panel.y.get(i));
        }
        out.close();      //закрываем наш файл, чтобы закончить запись
    }
}
