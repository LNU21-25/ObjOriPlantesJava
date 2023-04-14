package assignmenttwo;

import java.util.Arrays;

/**
 * for adding defaults values and manipulation.
 */
public class SolarSystem {

  public Star sun;

  /**
   * creates default value for the solar system.
   */
  public SolarSystem() {
    sun = new Star("Sun", 696342);

    Planet earth = sun.addPlanet("Earth", 6371, 149600);
    earth.addMoon("Moon", 1737, 17370);

    Planet mars = sun.addPlanet("Mars", 3389, 227900);
    mars.addMoon("Phobos", 12, 12000);
    mars.addMoon("Deimos", 6, 6000);

    Planet jupiter = sun.addPlanet("Jupiter", 69911, 778500);
    jupiter.addMoon("Io", 1821, 18210);
    jupiter.addMoon("Europa", 1560, 15600);
    jupiter.addMoon("Ganymede", 2634, 26340);
    jupiter.addMoon("Callisto", 2410, 24100);

    Planet saturn = sun.addPlanet("Saturn", 58232, 582320);
    saturn.addMoon("Mimas", 198, 1980);
    saturn.addMoon("Enceladus", 252, 2520);
    saturn.addMoon("Tethys", 533, 5330);
    saturn.addMoon("Dione", 561, 5610);
    saturn.addMoon("Rhea", 764, 7640);
    saturn.addMoon("Titan", 2575, 25750);
  }
  /**
   * prints the solar system.
   * @return toprint
   */
  public String getSunPlanetMoon() {
    String ret = "";
    for (HeavenlyBody hb : sun.getHeavenlyBodies()) {
      if (hb != null) {
        ret += hb.hbString() + "\n";
    }
    }
    return ret;
  }


  /**sorts the objects and prints them.

   * @return toprint
   */
  public String getOrderInHeaven() {
    HeavenlyBody[] hb = sun.getHeavenlyBodies();
    HeavenlyBody[] finish = new HeavenlyBody[hb.length];
    int loc = 0;
    for (HeavenlyBody test : hb) {
      if (!(test == null)) {
        finish[loc] = test;
        loc++;
      }
    }
    HeavenlyBody[] sorted = new HeavenlyBody[loc];
    System.arraycopy(finish, 0, sorted, 0, loc);
    Arrays.sort(sorted, HeavenlyBody::compareTo);
    String ret = "";
    for (HeavenlyBody body : sorted) {
      if (body != null) {
        ret += body.toOrderString() + "\n";
      }
    }
    return ret;
  }

}
