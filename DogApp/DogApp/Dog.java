import java.util.Scanner;

public class Dog {

    // instance variables
	private String type;
	private String breed;
	private String name;
	private static String topTrick;

    // constructor
	public Dog(String dogType, String dogBreed, String dogName) {
		type = dogType;
		breed = dogBreed;
		name = dogName;
	}

    // methods
	public static String setTopTrick(String trick) {
		topTrick = trick;
		return trick;
	}

    // method used to print Dog information
    public String toString() {
        String temp = "\nDOG DATA\n" + name + " is a " + breed +
                ", a " + type + " dog. \nThe top trick is : " +
                topTrick + ".";
        return temp;
    }

}
