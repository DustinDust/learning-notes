package learning.hfdp.factory;

// abstract product class
abstract class Pizza { 
  String name;
  String dough;
  String sauce;

  List<String> toppings = new ArrayList<String>();

  void prepare() {
    // preparing the pizza
  }

  void bake() {
    // bake the pizza;
  }

  void cut() {
    // cut the pizza
  }

  void box() {
    // box the pizza
  }

  // other getters/setters
}


// concrete product class
public class NYCheesePizza extends Pizza {
  public NYCheesePizza() {
    this.name = "NY Style sauce and Cheese Pizza";
    this.dough = "Thin crust";
    this.sauce = "Mariana";

    toppings.add("Grated Reggiano Cheese");
  }
}

// another concrete product class
public class ChicagoStyleCheesePizza extends Pizza {
  public ChicagoStyleCheesePizza() {
    name = "Chicago Style Deep Dish Cheese Pizza";
    dough = "Extra Thick Crust Dough";
    sauce = "Plum Tomato Sauce";
    toppings.add("Shredded Mozzarella Cheese");
  }

  void cut() {
    System.out.println("Cutting the pizza into square slices");
  }
}


// Creator class
abstract class PizzaStore {
  public Pizza orderPizza(String type) {
    Pizza pizza;
    pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();


    return pizza;
  }

  protected abstract Pizza createPizza(String type);
}

// concrete creators
class NYPizzaStore extends PizzaStore {
  protected Pizza createPizza(String item) {
    if (item.equals("cheese")) {
      return new NYStyleCheesePizza();
    } 
    // Additional styles (veggie, clam, pepperoni) would go here
    else return null;
  }
}

class ChicagoPizzaStore extends PizzaStore {
  protected Pizza createPizza(String item) {
    if (item.equals("cheese")) {
      return new ChicagoStyleCheesePizza();
    } 
    // Additional styles would go here
    else return null;
  }
}
