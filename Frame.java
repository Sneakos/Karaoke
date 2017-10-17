
/**
 * Write a description of class Frame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Frame extends JFrame implements KeyListener
{
    private static final int WIDTH = 1350, HEIGHT = 750;
    private final Dimension gameSize = new Dimension(WIDTH, HEIGHT);
    Line line;
    Lyrics lyrics;
    int ind;

    public Frame()
    {
        lyrics = new Lyrics();
        try {
            lyrics.openFile();
        } catch (IOException e){
            System.out.println("I dun goofed");
        }

        ind = 0;
        line = new Line("Don't Forget The Lyrics");
        createWindow();
    }

    private void createWindow() 
    {
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(gameSize);
        setLocationRelativeTo(null);

        addKeyListener(this);
        add(line);
        setPreferredSize(gameSize);
        setMinimumSize(gameSize);
        setMaximumSize(gameSize);
    }

    public void keyReleased(KeyEvent e){}

    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_ENTER)
        {
            if(ind < lyrics.lines.size())
            {
                String change = lyrics.lines.get(ind);
                line.changeText(change);
                ind++;
            } else
                line.changeText("End of Song");
        }
    }

    public void keyTyped(KeyEvent e){}
}
