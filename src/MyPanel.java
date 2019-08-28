import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {


    ArrayList <Integer> x = new ArrayList <Integer> ();    //добавляем массив, который автоматически растягивается до нужнх размеров
    ArrayList <Integer> y = new ArrayList <Integer> ();


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);




        for (int i = 0; i < x.size(); i += 1) {
            g.drawOval(x.get(i), y.get(i), 2, 2);   //рисуем точки (новые и все предыдущие)
        }

    }
}
