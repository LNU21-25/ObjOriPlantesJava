package assignmenttwo;

/**
 * defines a planet object.
 */
public class Planet extends HeavenlyBody {

  public Moon[] moons = new Moon[8];
  private int avgOrbitRadiusInKm;

  /**
   * creates a planet.
   * 
   * @param planetName         planet name
   * @param avgRadiusInKm      radius
   * @param avgOrbitRadiusInKm orbit
   */
  public Planet(String planetName, int avgRadiusInKm, int avgOrbitRadiusInKm) {
    super(planetName, avgRadiusInKm);
    validatePlanet(planetName, avgRadiusInKm);
    validateOrbit(avgOrbitRadiusInKm);
    this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
  }

  /**
   * creates a planet.
   * 
   * @param planetName    planet name
   * @param avgRadiusInKm radius
   */
  public Planet(String planetName, int avgRadiusInKm) {
    super(planetName, avgRadiusInKm);
    validatePlanet(planetName, avgRadiusInKm);
  }

  /**
   * creates a planet.
   * 
   * @param p planet
   */
  public Planet(Planet p) {
    super(p.getName(), p.getAvgRadiusInKm());
    validatePlanet(p.getName(), p.getAvgRadiusInKm());
    this.avgOrbitRadiusInKm = p.avgOrbitRadiusInKm;
  }

  /**
   * Validates the planet name and radius.
   *
   * @param planetName    the planet name
   * @param avgRadiusInKm the average radius in kilometers
   */
  private void validatePlanet(String planetName, int avgRadiusInKm) {
    if (planetName == null || planetName.isEmpty() || avgRadiusInKm < 1500 || avgRadiusInKm > 200000) {
      throw new IllegalArgumentException("Invalid planet: invalid name or radius");
    }
  }

  /**
   * Validates the orbit radius.
   *
   * @param avgOrbitRadiusInKm the average orbit radius in kilometers
   */
  private void validateOrbit(int avgOrbitRadiusInKm) {
    if (avgOrbitRadiusInKm < 17000 || avgOrbitRadiusInKm > 1000000) {
      throw new IllegalArgumentException("Invalid planet: invalid orbit radius");
    }
  }

  /**
   * adds a moon to this planet.
   * 
   * @param moonName           name
   * @param avgRadiusInKm      int
   * @param avgOrbitRadiusInKm double
   * @throws Exception bruh
   */
  public Moon addMoon(String moonName, int avgRadiusInKm, int avgOrbitRadiusInKm) {
    Moon newMoon = new Moon(moonName, avgRadiusInKm, avgOrbitRadiusInKm);
    addMoon(newMoon);
    return newMoon;
  }

  /**
   * adds a moon.
   * 
   * @param m moon
   */
  private void addMoon(Moon newMoon) {
    if (newMoon != null) {
      int newSize = moons.length + 1;
      Moon[] newMoonsArray = new Moon[newSize];
      System.arraycopy(moons, 0, newMoonsArray, 0, moons.length);
      newMoonsArray[newSize - 1] = newMoon;
      moons = newMoonsArray;
    } else {
      throw new IllegalArgumentException("Invalid moon: null object");
    }
  }

  /**
   * gets sub-bodies.
   * 
   * @return HeavenlyBody[] bods
   */
  public HeavenlyBody[] getHeavenlyBodies() {
    HeavenlyBody[] heavenlyBodies = new HeavenlyBody[moons.length + 1];
    int index = 0;
    
    heavenlyBodies[index++] = this;
    for (Moon moon : moons) {
        heavenlyBodies[index++] = moon;
    }
    
    return heavenlyBodies;
}

  /**
   * gets the tostring.
   * 
   * @return String tostring
   */
  @Override
  public String toString() {
    String result = "Planet: " + getName() + ", average radius " + getAvgRadiusInKm() + "km";
    return result;
  }

  /**
   * gets the moons.
   * 
   * @return String moons
   */
  public String moonsToString() {
    String result = "";
    if (moons.length > 0) {
      for (Moon moon : moons) {
        if (moon != null) {
          result += "    " + moon.toString() + "\n";
        }
      }
    }
    return result;
  }

  /**
   * gets the average orbit radius.
   * 
   * @return int avgOrbitRadiusInKm
   */
  public int getAvgOrbitRadiusInKm() {
    return avgOrbitRadiusInKm;
  }
}
