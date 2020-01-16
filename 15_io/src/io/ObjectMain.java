package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		PersonDTO dto = new PersonDTO("홍길동", 25, 185.3);
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
//		oos.writeObject(dto);
//		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));
		System.out.println(ois.available());
		PersonDTO dto2 = (PersonDTO) ois.readObject();
		System.out.println("이름 = " + dto2.getName());
		System.out.println("나이 = " + dto2.getAge());
		System.out.println("키 = " + dto2.getHeight());
		System.out.println(ois.available());
		ois.close();
	}

}
