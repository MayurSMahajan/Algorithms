import java.util.*;

// 1352. https://leetcode.com/problems/product-of-the-last-k-numbers/

public class ProductOfKLastNums {
    public static void main(String[] args) {
        ProductOfNumbers pn = new ProductOfNumbers();
        pn.add(2);
        pn.add(5);
        pn.add(4);
        pn.printPdts();
        System.out.println(pn.getProduct(3));
    }
}

class ProductOfNumbers {

    ArrayList<Integer> pdts = new ArrayList<Integer>(){{
        add(1);
    }};

    public void add(int a) {
        if (a > 0)
            pdts.add(pdts.get(pdts.size() - 1) * a);
        else {
            pdts = new ArrayList<Integer>();
            pdts.add(1);
        }
    }

    public int getProduct(int k) {
        int n = pdts.size();
        if(k < n ){
           return pdts.get(n - 1) / pdts.get(n - k - 1);
        }
        return 0;
    }

    public void printPdts(){
        System.out.println(pdts);
    }
}
