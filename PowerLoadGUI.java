
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

import java.awt.FlowLayout;

public class PowerLoadGUI extends JPanel
{
  private final String[] AIRCRAFT_TYPES = 
                           {"Fixed Gear Aluminum",
                            "Retractable Gear Aluminum",
                            "Fixed Gear Smooth",
                            "Retractable Gear Smooth" };
                            
  private JTextField tfVmax;
  private JComboBox cbAircraftType;
  private JLabel lblAircraftType;
  private JLabel lblPowerLoad;
  private JButton bCalc;
  
  public PowerLoadGUI()
  {
    setLayout( new GridLayout(3,4, 2,2 ) );
    
    add( new JLabel( "V Max" ) );
    
    tfVmax = new JTextField(); 
    add( tfVmax );
    
    add( new JLabel("") );
    
    cbAircraftType = new JComboBox( AIRCRAFT_TYPES );
    cbAircraftType.addItemListener( new comboHandler() );
    
    add( cbAircraftType );
    
    add( new JLabel("") );
    add( new JLabel("") );
    add( new JLabel("") );
    add( new JLabel("") );
    
    lblAircraftType = new JLabel( AIRCRAFT_TYPES[0] );
    add( lblAircraftType );
    
    lblPowerLoad =  new JLabel( "0" );
    add( lblPowerLoad );
    
    add( new JLabel( "W/hp" ) );

  }// constructor
  
  private class comboHandler implements ItemListener
  {
    public void itemStateChanged( ItemEvent e )
    {
      double vmax = Double.parseDouble( tfVmax.getText() );
      PowerLoad pl = new PowerLoad( vmax );
      double powerLoad = -1;
      
      switch( cbAircraftType.getSelectedIndex() ) 
      {
        case 0: // fixed gear aluminum
          powerLoad = pl.fixedGearAluminum();
          break;
        case 1: // fixed gear composite
          powerLoad = pl.fixedGearSmooth();
          break;
        case 2: // retract alum
          powerLoad = pl.rgnd();
        case 3:
          powerLoad = pl.rgsd();
        default:
      }// end switch
      
      lblPowerLoad.setText( Double.toString (powerLoad) );
    }
  }// end handler
  
}