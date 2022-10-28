package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.SwingConstants;

import constant.Role;
import dao.MemberDAO;
import vo.MemberVO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView { 

	public static void main(String[] args) {
		MemberDAO memberDAO = new MemberDAO();
		
		JFrame f = new JFrame();
		f.setSize(800, 800);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("멀티캠퍼스 카페");
		JLabel idLabel = new JLabel("ID");
		JLabel pwLabel = new JLabel("Password");
		JTextField idField = new JTextField();
		JPasswordField pwField = new JPasswordField();
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(265, 212, 272, 89);
		f.getContentPane().add(lblNewLabel);
		
		idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setBounds(172, 335, 135, 40);
		f.getContentPane().add(idLabel);
		
		pwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pwLabel.setBounds(172, 385, 135, 40);
		f.getContentPane().add(pwLabel);
		
		idField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		idField.setBounds(319, 335, 206, 40);
		f.getContentPane().add(idField);
		idField.setColumns(10);
		
		pwField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		pwField.setColumns(10);
		pwField.setBounds(319, 385, 206, 40);
		f.getContentPane().add(pwField);
		
		JButton loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				String pw = new String(pwField.getPassword());
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPw(pw);
				
				MemberVO member = memberDAO.getMemberIdPw(vo);
				if(member.getId() == null || member.getPw() == null) {
					JOptionPane.showMessageDialog(f, "아이디, 비밀번호를 확인해주세요.");
				}else if(id.equals(member.getId()) && pw.equals(member.getPw())) {
					MainView mainView = new MainView();
					mainView.open();
				}
			}
		});
		loginBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		loginBtn.setBounds(430, 454, 107, 40);
		f.getContentPane().add(loginBtn);
		
		JButton joinBtn = new JButton("회원가입");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JoinView joinView = new JoinView();
				joinView.open();
			}
		});
		joinBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		joinBtn.setBounds(265, 454, 107, 40);
		f.getContentPane().add(joinBtn);
		f.setVisible(true);
	}
}
