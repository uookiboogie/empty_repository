package co.yedam.app.gugudan;

import java.util.Scanner;

public class GugudanApp {
	int dan;
	int dan1;
	int dan2;
	void printDan(int dan){
		// 2*1=2 ~ 2*9=18
		for (int i=1; i<10;i++ ) {
			System.out.printf("%d x %d = %d ",dan,i,dan * i);
			System.out.println();
		}
		
	}
	void printRange(int dan1, int dan2) {
		for(int i=dan1; i<(dan2+1);i++) {
			for(int j=1; j<10;j++) {
				System.out.printf("%d x %d = %d ",i,j,i*j);
				System.out.println();
			}
			System.out.println();
		}
	}

	void printAll() {
		for(int i=1; i<10;i++) {
			for(int j=1; j<10;j++) {
				System.out.print((i*j)+" ");
			}
			System.out.println();
		}
	}
	
	void printAllReverse() {
		for(int i=9; i>0;i--) {
			for(int j=9; j>0;j--) {
				System.out.print((i*j)+" ");
			}
			System.out.println();
		 }
	   }
     }

