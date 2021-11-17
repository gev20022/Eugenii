public abstract class sharp {
    protected String color;
    protected Boolean filled;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean isFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public sharp(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public sharp() {
        this.color = "BLACK";
        this.filled = false;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public abstract String toString();
}
