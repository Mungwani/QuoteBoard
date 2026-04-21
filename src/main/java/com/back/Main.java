package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);
        int num = 0;
        int[] id = new int[100];
        String[] quotes = new String[100];
        String[] authors = new String[100];

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) break;
            else if (cmd.equals("등록")) {

                System.out.print("명언 : ");
                String quote = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();

                id[num] = num + 1;
                quotes[num] = quote;
                authors[num] = author;
                System.out.println(id[num] + "번 명언이 등록되었습니다.");
                num++;

            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언\n------------------");
                for (int i = num - 1; i >= 0; i--) {
                    if (id[i] == 0) continue;
                    System.out.println(id[i] + " / " + authors[i] + " / " + quotes[i]);
                }
            } else if (cmd.startsWith("삭제?id=")) {
                String[] parts = cmd.split("=");
                int deleteId = Integer.parseInt(parts[1]);

                boolean isFound = false;

                for (int i = 0; i < num; i++) {
                    if (id[i] == deleteId) {
                        id[i] = 0;
                        quotes[i] = null;
                        authors[i] = null;
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    System.out.println(deleteId + "번 명언이 삭제되었습니다.");
                } else {
                    System.out.println(deleteId + "번 명언은 존재하지 않습니다.");
                }
            } else if (cmd.startsWith("수정?id=")) {
                String[] parts = cmd.split("=");
                int editId = Integer.parseInt(parts[1]);

                boolean isFound = false;

                for (int i = 0; i < num; i++) {
                    if (id[i] == editId) {
                        System.out.println("명언(기존) : " + quotes[i]);
                        System.out.print("명언 : ");
                        String quote = scanner.nextLine();

                        System.out.println("작가(기존) : " + authors[i]);
                        System.out.print("작가 : ");
                        String author = scanner.nextLine();

                        quotes[i] = quote;
                        authors[i] = author;

                        isFound = true;
                        break;
                    }
                }

                if (!isFound) {
                    System.out.println(editId + "번 명언은 존재하지 않습니다.");
                }
            }

        }
    }

}
