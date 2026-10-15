package cs02.异常.chapt12;


public class DemoException {
    public static void main(String[] args) {
        // 除数为0，抛出异常。这种情况程序员可以控制，把计算时除数为0的情况排除就行了
        int num = 3 / 0;
        // 内存溢出，这是错误。这种情况程序员无法处理，因为内存溢出可能与硬件设备相关，比如计算机内存只有256M
        int[] arr = new int[1024*1024*1024];
    }
}
