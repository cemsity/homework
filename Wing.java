public class Wing{

   private double span;                //in feet
   private double chord;               //in feet
   
                                           //cold 0  // hot 1
   private double[][] rho = new double[][] {{0.00238,	0.00226},
                                            {0.00231,	0.00220},
                                            {0.00224,	0.00214},
                                            {0.00218,	0.00208},
                                            {0.00211,	0.00202},
                                            {0.00205,	0.00196},
                                            {0.00199,	0.00191},
                                            {0.00193,	0.00185},
                                            {0.00187,	0.00180},
                                            {0.00181,	0.00175},
                                            {0.00176,	0.00170},
                                            {0.00170,	0.00165},
                                            {0.00165,	0.00160},
                                            {0.00160,	0.00155},
                                            {0.00155,	0.00150},
                                            {0.00150,	0.00146},
                                            {0.00145,	0.00141},
                                            {0.00140,	0.00137},
                                            {0.00136,	0.00133},
                                            {0.00131,	0.00129},
                                            {0.00127,	0.00125}};             //slugs
   private double vCruise;             //in fps
   private double vStall;              //in fps
   private double cLiftMax;            //
   private double cLiftCruise;         // found in the the and dimentionless
   private int altitudeTO;          //index for rho
   private int altitudeCruise;      //index for rho
   private int dayTemp;

   public Wing(double span, double chord, double vCruise, double vStall, double clm, double clc, int ato, int ac, int dt)   //constructor
   {
   
      span = span;                //in feet
      chord = chord;
      vCruise = knotToFeet(vCruise);             //in fps
      vStall = knotToFeet(vStall);              //in fps
      cLiftMax = clm;            //
      cLiftCruise = clc;         // found in the the and dimentionless
      altitudeTO = ato;          //index for rho
      altitudeCruise = ac;      //index for rho
      dayTemp = dt;
   }
   
   // accsessors/getters
   public double getSpan()
   {
      return span;
   }
   
   public double getChord()
   {
      return chord;
   }
   
   public double getRho(int alt, int temp)
   {
      return rho[alt][temp];
   }
   
   
   // mutators \ setters

   public void setSpan(double newSpan)
   {
      span = newSpan;
   }
   
   public void setChord(double newChord)
   {
      chord = newChord;
   }
   
   public void setCLiftMax(double newCLiftMax)
   {
      cLiftMax = newCLiftMax;
   }
            
        
   public void setCLiftCruise(double newCLiftCruise)
   {
      cLiftCruise = newCLiftCruise;
   }
   
   
   //methods
   public double knotToFeet(double knots)
   {
      return knots * 1.689;
   }

   public double wingArea()
   {
      return chord*span;
   }

   public double dynamicPressCruise(int alt, int temp)  //dynamic pressure for cruise
   {
      return (1/2) * rho[alt][temp] * (vCruise * vCruise);
   }
 
   public double dynamicPressStall(int alt, int temp)  //dynamic pressure for stall
   {
      return (1/2) * rho[alt][temp] * (vStall * vStall);
   }
   
   
   public double totalLift(int alt, int temp, boolean cruise)    // in lbs
   {
      if (cruise)
      {
         return wingArea() * dynamicPressCruise( alt, temp)* cLiftCruise;
      }
      else
      {
         return wingArea() * dynamicPressCruise( alt, temp)* cLiftMax;
      }
   }

   public double wingLoad (int alt, int temp, boolean cruise)
   {
      return totalLift(alt, temp, cruise)/ wingArea();
      
   }
}