package 대회.보라매컵;

class Solution {
    public int solution(String phone_number) {
        int answer = 0;

        if(phone_number.charAt(3)=='-'){
            String separator = phone_number.substring(0,4);
            if(separator.equals("010-")){
                if(!validateSize(phone_number,13)) return -1;
//                if(!validateCharacter(phone_number,8,'-')) return -1;
                if(!validateTypeOne(phone_number)) return -1;
                answer=1;
            }
            else if(separator.equals("+82-")){
                if(!validateSize(phone_number,16)) return -1;
                if(!validateTypeThree(phone_number)) return -1;
//                if(!validateCharacter(phone_number,6,'-')) return -1;
//                if(!validateCharacter(phone_number,11,'-')) return -1;
                answer = 3;
            }
        }
        else{
            if(!validateSize(phone_number,11)) return -1;
            if(!validateTypeTwo(phone_number)) return -1;
            answer = 2;
        }
        return answer;
    }

    public boolean validateSize(String input, int size){
        if(input.length()!=size) return false;
        return true;
    }

    public boolean validateCharacter(String input, int position, char ch){
        if(input.charAt(position)!=ch) return false;
        return true;
    }

    public boolean validateTypeOne(String input){
        for(int i=0;i<input.length();++i){
            if(i==3 || i==8){
                if(input.charAt(i)!='-') return false;
            }
            else{
                if(input.charAt(i)<48 || input.charAt(i)>57) return false;
            }
        }
        return true;
    }

    public boolean validateTypeTwo(String input){
        for(int i=0;i<input.length();++i){
            if(input.charAt(i)<48 || input.charAt(i)>57) return false;
        }
        return true;
    }

    public boolean validateTypeThree(String input){
        for(int i=0;i<input.length();++i){
            if(i==0){
                if(input.charAt(i)!='+') return false;
            }
            else if(i==3 || i==6 || i==11){
                if(input.charAt(i)!='-') return false;
            }
            else{
                if(input.charAt(i)<48 || input.charAt(i)>57) return false;
            }
        }
        return true;
    }
}