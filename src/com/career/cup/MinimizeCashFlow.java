package com.career.cup;

import java.util.Arrays;

/**
 * Problem:
 * Minimize Cash Flow among a given set of friends who have borrowed money from each other
 * Given a number of friends who have to give or take some amount of money from one another.
 * Design an algorithm by which the total cash flow among all the friends is minimized
 *
 * @author hrishikesh.mishra
 */
public class MinimizeCashFlow {
	
	public static void main(String[] args) {
        int[][] graph = {
        		//i=>
                {0, 1000, 2000},//j
                {0, 0, 5000},
                {0, 0, 0},
        };
        minimumCashFlow(graph);
    }

    public static void minimumCashFlow(int[][] graph) {
        int[] amount = getAmount(graph);
        minimumCashFlow(amount);

    }
    private static int[] getAmount(int[][] graph) {
    	
        int amount[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                /**
                 * Here  graph[j][i] => incoming amount
                 * and  graph[i][j] => outgoing amount
                 */
            	System.out.println(i+"====="+j);
            	System.out.println(graph[j][i]+"*****"+graph[i][j]);
                amount[i] += graph[j][i] - graph[i][j];
                System.out.println("Amount for "+i+" is "+amount[i]);
            }
        }
        System.out.println(Arrays.toString(amount));
        return amount;
    }
  
    public static void minimumCashFlow(int[] amount) {

        //@// TODO: 13/12/16  
        int maximumCreditPerson = getMaxPerson(amount);
        int maximumDebitPerson = getMinPerson(amount);

        if (amount[maximumCreditPerson] == 0 && amount[maximumDebitPerson] == 0) {
            return;
        }

        int min = Math.min(-amount[maximumDebitPerson], amount[maximumCreditPerson]);

        amount[maximumCreditPerson] -= min;
        amount[maximumDebitPerson] += min;


        System.out.println("Person(" + maximumDebitPerson + ") pays " +
                min + " to Person(" + maximumCreditPerson + ")");

        minimumCashFlow(amount);
    }

    private static int getMinPerson(int[] amount) {
        int minPerson = 0;
        for (int i = 1; i < amount.length; i++) {
            if (amount[i] < amount[minPerson]) {
                minPerson = i;
            }
        }

        return minPerson;
    }

    private static int getMaxPerson(int[] amount) {
        int maxPerson = 0;
        for (int i = 1; i < amount.length; i++) {
            if (amount[i] > amount[maxPerson]) {
                maxPerson = i;
            }
        }
        return maxPerson;
    }
}
