import java.util.Scanner;

public class 띠계산기 {
  public static void main(String[] args){
  Scanner scanner = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("출생년도를 입력하세요: ");
        int birthYear = scanner.nextInt();

        // 띠 계산하기
        String zodiac = calculateZodiac(birthYear);

        System.out.println(name + "님의 띠는 " + zodiac + " 띠입니다.");
    }

    public static String calculateZodiac(int year) {
      String rat = "🐁";
      String ox = "🐄";
      String tiger = "🐅";
      String rabbit = "🐇";
      String dragon = "🐉";
      String snake = "🐍";
      String horse = "🐎";
      String goat = "🐑";
      String monkey = "🐒";
      String chicken = "🐓";
      String dog = "🦮";
      String pig = "🐖";
      String[] zodiacs = {rat, ox, tiger, rabbit, dragon, snake, horse, goat, monkey, chicken, dog, pig};
      return zodiacs[(year - 1900) % 12];
  }
     
}

