package enumexample;

public enum Enum2 {
    Ankit(1),
    Aparna(2);

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    Enum2(int code) {
        this.code = code;
    }
}
