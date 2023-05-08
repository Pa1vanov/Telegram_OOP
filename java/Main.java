package jk.uz.pdp;

import jk.uz.pdp.model.Message;
import jk.uz.pdp.model.User;
import jk.uz.pdp.service.message.MessageServiceImpl;
import jk.uz.pdp.service.user.UserServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner scanInt = new Scanner(System.in);
    static Scanner scanStr = new Scanner(System.in);
    static UserServiceImpl userService = new UserServiceImpl();
    static MessageServiceImpl messageService = new MessageServiceImpl();

    public static void main(String[] args) {
        defaults();

        int action = 1;

        while(action != 0) {
            System.out.println("1. SignIn\t2. SignUp\t0. Exit");
            action = scanInt.nextInt();

            switch (action) {
                case 1 -> {
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanStr.nextLine();
                    int smsCode = generateSMSCode();
                    System.out.println("============ Don't give this code to anyone else || " + smsCode);
                    userService.setSMSCode(smsCode, phoneNumber);
                    System.out.print("Enter sms code: ");
                    int code = scanInt.nextInt();

                    User currentUser = userService.signIn(phoneNumber, code);
                    if (currentUser == null) {
                        System.out.println("Wrong phone number and/or sms code");
                    } else {
                        userOperations(currentUser);
                    }
                    break;
                }
            }
        }
    }

    public static void defaults(){
        userService.create(new User("123", "Jack Wilson", 0));
        userService.create(new User("1234", "John Wick", "jhony", 0));
        userService.create(new User("12", "Bill Bobson", 0));
        userService.create(new User("23", "Billy Bob", 0));
        userService.create(new User("34", "Bil Robertson", 0));
        userService.create(new User("45", "robert Bilandowski", 0));

        messageService.create(new Message("Assalomu alaykum", 1L, 2L));
        messageService.create(new Message("Va alaykum assalom", 2L, 1L));
    }

    public static int generateSMSCode() {
        return (int) (Math.random() * 89999 + 10000);
    }

    public static void userOperations(User currentUser) {
        int action = 1;

        while(action != 0) {
            System.out.println("1. Open chat\t0. Exit");
            action = scanInt.nextInt();

            switch (action) {
                case 1 -> {
                    chats(currentUser);
                }
            }
        }
    }

    public static void chats(User currentUser) {
        int action = 1;

        while(action != 0) {
            System.out.println("1. Show all\t2. Search\t0. Back");
            action = scanInt.nextInt();

            switch (action) {
                case 1 -> {
                    ArrayList<User> users = showChatList(currentUser.getId());
                    User user = chooseChat(users);

                    if(user != null) {
                        openChat(currentUser.getId(), user.getId());

                    }

                    write(currentUser.getId(), user.getId());
                }
                case 2 -> {
                    ArrayList<User> users = searchUsersByName();
                    if (users != null) {
                        User user = chooseChat(users);

                        if (user != null) {
                            write(currentUser.getId(), user.getId());
                        }
                    }
                }
            }
        }
    }

    public static ArrayList<User> showChatList(Long userId) {
        Set<Long> chats = messageService.chats(userId);

        ArrayList<User> usersByIds = userService.getUsersByIds(chats);

        int i = 1;

        for (User user: usersByIds) {
            System.out.println(i++ + ". " + user.getFullName());
        }
        return usersByIds;
    }

    public static User chooseChat(ArrayList<User> chats) {
        System.out.print("Choose chat: ");
        int choice = scanInt.nextInt();

        if(0 < choice && choice <= chats.size()) {
            return chats.get(choice-1);
        }
        System.out.println("Wrong input\n");
        return null;
    }

    public static void openChat(Long userId, Long friendId) {
        ArrayList<Message> messages = messageService.getByUserIdAndReceiverId(userId, friendId);

        for (Message message:messages) {
            if(message.getFromId().equals(userId)) {
                System.out.println("\t\t" + message.getText());
            } else {
                System.out.println(message.getText());
            }
        }
    }

    public static void write(Long userId, Long friendId) {
        while (true) {
            System.out.println("\nWrite something: (0. Exit)");
            String text = scanStr.nextLine();

            if (text.equals("0")) {
                break;
            }
            messageService.create(new Message(text, userId, friendId));
        }
    }

    public static ArrayList<User> searchUsersByName() {
        while (true) {
            System.out.print("Enter name or part of it: (0. Back)");
            String partOfName = scanStr.nextLine();

            if(partOfName.equals("0")) {
                return null;
            }

            ArrayList<User> users = userService.searchByName(partOfName);

            if (users.size() == 0) {
                System.out.println("User with name " + partOfName + " not found");
                continue;
            }

            showUsers(users);

            System.out.println("1. Search again\t2. Choose");
            int act = scanInt.nextInt();

            if (act == 1) {
                continue;
            } else if (act == 2) {
                return users;
            }
        }
    }

    public static void showUsers(ArrayList<User> users) {
        int i = 1;
        for (User user:users) {
            System.out.println(i++ + ". " + user.getFullName() + " || " + user.getPhoneNumber());
        }
    }
}
