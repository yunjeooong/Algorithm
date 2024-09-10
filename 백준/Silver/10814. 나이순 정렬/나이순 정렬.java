import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

class Person {
    int age;
    String name;

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 저지 인원 수 받기
        int n = Integer.parseInt(br.readLine());
        Person[] arr = new Person[n];
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            arr[i] = new Person(age, name);
        }

        // 나이순으로 정렬
        Arrays.sort(arr, Comparator.comparingInt(p -> p.age));

        // 결과 출력
        for (Person p : arr) {
            bw.write(p.age + " " + p.name + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}