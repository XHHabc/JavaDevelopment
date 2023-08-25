package com.sjsq;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.io.*;

public class MainScreen extends JFrame {
	PetShop pet_shop;
	JButton dog, cat, mouse, otherpets;
	// JLabel dog_lab,cat_lab,mouse_lab,otherpets_lab;
	ImageIcon dog_icon, cat_icon, mouse_icon, otherpets_icon;
	JButton Add, Delete, Change, Search;
	Container con = getContentPane();
	FileReader filereader = null;
	BufferedReader bufferedreader = null;
	FileWriter fileWritter = null;
	PetInput pet_input;
	PetInterface petinterface;

	public MainScreen() {

		super("宠物商店");
		setLayout(null);
		setSize(650, 450);
		setVisible(true);
		//setLocation(450, 50);
		setLocationRelativeTo(null);
		pet_shop = new PetShop(0);
		dog = new JButton("狗");
		cat = new JButton("猫");
		mouse = new JButton("鼠");
		otherpets = new JButton("其他");
		Add = new JButton("增加宠物");
		Delete = new JButton("删除宠物");
		Change = new JButton("更改宠物");
		Search = new JButton("查找宠物");
		dog.setBounds(120, 40, 150, 60);
		con.add(dog);
		cat.setBounds(120, 120, 150, 60);
		con.add(cat);
		mouse.setBounds(120, 200, 150, 60);
		con.add(mouse);
		otherpets.setBounds(120, 280, 150, 60);
		con.add(otherpets);
		Add.setBounds(400, 40, 150, 60);
		con.add(Add);
		Delete.setBounds(400, 120, 150, 60);
		con.add(Delete);
		Change.setBounds(400, 200, 150, 60);
		con.add(Change);
		Search.setBounds(400, 280, 150, 60);
		con.add(Search);

		ImageIcon icon = new ImageIcon("C:/Users/HiWin10/IdeaProjects/PetStore/untitled/src/PictureSource/背景图.jpg");
		JLabel picture = new JLabel(icon);
		con.add(picture);
		picture.setBounds(0, 0, 700, 400);
		init_button_listener();
		file_read();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class ImagePanel extends JPanel {
		private Image backgroundImage;

		ImagePanel() {
			backgroundImage = new ImageIcon("src/PictureSource/背景图.jpg").getImage();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (backgroundImage != null) {
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			}
		}
	}

	void file_read() {
		try {
			filereader = new FileReader("src/Pet information.txt");
			bufferedreader = new BufferedReader(filereader);
			String s = null;
			Pet p;
			while ((s = bufferedreader.readLine()) != null) {
				String[] ss = new String[6];
				ss = s.split(" ");
				if (ss[0].equals("狗"))
					p = new Dog(ss[1], ss[2], ss[3], ss[4], ss[5]);
				else if (ss[0].equals("猫"))
					p = new Cat(ss[1], ss[2], ss[3], ss[4], ss[5]);
				else if (ss[0].equals("鼠"))
					p = new Mouse(ss[1], ss[2], ss[3], ss[4], ss[5]);
				else
					p = new OtherPets(ss[1], ss[2], ss[3], ss[4], ss[5]);
				pet_shop.add(p);
			}
			bufferedreader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void init_button_listener() {
		dog.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				int[] pos = new int[110];
				int num = 0;
				Pet[] p = pet_shop.pets;
				for (int i = 0; i < pet_shop.num; i++)
					if (p[i].getKind().equals("狗"))
						pos[num++] = i;
				petinterface = new PetInterface(MainScreen.this, pos, num, p);
				petinterface.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		cat.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				int[] pos = new int[110];
				int num = 0;
				Pet[] p = pet_shop.pets;
				for (int i = 0; i < pet_shop.num; i++)
					if (p[i].getKind().equals("猫"))
						pos[num++] = i;
				petinterface = new PetInterface(MainScreen.this, pos, num, p);
				petinterface.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		mouse.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				int[] pos = new int[110];
				int num = 0;
				Pet[] p = pet_shop.pets;
				for (int i = 0; i < pet_shop.num; i++)
					if (p[i].getKind().equals("鼠"))
						pos[num++] = i;
				petinterface = new PetInterface(MainScreen.this, pos, num, p);
				petinterface.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		otherpets.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				int[] pos = new int[110];
				int num = 0;
				Pet[] p = pet_shop.pets;
				for (int i = 0; i < pet_shop.num; i++)
					if (p[i].getKind().equals("其他"))
						pos[num++] = i;
				petinterface = new PetInterface(MainScreen.this, pos, num, p);
				petinterface.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pet_input = new PetInput(MainScreen.this, true);
				pet_input.setVisible(true);
				if (pet_shop.add(pet_input)) {
					try {
						fileWritter = new FileWriter("src/Pet information.txt");
						Pet[] p = pet_shop.pets;
						for (int i = 0; i < pet_shop.num; i++) {
							fileWritter.write(p[i].getKind() + " ");
							fileWritter.write(p[i].getName() + " ");
							fileWritter.write(p[i].getAge() + " ");
							fileWritter.write(p[i].getColor() + " ");
							fileWritter.write(p[i].getPrice() + " ");
							fileWritter.write(p[i].getPic_routh() + "\r\n");
						}
						fileWritter.close();
					} catch (Exception event) {
						event.printStackTrace();
					}
				}

			}
		});
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pet_shop.delete()) {
					try {
						fileWritter = new FileWriter("src/Pet information.txt");
						Pet[] p = pet_shop.pets;
						for (int i = 0; i < pet_shop.num; i++) {
							fileWritter.write(p[i].getKind() + " ");
							fileWritter.write(p[i].getName() + " ");
							fileWritter.write(p[i].getAge() + " ");
							fileWritter.write(p[i].getColor() + " ");
							fileWritter.write(p[i].getPrice() + " ");
							fileWritter.write(p[i].getPic_routh() + "\r\n");
						}
						fileWritter.close();
					} catch (Exception event) {
						event.printStackTrace();
					}
				}
			}
		});
		Change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pos = pet_shop.change();
				if (pos != -1) {
					pet_input = new PetInput(MainScreen.this, true);
					pet_input.setVisible(true);
					if (pet_input.flag == 1) {
						pet_shop.pets[pos].Change(pet_input.pet);
						JOptionPane.showMessageDialog(null, "宠物修改成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
						try {
							fileWritter = new FileWriter("src/Pet information.txt");
							Pet[] p = pet_shop.pets;
							for (int i = 0; i < pet_shop.num; i++) {
								fileWritter.write(p[i].getKind() + " ");
								fileWritter.write(p[i].getName() + " ");
								fileWritter.write(p[i].getAge() + " ");
								fileWritter.write(p[i].getColor() + " ");
								fileWritter.write(p[i].getPrice() + " ");
								fileWritter.write(p[i].getPic_routh() + "\r\n");
							}
							fileWritter.close();
						} catch (Exception event) {
							event.printStackTrace();
						}
					} else
						JOptionPane.showMessageDialog(null, "宠物修改失败!", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] pos = new int[110];
				int num = pet_shop.search(pos);
				Pet[] p = pet_shop.pets;
				if (num > 0) {
					petinterface = new PetInterface(MainScreen.this, pos, num, p);
					petinterface.setVisible(true);
				}
			}
		});
	}

	public static void main(String[] args) {
		new MainScreen();
	}
}
