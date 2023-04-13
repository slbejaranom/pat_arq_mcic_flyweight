import java.util.*;

// singleton Flyweight Factory
public class FlyweightFactory {
  private HashMap lstFlyweight;
  private static FlyweightFactory factory =
    new FlyweightFactory();

  private FlyweightFactory() {
    lstFlyweight = new HashMap();
  }

  public synchronized FlyweightIntr getFlyweight(
    String faculty) {
    if (lstFlyweight.get(faculty) == null) {
      FlyweightIntr fw = new Flyweight(faculty);
      lstFlyweight.put(faculty, fw);
      return fw;
    } else {
      return (FlyweightIntr) lstFlyweight.get(faculty);
    }
  }
  public static FlyweightFactory getInstance() {
    return factory;
  }

  //Inner flyweight class
  private class Flyweight implements FlyweightIntr {
	private String nameFac;
	private String locality;
    private String address;
    private String neighbourhood;
    
    private String coordinates;

    private void setValues(String nm,String loc, String addr,
        String ngb,  String coord) {

    nameFac=nm;
    locality = loc;
    address=addr;
    neighbourhood = ngb;
    coordinates = coord;
    }

    private Flyweight(String faculty) {
      // values are hard coded
      //for simplicity
      if (faculty.equals("Tech")) {
        setValues("Technological Faculty","Ciudad Bolívar","Av. Villavicencio","Candelaria", "South");
      }
      if (faculty.equals("Env")) {
        setValues("Environmental Faculty","La Candelaria","Av Circunvalar", "La Candelaria","East");
      }
      if (faculty.equals("Eng")) {
        setValues("Engineering Faculty","Teusaquillo","Cra. Séptima Cl. 40", "Palermo","East-North");
      }
      if (faculty.equals("Arts")) {
        setValues("Arts Faculty","Mártires","Cra. 13 Cl. 14", "Mártires","Center");
      }
    }

    public String getLocality() {
      return locality;
    }
    public String getAddress() {
      return address;
    }
    public String getNeighbourhood() {
      return neighbourhood;
    }
    public String getNameFac() {
      return nameFac;
    }
    public String getCoordinates() {
      return coordinates;
    }

  }// end of Flyweight
}// end of FlyweightFactory

