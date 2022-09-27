package anagrams;

public class NotALetterException extends java.lang.RuntimeException {
    private String message;
    NotALetterException() {this("Not A Letter");}
    NotALetterException(java.lang.String message) {this.message = message;}
}
