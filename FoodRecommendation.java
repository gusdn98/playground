import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FoodRecommendation {
    public static void main(String[] args) {
        String[][] foodList = {
            {"두레박한우촌", "두끼", "병천가마솥순대국","새벽집", "신천직화집", "예솔감자탕2호점", "이태리부대찌개(잠실역점)", "김명자굴국밥(잠실)","전주콩나루콩나물국밥(잠실점)", "지강한식당", "진전복삼계탕(잠실점)", "한국교자(잠실점)", "창고43(잠실점)","헬로우낙곱새(방이점)", "현대칼국수", "흥부네"},
            {"마라공방(잠실역점)", "만리장성(잠실)", "차이나스토리(삼성생명잠실사옥점)", "한약중식(잠실점)"},
            {"더플레이스 잠실롯데백화점", "도쿄등심(잠실점)", "롯데리아 롯데백잠실광장", "롯데리아 언더랜드", "모타운 서울", "엔제리너스 롯데백잠실", "엔제리너스 잠실샤롯데", "카페마마스(잠실점)", "크리스피크림도넛 잠실점", "클럽2", "모스버거(홈플러스잠실점)", "샐러디", "알라보"},
            {"나루카츠", "스시준", "오마카세오사이초밥(잠실점)"},
            {"리김밥 잠시롯데월드점", "보영만두(잠실점)", "싸다김밥(잠실점)"}
        };

        // 사용자로부터 어제 먹은 음식 입력 받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("어제 먹은 음식을 입력하세요: ");
        String yesterdayFood = scanner.nextLine();
        
        // 어제 먹은 음식이 포함된 배열에서 해당 음식 제외
        String[] chosenFoodArray = null;
        switch (yesterdayFood) {
            case "한식":
                chosenFoodArray = foodList[0];
                break;
            case "중식":
                chosenFoodArray = foodList[1];
                break;
            case "양식":
                chosenFoodArray = foodList[2];
                break;
            case "일식":
                chosenFoodArray = foodList[3];
                break;
            case "분식":
                chosenFoodArray = foodList[4];
                break;
            default:
                System.out.println("없는 종류의 음식");
                scanner.close();
                return;
        }
        
        // chosenFoodArray를 foodList에서 제거
        for (int i = 0; i < foodList.length; i++) {
            if (Arrays.equals(foodList[i], chosenFoodArray)) {
                foodList[i] = null;
                break;
            }
        }
        
        // 남은 음식 배열에서 랜덤으로 식당 선택하여 추천 리스트에 추가
        Random rand = new Random();
        List<String> recommendationList = new ArrayList<>();
        for (String[] foodArray : foodList) {
            if (foodArray != null) {
                for (int i = 0; i < 3; i++) { // 각 음식 종류에서 3개의 식당 선택
                    String restaurant = foodArray[rand.nextInt(foodArray.length)];
                    if (!recommendationList.contains(restaurant)) { // 중복되지 않도록 체크
                        recommendationList.add(restaurant);
                        break;
                    }
                }
            }
        }
        
        // 추천 결과 출력
        System.out.println("오늘의 추천 식당:");
        for (String restaurant : recommendationList) {
            System.out.println(restaurant);
        }
        
        // 스캐너 닫기
        scanner.close();
    }
}
