import java.awt.geom.Rectangle2D;
public class Mandelbrot extends FractalGenerator{

    // Количество итераций, наобходимое для определения принадлежности точки множеству.
    public static final int MAX_ITERATIONS = 2000; //2000

    public Mandelbrot() {

    }

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    /**
     * Если значения Z в рекуррентной формуле Z(n+1) = Z(n)^2 + c; стремится к бесконечности -
     * значит точка находится за пределами фрактала.
     * Если значение Z колеблется в пределах фрактала: |Z| < 2, значит точка принадлежит множеству Мандельброта.
     * При переформулировании формулы множества Мандельброта в итеративную последовательность значений координат на плоскости
     * формула принимает вид: X(n+1) = X(n)^2 - Y(n)^2 + X(0); Y(n+1) = 2 *  X(n) * Y(n) + Y(0);
     * А ограничение примет вид: X(n)^2 + Y(n)^2 < 4
     */
    @Override
    public int numIterations(double x, double y) {
        int iteration = 0;
        double realPart = 0;
        double imaginaryPart = 0;

        while ((iteration < MAX_ITERATIONS) && ((realPart * realPart + imaginaryPart * imaginaryPart) < 4)) {
            double rp = realPart * realPart - imaginaryPart * imaginaryPart + x;
            double ip = 2 * realPart * imaginaryPart + y;
            realPart = rp;
            imaginaryPart = ip;
            iteration ++;
        }

        // -1 - точка принадлежит последовательности, iteration - не принадлежит.
        if (iteration == MAX_ITERATIONS)
            return -1;
        else
            return iteration;
    }

    @Override
    public String toString() {
        return "Mandelbrot";
    }
}
