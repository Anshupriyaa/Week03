// Source code is decompiled from a .class file using FernFlower decompiler.
class TicketReservationSystem {
    private Ticket head = null;
 
    TicketReservationSystem() {
    }
 
    public void addTicket(int var1, String var2, String var3, String var4, String var5) {
       Ticket var6 = new Ticket(var1, var2, var3, var4, var5);
       if (this.head == null) {
          this.head = var6;
          this.head.next = this.head;
       } else {
          Ticket var7;
          for(var7 = this.head; var7.next != this.head; var7 = var7.next) {
          }
 
          var7.next = var6;
          var6.next = this.head;
       }
 
       System.out.println("Ticket added successfully!");
    }
 
    public void removeTicket(int var1) {
       if (this.head == null) {
          System.out.println("No tickets to remove!");
       } else {
          Ticket var2 = this.head;
          Ticket var3 = null;
 
          while(var2.ticketID != var1) {
             var3 = var2;
             var2 = var2.next;
             if (var2 == this.head) {
                System.out.println("Ticket ID not found!");
                return;
             }
          }
 
          if (var3 == null) {
             Ticket var4;
             for(var4 = this.head; var4.next != this.head; var4 = var4.next) {
             }
 
             if (this.head == this.head.next) {
                this.head = null;
             } else {
                var4.next = this.head.next;
                this.head = this.head.next;
             }
          } else {
             var3.next = var2.next;
          }
 
          System.out.println("Ticket removed successfully!");
       }
    }
 
    public void displayTickets() {
       if (this.head == null) {
          System.out.println("No tickets available!");
       } else {
          Ticket var1 = this.head;
          System.out.println("Current Tickets:");
 
          do {
             System.out.println("Ticket ID: " + var1.ticketID + ", Customer Name: " + var1.customerName + ", Movie Name: " + var1.movieName + ", Seat Number: " + var1.seatNumber + ", Booking Time: " + var1.bookingTime);
             var1 = var1.next;
          } while(var1 != this.head);
 
       }
    }
 
    public void searchTicket(String var1) {
       if (this.head == null) {
          System.out.println("No tickets to search!");
       } else {
          Ticket var2 = this.head;
          boolean var3 = false;
 
          do {
             if (var2.customerName.equalsIgnoreCase(var1) || var2.movieName.equalsIgnoreCase(var1)) {
                System.out.println("Found Ticket - Ticket ID: " + var2.ticketID + ", Customer Name: " + var2.customerName + ", Movie Name: " + var2.movieName + ", Seat Number: " + var2.seatNumber + ", Booking Time: " + var2.bookingTime);
                var3 = true;
             }
 
             var2 = var2.next;
          } while(var2 != this.head);
 
          if (!var3) {
             System.out.println("No tickets found for the given search parameter!");
          }
 
       }
    }
 
    public int totalTickets() {
       if (this.head == null) {
          return 0;
       } else {
          int var1 = 0;
          Ticket var2 = this.head;
 
          do {
             ++var1;
             var2 = var2.next;
          } while(var2 != this.head);
 
          return var1;
       }
    }
 
    public static void main(String[] var0) {
       TicketReservationSystem var1 = new TicketReservationSystem();
       var1.addTicket(1, "Shamiksha", "Barfi", "A1", "10:00 AM");
       var1.addTicket(2, "Nimish", "Jab Tak Hai Jaan", "B2", "12:00 PM");
       var1.addTicket(3, "Mohan", "Titanic", "C3", "02:00 PM");
       var1.displayTickets();
       var1.searchTicket("Titanic");
       var1.searchTicket("Zindagi na milegi dobara");
       System.out.println("Total Tickets: " + var1.totalTickets());
       var1.removeTicket(2);
       var1.displayTickets();
       System.out.println("Total Tickets: " + var1.totalTickets());
    }
 }
 