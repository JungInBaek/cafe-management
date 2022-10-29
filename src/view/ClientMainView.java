package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ClientMainView {
	
	public void open() {
		JFrame f = new JFrame();
		f.setSize(800, 800);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("멀티캠퍼스 카페");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(275, 130, 272, 89);
		f.getContentPane().add(lblNewLabel);
		
		JButton itemSaleBtn = new JButton("상품판매");
		itemSaleBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		itemSaleBtn.setBounds(218, 225, 154, 107);
		f.getContentPane().add(itemSaleBtn);
		f.setVisible(true);
	}
	
}
