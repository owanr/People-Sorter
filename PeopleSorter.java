/*
** PeopleSorter.java
** Written by Risako Owan

** Input: A textfile with people records with each line formatted as: 
family-name,given-name,year-of-birth,month-of-birth,day-of-birth

** Output: Standard output organized by family name (alphabetized) and 
birth year with each line formatted as given-name family-name age. Age
is sorted from younger to older.

** Received help from Professor Jadrian Miles, Daniel Alabi,
and stackoverflow

** Some coding and comments taken directly from homework directions
http://cs.carleton.edu/faculty/jadrian/cs201/2014.1/hw/hw03-people-sorter.html
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class PeopleSorter {

	public static void main(String[] args) {
		//If no command-line argument, prints usage statement and exits.
		if (args.length==0) {
			System.out.println("usage: PeopleSorter file1");
		
		} else {
			
		String filePath = args[0]; //args[0] = name of input file
		//Creates a list of person objects from the input file
		List<Person> personList = loadPersonList(filePath);

		//Sorts the list of person objects.
		List<Person> personList2 = PeopleSorter.sortPersonList(personList);
		
		//Prints result onto command prompt.
		PeopleSorter.printPersonList(personList2);
		}
	}

	/*
	** Input: Filename of the person text file
	** Output: A list containing all the person objects created from filename
	*/
	public static List<Person> loadPersonList(String personFilePath) {
		try {
		    //http://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-java
		    File inputFile = new File(personFilePath);
		    Scanner scanner = new Scanner(inputFile);
		    
		    List<Person> personList = new ArrayList<Person>();

		    //Instantiates new Person objects and adds them to personList
		    while (scanner.hasNextLine()) {
			    String x = scanner.nextLine();
			    String[] createP = x.split(",");
			    Person newP = new Person(createP[0], createP[1],
			    	Integer.parseInt(createP[2]), Integer.parseInt(createP[3]),
			    	Integer.parseInt(createP[4]));
			    personList.add(newP);
			}

			return personList;
			
		//If file cannot be loaded, warns user and returns empty list
		} catch (FileNotFoundException e) {
		    System.out.println("Please make sure file exists or is compatible with program");
		    List<Person> emptyList = new ArrayList<Person>();
		    return emptyList;
		}
	}
    
    /*
    ** Input: A list of Person objects
    ** Output: A sorted version of given list (sorted by family name and age)
	*/
	public static List<Person> sortPersonList(List<Person> personList) {  
		List<Person> resultList = new ArrayList<Person>();
        
		for (int i=0; i < personList.size(); i++) {
		    Person personObject = personList.get(i);
			
			//Performs an insertion sort
			int j;
			for (j=0; j < resultList.size(); j++) {
			    Person comparePerson = resultList.get(j);

			    //Gets family + given name + (200-age) for each Person object
			    String compareInfo = comparePerson.getSort();

			    if (compareInfo.compareTo(personObject.getSort()) > 0) {
				    break;
				}
			}

			//Adds element to result
			resultList.add(j, personObject);
		}

		return resultList;
	}

	/*
	** Prints result to standard output
	*/
	public static void printPersonList(List<Person> personList) {
		for (int i=0; i < personList.size(); i++) {
			Person person = personList.get(i);
			System.out.println(person.getOutput());
		}
	}
}