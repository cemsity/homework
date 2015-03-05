
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


public class WingGUI extends JPanel
{

//fields
private int[]        altidude = {0, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000, 13000, 14000, 15000, 16000, 17000, 18000, 19000, 20000};
private JTextField   tfSpan, tfChord, tfVCruise, tfVStall, tfCLiftMax, tfCLiftCruise; 
private JLabel       lblSpan, lblChord, lblVCruise, lblVStall, lblCLiftMax, lblCLiftCruise, lblAltTO, lblAltCruise; 
private JLabel       lblWingArea, lblDynamicPressCruise, lblDynamicPressStall;
private JComboBox    cbAltTOSelector, cbAltCruiseSelector;
private JButton      bCalc;


// constructor
public WingGUI()
{
setLayout( new GridLayout( 5, 5, 2, 2));

add( new JLabel( "Span");
add( new JLabel( "Span");
add( new JLabel( "Span");
add( new JLabel( "Span");
add( new JLabel( "Span");

}//end constructor



//methods

//private class







}// end class