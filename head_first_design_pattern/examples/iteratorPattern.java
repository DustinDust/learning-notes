public interface Iterator {
  boolean hasNext();
  Object next();
}

public interface Iterable {
  Iterator createIterator();
}

public class DinerMenuIterator implements Iterator {
  MenuItem[] items;
  int position = 0;

  public DinerMenuIterator(MenuItem[] items) {
    this.items = items;
  }

  public Object next() {
    MenuItem menuItem = items[position];
    position = position + 1;
    return menuItem;
  }

  public boolean hasNext() {
    if (position >= items.length || items[position] == null) {
      return false;
    } else {
      return true;
    }
  }
}

public class DinerMenu implements Iterable {
  static final int MAX_ITEMS = 6;
  static final int MAX_ITEMS = 6;
  int numberOfItems = 0;
  MenuItem[] menuItems;
  // constructor here
  // addItem here
  public Iterator createIterator() {
    return new DinerMenuIterator(menuItems);
  }
  // other menu methods here
  // removed the getMenuItems method because it exposes the underlying data
}

class Waitress {
  PancakeHouseMenu pancakeHouseMenu;
  DinerMenu dinerMenu;
  // constructor
  public void printMenu() {
    Iterator pancakeIterator = this.pancakeHouseMenu.createIterator();
    Iterator dinerIterator = this.dinerMenu.createIterator();
    printMenu(pancakeIterator);
    printMenu(dinerIterator);
  }

  private void printMenu(Iterator iterator) {
    while(iterator.hasNext()) {
      MenuItem menuItem = (MenuItem) iterator.next();
      // print menu item
    }
  }
  // other method
}
