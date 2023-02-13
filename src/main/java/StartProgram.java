/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Jan 31, 2023
 */

import java.util.List;
import java.util.Scanner;

import controller.ListSquishmallowHelper;
import model.Squishmallow;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListSquishmallowHelper lsh = new ListSquishmallowHelper();

		private static void addASquish() {
			// TODO Auto-generated method stub
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter a type: ");
			String type = in.nextLine();
			System.out.print("Enter a size: ");
			String size = in.nextLine();
			
			Squishmallow toAdd = new Squishmallow(name, type, size);
			lsh.insertSquishmallow(toAdd);
		}

		private static void deleteASquish() {
			// TODO Auto-generated method stub
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the type to delete: ");
			String type = in.nextLine();
			System.out.print("Enter a size to delete: ");
			String size = in.nextLine();
			
			Squishmallow toDelete = new Squishmallow(name, type, size);
			lsh.deleteItem(toDelete);
		}

		private static void editASquish() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");
			System.out.println("2 : Search by Type");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Squishmallow> foundSquish;
			if (searchBy == 1) {
				System.out.print("Enter the Squishmallow's name: ");
				String squishName = in.nextLine();
				foundSquish = lsh.searchForSquishByName(squishName);
				
			} else if (searchBy == 2) {
				System.out.print("Enter the Squishmallow's type: ");
				String squishType = in.nextLine();
				foundSquish = lsh.searchForSquishByType(squishType);
			} else {
				System.out.print("Enter the Squishmallow's Size: ");
				String squishSize = in.nextLine();
				foundSquish = lsh.searchForSquishBySize(squishSize);
			}

			if (!foundSquish.isEmpty()) {
				System.out.println("Found Results.");
				for (Squishmallow l : foundSquish) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Squishmallow toEdit = lsh.searchForSquishById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + " Size: " + toEdit.getSize() + " inch" +
									" type: " + toEdit.getType());
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Type");
				System.out.println("3 : Update Size");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 2) {
					System.out.print("New Item: ");
					String newType= in.nextLine();
					toEdit.setType(newType);
				} else if (update == 3){
					System.out.print("New Size: ");
					String newSize = in.nextLine();
					toEdit.setSize(newSize);
				}

				lsh.updateSquish(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the Squishmallow Collection Organizer! ---");
			while (goAgain) {
				System.out.println("*  Select an Option:");
				System.out.println("*  1 -- Add an Squishmallow");
				System.out.println("*  2 -- Edit an Squishmallow");
				System.out.println("*  3 -- Delete an Squishmallow");
				System.out.println("*  4 -- View your collection");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addASquish();
				} else if (selection == 2) {
					editASquish();
				} else if (selection == 3) {
					deleteASquish();
				} else if (selection == 4) {
					viewTheCollection();
				} else {
					lsh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheCollection() {
			// TODO Auto-generated method stub
			List<Squishmallow> allSquish = lsh.showCollection();
			for(Squishmallow singleSquish : allSquish) {
				System.out.println(singleSquish.returnSquishmallowDetails());
			}

		}

	}
