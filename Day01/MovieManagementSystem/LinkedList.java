public class LinkedList {
    public static Node head;
    public static Node tail;

    static class Node {
        Node prev;
        Node next;
        String movieTitle;
        String director;
        int yearOfRelease;
        float rating;

        Node(String movieTitle, String director, int yearOfRelease, float rating) {
            this.movieTitle = movieTitle;
            this.director = director;
            this.yearOfRelease = yearOfRelease;
            this.rating = rating;
            this.prev = null;
            this.next = null;
        }
    }

    // Add at the beginning
    public void addAtBeg(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    // Add at the end
    public void addAtEnd(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    // Add at a specific position
    public void addAtPos(int pos, Node node) {
        if (pos <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        if (head == null && pos > 1) {
            System.out.println("Position out of bounds!");
            return;
        }

        if (pos == 1) {
            addAtBeg(node);
            return;
        }

        Node temp = head;
        int i = 1;

        while (temp != null && i < pos - 1) {
            temp = temp.next;
            i++;
        }

        if (temp == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        node.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = node;
        }
        temp.next = node;
        node.prev = temp;

        if (node.next == null) {
            tail = node;
        }
    }

    // Remove a movie by title
    public void remove(String movieTitle) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        while (temp != null && !temp.movieTitle.equals(movieTitle)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found!");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // List is now empty
            }
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        while (temp != null) {
            printNodeDetails(temp);
            temp = temp.next;
        }
    }

    // Display backward
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = tail;
        while (temp != null) {
            printNodeDetails(temp);
            temp = temp.prev;
        }
    }

    // Search by director
    public void search(String director) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equals(director)) {
                printNodeDetails(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found for director: " + director);
        }
    }

    // Search by rating
    public void search(float rating) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                printNodeDetails(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Update rating by title
    public void updateRating(String movieTitle, float newRating) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        while (temp != null) {
            if (temp.movieTitle.equals(movieTitle)) {
                temp.rating = newRating;
                System.out.println("Rating updated for movie: " + movieTitle);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found: " + movieTitle);
    }

    // Utility method to print node details
    private void printNodeDetails(Node node) {
        System.out.println("Title of the movie: " + node.movieTitle);
        System.out.println("Director of the movie: " + node.director);
        System.out.println("Year of release: " + node.yearOfRelease);
        System.out.println("Rating of the movie: " + node.rating);
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addAtEnd(new Node("Barfi", "Priyanka Singh", 2021, 3));
        ll.addAtBeg(new Node("Jab Tak Hai Jaan", "Yash Chopra", 2012, 4));
        ll.addAtPos(2, new Node("DDLJ", "Yash Raj", 2000, 5));
        ll.addAtEnd(new Node("Happy New Year", "Farha Khan", 2018, 3));

        ll.displayForward();

        ll.remove("DDLJ");
        ll.search("Farha Khan");
        ll.search(3);

        ll.displayForward();
        ll.displayBackward();

        ll.updateRating("Jab Tak Hai Jaan", 5);
        ll.displayForward();
    }
}
