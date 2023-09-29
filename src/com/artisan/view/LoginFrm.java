package com.artisan.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.artisan.dao.AdminDao;
import com.artisan.dao.StudentDao;
import com.artisan.dao.TeacherDao;
import com.artisan.model.Admin;
import com.artisan.model.Student;
import com.artisan.model.Teacher;
import com.artisan.model.UserType;
import com.artisan.util.StringUtil;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;
	private JComboBox userTypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrm() {
		setTitle("登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JLabel label = new JLabel("欢迎来到学生选课系统");
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/logo.png")));
		label.setFont(new Font("微软雅黑", Font.BOLD, 18));

		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/用户名1q.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);

		JLabel label_2 = new JLabel("密码：");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/密码1.png")));

		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);

		JLabel label_3 = new JLabel("用户类型");
		label_3.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userType.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.TEACHER, UserType.STUDENT}));
		userTypeComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		loginButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/登录1.png")));
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/重置.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap(118, Short.MAX_VALUE)
												.addComponent(label))
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
												.addGap(134)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																		.addComponent(label_1)
																		.addComponent(label_2))
																.addGap(18)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																		.addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
																		.addComponent(userNameTextField, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(label_3)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(userTypeComboBox, 0, 162, Short.MAX_VALUE)))))
								.addGap(116))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(156)
								.addComponent(loginButton)
								.addGap(61)
								.addComponent(resetButton)
								.addContainerGap(127, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(26)
								.addComponent(label)
								.addGap(33)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_1)
										.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(28)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_2)
										.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(36)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_3)
										.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(resetButton)
										.addComponent(loginButton))
								.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName = userNameTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
		Admin admin = null;
		if("系统管理员".equals(selectedItem.getName())){
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			admin = adminDao.login(adminTmp);
			adminDao.closeDao();
			if(admin == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+admin.getName()+"登录本系统！");
			this.dispose();
			new MainFrm(selectedItem, admin).setVisible(true);
		}else if("教师".equals(selectedItem.getName())){
			//教师登录
			Teacher teacher = null;
			TeacherDao teacherDao = new TeacherDao();
			Teacher teacherTmp = new Teacher();
			teacherTmp.setName(userName);
			teacherTmp.setPassword(password);
			teacher = teacherDao.login(teacherTmp);
			teacherDao.closeDao();
			if(teacher == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+teacher.getName()+"登录本系统！");
			this.dispose();
			new MainFrm(selectedItem, teacher).setVisible(true);
		}else{
			//学生登录
			Student student = null;
			StudentDao studentDao = new StudentDao();
			Student studentTmp = new Student();
			studentTmp.setName(userName);
			studentTmp.setPassword(password);
			student = studentDao.login(studentTmp);
			studentDao.closeDao();
			if(student == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+student.getName()+"登录本系统！");
			this.dispose();
			new MainFrm(selectedItem, student).setVisible(true);
		}
	}

	protected void restValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		userNameTextField.setText("");
		passwordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	}
}
