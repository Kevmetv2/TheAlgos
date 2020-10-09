import java.util.Stack;

public class candyCrusher {

    public static void main(String[] args) {
        System.out.println(candyCrush("aaaaaaab"));
    }

    public candyCrusher(){

    }

    public static String candyCrush(String str){
        Stack<Character> characterStack = new Stack<>(); // stack for the current chars
        Stack<Integer> consecutiveCountStack = new Stack<>();
        for( char c : str.toCharArray()){
            if(!characterStack.isEmpty() && characterStack.peek() == c){
                consecutiveCountStack.push(consecutiveCountStack.peek()+1); // found a consecutive character
            }else{
                consecutiveCountStack.push(1); // empty or not equal
            }
            characterStack.push(c); // push the current char

            if(consecutiveCountStack.peek() == 3){ // if there is 3 consecutive characters
                for(int i = 0; i < 3; i++){
                    consecutiveCountStack.pop(); // pop the three increment numbers
                    characterStack.pop(); // pop the three chars off the stack
                }
            }
        }
        StringBuilder sb = new StringBuilder(); // create the string
        while(!characterStack.isEmpty()){
            sb.append(characterStack.pop()); // for every character append it to the result
        }
        return sb.reverse().toString();
    }
}
