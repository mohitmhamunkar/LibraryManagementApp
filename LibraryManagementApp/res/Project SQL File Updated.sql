CREATE DATABASE IF NOT EXISTS library_management;
USE library_management;

-- Library Branches
CREATE TABLE IF NOT EXISTS LibraryBranch (
    branch_id INT AUTO_INCREMENT PRIMARY KEY,
    branch_name VARCHAR(255) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL
);

-- Employees
CREATE TABLE IF NOT EXISTS Employees (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(255) NOT NULL,
    position ENUM('Librarian', 'Manager') NOT NULL,
    manager_id INT,
    branch_id INT NOT NULL,
    FOREIGN KEY (branch_id) REFERENCES LibraryBranch(branch_id) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (manager_id) REFERENCES Employees(emp_id) ON UPDATE CASCADE ON DELETE SET NULL
);

-- Authors
CREATE TABLE IF NOT EXISTS Authors (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    author_name VARCHAR(255) NOT NULL,
    birthdate DATE NOT NULL,
    nationality VARCHAR(255) NOT NULL
);

-- Genres
CREATE TABLE IF NOT EXISTS Genres (
    genre_id INT AUTO_INCREMENT PRIMARY KEY,
    genre_name VARCHAR(255) NOT NULL UNIQUE
);

-- Publishers
CREATE TABLE IF NOT EXISTS Publishers (
    publisher_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL
);

-- Books
CREATE TABLE IF NOT EXISTS Books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    publisher_id INT NOT NULL,
    published_date DATE NOT NULL,
    FOREIGN KEY (publisher_id) REFERENCES Publishers(publisher_id) ON UPDATE CASCADE ON DELETE RESTRICT
);

-- Book Copies
CREATE TABLE IF NOT EXISTS BookCopies (
    copy_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    branch_id INT NOT NULL,
    book_status ENUM('Available', 'Checked Out', 'Repair', 'Lost') NOT NULL,
    FOREIGN KEY (book_id) REFERENCES Books(book_id) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (branch_id) REFERENCES LibraryBranch(branch_id) ON UPDATE CASCADE ON DELETE RESTRICT
);

-- Members
CREATE TABLE IF NOT EXISTS Members (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    member_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(15) NOT NULL UNIQUE,
    date_joined DATE NOT NULL
);

-- Book Loans
CREATE TABLE IF NOT EXISTS BookLoans (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    copy_id INT NOT NULL,
    member_id INT NOT NULL,
    issue_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (copy_id) REFERENCES BookCopies(copy_id) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (member_id) REFERENCES Members(member_id) ON UPDATE CASCADE ON DELETE RESTRICT
);

