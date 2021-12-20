package project1;

import java.io.File;
import java.util.Scanner;

public class FileHandling {
	

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		File ob =  new File("Users//zola//Desktop");

		
		//create main directory in the working directory
		File folder = new File("./main");
		folder.mkdir();
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("press 1 to retrieve all files from main folder and display in ascending order");
			System.out.println("press 2 to display secondary menu for performing file operations and and take user input");
			System.out.println("press 3 to display program terminated successfully");
			
			
			
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				
				File[] arrayOfFiles = folder.listFiles();
				for(int i = 0; i< arrayOfFiles.length; i++) {
					System.out.println(arrayOfFiles[i].getName());
				}
				
				break;
				
			case 2:
				System.out.println("press 1 for --------");
				System.out.println("press 2 for --------");
				System.out.println("press 3 for --------");
				System.out.println("press 4 for --------");
				
				int menu = scan.nextInt();
				
				switch(menu) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					
					break;
				}
				
				break;
			case 3:
				System.out.println("program terminated successfully");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input: input correct value and retry");
				break;
			}
			
		
		
			
		}
		

	}

}



