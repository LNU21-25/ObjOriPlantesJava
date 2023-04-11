package assignmenttwo;

import java.util.Arrays;

/**
 * defines an abstract heavenlybody.
 */
public class Star extends HeavenlyBody {

  private Planet[] planets = new Planet[0];

  /**
   * Creates a star with the specified name and radius.
   *
   * @param name          the star name
   * @param avgRadiusInKm the average radius in kilometers
   */
  public Star(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
    validateStar(name, avgRadiusInKm);
  }

  /**
   * Creates a star by copying the properties of the given star.
   *
   * @param s the star to copy
   */
  public Star(Star s) {
    super(s.getName(), s.getAvgRadiusInKm());
    validateStar(s.getName(), s.getAvgRadiusInKm());
    this.planets = s.planets;
  }

  /**
   * Validates the star name and radius.
   *
   * @param name          the star name
   * @param avgRadiusInKm the average radius in kilometers
   */
  private void validateStar(String name, int avgRadiusInKm) {
    if (name == null || name.isEmpty() || avgRadiusInKm < 150000) {
      throw new IllegalArgumentException("Invalid star: invalid name or radius");
    }
  }

  /**
   * addPlanet adds a planet to the solar system.
   * 
   * @param planetName         string
   * @param avgRadiusInKm      int
   * @param avgOrbitRadiusInKm int
   */
  public Planet addPlanet(String planetName, int avgRadiusInKm, int avgOrbitRadiusInKm) {
    Planet newPlanet = new Planet(planetName, avgRadiusInKm, avgOrbitRadiusInKm);
    addPlanet(newPlanet);
    return newPlanet;
  }

  /**
   * adds a planet.
   * 
   * @param p planet
   */
  private void addPlanet(Planet newPlanet) {
    if (newPlanet != null) {
      int newSize = planets.length + 1;
      Planet[] newPlanetsArray = new Planet[newSize];
      System.arraycopy(planets, 0, newPlanetsArray, 0, planets.length);
      newPlanetsArray[newSize - 1] = newPlanet;
      planets = newPlanetsArray;
    } else {
      throw new IllegalArgumentException("Invalid planet: null object");
    }
  }

  /**
   * gets an array of the child heavenly bodies.
   * 
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
   * 
   * @return String toString
   */
  @Override
  public String toString() {
    String result = "Solar System:\n";
    result += "  Star: " + getName() + ", average radius " + getAvgRadiusInKm() + "km\n";
  
    if (planets.length > 0) {
      result += "\n  Planets:\n";
      for (Planet planet : planets) {
        result += "    " + planet.toString() + "\n";
      }
    }
  
    result += "\n  Some moons:\n";
    for (Planet planet : planets) {
      result += planet.moonsToString();
    }
  
    return result;
  }
}
