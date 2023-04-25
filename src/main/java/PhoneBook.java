
import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */

public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }


    public void add(String name, String phoneNumber) {
        List<String> numbers = new ArrayList<>();
        numbers.add(phoneNumber);
        this.phonebook.put(name, Arrays.asList(phoneNumber));
    }


    public void addAll(String name, String[] phoneNumbers) {
        List<String> phoneList = new ArrayList<>();
        phoneList.addAll(Arrays.asList(phoneNumbers));
        this.phonebook.put(name, List.of(phoneNumbers));
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
        List<String> names = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry: phonebook.entrySet()){
            names.add(entry.getKey());
        }
        return names;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}


















































