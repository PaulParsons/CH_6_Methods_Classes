public class Muscle {

	/**
	 * In this Muscle class, implement the following.
	 *
	 * A private String data field 'name' signifying the name of the muscle.
	 * A private double data field 'size' signifying how large the muscle is in centimeters.
	 * A private boolean data field 'needsNewShirt' that signifies the muscle has increased to a point where new clothes are
	 * necessary.
	 *
	 *
	 * $ Create getter methods for all three data fields.
	 *
	 * $ Create a setter method for ONLY 'needsNewShirt' and 'size'.
	 *
	 * A default constructor.
	 * $ An overloaded constructor that takes a name and size as parameters.
	 *
	 * $ A workout method that takes an int 'minutes' as a parameter.
	 * -Create your own forumula to determine how much size is increased for a given number of minutes.
	 *
	 * $ An overloaded workout method that takes an int 'minutes' and a String 'difficulty' as parameters.
	 * -Implement a formula that determines the size increased based on difficulty and time of the workout.
	 *
	 * $ A method that takes in a Muscle object as a parameter and determines if the size of THIS muscle is larger than the
	 * muscle in the parameter.
	 *
	 * ALSO!!! Create unit tests in MuscleTest.java for all parts above preceded by a $.
	 */

	private String name; //muscle name
	private double size;   // size of muscle in centimeters
	private boolean needsNewShirt;  //True: User needs to buy new clothes False: No new clothes necessary


	Muscle(){
		//default constructor
		name = "Right bicep";
		size = 13.0;  //avg arm size for programmers
		needsNewShirt = false;
	}

	Muscle(String muscleName, double muscleSize){
		//overloaded constructor
		name = muscleName;
		size = muscleSize;  //in centimeters
		needsNewShirt = false;
	}

	String getName(){
		return(name);
	}

	double getSize(){
		return (size);
	}

	void setSize(double sizeInput){
		size = sizeInput;
		if (size >=55.88){
			//Arnold's arm size (in centimeters) at his peak
			setNeedsNewShirt(true);
		}
	}

	boolean getNeedsNewShirt(){
		return (needsNewShirt);
	}

	void setNeedsNewShirt(boolean newShirtInput){
		needsNewShirt = newShirtInput;
	}

	void workout(int minutes){
		//minutes of time in workout - we shall assume it is 'arm' day since we are worried about our shirts
		//13.0 is default arm size
		setSize(minutes/60 + 13);  //1 centimeter per hour!
	}

	void workout(int minutes, String difficulty){
		//input: minutes of workout and difficulty factor string; set arm muscle size
		int difficultyFactor = 0;  //range is 1 to 4

		switch (difficulty) {
			case "Easy":
				difficultyFactor = 1;
				break;
			case "Moderate":
				difficultyFactor = 2;
				break;
			case "Schwarzenegger":
				difficultyFactor = 3;
				break;
			case "Webbtastic":
				difficultyFactor = 4;
				break;
			default:
				throw new IllegalArgumentException("Invalid difficulty Level: " + difficulty);
		}

		setSize((minutes/60.0)*difficultyFactor + 13);
		}

		boolean compareMuscles(Muscle yourMuscle){
			//true if THIS muscle is larger than muscle in parameter; false if THIS is smaller
			//THIS is my Muscle; parameter is your muscle
			boolean retVal = false;
			System.out.println("Your Muscle: " + yourMuscle.getSize() + " My Muscle: "+this.getSize());
			if (this.getSize() > yourMuscle.getSize()) {
				System.out.println("Your muscle is smaller and insignificant.\n");
				retVal = true;
			}
			else {
				System.out.println("Hey, let's work out together.\n");
				retVal = false;
			}
			return(retVal);
		}

		public static void main(String[] args){
		Muscle m1 = new Muscle();
		Muscle m2 = new Muscle();
		m2.setSize(60.0);

			int minutes = 0;
		do {
			minutes += 10;
			m1.workout(minutes ,"Schwarzenegger");
			if (m1.needsNewShirt){
				System.out.println("Time to buy a new shirt!");
			}
			System.out.println("Workout time: " + minutes + " minutes " + m1.getName() + " size: " + m1.getSize());
		}
		while (!m1.compareMuscles(m2));

		}
}


