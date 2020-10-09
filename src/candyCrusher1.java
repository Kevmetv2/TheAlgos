import java.util.Stack;

public class candyCrusher1 {
    public static void main(String[] args) {
        System.out.println(candyCrush("aabb"));
    }

    public static String candyCrush(String s ){

        Stack<Character> chars = new Stack(); // chars we already have
        Stack<Integer> consecutive = new Stack(); // consecutive occurences

        final int MAX_CONSECUTIVE = 3; // if we want to declare a final

        for(int i = 0; i<s.length();i++){
            Character temp = s.charAt(i);
            if(!chars.isEmpty() && chars.peek() == temp){
                consecutive.push(consecutive.peek()+1); // if the last char is equal to this char increment by 1
            }else{
                consecutive.push(1); // new unique char
            }
            chars.push(temp); // push the current char

            if(consecutive.peek() == 3){ // if consecutives is 3
                for(int j =0;j<3;j++){ // pop 3 times
                    chars.pop();
                    consecutive.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while(!chars.isEmpty()){
            result.append(chars.pop());
        }

        return result.reverse().toString();
    }
}
