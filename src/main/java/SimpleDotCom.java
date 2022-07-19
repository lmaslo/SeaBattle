public class SimpleDotCom {
    public static void main (String[] args){
        SimpleDotCom dot = new SimpleDotCom();

        int[] locations ={2,3,4};
        dot.setLocationCells(locations);

        String userGuess="2";
        String result = dot.checkYourself(userGuess);

        String testResult="fail";

        if(result.equals("Passed")){
            testResult = "done";
        }
        System.out.println(testResult);
    }

    private String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "мимо";
        return result;
    }
}
