package enumexample;

public enum Enum3 {
    Ankit(1) {
        public String gender() {
            return "male";
        }
    },
    Aparna(2) {
        public String gender() {
            return "female";
        }
    },
    baby(3);

    public String gender() {
        return "human";
    }

    private int code;

    public int getCode() {
        return code;
    }

    private Enum3(int code) {
        this.code = code;
    }


}
