package test.base;

import java.util.Scanner;

import junit.framework.TestCase;

/**
 * ������������ռ�ֽ���
 * int   4
 * float 4 [����8�ֽڵ�longȡֵ��Χ����]
 * long  8
 * ��һ�仰���ܼ�����
 * ��������ϸ������
 *
 * @author Json
 * @since 1.0.0
 */
public class BaseTest2 extends TestCase {

    public static void testStrange() {
        System.out.println("��ֵ�++");
        int x = 5;
        // x = ++x;

        //ͬ��
        int temp = x;
        x = x + 1;
        x = temp;
        System.out.println(x); //��ӡ5  
        main(new String[] { "ewe", "" });
    }

    /**
     * cmd�� �����Ŀ¼
     * javac BaseTest2.java  //����Ϊclass�ļ�
     * java BaseTest2  //ִ��
     * 
     * javap -c BaseTest  //�����룬���Բ鿴Դ��
     * ��һ�仰���ܼ�����
     * ��������ϸ������
     * MAIN�������ɳ�������ʱ��������� �ģ�������public�������Ƕ�����õ�
     * @param args
     */
    public static void main(String[] args) {
        testStrange();
    }

    /**
     * int,float,double��0����
     * ��һ�仰���ܼ�����
     * ��������ϸ������
     *
     */
    public void testDiv0() {
        //1.int 
        int i = 1;
        int j = 0;
        try {
            int ij = i / j;
            System.out.println("������0������" + ij);
        } catch (ArithmeticException e) {
            System.out.println("������0�����쳣"); //�˴�ִ��
        }
        //2.float 
        float m = 1f;
        float _m = -1f;
        float n = 0f;
        try {
            float mn = m / n;
            float _mn = _m / n;
            float temp = n / n;
            System.out.println("Float��0������" + mn); //��ӡInfinity
            System.out.println("��Float��0������" + _mn); //��ӡ-Infinity
            System.out.println("float0��0������" + temp);//��ӡNan
        } catch (ArithmeticException e) {
            System.out.println("Float��0�����쳣");
        }
        //3.double 
        double x = 1d;
        double _x = -1d;
        double y = 0d;
        try {
            double xy = (double) (x / y);
            double _xy = (double) (_x / y);
            double temp1 = y / y;
            System.out.println("double��0������" + xy);//��ӡInfinity
            System.out.println("����double��0������" + _xy);//��ӡ-Infinity
            System.out.println("double0��0������" + temp1);//��ӡNan
            System.out.println(Double.POSITIVE_INFINITY); //Infinity
        } catch (ArithmeticException e) {
            System.out.println("double��0�����쳣");
        }
    }

    public void testMaxStringArrayLength() {
        //char[] c = new char[Integer.MAX_VALUE]; //java.lang.OutOfMemeryError �޷���������������ֵ��
        //���4G���޷�������ô�� �������ڴ�ռ�

        /*ͨ���۰���ҵķ�������ȡ������������ռ�*/
        int low = 0;
        int high = Integer.MAX_VALUE;
        int mid = (low + high) / 2;
        int max = low;
        while (low <= high) {
            for (int i = 0; i < 10; i++) {
                try {
                    char[] myc = new char[mid];
                    //û�б��쳣����������
                    max = mid;
                    low = mid + 1;
                    mid = (low + high) / 2;
                    System.out.println("��" + i + "������ɹ���" + max);
                    break;
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    //�����ʮ������ʧ�ܣ���С����ֵ
                    if (i == 9) {
                        System.out.println("����ʧ�ܣ�" + mid);
                        high = mid - 1;
                        mid = (high + low) / 2;
                    }

                }
            }
        }
        System.out.println("The max vlue is:" + max);
    }
    
    public static int getDiv(int k){
    	int i = 2;
    	for (; i < k/2; i++) {
			if(k%i==0){
				System.out.print(i+"*");
				return k;
			}
		}
    	if(i>k/2){
    		return -1;
    	}
    	return -1;
    }
    
    /**
     * ��һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5��
     */
    public void testComputeYinzi(){
    	while(true){
    		Scanner s = new Scanner(System.in);
    		int number = s.nextInt();
    		   int a = 2;
    	        System.out.print(number + "=");
    	        while(number > a){
    	            if(number % a == 0){
    	                System.out.print(a + "*");
    	                number = number / a;
    	            }else{
    	                a++;
    	            }
    	        }

    	        System.out.print(a);
    	}
    }

}
