package Business.views;

public class ThemeTransferObject {
    private String themeName;

    private double average;

    public ThemeTransferObject(String themeName, double average) {
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
