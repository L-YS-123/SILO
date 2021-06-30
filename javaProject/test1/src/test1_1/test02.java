package test1_1;

public class test02 {
    // 인스턴스 변수 
    public String pVal = "test Instance Value";
 
    public void changeValue(test02 test, String[] pArrVal) {
        test.pVal = "change Instance Value";
        
        for(int i=0; i < pArrVal.length; i++) {
            pArrVal[i] = "change test" + Integer.toString(i);
        }
    }
    
    public static void main(String[] args) {
        //배열 
        String[] pArrVal = new String[]{"test", "test2"};
        
        test02 test = new test02();
        
        System.out.println("클래스 내 멤버변수 pVal : " + test.pVal);
 
        System.out.print("배열 값 : ");
        for(String innerVal : pArrVal) {
            System.out.print(innerVal + ", ");
        }
        
        System.out.println("\n");
 
        //메소드 호출
        test.changeValue(test, pArrVal);
        
        System.out.println("메소드 호출 후클래스 내 멤버변수 pVal : " + test.pVal);
 
        System.out.print("메소드 호출 후 배열 값 : ");
        for(String innerVal : pArrVal) {
            System.out.print(innerVal + ", ");
        }
    }
}
