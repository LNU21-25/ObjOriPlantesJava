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
    this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
    try {
      name.length();
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid moon");
    }
    if (name.equals("") || avgRadiusInKm < 6 || avgRadiusInKm > 10000 
        || avgOrbitRadiusInKm < 60 || avgOrbitRadiusInKm > 100000) {
      throw new IllegalArgumentException("Invalid moon");
    }
  }

  /**
   * creates a new moon.

   * @param name          name
   * @param avgRadiusInKm int
   */
  public Moon(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
    try {
      name.length();
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid moon");
    }
    if (name.equals("") || avgRadiusInKm < 6 
        || avgRadiusInKm > 10000) {
      throw new IllegalArgumentException("Invalid moon");
    }
  }

  /**
   * creates a new moon.

   * @param m moon
   */
  public Moon(Moon m) {
    super(m.getName(), m.getAvgRadiusInKm());
    try {
      m.getName().length();
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid moon");
    }
    this.avgOrbitRadiusInKm = m.avgOrbitRadiusInKm;
    if (m.getName().equals("") || m.getAvgOrbitRadiusInKm() < 6 
        || m.getAvgRadiusInKm() > 10000) {
      throw new IllegalArgumentException("Invalid moon");
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
  public String toString() {
    return "Moon: " + getName() + ", average radius "
        + getAvgRadiusInKm() + "km, average orbit radius " + avgOrbitRadiusInKm + "km";
  }
}
