/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4LabWork;

/**
 *
 * @author Sheetal
 */
import java.util.*;

class Node {

    Character ch;
    Integer freq;
    Node left = null, right = null;

    Node(Character ch, Integer freq) {
        this.ch = ch;
        this.freq = freq;
    }

    public Node(Character ch, Integer freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

class Main {
    // Traverse the Huffman Tree and store Huffman Codes in a map.

    public static void encode(Node root, String str,
            Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }

        // Found a leaf node
        if (isLeaf(root)) {
            huffmanCode.put(root.ch, str.length() > 0 ? str : "1");
        }

        encode(root.left, str + '0', huffmanCode);
        encode(root.right, str + '1', huffmanCode);
    }

    // Traverse the Huffman Tree and decode the encoded string
    public static int decode(Node root, int index, StringBuilder sb) {
        if (root == null) {
            return index;
        }

        // Found a leaf node
        if (isLeaf(root)) {
            System.out.print(root.ch);
            return index;
        }

        index++;

        root = (sb.charAt(index) == '0') ? root.left : root.right;
        index = decode(root, index, sb);
        return index;
    }

    // Utility function to check if Huffman Tree contains only a single node
    public static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    // Builds Huffman Tree and decodes the given input text
    public static void buildHuffmanTree(String text) {
        if (text == null || text.length() == 0) {
            return;
        }
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Node> pq;
        pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));
        freq.entrySet().forEach(entry -> {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        });

        while (pq.size() != 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            int sum = left.freq + right.freq;
            pq.add(new Node(null, sum, left, right));
        }

        Node root = pq.peek();
        Map<Character, String> huffmanCode = new HashMap<>();
        encode(root, "", huffmanCode);

        // Print the Huffman codes
        System.out.println("Huffman Codes are: " + huffmanCode);

        // Print encoded string
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }

        System.out.println("The encoded string is: " + sb);
        System.out.print("The decoded string is: ");

        if (isLeaf(root)) {
            while (root.freq-- > 0) {
                System.out.print(root.ch);
            }
        } else {
            // Traverse the Huffman Tree again and this time, decode the encoded string
            int index = -1;
            while (index < sb.length() - 1) {
                index = decode(root, index, sb);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String text = sc.nextLine();
        buildHuffmanTree(text);
    }
}
