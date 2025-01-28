import java.util.ArrayList;

class User {
    int userID;
    String name;
    int age;
    ArrayList<Integer> friendIDs; // List of Friend IDs
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head = null;

    // Add a new user
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("User added successfully!");
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return;
        }

        if (!user1.friendIDs.contains(userID2)) {
            user1.friendIDs.add(userID2);
        }
        if (!user2.friendIDs.contains(userID1)) {
            user2.friendIDs.add(userID1);
        }

        System.out.println("Friend connection added successfully!");
    }

    // Remove a friend connection
    public void removeFriendConnection(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return;
        }

        user1.friendIDs.remove((Integer) userID2);
        user2.friendIDs.remove((Integer) userID1);

        System.out.println("Friend connection removed successfully!");
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return;
        }

        ArrayList<Integer> mutualFriends = new ArrayList<>();
        for (int friendID : user1.friendIDs) {
            if (user2.friendIDs.contains(friendID)) {
                mutualFriends.add(friendID);
            }
        }

        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends found!");
        } else {
            System.out.println("Mutual Friends:");
            for (int friendID : mutualFriends) {
                User friend = findUserByID(friendID);
                System.out.println("User ID: " + friendID + ", Name: " + (friend != null ? friend.name : "Unknown"));
            }
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userID) {
        User user = findUserByID(userID);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        if (user.friendIDs.isEmpty()) {
            System.out.println(user.name + " has no friends!");
        } else {
            System.out.println("Friends of " + user.name + ":");
            for (int friendID : user.friendIDs) {
                User friend = findUserByID(friendID);
                System.out.println("User ID: " + friendID + ", Name: " + (friend != null ? friend.name : "Unknown"));
            }
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String searchParam) {
        User temp = head;
        boolean found = false;

        while (temp != null) {
            if (String.valueOf(temp.userID).equals(searchParam) || temp.name.equalsIgnoreCase(searchParam)) {
                System.out.println("User Found - User ID: " + temp.userID + ", Name: " + temp.name + ", Age: " + temp.age);
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("User not found!");
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        User temp = head;

        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIDs.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Find a user by ID
    private User findUserByID(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "shamiksha", 25);
        sm.addUser(2, "Anshu priya", 30);
        sm.addUser(3, "Kapil Tiwari", 22);
        sm.addUser(4, "Nimish", 28);

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);

        sm.displayFriends(1);
        sm.displayFriends(2);

        sm.findMutualFriends(1, 2);
        sm.findMutualFriends(1, 4);

        sm.countFriends();

        sm.searchUser("Alice");
        sm.searchUser("5");

        sm.removeFriendConnection(1, 2);
        sm.displayFriends(1);
        sm.countFriends();
    }
}
