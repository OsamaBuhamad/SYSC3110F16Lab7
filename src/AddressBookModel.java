import java.util.ArrayList;
import java.util.Observable;

import javax.swing.DefaultListModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class AddressBookModel extends Observable {
//	private ArrayList <BuddyInfo> buddyList;
	
	private DefaultListModel<BuddyInfo> buddyList = new DefaultListModel<BuddyInfo>();
	
	public AddressBookModel(){
		buddyList = new DefaultListModel<BuddyInfo>(); 
	}
	
	public void addBuddy(BuddyInfo b){
		if(b != null){
		buddyList.addElement(b);
		setChanged();
		notifyObservers();
		}
		
	}
	
	public void removeBuddy(int i){
		if (i>=0 && i<buddyList.size()){
			buddyList.remove(i);
			
			setChanged();
			notifyObservers();
			 
		}
	}
	
	public void editBuddy(int i, String name, String address, String number, int age){
		buddyList.getElementAt(i).setName(name);
		buddyList.getElementAt(i).setAddress(address);
		buddyList.getElementAt(i).setNumber(number);
		buddyList.getElementAt(i).setAge(age);
		
		
		setChanged();
		notifyObservers();
	}
	
	public DefaultListModel<BuddyInfo> getBuddyList() {
		return buddyList;
	}
	
	public DefaultListModel getBuddyList2() {
		return buddyList;
	}
	
	public BuddyInfo getBuddyAt(int index){
		return buddyList.getElementAt(index);
	}
	
	public int size(){
		return buddyList.size();
	}
	
	public void clear(){
		buddyList.clear();
	}
	
	public void export(){

		
		PrintWriter out = null;
		try {
			out = new PrintWriter("myFile.txt");
			for(int i=0;i<=buddyList.size()-1;i++)
			{
				String s =  buddyList.get(i).toString();
				out.println(s);
				//out.newLine();
			
			}//end of for 
			
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public static void main (String[] args){
		BuddyInfo buddy = new BuddyInfo("Bolt","123 Jam","123",33);
		
		String input = "Totti$123 Roma$1927$40";
		
		AddressBookModel ab = new AddressBookModel();
		ab.addBuddy(buddy);
		ab.export();
		
		buddy = BuddyInfo.importt(input); 
		System.out.println(buddy.toString());
		System.out.println("done");
	}
	

}
