package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibraryModel {
    String username;
    String password;
    final String DB_STRING;

    // Methods to interact with the database (e.g., retrieveBooks(), addBook(),
    // deleteBook(), etc.)
    public LibraryModel(String username, String password, String DB_STRING) {
        this.username = username;
        this.password = password;
        this.DB_STRING = DB_STRING;
    }

    public Connection makeConnection() {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(DB_STRING, username, password);

            if (connection != null) {
                System.out.println("Connected to the database!");
                return connection;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return null;
    }

    public List<String> retreiveBooks(Connection conn) throws SQLException {
        List<String> books = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from books");
        while (rs.next()) {
            String book = rs.getString("title");
            books.add(book);
        }
        return books;
    }

    public void addBook(Connection conn, int book_id, String title, int authorId, int genreId, int publisherId,
            Date publishedDate) throws SQLException {
        String sql = "INSERT INTO books (isbn, title, author_id, genre_id, publisher_id, published_date) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, book_id);
            pstmt.setString(2, title);
            pstmt.setInt(3, authorId);
            pstmt.setInt(4, genreId);
            pstmt.setInt(5, publisherId);
            pstmt.setDate(6, publishedDate);
            pstmt.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    // add Author

    public void addAuthor(Connection conn, String authorName, Date birthdate, String nationality)
            throws SQLException {
        String sql = "INSERT INTO authors (author_name, birthdate, nationality) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, authorName);
            pstmt.setDate(2, birthdate);
            pstmt.setString(3, nationality);
            pstmt.executeUpdate();
            System.out.println("Author added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding author: " + e.getMessage());
        }
    }

    public void deleteAuthor(Connection conn, String authorName) throws SQLException {
        String sql = "DELETE FROM authors WHERE author_name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, authorName);
            int deletedRows = pstmt.executeUpdate();
            if (deletedRows > 0) {
                System.out.println("Author deleted successfully!");
            } else {
                System.out.println("Author not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting author: " + e.getMessage());
        }
    }

    public void updateAuthor(Connection conn, String authorName, Date birthDate, String newNationality)
            throws SQLException {
        String sql = "UPDATE authors SET nationality = ?, birthDate = ? WHERE author_name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newNationality);
            pstmt.setDate(2, birthDate);
            pstmt.setString(3, authorName);

            int updatedRows = pstmt.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Author updated successfully!");
            } else {
                System.out.println("Author not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating author: " + e.getMessage());
        }
    }

    public void addMember(Connection conn, String name, String email, String address, Date dateJoined,
            String phoneNumber) throws SQLException {
        String sql = "INSERT INTO members (member_name, email, address, phone, date_joined) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, address);
            pstmt.setString(4, phoneNumber);
            pstmt.setDate(5, dateJoined);

            pstmt.executeUpdate();
            System.out.println("Member added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding member: " + e.getMessage());
        }
    }

    public void addGeneres(Connection conn, String name) throws SQLException {
        String sql = "INSERT INTO genres (genre_name) VALUES (?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Genre added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding genre: " + e.getMessage());
        }
    }

    public void addPublishers(Connection conn, String name, String address) throws SQLException {
        String sql = "INSERT INTO publishers (name, address) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.executeUpdate();
            System.out.println("Publisher added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding publisher: " + e.getMessage());
        }
    }

    public void addEmployee(Connection conn, String name, String position, int managerId, int branchId)
            throws SQLException {
        String sql = "INSERT INTO employees (employee_name, position, manager_id, branch_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, position);
            pstmt.setInt(3, managerId);
            pstmt.setInt(4, branchId);

            pstmt.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    public void updateBook(Connection conn, int bookId, String title, int authorId, int genreId, int publisherId,
            Date publishedDate) throws SQLException {
        String sql = "UPDATE books SET title = ?, author_id = ?, genre_id = ?, publisher_id = ?, published_date = ? WHERE book_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, authorId);
            pstmt.setInt(3, genreId);
            pstmt.setInt(4, publisherId);
            pstmt.setDate(5, publishedDate);
            pstmt.setInt(6, bookId);

            int updatedRows = pstmt.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }

    public void updateMember(Connection conn, int memberId, String name, String email, String address, Date dateJoined,
            String phoneNumber) throws SQLException {
        String sql = "UPDATE members SET member_name = ?, email = ?, address = ?, phone = ?, date_joined = ? WHERE member_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, address);
            pstmt.setString(4, phoneNumber);
            pstmt.setDate(5, dateJoined);
            pstmt.setInt(6, memberId);

            int updatedRows = pstmt.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Member updated successfully!");
            } else {
                System.out.println("Member not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating member: " + e.getMessage());
        }
    }

    public void updatePublishers(Connection conn, int publisher_id, String newName, String address)
            throws SQLException {
        String sql = "UPDATE publishers SET name = ?, address = ? WHERE publisher_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setString(2, address);
            pstmt.setInt(3, publisher_id);

            int updatedRows = pstmt.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Publisher updated successfully!");
            } else {
                System.out.println("Publisher not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating publisher: " + e.getMessage());
        }
    }

    public void updateEmployee(Connection conn, String name, String position, int managerId, int branchId)
            throws SQLException {
        String sqlFindId = "SELECT emp_id FROM employees WHERE employee_name = ?";
        String sqlUpdate = "UPDATE employees SET position = ?, manager_id = ?, branch_id = ? WHERE emp_id = ?";

        try (PreparedStatement pstmtFindId = conn.prepareStatement(sqlFindId)) {
            pstmtFindId.setString(1, name);
            ResultSet rs = pstmtFindId.executeQuery();

            if (rs.next()) {
                int empId = rs.getInt("emp_id");

                try (PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {
                    pstmtUpdate.setString(1, position);
                    pstmtUpdate.setInt(2, managerId);
                    pstmtUpdate.setInt(3, branchId);
                    pstmtUpdate.setInt(4, empId);

                    int updatedRows = pstmtUpdate.executeUpdate();
                    if (updatedRows > 0) {
                        System.out.println("Employee updated successfully!");
                    } else {
                        System.out.println("Employee not found!");
                    }
                }
            } else {
                System.out.println("Employee not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    public void searchReviews(Connection conn, int reviewId) throws SQLException {
        String sql = "SELECT * FROM reviews WHERE review_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reviewId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int bookId = rs.getInt("book_id");
                int memberId = rs.getInt("member_id");
                int rating = rs.getInt("rating");
                String reviewText = rs.getString("review_text");
                java.sql.Date reviewDate = rs.getDate("review_date");

                // Print the review details to the console
                System.out.println("Review ID: " + reviewId);
                System.out.println("Book ID: " + bookId);
                System.out.println("Member ID: " + memberId);
                System.out.println("Rating: " + rating);
                System.out.println("Review Text: " + reviewText);
                System.out.println("Review Date: " + reviewDate);
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error searching reviews: " + e.getMessage());
        }
    }

    public void deleteBook(Connection conn, int bookId) throws SQLException {
        String sql = "DELETE FROM books WHERE book_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);

            int deletedRows = pstmt.executeUpdate();
            if (deletedRows > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }

    public void deleteMember(Connection conn, String name) throws SQLException {
        String sql = "DELETE FROM members WHERE member_name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);

            int deletedRows = pstmt.executeUpdate();
            if (deletedRows > 0) {
                System.out.println("Member deleted successfully!");
            } else {
                System.out.println("Member not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting member: " + e.getMessage());
        }
    }

    public void deletePublishers(Connection conn, String name) throws SQLException {
        String sql = "DELETE FROM publishers WHERE name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);

            int deletedRows = pstmt.executeUpdate();
            if (deletedRows > 0) {
                System.out.println("Publisher deleted successfully!");
            } else {
                System.out.println("Publisher not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting publisher: " + e.getMessage());
        }
    }

    public void deleteEmployee(Connection conn, String name) throws SQLException {
        String sql = "DELETE FROM employees WHERE employee_name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);

            int deletedRows = pstmt.executeUpdate();
            if (deletedRows > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }

}