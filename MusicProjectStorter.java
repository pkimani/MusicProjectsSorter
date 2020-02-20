import java.awt.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class MusicProjectStorter {
	public static final String DRIVE_LABEL = "/Volumes/Untitled/";
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File abletonSetsFolders = new File(DRIVE_LABEL + "ableton sets folders.txt");
		Scanner input = new Scanner(abletonSetsFolders);
//		LinkedList<LinkedList<String>> projectSets = new LinkedList<>();
		
//		LinkedList<String> directory1 = new LinkedList<>();
//		directory1.add(input.nextLine());
//		LinkedList<String> directory2 = new LinkedList<>();
//		directory2.add(input.nextLine());
//		LinkedList<String> directory3 = new LinkedList<>();
//		directory3.add(input.nextLine());
//		LinkedList<String> directory4 = new LinkedList<>();
//		directory4.add(input.nextLine());
		
//		while (input.hasNext()) {
//			projectSets.add(new LinkedList<String>());
//			projectSets.get(projectSets.size() - 1).add(input.next());			
//		}
		
		LinkedList<String> directory1 = readFromFile(input.nextLine());
		LinkedList<String> directory2 = readFromFile(input.nextLine());
		
		
//		readFromFile(directory1, input);
//		readFromFile(directory2, input);
//		readFromFile(directory3);
//		readFromFile(directory4);
//		writeToFile(compareDirectories(directory1, directory4), "Archive");
//		writeToFile(compareDirectories(directory2, directory3), "Projects");
		writeToFile(compareDirectories(directory1, directory2), "Sets");
		
	}
	
//	public static void 
	
	public static LinkedList<String> readFromFile(String directory) throws FileNotFoundException {
		
//		LinkedList<String> projectList = new LinkedList<String>();
//		LinkedList<String> timestamps = new LinkedList<String>();
//		String projectFolder;
//		
//		if (input.hasNext()) {
//			projectFolder = input.nextLine(); 
//			projectList.add(projectFolder);
//			timestamps.add(projectFolder);
//		}
		
//		String location = DRIVE_LABEL + projectList.get(0);
//		String timeList = DRIVE_LABEL + timestamps.get(0);
		LinkedList<String> directorySets = new LinkedList<String>();
		directorySets.add(directory);
		File directoryFile = new File(DRIVE_LABEL + directorySets.get(0));
//		File setTimes = new File(timeList);
		Scanner input = new Scanner(directoryFile);
//		Scanner setDates = new Scanner(setTimes);
		while(input.hasNext()) {
			directorySets.add(input.nextLine());
		}
//		while(setDates.hasNext()) {
//			timestamps.add(setDates.nextLine());
//		}
		
		return directorySets;
	}
	
	public static LinkedList<String> compareDirectories(LinkedList<String> list1, LinkedList<String> list2) {
		Iterator<String> itr = list1.iterator();
		LinkedList<String> uniqueProjects = new LinkedList<>();
		uniqueProjects.add(list1.get(0));
		uniqueProjects.add(list2.get(0));
		while (itr.hasNext()) {
			String project = itr.next();
			if (!list2.contains(project)) {
				uniqueProjects.add(project);
			}
		}		
		return uniqueProjects;
	}
	
	public static void writeToFile(LinkedList<String> uniqueProjects, String filename) {
		try {
			Iterator<String> itr = uniqueProjects.iterator();
			File file = new File(DRIVE_LABEL + "uniqueProjects" + filename + ".txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			String list1 = itr.next();
			String list2 = itr.next();
			bw.write("The following files are projects unique to " + list1 + " compared against " + list2);
			bw.write("\n");
			
			while (itr.hasNext()) {
				bw.write("\n");
				bw.write(itr.next());
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
