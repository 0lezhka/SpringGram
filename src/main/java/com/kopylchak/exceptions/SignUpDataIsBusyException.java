package com.kopylchak.exceptions;

public class SignUpDataIsBusyException extends Exception{
    private boolean isEmilBusy;
    private boolean isPasswordBusy;
    private boolean isNicknameBusy;

    public SignUpDataIsBusyException(boolean isEmilBusy, boolean isPasswordBusy, boolean isNicknameBusy) {
        this.isEmilBusy = isEmilBusy;
        this.isPasswordBusy = isPasswordBusy;
        this.isNicknameBusy = isNicknameBusy;
    }

    public SignUpDataIsBusyException() {
    }

    public boolean isDataBusy(){return isEmilBusy || isPasswordBusy || isNicknameBusy;}

    public boolean isEmilBusy() {
        return isEmilBusy;
    }

    public void setEmilBusy(boolean emilBusy) {
        isEmilBusy = emilBusy;
    }

    public boolean isPasswordBusy() {
        return isPasswordBusy;
    }

    public void setPasswordBusy(boolean passwordBusy) {
        isPasswordBusy = passwordBusy;
    }

    public boolean isNicknameBusy() {
        return isNicknameBusy;
    }

    public void setNicknameBusy(boolean nicknameBusy) {
        isNicknameBusy = nicknameBusy;
    }
}
