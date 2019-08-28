import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

    MyPanel panel;

    public MyMouseListener(MyPanel panel) {
        this.panel = panel;

    }


    @Override
    public void mouseExited(MouseEvent e){         //нужно реализовывать все 6 методов!!!! иначе не заработает!

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    public void mouseClicked (MouseEvent e) {
        panel.x.add(e.getX());
        panel.y.add(e.getY());
    }
}
