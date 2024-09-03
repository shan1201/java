public class Encryptor {
    private final int key;
    public Encryptor(int key) {
        this.key = key;
    }
    public String encryptString(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                int base = Character.isLowerCase(c) ? 'a' : 'A';
                int newCharValue = (Character.toLowerCase(c) - base + key) % 26;
                char newChar = (char) (base + newCharValue);
                if (Character.isLowerCase(c)) {
                    encrypted.append(Character.toUpperCase(newChar));
                } else {
                    encrypted.append(Character.toLowerCase(newChar));
                }
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }
    public static void main(String[] args) {
        Encryptor encryptor = new Encryptor(20);
        String input1 = "Wipro Tech";
        System.out.println(encryptor.encryptString(input1)); 
    }
}
