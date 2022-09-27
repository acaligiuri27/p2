/*@author
Adam Caligiuri
CS 242 P2
*/

package anagrams;

public class DuplicateKeyException extends java.lang.RuntimeException {
    private String message;
    DuplicateKeyException() {this("Duplicate Key");}
    DuplicateKeyException(java.lang.String message) {this.message = message;}

}
