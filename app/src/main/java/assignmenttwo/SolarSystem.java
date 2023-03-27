package assignmenttwo;

import java.util.Arrays;

/**
 * for adding defaults values and manipulation.
 */
public class SolarSystem {

  /**
   * creates default value for the solar system.
   */
  public SolarSystem() {
    Planet pl1 = new Planet("earth", 1737, 17370);
    Moon mo1 = new Moon("moon", 1737, 17370);
    pl1.addMoon(mo1);

    Planet pl2 = new Planet("mars", 3389, 33890);
    Moon mo2 = new Moon("phobos", 12, 120);
    Moon mo3 = new Moon("deimos", 6, 60);
    pl2.addMoon(mo2);
    pl2.addMoon(mo3);

    Planet pl3 = new Planet("jupiter", 69911, 699110);
    Moon mo4 = new Moon("io", 1821, 18210);
    Moon mo5 = new Moon("europa", 1560, 15600);
    Moon mo6 = new Moon("ganymede", 2634, 26340);
    Moon mo7 = new Moon("callisto", 2410, 24100);
    pl3.addMoon(mo4);
    pl3.addMoon(mo5);
    pl3.addMoon(mo6);
    pl3.addMoon(mo7);

    Planet pl4 = new Planet("saturn", 58232, 582320);
    Moon mo8 = new Moon("mimas", 198, 1980);
    Moon mo9 = new Moon("encaladus", 252, 2520);
    Moon mo10 = new Moon("tethys", 533, 5330);
    Moon mo11 = new Moon("dione", 561, 5610);
    Moon mo12 = new Moon("rhea", 764, 7640);
    Moon mo13 = new Moon("titan", 2575, 25750);
    pl4.addMoon(mo8);
    pl4.addMoon(mo9);
    pl4.addMoon(mo10);
    pl4.addMoon(mo11);
    pl4.addMoon(mo12);
    pl4.addMoon(mo13);

    Star st1 = new Star("Sun", 696342);
    st1.addPlanet(pl1);
    st1.addPlanet(pl2);
    st1.addPlanet(pl3);
    st1.addPlanet(pl4);

    System.out.println(st1.toString());
    HeavenlyBody[] hbs = st1.getHeavenlyBodies();
    if (hbs != null && hbs.length > 0) {
      System.out.println(orderInHeaven(hbs));
    }
  }

  /**sorts the objects and prints them.

   * @param hb heavenly bodies
   * @return toprint
   */
  public String orderInHeaven(HeavenlyBody[] hb) {
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
    System.err.println("SORTING");
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
