import java.util.Scanner;

public class Student {
	int id;
	String name;
	String mf;
	Team myTeam;                        //�ڱ��� ���� ����������.
	

	void read(Scanner scan, Main main) {
		id = scan.nextInt();            //���� �а�
		name = scan.next();
		mf = scan.next();
		String tok = scan.next();
		Team t = main.getTeam(tok);     //���ο��� Team�� ã�ƴ޶�� �䱸. ������ ����� ������ ���ΰ�
		this.myTeam = t;                // myTeam�� �ִ´�.
		t.members.add(this);
	}

	void print() {
		System.out.printf("[%d] %s (%s) - %s��\n", id, name, mf, myTeam.name);
	}

	boolean matches(String kwd) {      //���� �̸��� ��.
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
