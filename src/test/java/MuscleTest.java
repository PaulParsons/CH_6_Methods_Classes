import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MuscleTest {

	@Test
	void getNameTest() {
		Muscle testMuscle = new Muscle();
		Assertions.assertEquals(testMuscle.getName(), "Right bicep");
	}

	@Test
	void getSizeTest() {
		Muscle testMuscle = new Muscle();
		Assertions.assertEquals(testMuscle.getSize(), 13.0);
	}

	@Test
	void setSizeTest() {
		Muscle testMuscle = new Muscle();
		testMuscle.setSize(17.34);
		Assertions.assertEquals(testMuscle.getSize(), 17.34);
	}

	@Test
	void getNeedsNewShirtTest() {
		Muscle testMuscle = new Muscle();
		Assertions.assertEquals(testMuscle.getNeedsNewShirt(), false);
	}

	@Test
	void setNeedsNewShirtTest() {
		Muscle testMuscle = new Muscle();
		testMuscle.setNeedsNewShirt(true);
		Assertions.assertEquals(testMuscle.getNeedsNewShirt(), true);
	}

	@Test
	void WorkoutTest() {
	//	workout(int minutes, String difficulty)
		Muscle testMuscle = new Muscle();
		testMuscle.workout(60,"Schwarzenegger");
		Assertions.assertEquals(testMuscle.getSize(), 16.0);
	}

	@Test
	void muscleTest() {
		//		Muscle(String muscleName, double muscleSize){
		Muscle testMuscle = new Muscle("left bicep",14.4);
		Assertions.assertEquals(testMuscle.getSize(), 14.4);
		Assertions.assertEquals(testMuscle.getName(), "left bicep");
	}

	@Test
	void workout1Test() {
		//workout(int)
		Muscle testMuscle = new Muscle();
		testMuscle.workout(60);
		Assertions.assertEquals(testMuscle.getSize(), 14.0);
	}


	@Test
	void compareMusclesTest() {
		boolean compVal = false;
		Muscle m1 = new Muscle();
		Muscle m2 = new Muscle();
		m2.setSize(12.0);
		compVal = m1.compareMuscles(m2);
		Assertions.assertEquals(compVal,true);
	}
}