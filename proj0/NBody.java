public class NBody {
    /**Reads the radius of the universe*/
    /** Simpler demo of the In class. */
    public static double readRadius(String filename) {
        In in = new In(filename);

        /* Every time you call a read method from the In class,
         * it reads the next thing from the file, assuming it is
         * of the specified type. */

        int N = in.readInt();
        double R = in.readDouble();
        double xPos;
        double yPos;
        double xVel;
        double yVel;
        double mass;
        String img;

        return R;
    }

    /**reads amount of planets*/
    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);

        /* Every time you call a read method from the In class,
         * it reads the next thing from the file, assuming it is
         * of the specified type. */

        int N = in.readInt();
        double R = in.readDouble();
        double xPos;
        double yPos;
        double xVel;
        double yVel;
        double mass;
        String img;
        Planet[] Planets = new Planet[N];
        for (int i = 0; i < N; i++) { //for every planet
            xPos = in.readDouble();
            yPos = in.readDouble();
            xVel = in.readDouble();
            yVel = in.readDouble();
            mass = in.readDouble();
            img = in.readString();
            Planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, img);
            //don't need to skip anymore, R and N only appear once.
        }
        return Planets;
    }

    /**main function draws the universe*/
    public static void main(String[] args) {
        double time = 0;
        //0th and 1st command line arguments as doubles named T and dt. convert the strings to dfoubles
        //2nd command line argument is a string called filename
        //read in the planets and the universe radius from the file described by filename using your methods
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        System.out.println(dt);
        String filename = args[2];

        double R = readRadius(filename);
        Planet[] Planets = readPlanets(filename);

        double x0 = 0;
        double x1 = R;
        double y0 = 0;
        double y1 = R;
        //set scale so it matches the radius of the universe
        StdDraw.setXscale(x0, x1);
        StdDraw.setYscale(y0, y1);
        //draw image starfield.jpg as the bacgrkound
        StdDraw.enableDoubleBuffering();



        while (time <= T) { //until time = T
            double[] xForces= new double[Planets.length];
            double[] yForces = new double[Planets.length];

            for(int i = 0; i < Planets.length; i++) {
                yForces[i] = Planets[i].calcNetForceExertedByY(Planets);
                xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
            }

            for(int i = 0; i < Planets.length; i++) {
                Planets[i].update(time, xForces[i], yForces[i]);
            }

            //drawing background and all planets
            StdDraw.picture(R/2, R/2, "images/starfield.jpg");
            for(int i = 0; i < Planets.length; i++) {
                Planets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", R);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                    Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }

    }
}
