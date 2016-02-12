import javafx.geometry.Pos;
import org.javatuples.Quartet;
import java.util.Arrays;

public class AIguess {

    CodePegs.Peg[][] PossSet = new CodePegs.Peg[4][1269];

    //returns array of all possible secret codes
    public CodePegs.Peg[][] PossSetGen(CodePegs.Peg[][] PossSet) {
        int index = 0;
        for (CodePegs.Peg h : CodePegs.Peg.values()) {
            for (CodePegs.Peg i : CodePegs.Peg.values()) {
                for (CodePegs.Peg j : CodePegs.Peg.values()) {
                    for (CodePegs.Peg k : CodePegs.Peg.values()) {
                        PossSet[index] = new CodePegs.Peg[]{h, i, j, k};
                        index++;
                    }
                }
            }
        }
        return PossSet;
    }

    //Turn quartet guess into array for indexing
    CodePegs.Peg[] Guess = {guess.getValue0(),guess.getValue1(),guess.getValue2(),guess.getValue3()};

    //Returns array without codes that would not return the same feedback
    public CodePegs.Peg[][] trim(CodePegs.Peg[] Guess, KeyPegs FB, CodePegs.Peg[][] PossSet) {
        CodePegs.Peg[][] Result = new CodePegs.Peg[4][PossSet.length];
        int results = 0;

        //evaluate set of possible codes for the feedback
        //nested loops to get different possible combinations
        for(CodePegs.Peg[] event:PossSet){
            for (int i = 0; i < 2; i++) {
                int j = i + 1;
                if (FB.getNumBlackPegs() == 2) { j = 0; i = 4;}
                while (j < 3) {
                    int k = j + 1;
                    if (FB.getNumBlackPegs() == 1) { k = 0; j=4; i = 4;}
                    for (k = j + 1; k < 4; k++) {
                        if (FB.getNumBlackPegs() == 3 && arrayContains(event,Guess[i],Guess[j],Guess[k]) && event[i] == Guess[i] && event[j] == Guess[j]
                        && event[k] == Guess[k]){
                            Result[results] = event;
                            results++;
                        } else if((FB.getNumBlackPegs() == 2) && (arrayContains(event,Guess[j],Guess[k],null)) &&!(arrayContains(event,Guess[k],null,null)) && (event[j] == Guess[j] && event[k] == Guess[k])) {
                            Result[results] = event;
                            results++;
                        }
                        else if(FB.getNumBlackPegs() == 1 && (arrayContains(event,Guess[k],null,null)) &&!(arrayContains(event,Guess[i],Guess[j],null)) && event[k]==Guess[k]){
                            Result[results] = event;
                            results++;
                        }
                    }j++;
                } i++;
            }
        }
        return Result;
    }

    //returns guess that could return the most information in the worst possible feedback
    public CodePegs.Peg[] nextGuess(CodePegs.Peg[][] PossSet) {
        KeyPegs FB;
        int score = PossSet.length;
        int maxElim = PossSet.length;
        CodePegs.Peg[] currMaxGuess = PossSet[0];
        int minElim = 0;
        CodePegs.Peg[] currMinGuess = PossSet[0];

        //iter through each guess
        for (CodePegs.Peg[] guess : PossSet){
            //iter through FB cases
            for (int totalpegs =0;totalpegs<5;totalpegs++){
                for (int i =0;i<=totalpegs;i++){
                    int j = totalpegs-i;
                    FB = new KeyPegs(j,i);
                    score = (trim(guess,FB,PossSet)).length;
                }
                if(score>minElim){minElim=score; currMinGuess=guess}
            } if(minElim<maxElim){maxElim=minElim;currMaxGuess=currMinGuess;}
        } return currMaxGuess;
    }

    //returns true if 1, 1 and 2, or 1 and 2 and 3 are in the array
    private static <T> boolean arrayContains(T[] array, T value0, T value1, T value2) {
        if (value1 == null){return (Arrays.asList(array).contains(value0));}
        else if (value2 == null){return Arrays.asList(array).contains(value0)
                && Arrays.asList(array).contains(value1);}
        else{
            return (Arrays.asList(array).contains(value0)
                    && Arrays.asList(array).contains(value1)
                    && Arrays.asList(array).contains(value2));
        }
    }
}
