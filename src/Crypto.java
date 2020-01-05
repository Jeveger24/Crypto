public class Crypto {
    public static void main(String[] args) {
        System.out.println(normalizeText("i like zoos"));
        System.out.println(caesarify("ILIKEZOOS", 2));
    }

    public static String normalizeText(String text) {
        String modify = text.replaceAll("[^A-Za-z]+", "").toUpperCase();
        return modify;
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for (; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if (result.length() < 26) {
            for (currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String caesarify(String text, int key) {
        String modify = shiftAlphabet(key);
        modify = text.replace(text, modify);
        return modify;
    }

    public static String groupify(String text, int letters) {
        String modify = "";
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (i % letters == 0 && i != 0) {
                modify = modify + " ";
            }
            modify = modify + text.charAt(i);
        }
        for (int i = modify.lastIndexOf(" ")+1; i < modify.length(); i++) {
            ++count;
        }
        for (int i = letters - count; i > 0; i--) {
            modify += "X";
        }
        return modify;
    }

    public static String encryptString(String text, int value, int size) {
        String modify = "";
        modify = normalizeText(text);
        modify = caesarify(text, value);
        modify = groupify(text, size);
        return modify;
    }

    public static String ungroupify(String text) {
        String modify = text.replaceAll(" ", "");
        return modify;
    }

    public static String decryptString(String text, int value) {
        return ungroupify(text);
    }
}
