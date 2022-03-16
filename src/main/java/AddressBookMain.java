
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * class containing different contacts
 */
public class AddressBookMain {
    private List<AddressBookMain> contact = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    /**
     * default constructor to print welcome message
     */
    public AddressBookMain() {
        System.out.println("Welcome to address book program");
    }


    public AddressBookMain(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * method to insert a new contact into addressbook
     */
    public void insertContact() {
        System.out.println("Enter the details of person!!");
        System.out.println("first Name:");
        String firstname = sc.next();
        if (!duplicateCheck(firstname)) {
            System.out.println("last name:");
            String last_name = sc.next();
            System.out.println("address:");
            String address = sc.next();
            System.out.println("city:");
            String city = sc.next();
            System.out.println("state:");
            String state = sc.next();
            System.out.println("zip:");
            String zip = sc.next();
            System.out.println("phone number:");
            String phone_number = sc.next();
            System.out.println("E-mail:");
            String email = sc.next();
            contact.add(new AddressBookMain(firstname, last_name, address, city, state, zip, phone_number, email));
        }
    }

    public void writeFile(String file) {
        try {
            FileWriter writer = new FileWriter(file + ".txt", true);
            for (int j = 0; j < contact.size(); j++) {
                AddressBookMain object = contact.get(j);
                writer.write("\nfirstname:" + object.firstName + "\nlastname:" + object.lastName +
                        "\naddress:" + object.address + "\ncity:" + object.city + "\nstate:" + object.state
                        + "\nzip:" + object.zip + "\nphone number:" + object.phoneNumber + "\nemail:"
                        + object.email + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(String file) throws IOException {
        FileReader fr = new FileReader(file + ".txt");
        int i;
        while ((i = fr.read()) != -1)
            System.out.print((char) i);
    }

    /**
     * method to display a particular contact
     */
    public void display() {
        System.out.println("Enter the person whose contact to be displayed"); //to display desired contact
        String name1 = sc.next();    //input is taken from console
        int flag = 0;
        for (int j = 0; j < contact.size(); j++) {
            AddressBookMain object = contact.get(j);
            if (object.firstName.equals(name1)) {
                flag = 1;
                System.out.println("first Name:" + object.firstName);
                System.out.println("last name:" + object.lastName);
                System.out.println("address:" + object.address);
                System.out.println("city:" + object.city);
                System.out.println("state:" + object.state);
                System.out.println("zip:" + object.zip);
                System.out.println("phone number:" + object.phoneNumber);
                System.out.println("E-mail:" + object.email);
            }
        }
        if (flag == 0)
            System.out.println("Contact not found!!!");
    }

    /**
     * method to display the entire addressbook
     */
    public void display_addressbook() {
        if (contact.size() == 0) {
            System.out.println("No Contacts in the address book!!!");
        } else {
            System.out.println("Address book contains following contacts!!!");
            for (int j = 0; j < contact.size(); j++) {
                AddressBookMain object = contact.get(j);
                System.out.println("Contact details of person" + j);
                System.out.println("first Name:" + object.firstName);
                System.out.println("last name:" + object.lastName);
                System.out.println("address:" + object.address);
                System.out.println("city:" + object.city);
                System.out.println("state:" + object.state);
                System.out.println("zip:" + object.zip);
                System.out.println("phone number:" + object.phoneNumber);
                System.out.println("E-mail:" + object.email);
            }
        }
    }

    /**
     * method to edit the contact of addressbook
     */
    public void edit() {
        System.out.println("Enter the person whose contact to be edited");
        String name = sc.next();
        int flag = 0;
        for (int j = 0; j < contact.size(); j++) {
            AddressBookMain object = contact.get(j);
            if (object.firstName.equals(name)) {
                flag = 1;
                System.out.println("first Name:" + object.firstName);
                System.out.println("last name:" + object.lastName);
                System.out.println("address:" + object.address);
                System.out.println("city:" + object.city);
                System.out.println("state:" + object.state);
                System.out.println("zip:" + object.zip);
                System.out.println("phone number:" + object.phoneNumber);
                System.out.println("E-mail:" + object.email);
                System.out.println("Enter the number which you want to edit\n1.first name\n2.last name\n3.address\n4.city\n5.state\n6.zip\n7.phone number\n8.email");
                int choose = sc.nextInt();
                switch (choose) {
                    case 1:
                        System.out.println("first name:");
                        object.firstName = sc.next();
                        break;
                    case 2:
                        System.out.println("last name:");
                        object.lastName = sc.next();
                        break;
                    case 3:
                        System.out.println("address:");
                        object.address = sc.next();
                        break;

                    case 4:
                        System.out.println("city:");
                        object.city = sc.next();
                        break;
                    case 5:
                        System.out.println("state:");
                        object.state = sc.next();
                        break;
                    case 6:
                        System.out.println("zip:");
                        object.zip = sc.next();
                        break;
                    case 7:
                        System.out.println("phone_number:");
                        object.phoneNumber = sc.next();
                        break;
                    case 8:
                        System.out.println("email:");
                        object.email = sc.next();
                        break;
                }
            }
        }
        if (flag == 0)
            System.out.println("Contact not found!!!");
    }

    /**
     * method to delete a contact in a addressbook
     */
    public void delete() {
        System.out.println("Enter the person whose contact to be deleted");
        String name11 = sc.next();
        int flag = 0;
        for (int j = 0; j < contact.size(); j++) {
            AddressBookMain object = contact.get(j);
            if (object.firstName.equals(name11)) {
                flag = 1;
                contact.remove(object);
            }
        }
        if (flag == 0)
            System.out.println("Contact not found!!!");
    }

    /**
     * method to check if contact is already present in addressbook
     */
    public Boolean duplicateCheck(String name) {
        for (int j = 0; j < contact.size(); j++) {
            AddressBookMain object = contact.get(j);
            if (object.firstName.equals(name)) {
                System.out.println("Contact already exists!!Please enter a different contact name");
                return true;
            }
        }
        return false;
    }

    /*
     * method to search a particular contact based on city or state
     */
    public void search(String place) {
        for (int j = 0; j < contact.size(); j++) {
            AddressBookMain object = contact.get(j);
            if (object.city.equals(place) || object.state.equals(place)) {
                System.out.println(object.firstName + " " + object.lastName);
            }
        }

    }

    /**
     * method to view a particular contact based on state
     */
    public void viewPersonByState() {
        Map<String, List<String>> stateMap = new HashMap<>();
        for (int j = 0; j < contact.size(); j++) {
            AddressBookMain object = contact.get(j);
            if (stateMap.containsKey(object.state)) {
                List<String> temp = stateMap.get(object.state);
                temp.add(object.firstName);
                stateMap.put(object.state, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(object.firstName);
                stateMap.put(object.state, temp);
            }
        }
        for (Map.Entry m : stateMap.entrySet()) {

            System.out.println(m.getKey() + " : " + m.getValue());
            System.out.println("There are " + ((List<String>) m.getValue()).size() + " persons in state " + m.getKey());
        }
    }

    /**
     * method to view a particular contact based on city
     */
    @SuppressWarnings("unchecked")
    public void viewPersonByCity() {
        Map<String, List<String>> cityMap = new HashMap<>();
        for (int j = 0; j < contact.size(); j++) {
            AddressBookMain object = contact.get(j);
            if (cityMap.containsKey(object.city)) {
                List<String> temp = cityMap.get(object.city);
                temp.add(object.firstName);
                cityMap.put(object.city, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(object.firstName);
                cityMap.put(object.city, temp);
            }
        }
        for (Map.Entry m : cityMap.entrySet()) {

            System.out.println(m.getKey() + " : " + m.getValue());
            System.out.println("There are " + ((List<String>) m.getValue()).size() + " persons in city " + m.getKey());

        }
    }
    /**
     * method to sort the list based on name or city or state or zip
     */

    public void sortPersonByNameCityStateZip(int option) {

        Map<String, List<AddressBookMain>> map = new HashMap<>();
        if (option == 1) {
            for (int j = 0; j < contact.size(); j++) {
                AddressBookMain object = contact.get(j);
                if (map.containsKey(object.firstName)) {
                    List<AddressBookMain> temp = map.get(object.firstName);
                    temp.add(object);
                    map.put(object.firstName, temp);
                } else {
                    List<AddressBookMain> temp = new ArrayList<>();
                    temp.add(object);
                    map.put(object.firstName, temp);
                }
            }
        } else if (option == 2) {
            for (int j = 0; j < contact.size(); j++) {
                AddressBookMain object = contact.get(j);
                if (map.containsKey(object.city)) {
                    List<AddressBookMain> temp = map.get(object.city);
                    temp.add(object);
                    map.put(object.city, temp);
                } else {
                    List<AddressBookMain> temp = new ArrayList<>();
                    temp.add(object);
                    map.put(object.city, temp);
                }
            }
        } else if (option == 3) {
            for (int j = 0; j < contact.size(); j++) {
                AddressBookMain object = contact.get(j);
                if (map.containsKey(object.state)) {
                    List<AddressBookMain> temp = map.get(object.state);
                    temp.add(object);
                    map.put(object.state, temp);
                } else {
                    List<AddressBookMain> temp = new ArrayList<>();
                    temp.add(object);
                    map.put(object.state, temp);
                }
            }
        } else if (option == 4) {
            for (int j = 0; j < contact.size(); j++) {
                AddressBookMain object = contact.get(j);
                if (map.containsKey(object.zip)) {
                    List<AddressBookMain> temp = map.get(object.zip);
                    temp.add(object);
                    map.put(object.zip, temp);
                } else {
                    List<AddressBookMain> temp = new ArrayList<>();
                    temp.add(object);
                    map.put(object.zip, temp);
                }
            }
        } else {
            System.out.println("choose correct option");
        }
        Map<String, List<AddressBookMain>> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<String, List<AddressBookMain>> entry : sortedMap.entrySet()) {
            for (AddressBookMain a : entry.getValue()) {
                System.out.println("First Name:" + a.firstName);
                System.out.println("Last Name:" + a.lastName);
                System.out.println("Address:" + a.address);
                System.out.println("City:" + a.city);
                System.out.println("State:" + a.state);
                System.out.println("Zip:" + a.zip);
                System.out.println("Phone number:" + a.phoneNumber);
                System.out.println("E-mail:" + a.email);
                System.out.println("--------------------------------------------");
            }
        }
    }
}
