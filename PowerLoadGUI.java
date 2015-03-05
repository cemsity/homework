
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
									 "Retractable Gear Smooth"	};

  private JTextField	tfVmax;
  private JComboBox cbAircraftType;
  private JLabel lblAircraftType;
  private JLabel lblPowerLoad;
  private JButton	bCalc;

  public	PowerLoadGUI()
  {
	 setLayout(	new GridLayout(3,4, 2,2	) );

	 add(	new JLabel(	"V Max" ) );

	 tfVmax = new JTextField();
	 add(	tfVmax );

	 add(	new JLabel("")	);

	 cbAircraftType =	new JComboBox(	AIRCRAFT_TYPES	);
	 cbAircraftType.addItemListener(	new ComboHandler() );

	 add(	cbAircraftType	);

	 add(	new JLabel("")	);
	 add(	new JLabel("")	);
	 add(	new JLabel("")	);
	 add(	new JLabel("")	);

	 lblAircraftType = new JLabel( AIRCRAFT_TYPES[0] );
	 add(	lblAircraftType );

	 lblPowerLoad =  new	JLabel( "0"	);
	 add(	lblPowerLoad );

	 add(	new JLabel(	"W/hp" )	);

	 bCalc =	new JButton("Calculate");
	 bCalc.addActionListener( new	ButtonHandler());
    add(bCalc);

  }//	constructor
	public void	genEvent()
	{
	double vmax	= Double.parseDouble( tfVmax.getText()	);
		PowerLoad pl =	new PowerLoad(	vmax );
		double powerLoad = -1;

		switch( cbAircraftType.getSelectedIndex()	)
		{
		  case 0: // fixed gear	aluminum
			 powerLoad = pl.fixedGearAluminum();
			 break;
		  case 1: // Retractable Gear	Aluminum",
			 powerLoad = pl.rgnd();
			 break;
		  case 2: // fixed gear	smooth
			 powerLoad = pl.fixedGearSmooth();
			 break;
		  case 3:
			 powerLoad = pl.rgsd();
			 break;
		  default:
			 powerLoad = 100;
		}// end switch

		lblPowerLoad.setText( Double.toString (powerLoad) );
	 }
  


  private class ComboHandler implements ItemListener
  {
	 public void itemStateChanged( ItemEvent e )
	 {
		genEvent();

	 }// end	ItemStateChanged

  }//	end combo handler

  private class ButtonHandler	implements ActionListener
  {
	  public	void actionPerformed(ActionEvent	e)
	  {
			genEvent();
	  }



  }//end	ButtonHandler
}
