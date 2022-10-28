package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import constant.Role;
import dao.MemberDAO;
import vo.MemberVO;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class JoinView {
	
	private MemberDAO memberDAO = new MemberDAO();
	
	private boolean idCheck = false;
	private boolean pwCheck = false;
	private boolean nameCheck = false;
	private boolean telCheck = false;

	public void open() {
		
		JFrame f = new JFrame();
		f.setSize(800, 800);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("멀티캠퍼스 카페");
		JLabel idLabel = new JLabel("아이디");
		JLabel pwLabel1 = new JLabel("비밀번호");
		JLabel pwLabel2 = new JLabel("비밀번호 확인");
		JLabel nameLabel = new JLabel("이름");
		JLabel telLabel = new JLabel("전화번호");
		JTextField idTextField = new JTextField();
		JPasswordField pwField1 = new JPasswordField();
		JPasswordField pwField2 = new JPasswordField();
		JTextField nameTextField = new JTextField();
		JTextField telTextField = new JTextField();
		
		Border redBorder = BorderFactory.createLineBorder(Color.red);
		Border greenBorder = BorderFactory.createLineBorder(Color.green);
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(275, 130, 272, 89);
		f.getContentPane().add(lblNewLabel);
		
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		idLabel.setBounds(167, 314, 135, 40);
		f.getContentPane().add(idLabel);
		
		pwLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pwLabel1.setBounds(167, 364, 135, 40);
		f.getContentPane().add(pwLabel1);
		
		pwLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLabel2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pwLabel2.setBounds(167, 414, 135, 40);
		f.getContentPane().add(pwLabel2);
		
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameLabel.setBounds(167, 464, 135, 40);
		f.getContentPane().add(nameLabel);
		
		telLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		telLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		telLabel.setBounds(167, 514, 135, 40);
		f.getContentPane().add(telLabel);

		idTextField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				idCheck = false;
				idTextField.setBorder(redBorder);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		idTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		idTextField.setColumns(10);
		idTextField.setBounds(314, 314, 206, 40);
		f.getContentPane().add(idTextField);
		
		pwField1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String pwText1 = new String(pwField1.getPassword());
				String pwText2 = new String(pwField2.getPassword());
				
				if(pwText1 == null || pwText2 == null) {
					pwCheck = false;
					
					pwField1.setBorder(redBorder);
					pwField2.setBorder(redBorder);
				} else if(pwText1.trim().isEmpty() || pwText2.trim().isEmpty()) {
					pwCheck = false;
					pwField1.setBorder(redBorder);
					pwField2.setBorder(redBorder);
				} else if(pwText1.contains(" ") || pwText2.contains(" ")) {
					pwCheck = false;
					pwField1.setBorder(redBorder);
					pwField2.setBorder(redBorder);
				} else if(pwText1.equals(pwText2)) {
					pwCheck = true;
					pwField1.setBorder(greenBorder);
					pwField2.setBorder(greenBorder);
				} else {
					pwCheck = false;
					pwField1.setBorder(redBorder);
					pwField2.setBorder(redBorder);
				}
			}
		});
		pwField1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		pwField1.setColumns(10);
		pwField1.setBounds(314, 364, 206, 40);
		f.getContentPane().add(pwField1);
		
		pwField2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String pwText1 = new String(pwField1.getPassword());
				String pwText2 = new String(pwField2.getPassword());
				
				if(pwText1 == null || pwText2 == null) {
					pwCheck = false;
					pwField1.setBorder(redBorder);
					pwField2.setBorder(redBorder);
				} else if(pwText1.trim().isEmpty() || pwText2.trim().isEmpty()) {
					pwCheck = false;
					pwField1.setBorder(redBorder);
					pwField2.setBorder(redBorder);
				} else if(pwText1.contains(" ") || pwText2.contains(" ")) {
					pwCheck = false;
					pwField1.setBorder(redBorder);
					pwField2.setBorder(redBorder);
				} else if(pwText1.equals(pwText2)) {
					pwCheck = true;
					pwField1.setBorder(greenBorder);
					pwField2.setBorder(greenBorder);
				} else {
					pwCheck = false;
					pwField1.setBorder(redBorder);
					pwField2.setBorder(redBorder);
				}
			}
		});
		pwField2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		pwField2.setColumns(10);
		pwField2.setBounds(314, 414, 206, 40);
		f.getContentPane().add(pwField2);
		
		nameTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				String nameText = nameTextField.getText();
				
				if(nameText == null || nameText.trim().isEmpty() || nameText.contains(" ")) {
					nameCheck = false;
					nameTextField.setBorder(redBorder);
				} else {
					nameCheck = true;
					nameTextField.setBorder(greenBorder);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		nameTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		nameTextField.setColumns(10);
		nameTextField.setBounds(314, 464, 206, 40);
		f.getContentPane().add(nameTextField);
		
		telTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				String telText = telTextField.getText();
				
				if(telText == null || telText.trim().isEmpty() || telText.contains(" ")) {
					telCheck = false;
					telTextField.setBorder(redBorder);
				} else {
					telCheck = true;
					telTextField.setBorder(greenBorder);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		telTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		telTextField.setColumns(10);
		telTextField.setBounds(314, 514, 206, 40);
		f.getContentPane().add(telTextField);
		
		JButton idCheckBtn = new JButton("중복확인");
		idCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idTextField.getText();
				String lowerId = id.toLowerCase();
				MemberVO member = memberDAO.getMemberId(id);
				
				if(id == null || id.trim().isEmpty()) {
					idCheck = false;
					idTextField.setBorder(redBorder);
					JOptionPane.showMessageDialog(f, "아이디를 입력해주세요.");
				} else if(id.contains(" ")) {
					idCheck = false;
					idTextField.setBorder(redBorder);
					JOptionPane.showMessageDialog(f, "공백을 제거해주세요.");
				} else if(!id.equals(lowerId)) {
					idCheck = false;
					idTextField.setBorder(redBorder);
					JOptionPane.showMessageDialog(f, "소문자만 입력가능합니다.");
				} else if(id.equals(member.getId())) {
					idCheck = false;
					idTextField.setBorder(redBorder);
					JOptionPane.showMessageDialog(f, "중복된 아이디입니다.");
				} else {
					idCheck = true;
					idTextField.setBorder(greenBorder);
					JOptionPane.showMessageDialog(f, "사용 가능한 아이디입니다.");
				}
			}
		});
		idCheckBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		idCheckBtn.setBounds(532, 314, 107, 40);
		f.getContentPane().add(idCheckBtn);
		
		JButton joinReqBtn = new JButton("가입완료");
		joinReqBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idCheck == false) {
					JOptionPane.showMessageDialog(f, "아이디 중복을 확인해주세요.");
				} else if(pwCheck == false) {
					JOptionPane.showMessageDialog(f, "비밀번호를 확인해주세요.");
				} else if(nameCheck == false) {
					JOptionPane.showMessageDialog(f, "이름을 확인해주세요.");
				} else if(telCheck == false) {
					JOptionPane.showMessageDialog(f, "전화번호를 확인해주세요.");
				} else {
					MemberVO vo = new MemberVO();
					vo.setId(idTextField.getText());
					vo.setPw(new String(pwField1.getPassword()));
					vo.setName(nameTextField.getText());
					vo.setTel(telTextField.getText());
					vo.setRole(Role.CLIENT);
					
					memberDAO.add(vo);
					
					f.dispose();
				}
			}
		});
		joinReqBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		joinReqBtn.setBounds(265, 613, 107, 40);
		f.getContentPane().add(joinReqBtn);
		
		JButton cancelBtn = new JButton("가입취소");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		cancelBtn.setBounds(430, 613, 107, 40);
		f.getContentPane().add(cancelBtn);
		
		f.setVisible(true);
	}
}
