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
}
