public class PowerLoad{
    private double vmax; // knots

    public PowerLoad( double vm)
    {
        this.vmax = vm;
    }

    public double pleq(double con, double exp) // power load equation
    {
        return con*Math.pow(vmax, exp);
    }

    public double fixedGearAluminum()    //fix gear normal Design
    {
        return pleq(215, -0.61);
    }

    public double rgnd()    //retractable gear normal Design
    {
        return pleq(276, -0.65);
    }

    public double fixedGearSmooth()   //fix gear smooth Design
    {
        return pleq(248, -0.61);
    }

    public double rgsd()    //retractable gear smooth Design
    {
        return pleq(680, -0.79);
    }

    public double acro()    //acrobatic
    {
        return pleq(172, -0.61);
    }

    public double ragWing()
    {
        return pleq(511, -0.75);
    }

    public double ultralight()
    {
        return pleq(325, -0.75);
    }
}