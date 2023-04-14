package assignmenttwo;

/**
 * defines a moon.
 */
public class Moon extends HeavenlyBody {

  private int avgOrbitRadiusInKm;

  /**
   * creates a new moon.

   * @param name               name
   * @param avgRadiusInKm      int
   * @param avgOrbitRadiusInKm int
   */
  public Moon(String name, int avgRadiusInKm, int avgOrbitRadiusInKm) {
    super(name, avgRadiusInKm);
    validateMoon(name, avgRadiusInKm);
    validateOrbit(avgOrbitRadiusInKm);
    this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
  }

  /**
   * creates a new moon.

   * @param name          name
   * @param avgRadiusInKm int
   */
  public Moon(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
    validateMoon(name, avgRadiusInKm);
  }

  /**
   * creates a new moon.

   * @param m moon
   */
  public Moon(Moon m) {
    super(m.getName(), m.getAvgRadiusInKm());
    validateMoon(m.getName(), m.getAvgRadiusInKm());
    this.avgOrbitRadiusInKm = m.avgOrbitRadiusInKm;
  }

  /**
   * Validates the moon name and radius.

   * @param name          the moon name
   * @param avgRadiusInKm the average radius in kilometers
   */
  private void validateMoon(String name, int avgRadiusInKm) {
    if (name == null || name.isEmpty() || avgRadiusInKm < 6 || avgRadiusInKm > 5000) {
      throw new IllegalArgumentException("Invalid moon: invalid name or radius");
    }
  }

  /**
   * Validates the orbit radius.

   * @param avgOrbitRadiusInKm the average orbit radius in kilometers
   */
  private void validateOrbit(int avgOrbitRadiusInKm) {
    if (avgOrbitRadiusInKm < 60 || avgOrbitRadiusInKm > 100000) {
      throw new IllegalArgumentException("Invalid moon: invalid orbit radius");
    }
  }

  /**
   * gets the average orbit radius.

   * @return double
   */
  public int getAvgOrbitRadiusInKm() {
    return avgOrbitRadiusInKm;
  }

  /**
   * tostring for moon.

   * @return String tostring
   */
  @Override
  public String toString() {
    return "Moon: " + getName() + ", average radius " + getAvgRadiusInKm() + "km";
  }
}
