package com.sjsq;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class PetInterface extends Dialog {
	JLabel[][] label;
	JLabel[][] Label;
	ImageIcon icon;
	JTextArea jtextarea;
	JScrollPane jscrollpane;

	PetInterface(JFrame owner, int[] pos, int num, Pet[] p) {
		super(owner, "宠物信息");
		setLocation(500, 100);
		//setLocationRelativeTo(null);
		setSize(450, 500);
		setLayout(null);
		label = new JLabel[num][5];
		Label = new JLabel[num][5];
		jtextarea = new JTextArea(450, 700);
		jscrollpane = new JScrollPane(jtextarea);
		jscrollpane.setBounds(0, 0, 440, 700);
		jscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jscrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(jscrollpane);
		for (int i = 0; i < num; i++) {
			label[i][0] = new JLabel("姓名:");
			Label[i][0] = new JLabel(p[pos[i]].getName());
			label[i][1] = new JLabel("年龄:");
			Label[i][1] = new JLabel(p[pos[i]].getAge());
			label[i][2] = new JLabel("颜色:");
			Label[i][2] = new JLabel(p[pos[i]].getColor());
			label[i][3] = new JLabel("价格:");
			Label[i][3] = new JLabel(p[pos[i]].getPrice());
			label[i][4] = new JLabel("图片路径:");
			icon = new ImageIcon(p[pos[i]].getPic_routh());
			Label[i][4] = new JLabel(icon);

		}
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 5; j++) {
				label[i][j].setBounds(20, 30 + j * 30 + i * 220, 60, 30);
				Label[i][j].setBounds(80, 30 + j * 30 + i * 220, 60, 30);
				jtextarea.add(label[i][j]);
				jtextarea.add(Label[i][j]);
			}
			jtextarea.add(label[i][4]);
			jtextarea.add(Label[i][4]);
		}
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
}
