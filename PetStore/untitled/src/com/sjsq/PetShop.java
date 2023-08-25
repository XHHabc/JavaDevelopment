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
			JOptionPane.showMessageDialog(null, "������ӳɹ�!", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "�������ʧ��!", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}

	boolean delete() {
		String keyWord = JOptionPane.showInputDialog(null, "������Ҫɾ���ĳ�����Ϣ:", "����");
		int flag = -1;
		for (int i = 0; i < num; i++)
			if (pets[i].getName().equals(keyWord)) {
				flag = i;
				break;
			}
		if (flag == -1) {
			JOptionPane.showMessageDialog(null, "δ���ҵ��ó���!", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			for (int i = flag; i < num - 1; i++)
				pets[i] = pets[i + 1];
			num--;
			JOptionPane.showMessageDialog(null, "�ѳɹ�ɾ���ó���!", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
	}

	int change() {
		String keyWord = JOptionPane.showInputDialog(null, "������Ҫ���ĵĳ�����Ϣ:", "����");
		int pos = -1;
		for (int i = 0; i < num; i++)
			if (pets[i].getName().equals(keyWord)) {
				pos = i;
				break;
			}
		if (pos == -1) {
			JOptionPane.showMessageDialog(null, "δ���ҵ��ó���!", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "�����޸�ʧ��!", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
		}
		return pos;
	}

	int search(int[] pos) {
		String keyWord = JOptionPane.showInputDialog(null, "������Ҫ���ҵĳ�����Ϣ:", "����");
		int n = 0;
		for (int i = 0; i < num; i++) {
			System.out.println(pets[i].getName());
			if (pets[i].getName().equals(keyWord))
				pos[n++] = i;
		}
		if (n == 0)
			JOptionPane.showMessageDialog(null, "δ���ҵ��ó���!", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
		return n;
	}
}
