
// legacy 
class LegacyData {

}

class LegacyService {

  public void serviceMethod(LegacyData data) {

  }
}

class NewToLegacyDataAdapter extends LegacyData {

  private Service adaptee;

  private NewData data;

  public Adapter(NewData data) {
    this.data = data;
  }

  public void method() {

    // some data manipulation

    adaptee.serviceMethod(this);
  }

}

interface ClientInterface {

  method(Object data);

}

public class Client extends ClientInterface {

  public void method(Object data) {

  }

  public static void main(String[] argv) {



  }
}