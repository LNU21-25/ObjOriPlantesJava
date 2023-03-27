package assignmenttwo;

import java.util.Arrays;

/**
 * defines a planet object.
 */
public class Planet extends HeavenlyBody {

  public Moon[] moons = new Moon[8];
  private int avgOrbitRadiusInKm;

  /**
   * creates a planet.

   * @param planetName         planet name
   * @param avgRadiusInKm      radius
   * @param avgOrbitRadiusInKm orbit
   */
  public Planet(String planetName, int avgRadiusInKm, int avgOrbitRadiusInKm) {
    super(planetName, avgRadiusInKm);
    try {
      planetName.length();
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid moon");
    }
    if (planetName.equals("") || avgRadiusInKm < 2000 
        || avgRadiusInKm > 200000 || avgOrbitRadiusInKm < 18000 
        || avgOrbitRadiusInKm > 200000) {
      throw new IllegalArgumentException("Invalid planet");
    }
    this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
  }

  /**
   * creates a planet.

   * @param planetName    planet name
   * @param avgRadiusInKm radius
   */
  public Planet(String planetName, int avgRadiusInKm) {
    super(planetName, avgRadiusInKm);
    try {
      planetName.length();
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid moon");
    }
    if (planetName.equals("") || avgRadiusInKm < 2000 || avgRadiusInKm > 200000) {
      throw new IllegalArgumentException("Invalid planet");
    }
  }

  /**
   * creates a planet.

   * @param p planet
   */
  public Planet(Planet p) {
    super(p.getName(), p.getAvgRadiusInKm());
    try {
      p.getName().length();
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid moon");
    }
    if (p.getName().equals("") 
        || p.getAvgRadiusInKm() < 2000 || p.getAvgRadiusInKm() > 200000) {
      throw new IllegalArgumentException("Invalid planet");
    }
    this.avgOrbitRadiusInKm = p.avgOrbitRadiusInKm;
  }

  /**
   * adds a moon to this planet.

   * @param moonName           name
   * @param avgRadiusInKm      int
   * @param avgOrbitRadiusInKm double
   * @throws Exception bruh
   */
  public Moon addMoon(String moonName, int avgRadiusInKm, int avgOrbitRadiusInKm) {
    try {
      moonName.length();
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid moon");
    }
    if (avgRadiusInKm < 50 || avgRadiusInKm > 5000) {
      throw new IllegalArgumentException("Invalid moon");
    }
    Moon newMoon = new Moon(moonName, avgRadiusInKm, avgOrbitRadiusInKm);
    addMoon(newMoon);
    return newMoon;
  }

  /**
   * adds a moon.

   * @param m moon
   */
  public void addMoon(Moon m) {
    Moon[] temp = new Moon[moons.length + 2];
    int loc = 0;
    for (Moon mo : moons) {
      temp[loc] = mo;
      loc++;
    }
    temp[loc] = m;
    moons = Arrays.copyOfRange(temp, 0, loc + 1);
  }
  

  /**
   * gets sub-bodies.

   * @return HeavenlyBody[] bods
   */
  public HeavenlyBody[] getHeavenlyBodies() {
    HeavenlyBody[] ret = new HeavenlyBody[100];
    int loc = 1;
    ret[0] = new Planet(this);
    for (Moon m : moons) {
      if (!(m == null)) {
        ret[loc] = new Moon(m);
        loc++;
      }
    }
    ret = Arrays.copyOfRange(ret, 0, loc);
    return ret;
  }

  /**
   * gets the tostring.

   * @return String tostring
   */
  public String toString() {
    String ret = "\tPlanet: " + getName() + ", average radius "
        + getAvgRadiusInKm() + "km, average orbit radius " + avgOrbitRadiusInKm + "km\n\n";
    for (Moon m : moons) {
      if (!(m == null)) {
        ret += "\t\t" + m.toString() + "\n";
      }
    }
    return ret;
  }

  /**
   * gets the average orbit radius.

   * @return int avgOrbitRadiusInKm
   */
  public int getAvgOrbitRadiusInKm() {
    return avgOrbitRadiusInKm;
  }
}
