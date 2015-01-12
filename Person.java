/*
** Written by Risako Owan
**
** Creates Person object for PeopleSorter.java
** Some coding and comments taken directly from homework directions
*/
public class Person {
	private String givenName;
	private String familyName;
	private int yearOfBirth;
	private int monthOfBirth;
	private int dayOfBirth;

	/*
    ** Contructor
    */
	public Person(String fName, String gName, int year, int month, int day) {
		givenName = gName;
		familyName = fName;
		yearOfBirth = year;
		monthOfBirth = month;
		dayOfBirth = day;
	}

	/*
    ** Returns age of person
    */
	public int age() {
		return (2013 - yearOfBirth);
	}

	/*
    ** Since age should be sorted from older to younger, returns 200-age()
    ** to help with sorting
    */
	public int sortAge() {
		return (200-this.age());
	}

	/*
    ** Returns family, given name, adjusted-age for sorting purposes
	*/
	public String getSort() {
		return familyName + " " + givenName + this.sortAge();
	}

	/*
    ** Returns full name of person
    */
	public String getFullName() {  
		//Prevents one-named people from having an extra space (ex. Madonna) 
		if (givenName.length() == 0) {
			return familyName;

		} else {
			return givenName + " " + familyName;
		}
	}
	/*
    ** Returns output for results
    */
	public String getOutput() {
		String output = this.getFullName() + " " + this.age();
		return output;
	}
}