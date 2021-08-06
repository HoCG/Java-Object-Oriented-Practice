import java.util.ArrayList;

public class Team {
	String name;
	ArrayList<Student> members = new ArrayList<>();          //자료구조를 이용.

	Team(String name) {
		this.name = name;
	}

	void addMember(Student s) {
		members.add(s);
	}
	void print()
	{
		System.out.printf("%s-[",name);
		for(Student s: members)
			System.out.printf(s.name+" ");
		System.out.println("]");
	}

	boolean matches(String kwd) {
		if (name.equals(kwd))
			return true;
		for(Student s: members)
			if(s.matches(kwd))          //학생 하나하나를 매치
				return true;
		return false;
	}
}