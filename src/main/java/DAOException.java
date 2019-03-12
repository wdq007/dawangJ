package main.java;

public class DAOException extends Exception {
    private static final long serialVersionUUID = 19192L;

    public DAOException(){

    }

    public DAOException(String message){
        this.message = message;
    }
    public String getMessage(){
     return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    private String message;
    public String toString(){
        return message;
    }
}
