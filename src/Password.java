import java.util.Random;

public class Password {
    public String generate (int size, char upperCase, char Symbols) {
        Random rand = new Random();
        String password = "";
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";

        // If user includes upper case and / or Symbols include to the initial string
        if (upperCase == 'y') {
            characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (Symbols == 'y') {
            characters += "!@#$%^&/*-+(?~<>_";
        }

        for (int i = 0; i < size; i++) {
            int x = rand.nextInt(characters.length());
            char y = characters.charAt(x);
            password += y;
        }
        return password;
    }

    public void strength (String password) {
        // Variables
        double strengthPoints = 0;
        int length = password.length();
        boolean includeUpper = false, includLower = false, includeDigit = false, includeSymbol = false;


        if (length >= 12) {
            strengthPoints += 8;
        } else if (length >= 8) {
            strengthPoints += 6;
        } else if (length >= 6) {
            strengthPoints += 4;
        } else {
            System.out.println("Your password is very poor");
            return;
        }

        for (int i = 0; i < length; i++) {
            char c = password.charAt(i);

            // Verify character type
            if (Character.isUpperCase(c)) {
                includeUpper = true;
            } else if (Character.isLowerCase(c)) {
                includLower = true;
            } else if (Character.isDigit(c)) {
                includeDigit = true;
            } else includeSymbol = true;
        }

        if (includeUpper) strengthPoints += 3;
        if (includLower) strengthPoints += 2;
        if (includeDigit) strengthPoints += 2;
        if (includeSymbol) strengthPoints += 4;

        String strength;
        if (strengthPoints >= 20) strength = "Very strong";
        else if (strengthPoints >= 15) strength = "Strong";
        else if (strengthPoints >= 10) strength = "Moderated";
        else if (strengthPoints >= 5) strength = "Poor";
        else strength = "Too poor";

        System.out.println("Strength: " + strength + " | Points: " + strengthPoints);
    }
}
