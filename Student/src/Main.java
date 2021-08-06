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
		Scanner in = openFile("teams.txt"); //파일 오픈으로 스케너를 만듦
		while (in.hasNext()) {              //끝까지 읽은다.
			Student s = new Student();
			s.read(in, this);               // main부의 this 추가 알아서 읽어라
			stList.add(s);                  //stList에 추가
		} 
		// for (int i=0;i<stList.size();i++)
		// stList.get(i).print();
		for (Student s : stList)            //이후 프린트
			s.print();
		for (Team s : tmList)
			s.print();
		int menu;                           //메뉴 인트형
		String kwd;
		Scanner keyin = new Scanner(System.in);
		while (true) {
			System.out.print("(1)학생 (2) 팀 (0) 종료\n");
			menu = keyin.nextInt();
			if (menu == 0)
				break;
			kwd = keyin.next();
			while(!kwd.equals("end")) {
			if (menu == 1) {
				for (Student s : stList)
					if (s.matches(kwd))     //키워드가 학생과 매치가 되는가. 디테일 한것은 각각의 클래스의 메소드가.
						s.print();
			} else if (menu == 2) {
				for (Team t : tmList)
					if (t.matches(kwd))
						t.print();
			}
			kwd = keyin.next();          // 이걸 안하면 출력만 반복. 꼭할것.
			}

		}
	}

	Team getTeam(String kwd) {          
		for (Team t : tmList)            //현재까지 만들어진 리스트에 
			if (t.matches(kwd))
				return t;
		Team t = new Team(kwd);          //새로운 팀이 왔으므로 새로운 팀을 만들어준다. 키워드로 팀을 만들어달라고 요구
		tmList.add(t);                   // 팀에 자기를 넣는것.
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
