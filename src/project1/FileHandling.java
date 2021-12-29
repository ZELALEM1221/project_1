package project1;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Scanner;

public class FileHandling {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub

		// create main directory in the working directory
		File folder = new File("./main");
		folder.mkdir();

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("press 1 to retrieve all files from main folder and display in ascending order");
			System.out.println(
					"press 2 to display secondary menu for performing file operations");
			System.out.println("press 3 to program terminated successfully");

			int choice = scan.nextInt();

			switch (choice) {
			case 1:

				File dir = new File("./main");

				File[] files = dir.listFiles();
				if (files != null && files.length > 0) {
					for (File file : files) {

						if (file.isDirectory()) {

							System.out.println(file.getAbsolutePath());
						} else {

							System.out.println(file.getName() + " (size in bytes: " + file.length() + ")");
						}

					}
				}

				break;

			case 2:
				while (choice == 2) {
					System.out.println("press 1 to add file/folder to \"main\" folder");
					System.out.println("press 2 to delete a file/folder");
					System.out.println("press 3 to show file that starts with");
					System.out.println("press 4 to return to previous menu");

					int menu = scan.nextInt();

					switch (menu) {
					case 1:

						System.out.println("press 1 to add folder to \"main\" folder");
						System.out.println("press 2 to add file to \"main\" folder");
						int menu2 = scan.nextInt();
						switch (menu2) {
						case 1:

							Scanner sc = new Scanner(System.in);
							String path = "./main/";
							System.out.println("Enter the name of the desired directory: ");
							path = path + sc.next();
							// Creating a File object
							File file = new File(path);
							// Creating the directory
							boolean bool = file.mkdir();
							if (bool) {
								System.out.println("Directory created successfully\n");
							} else {
								System.out.println("Sorry couldn’t create specified directory\n");
							}

							break;
						case 2:
							Scanner key = new Scanner(System.in);
							String fpath = "./main/";
							System.out.println("Enter the name of the desired directory: ");
							fpath = fpath + key.next();
							// Creating a File object

							try {

								File myFileObj = new File(fpath);
								if (myFileObj.createNewFile()) {
									System.out.println("File created: " + myFileObj.getName());
								} else {
									System.out.println("File already exists.\n");
								}
							} catch (IOException e) {
								System.out.println("An error occurred.\n");
								e.printStackTrace();
							}
							break;
						}
						break;
					case 2:
						System.out.println("Enter file/folder name to be deleted");
						Scanner keyboard = new Scanner(System.in);
						String ffname = keyboard.next();

						Path path = FileSystems.getDefault().getPath("./main/" + ffname);
						System.out.println(path);
						try {
							Files.delete(path);
						} catch (NoSuchFileException x) {
							System.err.format("%s: no such" + " file or directory%n", path);
						} catch (IOException x) {
							System.err.println(x);
						}
						break;
					case 3:
						System.out.println("Enter to file that starts with");
						Scanner keyb = new Scanner(System.in);
						String name = keyb.next();
						
						File dirStartsWith = new File("./main");

						File[] arrayFiles = dirStartsWith.listFiles();
						if (arrayFiles != null && arrayFiles.length > 0) {
							for (File file : arrayFiles) {

								if (file.getName().startsWith(name)) {

									System.out.println(file);
								} 

							}
							System.out.println();
						}
						
						break;
						
					case 4:
						choice = 0;
						break;
					default:
						System.out.println("Invalid input: input correct value and retry");
						break;
					}
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
