public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    /** Planet Constructor. */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        //create an instance of the planet class
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /**Intitialises an identical planet object*/
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /**Calculates distance between 2 objects*/
    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double distance = Math.sqrt(dx*dx + dy*dy);
        return distance;
    }

    /**Calculates gravitational force between 2 objects*/
    public double calcForceExertedBy(Planet p) {
        double distance = this.calcDistance(p);
        double F = (G * p.mass * this.mass)/(distance * distance);
        return F;
    }

    /**Calculates X component of gravitational force between 2 objects*/
    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double F = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        double forceX = (F*dx)/r;
        return forceX;
    }

    /**Calculates Y component of gravitaton force between 2 objects*/
    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        double F = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        double forceY = (F*dy)/r;
        return forceY;
    }

    /**Calculates net Y force of an array of planets*/
    public double calcNetForceExertedByY(Planet[] allPlanets) {
        int size = allPlanets.length;
        double netForceY = 0;
        for (int i = 0; i < size; i++) {
            if (this.equals(allPlanets[i]) == false) {
                netForceY = netForceY + this.calcForceExertedByY(allPlanets[i]);
            }
        }
        return netForceY;
    }

    /**Calculates net X force of an array of planets*/
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        int size = allPlanets.length;
        double netForceX = 0;
        for (int i = 0; i < size; i++) {
            if (this.equals(allPlanets[i]) == false) {
                netForceX = netForceX + this.calcForceExertedByX(allPlanets[i]);
            }
        }
        return netForceX;
    }

    /**Determines:
     * How much the forces exerted on the planet will cause that planet to accelerate
     * Resulting change in the planet's velocity and position in period of time dt*/
    public void update(double dt, double fX, double fY) {
        /**movement of Planet consists of:
         * Calculate the acceleration using x- and y- forces
         * Calculate the new velocity by using the acceleration and current velocity
         * Calculate new position using velocity in step2 and the current position.*/
        double netAccX = fX/(this.mass);
        double netAccY = fY/(this.mass);
        double newVeloX = this.xxVel + (dt)*(netAccX);
        double newVeloY = this.yyVel + (dt)*(netAccY);
        double newPosX = this.xxPos + (dt)*(newVeloX);
        double newPosY = this.yyPos + (dt)*(newVeloY);
        this.xxVel = newVeloX;
        this.yyVel = newVeloY;
        this.xxPos = newPosX;
        this.yyPos = newPosY;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}

