package encapsulationHomeWork.classBox_01;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        validateParameter("Length", length);
        this.length = length;
    }

    private void setWidth(double width) {
        validateParameter("Width", width);
        this.width = width;
    }

    private void setHeight(double height) {
        validateParameter("Height", height);
        this.height = height;
    }

    public double calculateSurfaceArea() {
        // Volume = lwh
//Lateral Surface Area = 2lh + 2wh
//Surface Area = 2lw + 2lh + 2wh
        return 2 * (length * width) + 2 * (length * height) + 2 * (width * height);
    }

    public double calculateLateralSurfaceArea() {
       return  2 * (length * height) + 2 * (width * height);
    }

    public double calculateVolume() {
        return length * width * height;
    }

    private void validateParameter(String parameterName, double parameter) {
        if (parameter <= 0) {
            throw new IllegalArgumentException(parameterName + " cannot be zero or negative.");
        }
    }
}
