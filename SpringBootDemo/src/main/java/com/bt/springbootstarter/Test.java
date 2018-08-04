package com.bt.springbootstarter;

public class Test {

    public static void main(String args[]){
        String teleNum= "12340416975";
        String newTelenum;
        newTelenum = teleNum.replaceAll(" ", "");
        int length = newTelenum.length();
        //Regex Pattern check to check if the string is numeric and has at least one digit
        boolean isNumeric = newTelenum.matches("[0-9 ]+");
        if (isNumeric && length <= 11) {
            System.out.println("Line id :"+newTelenum);
        } else {
            System.out.println("Circuit id :"+newTelenum);
        }
    }
}
