
public class Registry {

	private static final Map<String, Product> prototypes = new HashMap<>();

    static {
        prototypes.put("context1", new Product());
        prototypes.put("context2", new Product());
        prototypes.put("context3", new Product());
    }

    public static Product getPrototype(String context) {
    	try {
    		return prototypes.get(context).clone();
    	}
    	catch (Exception e) {
    		System.out.println("Prototype does not exist");
    		return null;
    	}
    }

}