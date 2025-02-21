class CubicFunction extends AlgebraicFunction {
    private double a, b, c, d;

    public CubicFunction(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    double calculate(double x) {
        return a * x * x * x + b * x * x + c * x + d;
    }
}