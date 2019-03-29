
package TryCatchThrows;

class TryCatch {

    private String name;
    private int divisor;

    TryCatch(String name, int divisor) {
        this.name = name;
        this.divisor = divisor;
    }

    void printName() throws InterruptedException {
        Thread.sleep(10);
        System.out.println(name);
    }

    void divide() throws ArithmeticException {
        System.out.println(100/divisor);
    }
}