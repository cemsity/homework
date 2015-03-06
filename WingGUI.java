
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


public class WingGUI extends JPanel
{

//fields
private String[]     altidude = {"0", "1000", "2000", "3000", "4000", "5000", "6000", "7000", "8000", "9000", "10000", 
                                 "11000", "12000", "13000", "14000", "15000", "16000", "17000", "18000", "19000", "20000"};
                                 
                                 
                       
private JTextField   tfSpan, tfChord, tfVCruise, tfVStall, tfCLiftMax, tfCLiftCruise; 
private JLabel       lblSpan, lblChord, lblVCruise, lblVStall, lblCLiftMax, lblCLiftCruise, lblAltTO, lblAltCruise; 
private JLabel       lblWingArea, lblDynamicPressCruise, lblDynamicPressStall;
                     
private JComboBox    cbAltTOSelector, cbAltCruiseSelector;

private JRadioButton rbStandard; 
private JRadioButton rbHot; 

private ButtonGroup radioGroup; // buttongroup to hold radio buttons


private JButton      bCalc;


// constructor
public WingGUI()
{
setLayout( new GridLayout( 7, 5, 2,2));

add( new JLabel( "Span"));
tfSpan = new JTextField();
add (tfSpan);
add( new JLabel( ""));

add( new JLabel( "Chord"));
tfChord = new JTextField();
add (tfChord);

add( new JLabel( "Cruise Velocity"));
tfVCruise = new JTextField();
add (tfVCruise);
add( new JLabel( ""));

add( new JLabel( "Stall Velocity"));
tfVStall = new JTextField();
add (tfVStall);

add( new JLabel( "C Lift Max"));
tfCLiftMax = new JTextField();
add (tfCLiftMax);
add( new JLabel( ""));

add( new JLabel( "C Lift at Cruise"));
tfCLiftCruise = new JTextField();
add (tfCLiftCruise);

add( new JLabel( "Take Off Altitude"));

cbAltTOSelector =	new JComboBox(	altidude	);
add(cbAltTOSelector);
add( new JLabel( ""));
add( new JLabel( ""));
add( new JLabel( ""));

add( new JLabel( "Cruise Altitude"));
cbAltCruiseSelector =	new JComboBox(	altidude	);

add (cbAltCruiseSelector);
add( new JLabel( ""));
add( new JLabel( ""));
add( new JLabel( ""));

add( new JLabel( "Day Time Temp"));
rbStandard = new JRadioButton( "Standard Day", true );
rbHot = new JRadioButton( "Hot Day", false );
add(rbStandard);
add(rbHot);
radioGroup = new ButtonGroup();
radioGroup.add(rbStandard);
radioGroup.add(rbHot);

add( new JLabel( ""));

bCalc = new JButton("Calculate");
bCalc.addActionListener(new ButtonHandler());
add(bCalc);

//lblWingArea, lblDynamicPressCruise, lblDynamicPressStall;
lblWingArea = new JLabel("Wing Area");
add(lblWingArea);
lblDynamicPressCruise = new JLabel("Cruising Dynamic Pressure");
add(lblDynamicPressCruise);
lblDynamicPressStall = new JLabel("Stalling Dynamic Pressure");
add(lblDynamicPressStall);





}//end constructor



//methods

//private class
private class ButtonHandler	implements ActionListener
  {
	  public	void actionPerformed(ActionEvent	e)
	  {
			tfSpan.setText( "" + cbAltCruiseSelector.getSelectedIndex() ) ;
     }



  }//end	ButtonHandler







}// end class