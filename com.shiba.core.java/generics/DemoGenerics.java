package generics;

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
    }
}
