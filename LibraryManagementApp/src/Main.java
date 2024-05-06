import java.sql.Connection;
import java.sql.SQLException;

import Model.LibraryModel;
import View.EmployeeDashboard;
import View.LoginView;
import View.ManagerDashboard;
import View.MemberDashboard;
import java.util.*;

/**
 * Main class to initialize the program and the model.
 * 
 * @author
 *
 */
public class Main {
	// public
	/**
	 * Main method to start the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		

		System.out.println("please enter MYSQL username : ");
		Scanner sc = new Scanner(System.in);
		String mysql_username = sc.nextLine();

		System.out.println("please enter MYSQL password : ");
		String mysql_password = sc.nextLine();

		LibraryModel model = new LibraryModel(mysql_username, mysql_password,
				"jdbc:mysql://localhost:3306/library_management");

		System.out.println("Please enter user Type :  member, employee or manager");
		String userType = sc.nextLine();

		System.out.println("Please enter username : ");
		String username = sc.nextLine();

		// TODO: verify if username exists in the DB; if not, let the user know. if yes.

		if (userType.equals("member")) {
			MemberDashboard memberDashboard = new MemberDashboard(username);
		} else if (userType.equals("employee")) {
			EmployeeDashboard employeeDashboard = new EmployeeDashboard(username);

		} else if (userType.equals("manager")) {
			ManagerDashboard managerDashboard = new ManagerDashboard(username, model);
		} else {
			System.out.println("Incorrect user type or username");
		}
		// System.out.println(view.userType);rro
		// Connection conn = model.makeConnection();
		// try {
		// List<String> books = model.retreiveBooks(conn);
		// if (books.size() > 0) {
		// System.out.println(books.get(0));

		// } else {
		// System.out.println("No data in the table.");
		// }
		// } catch (SQLException e) {
		// System.out.println("Some issue");
		// }
	}

}
