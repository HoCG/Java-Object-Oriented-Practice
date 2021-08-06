import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	// Student stList[] = new Student[20];
	// int cnt;
	ArrayList<Student> stList = new ArrayList<>();
	ArrayList<Team> tmList = new ArrayList<>();

	void mymain() {
		Scanner in = openFile("teams.txt"); //���� �������� ���ɳʸ� ����
		while (in.hasNext()) {              //������ ������.
			Student s = new Student();
			s.read(in, this);               // main���� this �߰� �˾Ƽ� �о��
			stList.add(s);                  //stList�� �߰�
		} 
		// for (int i=0;i<stList.size();i++)
		// stList.get(i).print();
		for (Student s : stList)            //���� ����Ʈ
			s.print();
		for (Team s : tmList)
			s.print();
		int menu;                           //�޴� ��Ʈ��
		String kwd;
		Scanner keyin = new Scanner(System.in);
		while (true) {
			System.out.print("(1)�л� (2) �� (0) ����\n");
			menu = keyin.nextInt();
			if (menu == 0)
				break;
			kwd = keyin.next();
			while(!kwd.equals("end")) {
			if (menu == 1) {
				for (Student s : stList)
					if (s.matches(kwd))     //Ű���尡 �л��� ��ġ�� �Ǵ°�. ������ �Ѱ��� ������ Ŭ������ �޼ҵ尡.
						s.print();
			} else if (menu == 2) {
				for (Team t : tmList)
					if (t.matches(kwd))
						t.print();
			}
			kwd = keyin.next();          // �̰� ���ϸ� ��¸� �ݺ�. ���Ұ�.
			}

		}
	}

	Team getTeam(String kwd) {          
		for (Team t : tmList)            //������� ������� ����Ʈ�� 
			if (t.matches(kwd))
				return t;
		Team t = new Team(kwd);          //���ο� ���� �����Ƿ� ���ο� ���� ������ش�. Ű����� ���� �����޶�� �䱸
		tmList.add(t);                   // ���� �ڱ⸦ �ִ°�.
		return t;

	}

	Scanner openFile(String filename) {
		File f = new File(filename);
		Scanner s = null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return s;
	}

	public static void main(String[] args) {
		Main a = new Main();
		a.mymain();
	}

}