-- Reviews
CREATE TABLE IF NOT EXISTS Reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    member_id INT NOT NULL,
    rating INT NOT NULL CHECK (rating BETWEEN 1 AND 5),
    review_text TEXT NOT NULL,
    review_date DATE NOT NULL,
    FOREIGN KEY (book_id) REFERENCES Books(book_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (member_id) REFERENCES Members(member_id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- BookAuthors for Many-to-Many relationship between Books and Authors
CREATE TABLE IF NOT EXISTS BookAuthors (
    book_id INT,
    author_id INT,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (author_id) REFERENCES Authors(author_id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- BookGenres for Many-to-Many relationship between Books and Genres
CREATE TABLE IF NOT EXISTS BookGenres (
    book_id INT,
    genre_id INT,
    PRIMARY KEY (book_id, genre_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES Genres(genre_id) ON UPDATE CASCADE ON DELETE CASCADE
);




INSERT INTO LibraryBranch (branch_name, address) VALUES
('Central Library', '123 Main St, Springfield, IL, 62704'),
('Downtown Branch', '456 Center Ave, Gotham, NY, 10001'),
('Westside Branch', '789 West St, Metropolis, TX, 75001'),
('Eastside Branch', '101 East Rd, Smallville, KS, 67801'),
('Lakeside Branch', '202 Lakeview Dr, Star City, CA, 90001');


INSERT INTO Employees (employee_name, position, manager_id, branch_id) VALUES
('Alice Johnson', 'Manager', NULL, 1),
('Bob Smith', 'Librarian', 1, 1),
('Carol White', 'Librarian', 1, 2),
('Dave Brown', 'Manager', NULL, 3),
('Eve Davis', 'Librarian', 4, 3);


INSERT INTO Authors (author_name, birthdate, nationality) VALUES
('Mark Twain', '1835-11-30', 'American'),
('Jane Austen', '1775-12-16', 'British'),
('Gabriel Garcia Marquez', '1927-03-06', 'Colombian'),
('Haruki Murakami', '1949-01-12', 'Japanese'),
('Virginia Woolf', '1882-01-25', 'British');


INSERT INTO Genres (genre_name) VALUES
('Fiction'),
('Non-Fiction'),
('Science Fiction'),
('Mystery'),
('Biography');


INSERT INTO Publishers (name, address) VALUES
('Penguin Books', '345 Publishers Rd, New York, NY, 10010'),
('HarperCollins', '678 Publishing St, San Francisco, CA, 94111'),
('Simon & Schuster', '901 Writers Ave, Chicago, IL, 60605'),
('Hachette Book Group', '234 Authors Ln, Boston, MA, 02110'),
('Macmillan Publishers', '567 Literature St, Austin, TX, 78701');


INSERT INTO Books (title, publisher_id, published_date) VALUES
('A Tale of Two Cities', 1, '2020-01-01'),
('Pride and Prejudice', 2, '2021-02-02'),
('To Kill a Mockingbird', 3, '2022-03-03'),
('1984', 4, '2019-04-04'),
('The Great Gatsby', 5, '2018-05-05');


INSERT INTO BookCopies (book_id, branch_id, book_status) VALUES
(1, 1, 'Available'),
(2, 2, 'Checked Out'),
(3, 3, 'Repair'),
(4, 4, 'Lost'),
(5, 5, 'Available');


INSERT INTO Members (member_name, email, address, phone, date_joined) VALUES
('John Doe', 'john.doe@example.com', '123 Elm St, Springfield, IL, 62704', '1234567890', '2021-01-01'),
('Mary Smith', 'mary.smith@example.com', '456 Oak St, Gotham, NY, 10001', '2345678901', '2021-06-01'),
('Alex Johnson', 'alex.johnson@example.com', '789 Pine St, Metropolis, TX, 75001', '3456789012', '2022-01-15'),
('Sarah Brown', 'sarah.brown@example.com', '101 Maple St, Smallville, KS, 67801', '4567890123', '2022-07-22'),
('James Williams', 'james.williams@example.com', '202 Birch St, Star City, CA, 90001', '5678901234', '2020-03-05');


INSERT INTO BookLoans (copy_id, member_id, issue_date, return_date) VALUES
(1, 1, '2023-01-01', '2023-01-15'),
(2, 2, '2023-02-01', NULL),
(3, 3, '2023-03-01', '2023-03-15'),
(4, 4, '2023-04-01', '2023-04-15'),
(5, 5, '2023-05-01', NULL);


INSERT INTO Reviews (book_id, member_id, rating, review_text, review_date) VALUES
(1, 1, 4, 'Great book!', '2023-01-20'),
(2, 2, 5, 'Loved it!', '2023-02-10'),
(3, 3, 3, 'Good, but not great', '2023-03-20'),
(4, 4, 2, 'Could be better', '2023-04-25'),
(5, 5, 5, 'A masterpiece!', '2023-05-30');


INSERT INTO BookAuthors (book_id, author_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);


INSERT INTO BookGenres (book_id, genre_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- FUNCTIONS

-- Returns the age of a member based on their birthdate.
DELIMITER $$
CREATE FUNCTION GetMemberAge(birthdate DATE) 
RETURNS INT deterministic contains sql
BEGIN
    RETURN TIMESTAMPDIFF(YEAR, birthdate, CURDATE());
END$$
DELIMITER ;

-- Returns the count of books in a specific genre.
DELIMITER $$
CREATE FUNCTION CountBooksByGenre(genre_id INT) 
RETURNS INT deterministic contains sql
BEGIN
    DECLARE book_count INT;
    SELECT COUNT(*) INTO book_count
    FROM BookGenres
    WHERE genre_id = genre_id;
    RETURN book_count;
END$$
DELIMITER ;

-- Checks if a book is available in any branch.
DELIMITER $$
CREATE FUNCTION CheckBookAvailability(book_id INT) 
RETURNS VARCHAR(255) deterministic contains sql
BEGIN
    DECLARE status VARCHAR(255);
    SELECT book_status INTO status
    FROM BookCopies
    WHERE book_id = book_id AND book_status = 'Available'
    LIMIT 1;
    IF status IS NOT NULL THEN
        RETURN 'Available';
    ELSE
        RETURN 'Unavailable';
    END IF;
END$$
DELIMITER ;


-- Returns the nationality of a specified author.
DELIMITER $$
CREATE FUNCTION GetAuthorNationality(author_id INT) 
RETURNS VARCHAR(255) deterministic contains sql
BEGIN
    DECLARE nationality VARCHAR(255);
    SELECT nationality INTO nationality
    FROM Authors
    WHERE author_id = author_id;
    RETURN nationality;
END$$
DELIMITER ;


-- Procedures


--  Adds a new member to the library.
DELIMITER $$
CREATE PROCEDURE AddNewMember(IN name VARCHAR(255), IN email VARCHAR(255), IN address VARCHAR(255), IN phone VARCHAR(15), IN joined DATE)
BEGIN
    INSERT INTO Members (member_name, email, address, phone, date_joined) 
    VALUES (name, email, address, phone, joined);
END$$
DELIMITER ;


-- Issues a book to a member.
DELIMITER $$
CREATE PROCEDURE IssueBookToMember(IN copy_id INT, IN member_id INT, IN issue_date DATE)
BEGIN
    INSERT INTO BookLoans (copy_id, member_id, issue_date) 
    VALUES (copy_id, member_id, issue_date);
    UPDATE BookCopies SET book_status = 'Checked Out' WHERE copy_id = copy_id;
END$$
DELIMITER ;


-- Handles book return and updates status.
DELIMITER $$
CREATE PROCEDURE ReturnBook(IN loan_id INT, IN return_date DATE)
BEGIN
    UPDATE BookLoans SET return_date = return_date WHERE loan_id = loan_id;
    UPDATE BookCopies 
    JOIN BookLoans ON BookCopies.copy_id = BookLoans.copy_id 
    SET BookCopies.book_status = 'Available' 
    WHERE BookLoans.loan_id = loan_id;
END$$
DELIMITER ;


-- Updates member details.
DELIMITER $$
CREATE PROCEDURE UpdateMemberDetails(IN member_id INT, IN name VARCHAR(255), IN email VARCHAR(255), IN address VARCHAR(255), IN phone VARCHAR(15))
BEGIN
    UPDATE Members 
    SET member_name = name, email = email, address = address, phone = phone 
    WHERE member_id = member_id;
END$$
DELIMITER ;

-- Removes members who haven't borrowed a book in over a year.
DELIMITER $$
CREATE PROCEDURE RemoveInactiveMembers()
BEGIN
    DELETE FROM Members 
    WHERE member_id NOT IN (
        SELECT DISTINCT member_id 
        FROM BookLoans 
        WHERE issue_date > DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
    );
END$$
DELIMITER ;


-- Triggers


-- Updates book availability status after a book is returned.
DELIMITER $$
CREATE TRIGGER AfterBookReturn 
AFTER UPDATE ON BookLoans 
FOR EACH ROW 
BEGIN
    IF NEW.return_date IS NOT NULL THEN
        UPDATE BookCopies SET book_status = 'Available' WHERE copy_id = NEW.copy_id;
    END IF;
END $$
DELIMITER ;


-- Checks if a book is available before issuing a loan.
DELIMITER $$
CREATE TRIGGER BeforeNewLoan 
BEFORE INSERT ON BookLoans 
FOR EACH ROW 
BEGIN
    DECLARE status VARCHAR(255);
    SELECT book_status INTO status FROM BookCopies WHERE copy_id = NEW.copy_id;
    IF status != 'Available' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Book is not available for loan';
    END IF;
END $$
DELIMITER ;


-- Prevents deletion of a book if it's currently on loan.
DELIMITER $$
CREATE TRIGGER BeforeBookDeletion 
BEFORE DELETE ON Books 
FOR EACH ROW 
BEGIN
    IF EXISTS (SELECT * FROM BookLoans WHERE book_id = OLD.book_id AND return_date IS NULL) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot delete book, it is currently on loan';
    END IF;
END $$
DELIMITER ;

-- Automatically sets the status of a new book copy to 'Available'.
DELIMITER $$
CREATE TRIGGER AfterNewBookCopy 
AFTER INSERT ON BookCopies 
FOR EACH ROW 
BEGIN
    UPDATE BookCopies SET book_status = 'Available' WHERE copy_id = NEW.copy_id;
END $$
DELIMITER ;

-- This trigger will check the position value before inserting or updating a record in the Employees table.
DELIMITER $$
CREATE TRIGGER CheckPositionBeforeInsertOrUpdate
BEFORE INSERT ON Employees
FOR EACH ROW
BEGIN
    IF NEW.position NOT IN ('Librarian', 'Manager') THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid position value';
    END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER CheckPositionBeforeUpdate
BEFORE UPDATE ON Employees
FOR EACH ROW
BEGIN
    IF NEW.position NOT IN ('Librarian', 'Manager') THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid position value';
    END IF;
END $$
DELIMITER ;


-- This trigger will check the book_status value before inserting or updating a record in the BookCopies table.
DELIMITER $$
CREATE TRIGGER CheckBookStatusBeforeInsertOrUpdate
BEFORE INSERT ON BookCopies
FOR EACH ROW
BEGIN
    IF NEW.book_status NOT IN ('Available', 'Checked Out', 'Repair', 'Lost') THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid book status value';
    END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER CheckBookStatusBeforeUpdate
BEFORE UPDATE ON BookCopies
FOR EACH ROW
BEGIN
    IF NEW.book_status NOT IN ('Available', 'Checked Out', 'Repair', 'Lost') THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid book status value';
    END IF;
END $$
DELIMITER ;
