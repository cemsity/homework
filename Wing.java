public class Wing{

	private double	span;						//in feet
	private double	chord;					//in feet

														 //cold 0  // hot	1
	private double[][] rho = new double[][] {{0.00238,	0.00226}, //0
														  {0.00231,	0.00220}, //1
														  {0.00224,	0.00214}, //2
														  {0.00218,	0.00208}, //3
														  {0.00211,	0.00202}, //4
														  {0.00205,	0.00196}, //5
														  {0.00199,	0.00191}, //6
														  {0.00193,	0.00185}, //7
														  {0.00187,	0.00180}, //8
														  {0.00181,	0.00175}, //9
														  {0.00176,	0.00170}, //10
														  {0.00170,	0.00165}, //11
														  {0.00165,	0.00160}, //12
														  {0.00160,	0.00155}, //13
														  {0.00155,	0.00150}, //14
														  {0.00150,	0.00146}, //15
														  {0.00145,	0.00141}, //16
														  {0.00140,	0.00137}, //17
														  {0.00136,	0.00133}, //18
														  {0.00131,	0.00129}, //19
														  {0.00127,	0.00125}};//20   units are in slugs
	private double	vCruise;					//in fps
	private double	vStall;					//in fps
	private double	cLiftMax;				//
	private double	cLiftCruise;			//	found	in	the the and	dimentionless
	private int	altitudeTO;				//index for	rho
	private int	altitudeCruise;		//index for	rho
	private int	dayTemp;             //index for rho

	public Wing(double spn,	double crd,	double vc, double	vs, double clm, double clc, int ato, int ac,	int dt)	 //constructor
	{

		span = spn;						//in feet
		chord	= crd;
		vCruise = knotToFeet(vc);				  //in fps
		vStall =	knotToFeet(vs);				  //in fps
		cLiftMax	= clm;				//
		cLiftCruise	= clc;			//	found	in	the the and	dimentionless
		altitudeTO = ato;				//index for	rho
		altitudeCruise	= ac;		  //index for rho
		dayTemp = dt;              //index for rho
	}

	//	accsessors/getters
	public double getSpan()
	{
		return span;
	}

	public double getChord()
	{
		return chord;
	}

	public double getRho(int alt,	int temp)
	{
		return rho[alt][temp];
	}


	//	mutators	\ setters

	public void	setSpan(double	newSpan)
	{
		span = newSpan;
	}

	public void	setChord(double newChord)
	{
		chord	= newChord;
	}

	public void	setCLiftMax(double newCLiftMax)
	{
		cLiftMax	= newCLiftMax;
	}


	public void	setCLiftCruise(double newCLiftCruise)
	{
		cLiftCruise	= newCLiftCruise;
	}


	//methods
	public double knotToFeet(double knots)
	{
		return knots *	1.68781;
	}

	public double wingArea()
	{
		return chord*span;
	}

	public double dynamicPressCruise(int alt,	int temp)  //dynamic	pressure	for cruise
	{
		return (0.5) *	this.rho[alt][temp] * (vCruise *	vCruise);
	}

	public double dynamicPressStall(int	alt, int	temp)	 //dynamic pressure for	stall
	{
		return (1/2) *	this.rho[alt][temp] * (vStall	* vStall);
	}


	public double totalLift(int alt,	int temp, boolean	dPress, boolean cLift)	  // in lbs  true = cruise variable false is the other
	{
		if	(dPress)
		{
		  if (cLift)
			{
				return wingArea()	* dynamicPressCruise( alt,	temp)* cLiftCruise;
			}
		 else
		   {
			   return wingArea()	* dynamicPressCruise( alt,	temp)* cLiftMax;
		   }
		  
		}
		else
		{
			if (cLift)
			{
				return wingArea()	* dynamicPressStall( alt, temp)* cLiftCruise;
			}
		 else
		   {
			   return wingArea()	* dynamicPressStall ( alt, temp)* cLiftMax;
		   }
		  
		}
	}

	public double wingLoad (int alt,	int temp, boolean	dPress, boolean cLift )
	{
		return totalLift(alt, temp, dPress, cLift)/ wingArea();

	}
}