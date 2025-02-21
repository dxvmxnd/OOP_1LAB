class LinearFunction extends AlgebraicFunction {
    private double a, b;

    public LinearFunction(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }

    @Override
    double calculate(double x) {
        return a * x + b;
    }
}