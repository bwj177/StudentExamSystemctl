package com.artisan.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.artisan.model.UserType;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;
	private JMenuItem addStudentMenuItem ;
	private JMenu manageClassMenu ;
	private JMenu manageTeacherMenu;
	private JMenuItem addTeacherMenuItem;
	private JMenu courseMenu;

	public MainFrm(UserType userType,Object userObject) {



		this.userType = userType;
		this.userObject = userObject;
		setTitle("ѧ��ѡ��ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 774);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);






		JMenu menu = new JMenu("ϵͳ����");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/ϵͳ����1.png")));
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("�޸�����");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/�޸�����2.png")));
		menu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "ȷ���˳���") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/�˳�2.png")));
		menu.add(menuItem_1);

		JMenu menu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/ѧ������2.png")));
		menuBar.add(menu_1);

		addStudentMenuItem = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		addStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentFrm addStudentFrm = new AddStudentFrm();
				addStudentFrm.setVisible(true);
				desktopPane.add(addStudentFrm);
			}
		});
		addStudentMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/���2.png")));
		menu_1.add(addStudentMenuItem);

		JMenuItem menuItem_3 = new JMenuItem("\u5B66\u751F\u5217\u8868");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStudentFrm studentManageFrm = new ManageStudentFrm();
				studentManageFrm.setVisible(true);
				desktopPane.add(studentManageFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/�û��б�2.png")));
		menu_1.add(menuItem_3);


		manageClassMenu = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		manageClassMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/�༶����.png")));
		menuBar.add(manageClassMenu);

		JMenuItem menuItem_4 = new JMenuItem("\u73ED\u7EA7\u6DFB\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addStudentClass(ae);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/���2.png")));
		manageClassMenu.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("\u73ED\u7EA7\u7BA1\u7406");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageClassFrm classManageFrm = new ManageClassFrm();
				classManageFrm.setVisible(true);
				desktopPane.add(classManageFrm);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/�༶�б�.png")));
		manageClassMenu.add(menuItem_5);

		manageTeacherMenu = new JMenu("\u6559\u5E08\u7BA1\u7406");
		manageTeacherMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/��ʦ����.png")));
		menuBar.add(manageTeacherMenu);

		addTeacherMenuItem = new JMenuItem("\u6DFB\u52A0\u6559\u5E08");
		addTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacherFrm addTeacherFrm = new AddTeacherFrm();
				addTeacherFrm.setVisible(true);
				desktopPane.add(addTeacherFrm);
			}
		});
		addTeacherMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/��ʦ.png")));
		manageTeacherMenu.add(addTeacherMenuItem);

		JMenuItem menuItem_8 = new JMenuItem("��ʦ�б�");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageTeacherFrm manageTeacherFrm = new ManageTeacherFrm();
				manageTeacherFrm.setVisible(true);
				desktopPane.add(manageTeacherFrm);
			}
		});
		menuItem_8.setIcon(new ImageIcon(MainFrm.class.getResource("/images/�û��б�2.png")));
		manageTeacherMenu.add(menuItem_8);




		courseMenu = new JMenu("\u8BFE\u7A0B\u7BA1\u7406");
		courseMenu.setIcon(new ImageIcon(	Objects.requireNonNull(MainFrm.class.getResource("/images/�γ�2.png"))));
		menuBar.add(courseMenu);

		JMenuItem addCourseMenuItem = new JMenuItem("\u6DFB\u52A0\u8BFE\u7A0B");
		addCourseMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddCourseFrm addCourseFrm = new AddCourseFrm();
				addCourseFrm.setVisible(true);
				desktopPane.add(addCourseFrm);
			}
		});
		addCourseMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/���2.png")));
		courseMenu.add(addCourseMenuItem);

		JMenuItem courseListMenuItem = new JMenuItem("\u8BFE\u7A0B\u5217\u8868");
		courseListMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageCourseFrm manageCourseFrm = new ManageCourseFrm();
				manageCourseFrm.setVisible(true);
				desktopPane.add(manageCourseFrm);
			}
		});
		courseListMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/�γ��б�.png")));
		courseMenu.add(courseListMenuItem);

		JMenu menu_4 = new JMenu("ѡ�ι���");
		menu_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/ѡ��1.png")));
		menuBar.add(menu_4);

		JMenuItem menuItem_2 = new JMenuItem("\u9009\u8BFE\u7BA1\u7406");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageSelectedCourseFrm manageSelectedCourseFrm = new ManageSelectedCourseFrm();
				manageSelectedCourseFrm.setVisible(true);
				desktopPane.add(manageSelectedCourseFrm);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/ѡ��1.png")));
		menu_4.add(menuItem_2);

		JMenu menu_3 = new JMenu("\u5E2E\u52A9");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/����2.png")));
		menuBar.add(menu_3);

		JMenuItem menuItem_6 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/��������.png")));
		menu_3.add(menuItem_6);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 0, 0));


		contentPane.add(desktopPane, BorderLayout.CENTER);


		setLocationRelativeTo(null);
		setAuthority();
	}

	protected void addStudentClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		AddStudentClassFrm sca = new AddStudentClassFrm();
		sca.setVisible(true);
		desktopPane.add(sca);
	}

	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
	}

	protected void aboutUs(ActionEvent ae) {
		// TODO Auto-generated method stub
		String info = "code from ���Ľ� �� �����֡����ͯ����Ŀ��ַ:https://gitee.com/bao_wenjie/select_course\n";

		int ret = JOptionPane.showOptionDialog(this, info, "��������", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION,null, null, null);

	}
	private void setAuthority(){
		if("ѧ��".equals(userType.getName())){
			addStudentMenuItem.setEnabled(false);
			manageClassMenu.setEnabled(false);
			manageTeacherMenu.setEnabled(false);
			courseMenu.setEnabled(false);
		}
		if("��ʦ".equals(userType.getName())){
			addTeacherMenuItem.setEnabled(false);
			courseMenu.setEnabled(false);
		}
	}
}
