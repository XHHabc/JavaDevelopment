package com.sjsq;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PetShop {
	Pet[] pets;
	int num;
	PetInput pet_input;

	PetShop(int len) {
		num = len;
		pets = new Pet[110];
	}

	void add(Pet pet) {
		pets[num++] = pet;
	}

	boolean add(PetInput pet_input) {
		if (pet_input.flag == 1) {
			pets[num++] = pet_input.pet;
			JOptionPane.showMessageDialog(null, "宠物添加成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "宠物添加失败!", "提示", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}

	boolean delete() {
		String keyWord = JOptionPane.showInputDialog(null, "请输入要删除的宠物信息:", "名字");
		int flag = -1;
		for (int i = 0; i < num; i++)
			if (pets[i].getName().equals(keyWord)) {
				flag = i;
				break;
			}
		if (flag == -1) {
			JOptionPane.showMessageDialog(null, "未查找到该宠物!", "提示", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			for (int i = flag; i < num - 1; i++)
				pets[i] = pets[i + 1];
			num--;
			JOptionPane.showMessageDialog(null, "已成功删除该宠物!", "提示", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
	}

	int change() {
		String keyWord = JOptionPane.showInputDialog(null, "请输入要更改的宠物信息:", "名字");
		int pos = -1;
		for (int i = 0; i < num; i++)
			if (pets[i].getName().equals(keyWord)) {
				pos = i;
				break;
			}
		if (pos == -1) {
			JOptionPane.showMessageDialog(null, "未查找到该宠物!", "提示", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "宠物修改失败!", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		return pos;
	}

	int search(int[] pos) {
		String keyWord = JOptionPane.showInputDialog(null, "请输入要查找的宠物信息:", "名字");
		int n = 0;
		for (int i = 0; i < num; i++) {
			System.out.println(pets[i].getName());
			if (pets[i].getName().equals(keyWord))
				pos[n++] = i;
		}
		if (n == 0)
			JOptionPane.showMessageDialog(null, "未查找到该宠物!", "提示", JOptionPane.INFORMATION_MESSAGE);
		return n;
	}
}
