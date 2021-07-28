import java.util.ArrayList;

public class SomeThing_About_ArrayList{
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Mazda");
        cars.add("Toyota");
        System.out.println(cars.get(0));
        System.out.println(cars);
        cars.set(0, "Change to Honda");
        System.out.println(cars);
    }
}
