package com.sjsq;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PetInput extends JDialog {
	Pet pet;
	int flag;
	String[] s;
	JLabel[] label;
	JTextField[] text;
	JButton confirm;
	ButtonGroup sex;
	JRadioButton sexm, sexf;
	final JRadioButton[] choice;
	ButtonGroup pet_choice;
	static int N = 6;

	PetInput(JFrame owner, boolean modal) {
		super(owner, "��س�����Ϣ����", modal);
		this.setSize(300, 280);
		this.setLayout(null);
		flag = 0;
		s = new String[N];
		// tip = new JLabel[N];
		label = new JLabel[N];
		text = new JTextField[N];
		choice = new JRadioButton[4];
		pet_choice = new ButtonGroup();
		choice[0] = new JRadioButton("��");
		choice[1] = new JRadioButton("è");
		choice[2] = new JRadioButton("��");
		choice[3] = new JRadioButton("����");
		choice[0].setBounds(60, 10, 40, 30);
		choice[1].setBounds(100, 10, 40, 30);
		choice[2].setBounds(140, 10, 40, 30);
		choice[3].setBounds(180, 10, 60, 30);
		for (int i = 0; i < 4; i++) {
			pet_choice.add(choice[i]);
			add(choice[i]);
		}
		label[0] = new JLabel("����:");
		label[1] = new JLabel("����:");
		label[2] = new JLabel("�Ա�:");
		label[2] = new JLabel("����:");
		label[3] = new JLabel("��ɫ:");
		label[4] = new JLabel("�۸�:");
		label[5] = new JLabel("·��:");

		for (int i = 0; i < N; i++) {
			label[i].setBounds(20, 10 + i * 30, 60, 30);
			add(label[i]);
			if (i != 0) {
				if (i == N - 1)
					text[i] = new JTextField("src/PictureSource/XXX.jpg");
				else
					text[i] = new JTextField();
				text[i].setBounds(90, 10 + 30 * i, 150, 30);
				add(text[i]);
			}
		}
		confirm = new JButton("ȷ��");
		confirm.setBounds(90, 195, 100, 30);
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cnt = 0;
				for (int i = 0; i < 4; i++)
					if (choice[i].isSelected() == true)
						cnt = 1;
				if (cnt == 0)
					JOptionPane.showMessageDialog(null, "��ѡ������!", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				else {
					solve();
					dispose();
				}
			}
		});
		add(confirm);
		setLocationRelativeTo(null);
	}

	void solve() {
		boolean[] select = new boolean[4];
		String[] s = new String[6];
		for (int i = 0; i < 4; i++)
			select[i] = choice[i].isSelected();
		for (int i = 1; i < 6; i++)
			s[i] = text[i].getText();
		if (select[0] == true)
			pet = new Dog(s[1], s[2], s[3], s[4], s[5]);
		else if (select[1] == true)
			pet = new Cat(s[1], s[2], s[3], s[4], s[5]);
		else if (select[2] == true)
			pet = new Mouse(s[1], s[2], s[3], s[4], s[5]);
		else
			pet = new OtherPets(s[1], s[2], s[3], s[4], s[5]);
		flag = 1;
	}
}
