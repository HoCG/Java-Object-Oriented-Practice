import java.util.Scanner;

public class Student {
	int id;
	String name;
	String mf;
	Team myTeam;                        //자기의 팀을 가지고있음.
	

	void read(Scanner scan, Main main) {
		id = scan.nextInt();            //각각 읽고
		name = scan.next();
		mf = scan.next();
		String tok = scan.next();
		Team t = main.getTeam(tok);     //메인에게 Team을 찾아달라고 요구. 있으면 만들고 없으면 관두고
		this.myTeam = t;                // myTeam에 넣는다.
		t.members.add(this);
	}

	void print() {
		System.out.printf("[%d] %s (%s) - %s팀\n", id, name, mf, myTeam.name);
	}

	boolean matches(String kwd) {      //팀의 이름만 비교.
		if (name.equals(kwd))
			return true;
		if (mf.equals(kwd))
			return true;
		if (myTeam.name.equals(kwd))
			return true;
		if (kwd.matches("[0-9]+")&&Integer.parseInt(kwd)==id)
			return true;
		return false;
	}
}
