
/**
 * Write a description of class Lyrics here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Lyrics
{
    ArrayList<String> lines;
    String filePath = new File("Lyrics.txt").getAbsolutePath();

    public Lyrics()
    {
        lines = new ArrayList<String>();
    }

    public void openFile() throws IOException
    {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while((line = br.readLine()) != null)
        {
            if(!line.equals("") && !line.toLowerCase().contains("chorus"))
                lines.add(line);
        }
    }

    public void printLyrics()
    {
        Scanner scan = new Scanner(System.in);
        String ans = "";
        for(int i = 0; i < lines.size(); i++)
        {
            System.out.print(lines.get(i));
            ans = scan.nextLine();
            System.out.print("\f");
        }
    }
}
