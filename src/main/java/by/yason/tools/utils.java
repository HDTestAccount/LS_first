package by.yason.tools;

public class utils {
    public static boolean isMyTicketLucky(String inputNum) {

        return String.valueOf(
                inputNum.chars()
                        .mapToObj(i -> (char) i)
                        .limit(inputNum.length() / 2)
                        .mapToInt(x -> Integer.parseInt(x.toString()))
                        .sum())
                .equals(
                        String.valueOf(inputNum.chars()
                                .mapToObj(i -> (char) i)
                                .skip(inputNum.length() / 2)
                                .mapToInt(x -> Integer.parseInt(x.toString()))
                                .sum()));
    }
}
