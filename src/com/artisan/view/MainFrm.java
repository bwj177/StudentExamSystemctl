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
		setTitle("学生选课系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 774);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);






		JMenu menu = new JMenu("系统设置");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/系统设置1.png")));
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("修改密码");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/修改密码2.png")));
		menu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "确认退出？") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/退出2.png")));
		menu.add(menuItem_1);

		JMenu menu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/学生管理2.png")));
		menuBar.add(menu_1);

		addStudentMenuItem = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		addStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentFrm addStudentFrm = new AddStudentFrm();
				addStudentFrm.setVisible(true);
				desktopPane.add(addStudentFrm);
			}
		});
		addStudentMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/添加2.png")));
		menu_1.add(addStudentMenuItem);

		JMenuItem menuItem_3 = new JMenuItem("\u5B66\u751F\u5217\u8868");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStudentFrm studentManageFrm = new ManageStudentFrm();
				studentManageFrm.setVisible(true);
				desktopPane.add(studentManageFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/用户列表2.png")));
		menu_1.add(menuItem_3);


		manageClassMenu = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		manageClassMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/班级管理.png")));
		menuBar.add(manageClassMenu);

		JMenuItem menuItem_4 = new JMenuItem("\u73ED\u7EA7\u6DFB\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addStudentClass(ae);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/添加2.png")));
		manageClassMenu.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("\u73ED\u7EA7\u7BA1\u7406");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageClassFrm classManageFrm = new ManageClassFrm();
				classManageFrm.setVisible(true);
				desktopPane.add(classManageFrm);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/班级列表.png")));
		manageClassMenu.add(menuItem_5);

		manageTeacherMenu = new JMenu("\u6559\u5E08\u7BA1\u7406");
		manageTeacherMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/教师管理.png")));
		menuBar.add(manageTeacherMenu);

		addTeacherMenuItem = new JMenuItem("\u6DFB\u52A0\u6559\u5E08");
		addTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacherFrm addTeacherFrm = new AddTeacherFrm();
				addTeacherFrm.setVisible(true);
				desktopPane.add(addTeacherFrm);
			}
		});
		addTeacherMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/老师.png")));
		manageTeacherMenu.add(addTeacherMenuItem);

		JMenuItem menuItem_8 = new JMenuItem("教师列表");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageTeacherFrm manageTeacherFrm = new ManageTeacherFrm();
				manageTeacherFrm.setVisible(true);
				desktopPane.add(manageTeacherFrm);
			}
		});
		menuItem_8.setIcon(new ImageIcon(MainFrm.class.getResource("/images/用户列表2.png")));
		manageTeacherMenu.add(menuItem_8);




		courseMenu = new JMenu("\u8BFE\u7A0B\u7BA1\u7406");
		courseMenu.setIcon(new ImageIcon(	Objects.requireNonNull(MainFrm.class.getResource("/images/课程2.png"))));
		menuBar.add(courseMenu);

		JMenuItem addCourseMenuItem = new JMenuItem("\u6DFB\u52A0\u8BFE\u7A0B");
		addCourseMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddCourseFrm addCourseFrm = new AddCourseFrm();
				addCourseFrm.setVisible(true);
				desktopPane.add(addCourseFrm);
			}
		});
		addCourseMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/添加2.png")));
		courseMenu.add(addCourseMenuItem);

		JMenuItem courseListMenuItem = new JMenuItem("\u8BFE\u7A0B\u5217\u8868");
		courseListMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageCourseFrm manageCourseFrm = new ManageCourseFrm();
				manageCourseFrm.setVisible(true);
				desktopPane.add(manageCourseFrm);
			}
		});
		courseListMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/课程列表.png")));
		courseMenu.add(courseListMenuItem);

		JMenu menu_4 = new JMenu("选课管理");
		menu_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/选择1.png")));
		menuBar.add(menu_4);

		JMenuItem menuItem_2 = new JMenuItem("\u9009\u8BFE\u7BA1\u7406");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageSelectedCourseFrm manageSelectedCourseFrm = new ManageSelectedCourseFrm();
				manageSelectedCourseFrm.setVisible(true);
				desktopPane.add(manageSelectedCourseFrm);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/选择1.png")));
		menu_4.add(menuItem_2);

		JMenu menu_3 = new JMenu("\u5E2E\u52A9");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/帮助2.png")));
		menuBar.add(menu_3);

		JMenuItem menuItem_6 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/关于我们.png")));
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
		String info = "code from 包文杰 、 张培林、徐嘉童。项目地址:https://gitee.com/bao_wenjie/select_course\n";

		int ret = JOptionPane.showOptionDialog(this, info, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION,null, null, null);

	}
	private void setAuthority(){
		if("学生".equals(userType.getName())){
			addStudentMenuItem.setEnabled(false);
			manageClassMenu.setEnabled(false);
			manageTeacherMenu.setEnabled(false);
			courseMenu.setEnabled(false);
		}
		if("教师".equals(userType.getName())){
			addTeacherMenuItem.setEnabled(false);
			courseMenu.setEnabled(false);
		}
	}
}
