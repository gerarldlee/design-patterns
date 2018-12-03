
/**
 * Concrete factory class for ProductA & B - 2
 */
public ConcreteFactory2 implements AbstractFactory {


	public ProductA createProductA() {
		return new ProductAImpl2();
	}

	public ProductB createProductB() {
		return new ProductBImpl2();
	}

}