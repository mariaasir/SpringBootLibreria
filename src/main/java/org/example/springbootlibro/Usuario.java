package org.example.springbootlibro;

public class Usuario {
    private String nickname;
    private String password;

    public Usuario(String nickname, String password) {
        this.nickname = nickname;
        if (validarPassword(password)) {
            this.password = password;
        }

    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean validarPassword(String password) throws IllegalArgumentException {
        if (password.matches("^[A-Za-z0-9]{8,16}$")) {
            return true;
        } else {
            throw new IllegalArgumentException("Password incorrecta.");
        }
    }

    public String toString() {
        return "Usuario{nickname='" + this.nickname + "', password='" + this.password + "'}";
    }
}
