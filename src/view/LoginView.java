package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import constant.Role;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView {
	
	private static JTextField idTextField;
	private static JTextField pwTextField;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(800, 800);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("멀티캠퍼스 카페");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(265, 212, 272, 89);
		f.getContentPane().add(lblNewLabel);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setBounds(172, 335, 135, 40);
		f.getContentPane().add(idLabel);
		
		JLabel pwLabel = new JLabel("Password");
		pwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pwLabel.setBounds(172, 385, 135, 40);
		f.getContentPane().add(pwLabel);
		
		idTextField = new JTextField();
		idTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		idTextField.setBounds(319, 335, 206, 40);
		f.getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		pwTextField = new JTextField();
		pwTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		pwTextField.setColumns(10);
		pwTextField.setBounds(319, 385, 206, 40);
		f.getContentPane().add(pwTextField);
		
		JButton loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
