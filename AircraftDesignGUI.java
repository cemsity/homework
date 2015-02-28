// Demonstrating JTabbedPane.
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class AircraftDesignGUI extends JFrame
{
   // set up GUI
   public AircraftDesignGUI()
   {
      super( "Aircraft Design" );
      JTabbedPane tabbedPane = new JTabbedPane(); // create JTabbedPane

      tabbedPane.addTab( "Power Loading", null, new PowerLoadingGUI(), "Power Loading Panel" );

      add( tabbedPane ); // add JTabbedPane to frame
      
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      setSize( 250, 200 ); // set frame size
      setVisible( true ); // display frame

   } // end JTabbedPaneFrame constructor

   public static void main( String args[] )
   {
      AircraftDesignGUI acg = new AircraftDesignGUI();
   } // end main

} // end class JTabbedPaneFrame