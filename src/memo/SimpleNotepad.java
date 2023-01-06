package memo;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class SimpleNotepad extends JFrame implements ActionListener{
	JMenuBar menuBar = new JMenuBar();
	JMenu menuFile = new JMenu("File");
	JMenu format = new JMenu("Format");
	JMenuItem itemNew, itemOpen, itemSave, itemExit;
	JMenuItem itemRed, itemYellow, itemBlue, itemBlack, itemPink, itemOrange;
	JMenuItem item5, item10, item15, item20, item25, item30, item35, item40;
	JMenuItem item휴먼둥근헤드라인, item맑은고딕, item휴먼편지체, item한컴고딕, item궁서체;
	JTextArea area = new JTextArea();
	JButton jbNew, jbOpen, jbSave;
	
	public SimpleNotepad() {
		super("Simple Notepad");
		makeToolbar();
		makeMenu();
		add(area);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(800, 600);
		setVisible(true);
	}
	
	public void makeToolbar() {
		JToolBar tool = new JToolBar();
		jbNew = new JButton(new ImageIcon("images/새 문서.jpg"));
		jbOpen = new JButton(new ImageIcon("images/열기.jpg"));
		jbSave = new JButton(new ImageIcon("images/저장.jpg"));
		
		jbNew.addActionListener(jbL);
		jbOpen.addActionListener(jbL);
		jbSave.addActionListener(jbL);
		
		tool.add(jbNew);
		tool.add(jbOpen);
		tool.add(jbSave);
		add(tool, "North");
	}
	
	ActionListener jbL = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object eJb = e.getSource();
			if(eJb == jbNew) {
				area.setText("");
			} else if(eJb == jbOpen) {
				readFile();
			} else if(eJb == jbSave) {
				writeFile();
			}
			
		}
		
	};
	
	public void makeMenu() {
		//글꼴 색
		JMenu color = new JMenu("Color");
		itemRed = new JMenuItem("Red");
		itemYellow = new JMenuItem("Yellow");
		itemBlue = new JMenuItem("Blue");
		itemBlack = new JMenuItem("Black");
		itemPink = new JMenuItem("Pink");
		itemOrange = new JMenuItem("Orange");
		
		itemRed.addActionListener(this);
		itemYellow.addActionListener(this);
		itemBlue.addActionListener(this);
		itemBlack.addActionListener(this);
		itemPink.addActionListener(this);
		itemOrange.addActionListener(this);
		
		
		//글꼴 크기
		JMenu size = new JMenu("Size");
		item5 = new JMenuItem("5px");
		item10 = new JMenuItem("10px");
		item15 = new JMenuItem("15px");
		item20 = new JMenuItem("20px");
		item25 = new JMenuItem("25px");
		item30 = new JMenuItem("30px");
		item35 = new JMenuItem("35px");
		item40 = new JMenuItem("40px");
		
		item5.addActionListener(this);
		item10.addActionListener(this);
		item15.addActionListener(this);
		item20.addActionListener(this);
		item25.addActionListener(this);
		item30.addActionListener(this);
		item35.addActionListener(this);
		item40.addActionListener(this);
		
		
		//글꼴 모양
		JMenu shape = new JMenu("Shape");
		item휴먼둥근헤드라인 = new JMenuItem("휴먼둥근헤드라인");
		item맑은고딕 = new JMenuItem("맑은고딕");
		item휴먼편지체 = new JMenuItem("휴먼편지체");
		item한컴고딕 = new JMenuItem("한컴고딕");
		item궁서체 = new JMenuItem("궁서체");
		
		item휴먼둥근헤드라인.addActionListener(this);
		item맑은고딕.addActionListener(this);
		item휴먼편지체.addActionListener(this);
		item한컴고딕.addActionListener(this);
		item궁서체.addActionListener(this);
		
		
		//상위메뉴
		itemNew = new JMenuItem("New");
		itemOpen = new JMenuItem("Open");
		itemSave = new JMenuItem("Save");
		itemExit = new JMenuItem("Exit");
		
		itemNew.addActionListener(this);
		itemOpen.addActionListener(this);
		itemSave.addActionListener(this);
		itemExit.addActionListener(this);
		
		//상위메뉴
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemExit);
		
		
		//글꼴 색
		color.add(itemRed);
		color.add(itemYellow);
		color.add(itemBlue);
		color.add(itemBlack);
		color.add(itemPink);
		color.add(itemOrange);
		
		
		//글꼴 크기
		size.add(item5);
		size.add(item10);
		size.add(item15);
		size.add(item20);
		size.add(item25);
		size.add(item30);
		size.add(item35);
		size.add(item40);
		
		
		//글꼴 모양
		shape.add(item휴먼둥근헤드라인);
		shape.add(item맑은고딕);
		shape.add(item휴먼편지체);
		shape.add(item한컴고딕);
		shape.add(item궁서체);
		
		//포멧
		format.add(size);
		format.add(shape);
		format.add(color);
		
		//메뉴바에 추가
		menuBar.add(menuFile);
		menuBar.add(format);
		
		//프레임에 메뉴바 설정
		setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem eItem = (JMenuItem)e.getSource();
		if(eItem == itemNew) {
			area.setText(""); //새 메모장
		} else if(eItem == itemOpen) {
			readFile(); //열기
		} else if(eItem == itemSave) {
			writeFile(); //저장하기
		} else if(eItem == itemExit) {
//			setVisible(false);
			System.exit(0); //종료
		} else if(eItem == item휴먼둥근헤드라인) {
			area.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, area.getFont().getSize()));
		} else if(eItem == item맑은고딕) {
			area.setFont(new Font("맑은 고딕", Font.PLAIN, area.getFont().getSize()));
		} else if(eItem == item휴먼편지체) {
			area.setFont(new Font("휴먼편지체", Font.PLAIN, area.getFont().getSize()));
		} else if(eItem == item한컴고딕) {
			area.setFont(new Font("한컴 고딕", Font.PLAIN, area.getFont().getSize()));
		} else if(eItem == item궁서체) {
			area.setFont(new Font("궁서체", Font.PLAIN, area.getFont().getSize()));
		} else if(eItem == item5) {
			area.setFont(new Font(area.getFont().getFamily() , Font.PLAIN, 5));
		} else if(eItem == item10) {
			area.setFont(new Font(area.getFont().getFamily() , Font.PLAIN, 10));
		} else if(eItem == item15) {
			area.setFont(new Font(area.getFont().getFamily() , Font.PLAIN, 15));
		} else if(eItem == item20) {
			area.setFont(new Font(area.getFont().getFamily() , Font.PLAIN, 20));
		} else if(eItem == item25) {
			area.setFont(new Font(area.getFont().getFamily() , Font.PLAIN, 25));
		} else if(eItem == item30) {
			area.setFont(new Font(area.getFont().getFamily() , Font.PLAIN, 30));
		} else if(eItem == item35) {
			area.setFont(new Font(area.getFont().getFamily() , Font.PLAIN, 35));
		} else if(eItem == item40) {
			area.setFont(new Font(area.getFont().getFamily() , Font.PLAIN, 40));
		} else if(eItem == itemRed) {
			area.setForeground(Color.RED);
		} else if(eItem == itemYellow) {
			area.setForeground(Color.YELLOW);
		} else if(eItem == itemBlue) {
			area.setForeground(Color.BLUE);
		} else if(eItem == itemBlack) {
			area.setForeground(Color.BLACK);
		} else if(eItem == itemPink) {
			area.setForeground(Color.PINK);
		} else if(eItem == itemOrange) {
			area.setForeground(Color.ORANGE);
		}//if
	}

	//열기 메소드
	public void readFile() {
		area.setText("");
		FileDialog fileDlg = null;
		fileDlg = new FileDialog(this, "파일 열기", FileDialog.LOAD);
		fileDlg.setVisible(true);
		System.out.println(fileDlg.getDirectory());
		System.out.println(fileDlg.getFile());
		FileReader fileread = null;
		BufferedReader reader = null;
		
		try {
			fileread = new FileReader(new File(fileDlg.getDirectory() + "/" + fileDlg.getFile()));
			reader = new BufferedReader(fileread);
			String line = "";
			while((line = reader.readLine()) != null) {
				area.append(line + "\n");
			}//while
			reader.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//저장하기 메소드
	public void writeFile() {
		FileDialog fileDlg = null;
		fileDlg = new FileDialog(this, "파일 저장", FileDialog.SAVE);
		fileDlg.setVisible(true);
		System.out.println(fileDlg.getDirectory());
		System.out.println(fileDlg.getFile());
		FileWriter filewrite = null;
		BufferedWriter writer = null;
		
		try {
			filewrite = new FileWriter(new File(fileDlg.getDirectory() + "/" + fileDlg.getFile()));
			writer = new BufferedWriter(filewrite);
			writer.write(area.getText());
			writer.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new SimpleNotepad();
	}
	
}
