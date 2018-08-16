
package finalprojectB;

import org.junit.Test;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {

    public UrlValidatorTest(String testName) {
        super(testName);
    }

    @Test
    public void testManualTest0() {
        UrlValidator validator = new UrlValidator();
        // should fail, null input is invalid
        assertFalse(validator.isValid(null));
        // should fail, default supported scheme is http, https, ftp
        assertFalse(validator.isValid("sftp://www.google.com"));
        // should fail, not match a URL_PATTERN
        assertFalse(validator.isValid("   "));
    }

    @Test
    public void testManualTest1() {
        UrlValidator validator = new UrlValidator();
        assertTrue(validator.isValid("http://www.google.com/"));
    }
    
    @Test
    public void testManualTest2() {
        UrlValidator validator = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
        assertTrue(validator.isValid("sftp://www.google.com"));
    }

    @Test
    public void testScheme() {
        String[] schemes = {"http"};
        UrlValidator validator = new UrlValidator(schemes);
        // valid
        assertTrue(validator.isValid("http://www.google.com/pathQuery#Fragment"));
        // not supported scheme
        assertFalse(validator.isValid("ftp://www.google.com/pathQuery#Fragment"));
        // Invalid scheme
        assertFalse(validator.isValid("123://www.google.com/pathQuery#Fragment"));
        // empty scheme
        assertFalse(validator.isValid("://www.google.com/pathQuery#Fragment"));
        // without
        assertFalse(validator.isValid("http//www.google.com/pathQuery#Fragment"));
    }

    @Test
    public void testAuthority() {
        UrlValidator validator = new UrlValidator();
        // valid
        assertTrue(validator.isValid("http://www.google.com/pathQuery#Fragment"));
        // valid
        assertTrue(validator.isValid("http://www.google.com:80/pathQuery#Fragment"));
        // valid
        assertTrue(validator.isValid("http://8.8.8.8/pathQuery#Fragment"));
        // valid
        assertTrue(validator.isValid("http://8.8.8.8:80/pathQuery#Fragment"));
        // invalid, empty hostname
        assertFalse(validator.isValid("http://:80/pathQuery#Fragment"));
        assertFalse(validator.isValid("http:///pathQuery#Fragment"));
        // invalid port
        assertFalse(validator.isValid("http://www.google.com:/pathQuery#Fragment"));
        assertFalse(validator.isValid("http://www.google.com:-80/pathQuery#Fragment"));
        assertFalse(validator.isValid("http://www.google.com:port/pathQuery#Fragment"));
        // valid
        assertFalse(validator.isValid("http://localhost/pathQuery#Fragment"));
    }

    @Test
    public void testURLPath() {
        
    }

    public void testIsValid() {
        // You can use this function for programming based testing

    }

}
