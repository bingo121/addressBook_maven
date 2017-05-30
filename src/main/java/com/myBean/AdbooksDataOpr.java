package com.myBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

public class AdbooksDataOpr {
	
	public static ArrayList<AdbooksData> deletePerson(int position,ArrayList<AdbooksData> adbooksList){
		adbooksList.remove(position);
		return adbooksList;
	}
	
	public static ArrayList<AdbooksData> UpdataPerson(String name, String sex,String phone,String email,String address,ArrayList<AdbooksData> adbooksList,int id){
		AdbooksData person = new AdbooksData(name,sex,phone,email,address);
		adbooksList.set(id,person);
		return adbooksList;
	}
	public static ArrayList<AdbooksData> addPerson(String name, String sex,String phone,String email,String address,ArrayList<AdbooksData> adbooksList){
		AdbooksData person = new AdbooksData(name,sex,phone,email,address);
		adbooksList.add(person);
		return adbooksList;
	}
	
	public static ArrayList<AdbooksData> searchPerson(String type,String content,ArrayList<AdbooksData> adbooksList){
		
		ArrayList<AdbooksData> personLists = new ArrayList<AdbooksData>();
		
		for(AdbooksData person:adbooksList){
			if(type.equals("name")){
				if(person.getName().equals(content)){
					personLists.add(person);
				}
			}else if(type.equals("phone")){
				if(person.getPhone().equals(content)){
					personLists.add(person);
				}
			}else if(type.equals("email")){
				if(person.getEmail().equals(content)){
					personLists.add(person);
				}
			}
			
		}
		return personLists;
	}
	
	public static ArrayList<AdbooksData> getAdbooksList(String filePath){
		
		ArrayList<AdbooksData> al = new ArrayList<AdbooksData>();
		AdbooksData linkPerson = null;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
			String text = reader.readLine();
			while(text!=null){
				String[] information = text.split(" ");
				//时秀兵 男 15967153342 2994143266@qq.com 钱江湾39幢601 
				linkPerson = new AdbooksData(information[0],information[1],information[2],information[3],information[4]);
				al.add(linkPerson);
				text = reader.readLine();
			}
		}catch(Exception e){
			
		}
		return al;
	}
	
	public static void saveAdbooks(ArrayList<AdbooksData> booklist,String filePath){
		
		try{
			
			//File data = new File("F:\\jsp\\project\\addressBooks\\WebRoot\\WEB-INF\\data.txt");
			File file = new File(filePath);
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        FileOutputStream outputStream = new FileOutputStream(file,false);
	        
	        
	        for (AdbooksData data : booklist) {
	        	
	        	StringBuffer sb = new StringBuffer();
	        	sb.append(data.getName()+" ").append(data.getSex()+" ").append(data.getPhone()+" ").append(data.getEmail()+" ").append(data.getAddress()).append("\r\n");
	            outputStream.write(sb.toString().getBytes());
	            
	        }
	        outputStream.close();
	    
		}catch(Exception e){
			
		}
	}
	
}
