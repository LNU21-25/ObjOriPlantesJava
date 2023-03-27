package assignmenttwo;

import java.util.Arrays;

/**
 * defines an abstract heavenlybody.
 */
public class Star extends HeavenlyBody {

  private Planet[] planets = new Planet[0];

  /**creates a star.

   * @param name name
   * @param avgRadiusInKm radius
   * @throws Exception only if invalid input
   */
  public Star(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
    try {
      name.length();
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid moon");
    }
    if (name.equals("") || avgRadiusInKm <  150000) {
      throw new IllegalArgumentException("Invalid moon");
    }
  }

  /**creates a star.

   * @param s star
   */
  public Star(Star s) {
    super(s.getName(), s.getAvgRadiusInKm());
    try {
      s.getName().length();
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid moon");
    }
    this.planets = s.planets;
  }

  /**
   * addPlanet adds a planet to the solar system.

   * @param planetName string
   * @param avgRadiusInKm int
   * @param avgOrbitRadiusInKm int
   */
  public Planet addPlanet(String planetName, int avgRadiusInKm, int avgOrbitRadiusInKm) {
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
    Planet newPlanet = new Planet(planetName, avgRadiusInKm, avgOrbitRadiusInKm);
    addPlanet(newPlanet);
    return newPlanet;
  }

  /**adds a planet.

   * @param p planet
   */
  public void addPlanet(Planet p) {
    Planet[] temp = new Planet[planets.length + 2];
    int loc = 0;
    for (Planet pl : planets) {
      temp[loc] = pl;
      loc++;
    }
    temp[loc] = p;
    planets = Arrays.copyOfRange(temp, 0, loc + 1);
  }


  /**
   * gets an array of the child heavenly bodies.

   * @return HeavenlyBody[] heavenlybodies.
   */
  public HeavenlyBody[] getHeavenlyBodies() {
    HeavenlyBody[] ret = new HeavenlyBody[100];
    int loc = 1;
    ret[0] = new Star(this);
    for (Planet p : planets) {
      ret[loc] = new Planet(p);
      loc++;
      HeavenlyBody[] pheavenly = p.getHeavenlyBodies();
      pheavenly = Arrays.copyOfRange(pheavenly, 1, pheavenly.length);
      for (HeavenlyBody m : pheavenly) {
        ret[loc] = m;
        loc++;
      }
    }
    ret = Arrays.copyOfRange(ret, 0, loc);
    return ret;
  }

  /**
   * gets the toString for this star.

   * @return String toString
   */
  public String toString() {
    String ret = "Star: " + getName() + ", average radius " + getAvgRadiusInKm() + "km\n\n";
    for (Planet p : planets) {
      if (!(p == null)) {
        ret += p.toString() + "\n";
      } else {
        break;
      }
    }
    return ret;
  }
  
}
