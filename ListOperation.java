package com.study;

import java.util.Scanner;

class ListNode {
	public int data;
	public ListNode next;

	public ListNode() {

	}
}

public class ListOperation {

	public static void CreateList(ListNode Node, int value) {
		if (Node == null)
			return;
		if (value != -1) {
			ListNode newNode = new ListNode();
			newNode.data = value;
			newNode.next = Node.next;
			Node.next = newNode;
		}
	}

	public static void MergeList(ListNode head1, ListNode head2,
			ListNode newHead) {
		// 分别指向两个表的头结点
		ListNode p1 = head1.next;
		ListNode p2 = head2.next;
		newHead.next = p1.data < p2.data ? p1 : p2; // 确定头结点
		ListNode p = new ListNode();

		for (p = head1; p1 != null && p2 != null; p = p.next) {
			if (p1.data < p2.data) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
		}

		if (p1 == null) {
			p.next = p2;
		} else {
			p.next = p1;
		}

	}

	public static ListNode MergeRecursively(ListNode node1, ListNode node2) {
		if (node1 == null)
			return node2;
		if (node2 == null)
			return node1;
		ListNode node = new ListNode();
		if (node1.data < node2.data) {
			node = node1;
			node.next = MergeRecursively(node1.next, node2);
		} else {
			node = node2;
			node.next = MergeRecursively(node1, node2.next);
		}
		return node;
	}

	public static void PrintList(ListNode head) {
		if (head.next == null) {
			System.out.println("This is an empty list!");
			return;
		}

		if (head.next != null) {
			head = head.next;
			while (head != null) {
				System.out.print(head.data + "-->");
				if (head.next != null)
					head = head.next;
				else
					break;
			}
			System.out.print("NULL");
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("请输入链表1：");
		ListNode head1 = new ListNode();
		while (input.hasNext()) {
			int num = input.nextInt();
			if (num == -1)
				break;
			CreateList(head1, num);
		}

		System.out.println("请输入链表2：");
		ListNode head2 = new ListNode();
		while (input.hasNext()) {
			int num = input.nextInt();
			if (num == -1)
				break;
			CreateList(head2, num);
		}

		input.close();

		System.out.println("链表1：");
		PrintList(head1);
		System.out.println();
		System.out.println("链表2：");
		PrintList(head2);

		ListNode newHead = new ListNode();
		newHead.next = MergeRecursively(head1.next, head2.next);
		System.out.println();
		System.out.println("合并之后的链表: ");
		PrintList(newHead);
	}
}
