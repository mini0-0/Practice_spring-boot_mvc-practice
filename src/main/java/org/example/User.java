package org.example;

public class User {

    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){
//        as-is방식
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

//      to-be 방식
        String password = passwordGenerator.generatePassword();
        if (password.length() >= 8 && password.length() <= 12){
            this.password = password;

        }
    }

    public String getPassword() {
        return password;
    }
}
