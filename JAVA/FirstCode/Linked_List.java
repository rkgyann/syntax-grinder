package JAVA.FirstCode;

import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Linked_List {
    static Node head, n1, n2;

    public static void newLinked_List(int data1, int data2) {
        n1 = new Node(data1);
        n2 = new Node(data2);
    }

    public static void add() {
        if (n1 == null || n2 == null) return;
        int sum = n1.data + n2.data;
        Node p1 = new Node(sum);
        if (head == null) {
            head = p1;
        } else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = p1;
        }
    }

    public static void display() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println();
    }

    public static void Quo() {
        Node d = head;
        while (d != null && d.data > 9 && d.next != null) {
            int t = d.data;
            d.data = t % 10;
            d.next.data = d.next.data + (t / 10);
            d = d.next;
        }
        if (d != null && d.data > 9)
            d.data = d.data % 10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No. of Nodes: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("\nEnter the First Node's No.: ");
            int a = sc.nextInt();
            System.out.print("\nEnter the Second Node's No.: ");
            int b = sc.nextInt();
            newLinked_List(a, b);
            add();
        }
        Quo();
        display();
        sc.close();
    }
}