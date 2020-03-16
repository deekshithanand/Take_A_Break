import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TakeBreak{


    public int timeInterval;
    void setTimeInterval(){
        System.out.println("Enter the time interval to be notified in minutes:");
        Scanner sc = new Scanner(System.in);
        this.timeInterval = sc.nextInt();
        sc.close();
    }    

    public static void main(String[] args) throws AWTException,InterruptedException{
        if (SystemTray.isSupported()) {
            TakeBreak td = new TakeBreak();
            td.setTimeInterval();
            while(true){
                TimeUnit.MINUTES.sleep(td.timeInterval);
            td.displayTray();
            
            }
        } else {
            System.err.println("System tray not supported!");
        }
    }

     void displayTray() throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image,"Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        tray.add(trayIcon);
       

        trayIcon.displayMessage("Hello, World", "notification demo", MessageType.INFO);
    }
}

