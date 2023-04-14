package assignmenttwo;

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
    int size = 1; // initialize size to 1 for the current object
    for (Planet planet : planets) {
      size += 1 + planet.moons.length; // add planet and moon count to size
    }
    HeavenlyBody[] heavenlyBodies = new HeavenlyBody[size];
    int index = 0;
    heavenlyBodies[index] = this;
    index++;
    for (Planet planet : planets) {
      heavenlyBodies[index] = (HeavenlyBody)planet;
      index++;
      for (HeavenlyBody moon : planet.getHeavenlyBodies()) {
        heavenlyBodies[index] = moon;
        index++;
      }
    }
    return heavenlyBodies;
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
