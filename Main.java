import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;

public class Car {
    int speed;
    int cost;
    String owner;

    public Car(int speed, int cost, String owner) {
        this.speed = speed;
        this.cost = cost;
        this.owner = owner;
    }

    public static void showInfo(){
        System.out.println("Car");
    }

    public static void main(String[] args) {
        Car car = new Car(100, 100000, "Mr.E");
        final Method[] methods = car.getClass().getDeclaredMethods();
        System.out.println(methods[0]);
        Car.showInfo();
    }

    static class Truck extends Car {
        public Truck(int speed, int cost, String owner) {
            super(speed, cost, owner);
        }

        public static void showInfo(){
            System.out.println("Truck");
        }

        public static void main(String[] args) {
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.txt"))) {
                Truck truck = new Truck(50, 20000, "Mr.C");
                final Method[] methods = truck.getClass().getDeclaredMethods();
                System.out.println(methods[0]);
                oos.writeObject(truck);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            Truck truck = new Truck(50, 20000, "Mr.C");
            final Method[] methods = truck.getClass().getDeclaredMethods();
            Truck.showInfo();
        }
    }

    static class Supercar extends Car{
        public Supercar(int speed, int cost, String owner) {
            super(speed, cost, owner);
        }

        public static void showInfo(){
            System.out.println("Supercar");
        }

        public static void main(String[] args) {
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.txt"))) {
                Supercar supercar = new Supercar(200, 1000000, "Mr.F");
                final Method[] methods = supercar.getClass().getDeclaredMethods();
                System.out.println(methods[0]);
                oos.writeObject(supercar);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            Supercar.showInfo();
        }
    }
    public static class pCar extends Supercar{
        public pCar(int speed, int cost, String owner) {
            super(speed, cost, owner);
        }
        public static void showInfo(){
            System.out.println("pCar");
        }
        public static void main(String[] args) {
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.txt"))) {
                pCar pCar = new pCar(13213212,31232132,"Mr.j");
                final Method[] methods = pCar.getClass().getDeclaredMethods();
                System.out.println(methods[0]);
                oos.writeObject(pCar);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            pCar.showInfo();
        }
    }
}
