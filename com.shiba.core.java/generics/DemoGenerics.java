package generics;

class twoD{
    int x,y;
    twoD(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class threeD extends twoD{
    int z;
    threeD(int x, int y, int z){
        super(x,y);
        this.z = z;
    }
}

class fourD extends threeD{
    int t;
    fourD(int x, int y, int z, int t){
        super(x,y,z);
        this.t = t;
    }
}

class coordinates<T extends twoD>{
    T[] coordinates;
    coordinates(T[] coordinates){
        this.coordinates = coordinates;
    }
}

/* 
 * In this Stats class below the type 
 * argument must be of either Number or
 * class derived from Number
*/
class Stats<T extends Number>{
    T[] numbers;

    //Constructor to define the numbers
    public Stats(T[] numbers){
        this.numbers = numbers;
    }
    
    //Returns the average of all numbers
    public double getAverage(){
        double sum = 0.0;
        double average = 0.0;
        int totalNumbers = numbers.length;
        for (int i = 0; i < totalNumbers; i++) {
            //This doesn't throw error since T is bounded by Numbers
            sum += numbers[i].doubleValue();
        }
        if (totalNumbers > 0) {
            average = sum / totalNumbers;
        }
        return average; 
    }
    //Determining if the average is same for two objects using 
    //wildcard generics
    public boolean isSameAverage(Stats<?> numbers){
        if (getAverage() == numbers.getAverage()) {
            return true;
        } 
        return false;
    }
}
class TwoGen<T, V>{
    T firstObject; // Decalares object of type T
    V secondObject;

    //Pass the constructor reference to an object
    //of type T
    public TwoGen(T firstObject, V secondObject) {
        this.firstObject = firstObject;
        this.secondObject = secondObject;
    }
    //Returns first object of type T
    T getFirstObj(){
        return firstObject;
    }
    //Returns the second object of type V
    V getSecondObj(){
        return secondObject;
    }
    
    //Shows the type of the object
    void showType(){
        System.out.println("Type of first object is: " 
                            + firstObject.getClass().getName());
        System.out.println("Type of second object is: " 
                            + secondObject.getClass().getName());
    }
}   

class Gen<T>{
    T obj; // Decalares object of type T

    //Pass the constructor reference to an object
    //of type T
    public Gen(T obj) {
        this.obj = obj;
    }
    //Returns object of type T
    T getObj(){
        return obj;
    }
    
    //Shows the type of the object
    void showType(){
        System.out.println("Type of object is: " + obj.getClass().getName());
    }
    
}

public class DemoGenerics {

    //Creating static methods for displaying co-ordinates
    static void showXY(coordinates<?> coordinates){
        System.out.println("X Y Coordinates: ");
        for(int i = 0; i < coordinates.coordinates.length; i++) {
            System.out.println(coordinates.coordinates[i].x + " " +
                               coordinates.coordinates[i].y + " ");
        }
        System.out.println();
    }

    //Creating static methods for displaying co-ordinates
    static void showXYZ(coordinates<? extends threeD> coordinates){
        System.out.println("X Y Z Coordinates: ");
        for(int i = 0; i < coordinates.coordinates.length; i++) {
            System.out.println(coordinates.coordinates[i].x + " " +
                               coordinates.coordinates[i].y + " " +
                               coordinates.coordinates[i].z + " ");
        }
        System.out.println();
    }

    //Creating static methods for displaying co-ordinates
    static void showXYZT(coordinates<? extends fourD> coordinates){
        System.out.println("X Y Coordinates: ");
        for(int i = 0; i < coordinates.coordinates.length; i++) {
            System.out.println(coordinates.coordinates[i].x + " " +
                               coordinates.coordinates[i].y + " " +
                               coordinates.coordinates[i].z + " " +
                               coordinates.coordinates[i].t + " ");
        }
        System.out.println();
    }

    static<T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++) {
            if (x.equals(y[i])) {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        //Creating a new object of type Integer
        Gen<Integer> integerObject = new Gen<>(88);
        
        System.out.println("The new object is: " + integerObject.getObj());
        integerObject.showType();

        //Creating a new object of type String
        Gen<String> stringObject;
        stringObject = new Gen<>("Hello Generics!");
        System.out.println("The value of the new object is: " 
                            + stringObject.getObj());
        stringObject.showType();
        
        //Creating an object of type TwoGen
        TwoGen<Integer, String> multiParameterGenerics;
        multiParameterGenerics = new TwoGen<>(88, "Dual Parameter Generics!");
        System.out.println("The value of first object of dual parameter" 
                            + "generics is: " 
                            + multiParameterGenerics.getFirstObj());
        System.out.println("The value of second object of dual parameter" 
                            + "generics is: " 
                            + multiParameterGenerics.getSecondObj());
        multiParameterGenerics.showType();

        //Stats object of Integer type
        Stats<Integer> integerNumber = new Stats<>(new Integer[]{10,20,35,73});
        System.out.println("The average of all integers are: " 
                           + integerNumber.getAverage());

        //Stats object of float type
        Stats<Float> floatNumber = new Stats<>(
                                        new Float[]{10.2f,20.3f,35.1f,73.7f});
        System.out.println("The average of all floats are: " 
                           + floatNumber.getAverage());

        Float newFloatNumbers[] = {1.0f, 2.0f, 3.0f, 4.0f, 7.0f};
        Integer newIntegerNumbers[] = {1,2,3,4,7};
        Double newDoubleNumbers[] = {10.0, 20.5, 30.224, 21.57};

        Stats<Float> newFloat = new Stats<>(newFloatNumbers);
        Stats<Integer> newInteger = new Stats<>(newIntegerNumbers);
        Stats<Double> newDouble = new Stats<>(newDoubleNumbers);

        //Checking the average
        if (newFloat.isSameAverage(newInteger)) {
            System.out.println("The average of integers and floats are same :)");
        } else {
            System.out.println("The average of integers and floats are not same :(");
        }
        if (newDouble.isSameAverage(newInteger)) {
            System.out.println("The average of integers and doubles are same :)");
        } else {
            System.out.println("The average of integers and doubles are not same :(");
        }
        
        twoD twoDimensions[] = {
          new twoD(0, 0),
          new twoD(4, 8),
          new twoD(-2, 4),
          new twoD(-5, -100)
        };
        coordinates<twoD> twoDimensionLocations = new coordinates<>(twoDimensions);
        System.out.println("The two dimensional positions are: ");
        showXY(twoDimensionLocations);

        threeD threeDimensions[] = {
          new threeD(0, 0, 0),
          new threeD(4, 8, -2),
          new threeD(-2, 4, 7),
          new threeD(-5, -100, 21)
        };
        coordinates<threeD> threeDimensionLocations = new coordinates<>(threeDimensions);
        System.out.println("The three dimensional positions are: ");
        showXYZ(threeDimensionLocations);

        fourD fourDimensions[] = {
          new fourD(0, 0, 0, 0),
          new fourD(4, 8, 2, 1),
          new fourD(-2, 4, -4, 9),
          new fourD(-5, -100, 40, -57)
        };
        coordinates<fourD> fourDimensionLocations = new coordinates<>(fourDimensions);
        System.out.println("The four dimensional positions are: ");
        showXYZT(fourDimensionLocations);
        

        Integer nums[] = {10, 30, 43, 45, 74};
        String colors[] = {"red", "blue", "green", "orange"};
        
        System.out.println("Is 20 in numbers list? " + isIn(20,nums));
        System.out.println("Is blue in colors list? " + isIn("blue",colors));
    }
}
