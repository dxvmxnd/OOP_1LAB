class CtgFunction extends TrigonometricFunction {
    @Override
    double calculate(double x) {
        return 1 / Math.tan(x);
    }
}
