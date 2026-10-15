package cs01;

public class java005switch {
    public static void main(String[] args) {
        //char grade = args[0].charAt(0);
        //可以理解为查找功能
        char grade = 'C';
        switch(grade)
        {
            case 'A' :
                System.out.println("优秀");
                break;
            case 'B' :
            case 'C' :
                System.out.println("良好");
                break;
            case 'D' :
                System.out.println("及格");
                break;
            case 'F' :
                System.out.println("你需要再努力努力");
                break;
            default :
                System.out.println("未知等级");
        }
        System.out.println("你的等级是 " + grade);


        //如果没有break则继续查找，直到找到或返回默认default
        //如果没有break且找到值，则在找到的指后面的语句都会执行
        int i = 1;
        switch(i){
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");
            default:
                System.out.println("default");
        }
    }
}
