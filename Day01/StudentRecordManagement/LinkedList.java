public class LinkedList {
    public static Node head;
    public static Node tail;
    static class Node {
        int rollNo;
        String name;
        int age;
        char grade;
        Node next;
        Node(int rollNo, String name, int age, char grade) {
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }
    //function to add new node at end of linked list
    public void addAtEnd(Node node) {
        if (head == null) {
            tail = head = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }
    //method to add new node at the begining
    public void addAtBeg(Node node){
        if(head==null){
            tail=head=node;
        }else{
            node.next=head;
            head=node;
        }
    }
    //method to add new node at the specific position
    public void addAtPos(Node node, int pos){
        int i=1;
        Node temp=head;
        Node prev=null;
        while(i<pos){
            prev=temp;
            temp=temp.next;
            i++;
        }
        node.next=temp;
        prev.next=node;
    }
    //method to delete node by roll no
    public void delete(int rollNo) {
        Node temp = head;
        Node prev = null;
        while (temp.rollNo != rollNo) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = prev.next.next;
    }
    //method to search student details by Roll no
    public void search(int rollNo) {
        Node temp = head;
        while (temp.rollNo != rollNo) {
            temp = temp.next;
        }
        System.out.println("Roll No of the student is " + temp.rollNo);
        System.out.println("Name of the student is  " + temp.name);
        System.out.println("Age of the student is " + temp.age);
        System.out.println("Grade of the student is " + temp.grade);
        System.out.println();
    }
    //methods to display details of students
    public void display(Node head) {
        Node temp = head;
        while (temp != null) {

            System.out.println("Roll No of the student is : " + temp.rollNo);
            System.out.println("Name of the student is : " + temp.name);
            System.out.println("Age of the student is :" + temp.age);
            System.out.println("Grade of the student is :" + temp.grade);
            System.out.println();
            temp = temp.next;

        }
    }
    //method to upgrade grade of students by rollNo
    public void upgradeGrade(int rollNo, char newGrade) {
        Node temp = head;
        while (temp.rollNo != rollNo) {
            temp = temp.next;
        }
        temp.grade = newGrade;
    }
    //main method
    public static void main(String args[]) {
        //creating the instance of Linked list class
        LinkedList ll = new LinkedList();
        //invoking method to add new Node in Linked list at the beg,end or specific position
        ll.addAtBeg(new Node(103, "Shamiksha", 21, 'A'));
        ll.addAtEnd(new Node(21, "Anshu Priya", 23, 'A'));
        ll.addAtEnd(new Node(67, "Nimish Rathi", 25, 'B'));
        ll.addAtPos(new Node(59, "Mohan Agrwal", 25, 'B'),1);
        //invoking method to delete node by roll no
        ll.delete(67);
        //searching details by roll no
        ll.search(59);
        //upgrade details by roll no
        ll.upgradeGrade(21,'E');
        //displaying details of every nodes
        ll.display(head);
    }
}