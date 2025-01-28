class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head = null;

    // Add a new ticket reservation
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head; // Circular linking
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("Ticket added successfully!");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove!");
            return;
        }
        Ticket current = head, prev = null;
        do {
            if (current.ticketID == ticketID) {
                if (prev == null) { // Removing head
                    Ticket temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    if (head == head.next) { // Only one node
                        head = null;
                    } else {
                        temp.next = head.next;
                        head = head.next;
                    }
                } else { // Removing non-head node
                    prev.next = current.next;
                }
                System.out.println("Ticket removed successfully!");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Ticket ID not found!");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets available!");
            return;
        }
        Ticket temp = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer Name: " + temp.customerName +
                    ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber +
                    ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchParam) {
        if (head == null) {
            System.out.println("No tickets to search!");
            return;
        }
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(searchParam) || temp.movieName.equalsIgnoreCase(searchParam)) {
                System.out.println("Found Ticket - Ticket ID: " + temp.ticketID + ", Customer Name: " + temp.customerName +
                        ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber +
                        ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tickets found for the given search parameter!");
        }
    }

    // Calculate the total number of booked tickets
    public int totalTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(1, "Shamiksha", "Barfi", "A1", "10:00 AM");
        system.addTicket(2, "Nimish", "Jab Tak Hai Jaan", "B2", "12:00 PM");
        system.addTicket(3, "Mohan", "Titanic", "C3", "02:00 PM");

        system.displayTickets();

        system.searchTicket("TItanic");
        system.searchTicket("Zindagi na milegi dobara");

        System.out.println("Total Tickets: " + system.totalTickets());

        system.removeTicket(2);
        system.displayTickets();

        System.out.println("Total Tickets: " + system.totalTickets());
    }
}
