package listprac;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static <T> void showList(List<T> list) {
        System.out.println("Các phần tử của List: ");
        Iterator var1 = list.iterator();

        while(var1.hasNext()) {
            T n = (T) var1.next();
            System.out.println(n);
        }

    }

    public static Integer getNode(LinkedList<Integer> list, int i) {
        if (i >= 0 && i < list.size()) {
            int currentIndex = 0;

            for(Iterator var3 = list.iterator(); var3.hasNext(); ++currentIndex) {
                int num = (Integer)var3.next();
                if (currentIndex == i) {
                    return num;
                }
            }

            return null;
        } else {
            throw new IndexOutOfBoundsException("Index" + i + ",Size: " + list.size());
        }
    }

    public static void main(String[] args) {
        duyetLinked list1 = new duyetLinked();
        duyetArray list2 = new duyetArray();
        list1.showList();
        list2.showList();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap vi tri muon xoa trong Linklist:");
        int index = input.nextInt();
        Integer value = getNode(list1.linkedlist, index);
        System.out.println("Gia tri muon xoa la:" + value);
        list1.linkedlist.remove(index);
        System.out.println("Linkedlist sau khi xoa");
        list1.showList();
    }

    public static class duyetLinked {
        LinkedList<Integer> linkedlist = new LinkedList();

        public duyetLinked() {
            this.linkedlist.add(19);
            this.linkedlist.add(29);
            this.linkedlist.add(49);
            this.linkedlist.add(14);
        }

        public void showList() {
            Main.showList(this.linkedlist);
        }
    }

    public static class duyetArray {
        ArrayList<Integer> arraylist = new ArrayList();

        public duyetArray() {
            this.arraylist.add(129);
            this.arraylist.add(229);
            this.arraylist.add(49);
            this.arraylist.add(114);
        }

        public void showList() {
            Main.showList(this.arraylist);
        }
    }
}
