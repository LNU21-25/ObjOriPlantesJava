package assignmenttwo;

import java.lang.Comparable;

/**
 * defines a heavenlybody.
 */
public abstract class HeavenlyBody implements Comparable<HeavenlyBody> {

  private String name;
  private Integer avgRadiusInKm;

  /**
   * creates a new heavenlybody.
   * 
   * @param name          name
   * @param avgRadiusInKm int
   */
  public HeavenlyBody(String name, int avgRadiusInKm) {
    this.setName(name);
    this.setAvgRadiusInKm(avgRadiusInKm);
  }

  /**
   * gets name.
   * 
   * @return String name
   */
  public String getName() {
    return this.name;
  }

  /**
   * sets name.
   * 
   * @param name name
   */
  private void setName(String newName) {
    this.name = newName;
  }

  /**
   * gets avgRadiusInKm.
   * 
   * @return int
   */
  public int getAvgRadiusInKm() {
    return this.avgRadiusInKm;
  }

  /**
   * sets avgRadiusInKm.
   * 
   * @param avgRadiusInKm int
   */
  private void setAvgRadiusInKm(int avgRadiusInKm) {
    this.avgRadiusInKm = avgRadiusInKm;
  }

  /**
   * tostring for heavenlybody.
   * 
   * @return String tostring
   */
  public String hbString() {
    if (this instanceof Moon) {
      return getClass().getSimpleName() + ": " + getName() + ", average radius " + getAvgRadiusInKm() + "km, average orbit radius " + ((Moon) this).getAvgOrbitRadiusInKm() + ",00km";
    } else if (this instanceof Planet) {
      return getClass().getSimpleName() + ": " + getName() + ", average radius " + getAvgRadiusInKm() + "km, average orbit radius " + ((Planet) this).getAvgOrbitRadiusInKm() + ",00km";
    } else {
      return getClass().getSimpleName() + ": " + getName() + ", average radius " + getAvgRadiusInKm() + "km";
    }
  }

  /**
   * tostring for heavenlybody.
   * 
   * @return String tostring
   */
  public String toOrderString() {
    String ret = "Heavenly Body: " + this.name + ", average radius " + this.avgRadiusInKm + "km";
    return ret;
  }

  /**
   * tostring for heavenlybody.
   * 
   * @return String tostring
   */
  @Override
  public int compareTo(HeavenlyBody other) {
    return this.avgRadiusInKm - other.avgRadiusInKm;
  }

}
