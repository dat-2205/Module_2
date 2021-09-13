package controller;

import model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static view.PhoneBookView.sc;

public class ContactManagement {
    private List<Contact> contactList;

    public ContactManagement() {
        contactList = new ArrayList<>();
    }

    public ContactManagement(List<Contact> phoneList) {
        this.contactList = phoneList;
    }

    public List<Contact> getPhoneList() {
        return contactList;
    }

    public void setPhoneList(List<Contact> phoneList) {
        this.contactList = phoneList;
    }

    public void add(Contact p) {
        contactList.add(p);
    }

    public void delete(int index) {
        contactList.remove(index);
    }

    public void update(int index, Contact p) {
        contactList.set(index,p);
    }

    public int findByPhoneNumber(String phoneNumber) {
        for(int i = 0; i< contactList.size(); i++) {
            if(contactList.get(i).getPhoneNumber().equals(phoneNumber)) {
                return i;
            }
        }
        return -1;
    }

   public void findByPhoneNumberContain(String phoneNumber) {
        for(Contact contact : contactList ) {
            if(contact.getPhoneNumber().contains(phoneNumber)) {
                System.out.println(contact);
            }
        }
   }

    public void showAll() {
        int count = 0;
        for(int i=0;i<contactList.size();i++) {
            System.out.println((i+1) + " " + contactList.get(i));
            count++;
            if(count==5) {
                sc.nextLine();
            }
        }
    }

    public void writeToFile(String path) {
        try {
            FileOutputStream os = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(contactList);
            oos.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> readFromFile(String path) {
        List<Contact> phoneBookElementList = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            phoneBookElementList = (List<Contact>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return phoneBookElementList;
    }
}
