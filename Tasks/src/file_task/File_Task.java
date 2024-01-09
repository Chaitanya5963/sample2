package file_task;
import java.util.*;
import java.io.Serializable;
import java.io.*;
public class File_Task {
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		ArrayList<Student> a = new ArrayList<Student>();
		a.add(new Student(1,"Chaitanya"));
		a.add(new Student(2,"Harsha"));
		a.add(new Student(3,"Mohan"));
		FileOutputStream fout = new FileOutputStream("files_task.txt");
		ObjectOutputStream os = new ObjectOutputStream(fout);
		os.writeObject(a);
		os.close();
		fout.close();
		FileInputStream fin = new FileInputStream("files_task.txt");
		ObjectInputStream is = new ObjectInputStream(fin);
		ArrayList<Student> list = (ArrayList)is.readObject();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Student st = (Student)it.next();
			System.out.println(st.id+" "+st.name);
		}
		is.close();
		fin.close();
	}
}
class Student implements Serializable {
	int id;
	 String name;
	Student(int id, String name){
		this.id = id;
		this.name = name;
	}
}