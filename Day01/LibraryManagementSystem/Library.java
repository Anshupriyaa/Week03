class Book {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head = null;
    private Book tail = null;
    private int totalBooks = 0;

    // Add a new book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        totalBooks++;
        System.out.println("Book added at the beginning: " + title);
    }

    // Add a new book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        totalBooks++;
        System.out.println("Book added at the end: " + title);
    }

    // Add a book at a specific position
    public void addBookAtPosition(String title, String author, String genre, int bookID, boolean isAvailable, int position) {
        if (position < 1 || position > totalBooks + 1) {
            System.out.println("Invalid position!");
            return;
        }

        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }

        if (position == totalBooks + 1) {
            addBookAtEnd(title, author, genre, bookID, isAvailable);
            return;
        }

        Book temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;

        totalBooks++;
        System.out.println("Book added at position " + position + ": " + title);
    }

    // Remove a book by Book ID
    public void removeBook(int bookID) {
        if (head == null) {
            System.out.println("No books to remove!");
            return;
        }

        Book temp = head;

        while (temp != null) {
            if (temp.bookID == bookID) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                totalBooks--;
                System.out.println("Book removed: ID=" + bookID);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found: ID=" + bookID);
    }

    // Search for a book by Title or Author
    public void searchBook(String searchParam) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(searchParam) || temp.author.equalsIgnoreCase(searchParam)) {
                System.out.println("Book Found - Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookID + ", Availability: " + (temp.isAvailable ? "Available" : "Not Available"));
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No books found for search: " + searchParam);
        }
    }

    // Update a book's availability status
    public void updateAvailability(int bookID, boolean isAvailable) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.isAvailable = isAvailable;
                System.out.println("Book availability updated: ID=" + bookID + ", Status: " + (isAvailable ? "Available" : "Not Available"));
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found: ID=" + bookID);
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books in the library!");
            return;
        }

        System.out.println("\nBooks in Forward Order:");
        Book temp = head;

        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookID + ", Availability: " + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("No books in the library!");
            return;
        }

        System.out.println("\nBooks in Reverse Order:");
        Book temp = tail;

        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookID + ", Availability: " + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    // Count the total number of books
    public void countBooks() {
        System.out.println("Total number of books in the library: " + totalBooks);
    }

    public static void main(String[] args) {
        Library library = new Library();

        library.addBookAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addBookAtBeginning("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true);
        library.addBookAtPosition("1984", "George Orwell", "Dystopian", 103, true, 2);

        library.displayBooksForward();
        library.displayBooksReverse();

        library.searchBook("1984");
        library.searchBook("J.K. Rowling");

        library.updateAvailability(101, false);
        library.displayBooksForward();

        library.removeBook(102);
        library.displayBooksForward();

        library.countBooks();
    }
}
