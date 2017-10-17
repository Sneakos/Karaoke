
/**
 * Write a description of class Line here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import java.util.ArrayList;

public class Line extends JComponent
{
    String[] lines;
    int x, y, fontSize;
    Color col;
    int MAX = 25;
    int num;

    public Line(String lyrics)
    {
        lines = new String[5];
        for(int i = 0; i < lines.length; i++)
            lines[i] = "";
        splitLine(lyrics);
        x = 100;
        y = 350;
        fontSize = 100;
        col = Color.WHITE;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        draw(g2);
    }

    public void draw(Graphics2D g2)
    {
        g2.setFont(new Font("", Font.PLAIN, fontSize));
        g2.setColor(col);
        y -= 50*num;
        for(int i = 0; i < lines.length; i++)
            g2.drawString(lines[i], x, y + 100*i);
        y = 350;
    }

    public void changeText(String text)
    {
        splitLine(text);
        repaint();
    }

    public void splitLine(String line)
    {
        num = 0;
        int end = MAX;
        if(end > line.length())
            end = line.length();
        int start = 0;
        String add = "";
        for(int i = 0; end <= line.length(); i++)
        {
            while(!line.substring(end-1, end).equals(" ") && end < line.length())
            {
                end--;
            }
            add = line.substring(start, end);
            lines[i] = add;
            start = end;
            end += MAX;
            if(end > line.length() && end - line.length() < MAX) end = line.length();
            num++;
        }
        for(int i = num; i < lines.length; i++)
            lines[i] = "";
    }
}
