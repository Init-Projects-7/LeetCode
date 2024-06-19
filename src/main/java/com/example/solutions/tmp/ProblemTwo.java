package com.example.solutions.tmp;

class SingleLinkedListNode {
    int data;
    SingleLinkedListNode next;

    public SingleLinkedListNode(int data, SingleLinkedListNode next) {
        this.data = data;
        this.next = next;
    }
}

public class ProblemTwo {

    public static void main(String[] args) {
        SingleLinkedListNode fifth = new SingleLinkedListNode(5, null);
        SingleLinkedListNode fourth = new SingleLinkedListNode(4, fifth);
        SingleLinkedListNode third = new SingleLinkedListNode(4, fourth);
        SingleLinkedListNode second = new SingleLinkedListNode(5, third);
        SingleLinkedListNode first = new SingleLinkedListNode(2, second);
        
        SingleLinkedListNode result = locateLongestList(first);
        int length = 0;
        
        // Print the longest list and its length
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
            length++;
        }
        System.out.println("\nLength of the longest non-increasing sublist: " + length);
    }

    private static int longestLength = 0; // to track the length of the longest sublist

    public static SingleLinkedListNode locateLongestList(SingleLinkedListNode head) {
        if (head == null) {
            return null;
        }

        SingleLinkedListNode maxStart = null;
        SingleLinkedListNode maxEnd = null;
        int len = 0;

        SingleLinkedListNode currStart = head;
        SingleLinkedListNode currEnd = head;
        int currLen = 1;

        for (SingleLinkedListNode current = head; current.next != null; current = current.next) {
            if (current.data >= current.next.data) {
                currEnd = current.next;
                currLen++;
            } else {
                if (currLen > len) {
                    len = currLen;
                    maxStart = currStart;
                    maxEnd = currEnd;
                }
                currStart = current.next;
                currLen = 1;
            }
        }

        if (currLen > len) {
            len = currLen;
            maxStart = currStart;
            maxEnd = currEnd;
        }

        longestLength = len; // set the global variable to the length of the longest sublist

        // Create a new list for the longest non-increasing sublist
        SingleLinkedListNode newHead = new SingleLinkedListNode(maxStart.data, null);
        SingleLinkedListNode newTail = newHead;
        SingleLinkedListNode temp = maxStart.next;
        while (temp != null && temp != maxEnd.next) {
            newTail.next = new SingleLinkedListNode(temp.data, null);
            newTail = newTail.next;
            temp = temp.next;
        }

        return newHead;
    }
}
