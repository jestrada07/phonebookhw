
import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */

public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) { //constructor that initializes a "phonebook" with a given map.
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());    //default constructor that initializes an empty "phonebook"
    }


    public void add(String name, String phoneNumber) {   //adds a single phone number to the phonebook under the given name
        List<String> numbers = new ArrayList<>();
        numbers.add(phoneNumber);
        this.phonebook.put(name, Arrays.asList(phoneNumber));
    }


    public void addAll(String name, String[] phoneNumbers) { //adds an array of phone numbers to the phonebook under the given name
        List<String> phoneList = new ArrayList<>();
        phoneList.addAll(Arrays.asList(phoneNumbers)); //Returns a fixed-size list backed by the specified array. Changes made to the array will be visible in the returned list, and changes made to the list will be visible in the array
        this.phonebook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber){
        if (this.phonebook.containsKey(name)) {
            if(this.phonebook.containsValue(Arrays.asList(phoneNumber))){
                return true;
            }
        }
        return false;
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()){
            if (entry.getValue().contains(phoneNumber)){
                return entry.getKey();
            }
        }
        return "Invalid phoneNumber";
    }

    public List<String> getAllContactNames(){
        List<String> names = new ArrayList<>(); //creating an array list type string that is named "names"
        for(Map.Entry<String,List<String>> entry: phonebook.entrySet()){      //Returns a Set view of the mappings contained in this map. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.
            names.add(entry.getKey());
        }
        return names;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}


















































