public class DogLauncher {
    public static void main(String[] args) {
        Dog d = new Dog(15); //create a new dog
        //d.makeNoise(); //go to dog class and find makeNoies function

        Dog d2 = new Dog(100);

        //Dog bigger = d.maxdog(d2); non-static version
        Dog bigger = Dog.maxDog(d, d2);
        bigger.makeNoise();

        //if you ever have a static variable, use the class name, not the specific name of the variable because it is confusing
        
    }
}

