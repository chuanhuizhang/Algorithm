package com.chapter05;

public class App {
    static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }

    static Double plus(String[] stringArray) throws Exception{
        Stack<String> operators = new Stack<String>();
        Stack<Double> values = new Stack<Double>();
        for (String s : stringArray) {
            if (s.equals("(")) {

            } else if (s.equals("+") || s.equals("-") || s.equals("*")) {
                operators.push(s);
            } else if (s.equals(")")) {
                double valFirst = values.pop();
                double valSecond = values.pop();
                String op = operators.pop();
                if (op.equals("+")) {
                    values.push(valFirst + valSecond);
                } else if (op.equals("-")) {
                    values.push(valSecond - valFirst);
                } else if (op.equals("*")) {
                    values.push(valSecond * valFirst);
                }
            } else {
                values.push(Double.parseDouble(s));
            }
        }
        return values.pop();
    }

    public static void main(String[] args) {
        System.out.println(gcd(8, 6));
        System.out.println(6%8);

        String[] expression = {"(", "1", "+", "2", ")"};
        try {
            System.out.println(plus(expression));
        } catch(Exception e) {}
    }


}
