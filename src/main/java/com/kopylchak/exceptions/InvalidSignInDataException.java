package com.kopylchak.exceptions;

public class InvalidSignInDataException extends UserProfileException{
    private String usernameMsg;
    private String nicknameMsg;
    private String passwordMsg;
    private String emailMsg;
    private String phoneMsg;

    public String getUsernameMsg() {
        return usernameMsg;
    }

    public void setUsernameMsg(String usernameMsg) {
        this.usernameMsg = usernameMsg;
    }

    public String getNicknameMsg() {
        return nicknameMsg;
    }

    public void setNicknameMsg(String nicknameMsg) {
        this.nicknameMsg = nicknameMsg;
    }

    public String getPasswordMsg() {
        return passwordMsg;
    }

    public void setPasswordMsg(String passwordMsg) {
        this.passwordMsg = passwordMsg;
    }

    public String getEmailMsg() {
        return emailMsg;
    }

    public void setEmailMsg(String emailMsg) {
        this.emailMsg = emailMsg;
    }

    public String getPhoneMsg() {
        return phoneMsg;
    }

    public void setPhoneMsg(String phoneMsg) {
        this.phoneMsg = phoneMsg;
    }

    public boolean isEmpty(){
        return usernameMsg == null &&
                nicknameMsg == null &&
                passwordMsg == null &&
                emailMsg == null &&
                phoneMsg == null;
    }
}
