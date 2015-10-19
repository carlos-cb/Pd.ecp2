package Business.views;

public class ThemeAverageTransferObject {
    private String themeName;

    private double average;

    public ThemeAverageTransferObject(String themeName, double average) {
        this.themeName = themeName;
        this.average = average;
    }

    public String getThemeName() {
        return themeName;
    }

    public double getAverage() {
        return average;
    }

}
