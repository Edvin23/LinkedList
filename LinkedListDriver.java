public class LinkedListDriver {
    public static void main(String[] args){
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        System.out.println(list);
        list.add(0,10);System.out.println(list);
        list.add(0,20);System.out.println(list);
        list.add(0,30);System.out.println(list);
        list.add(1,99);System.out.println(list);
        list.add(2,55);System.out.println(list);
        list.remove(0);System.out.println(list);
        list.remove(1);System.out.println(list);
        list.get(2);System.out.println(list);
        list.set(2,70);System.out.println(list);



    }
}
