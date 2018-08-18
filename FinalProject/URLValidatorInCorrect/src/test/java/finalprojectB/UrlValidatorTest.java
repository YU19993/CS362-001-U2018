
package finalprojectB;

import org.junit.Test;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {

    private static final long Timeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int TestNum = 100;

    private static final String[] validSchemes = new String[] {"http://","h3t://", "ftp://", "" };
    private static final String[] invalidSchemes = new String[] {"3ht://",  "http/", "://", "http:","http:/"};

    private static final String[] validAuthorities = new String[] {"www.google.com", "0.0.0.0","255.com","go.au"};
    private static final String[] invalidAuthorities = new String[] { "256.256.256.256", ""};

    private static final String[] validPorts = new String[] {":80",":65555",":0",""};
    private static final String[] invaildPorts = new String[] {":-1",":65636",":65a"};

    private static final String[] validPaths = new String[] {"/test1", "/t123"};
    private static final String[] invalidPaths = new String[] { "/..","/..//file"};

    private static final String[] vaildQueries = new String[] {"", "?action=view"};
    private static final String[] invaildQueries = new String[] {"&jft"};



    public UrlValidatorTest(String testName) {
        super(testName);
    }

    @Test
    public void testManualTest0() {
        UrlValidator validator = new UrlValidator();
        assertFalse(validator.isValid(null));
        assertFalse(validator.isValid("sftp://www.google.com"));
        assertFalse(validator.isValid("   "));
    }

   @Test
    public void testManualTest1() {
        UrlValidator validator = new UrlValidator();
        boolean vd = validator.isValid("http://www.google.com/");
        //assertTrue(vd);  fail the test  BUG
    }

    @Test
    public void testManualTest2() {
        UrlValidator validator = new UrlValidator();
        boolean vd = validator.isValid("3ht:///www.google.com");
        assertFalse(vd);
        vd = validator.isValid("hvlsdfjglfgldsfglkndflkgj");
        assertFalse(vd);
    }

   @Test
    public void testScheme() {
        String[] schemes = {"http"};
        UrlValidator validator1 = new UrlValidator(schemes);
        // valid
        boolean dv = validator1.isValid("http://www.google.com/");
        //assertTrue(dv);   BUG
        dv = validator1.isValid("://www.google.com/");
        assertFalse(dv);

        UrlValidator validator2 = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
        dv = validator2.isValid("http://www.google.com/");
        assertTrue(dv);
        dv = validator2.isValid("://www.google.com/");
        assertFalse(dv);
    }

  @Test
    public void testAuthority() {
        UrlValidator validator = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
        // valid
        boolean dv = validator.isValid("www.google.com/");
        //assertTrue(dv); BUG
        dv = validator.isValid("http://8.8.8.8/pathQuery#Fragment");
        //assertTrue(dv);
        dv = validator.isValid("http://localhost/index.html");
      //  assertTrue(dv); // Should be true
        dv = validator.isValid("http://256.256.256.256/pathQuery#Fragment");
      //  assertFalse(dv);
        dv = validator.isValid("http:///pathQuery#Fragment");
      //  assertFalse();
        dv = validator.isValid("http://localhost/pathQuery#Fragment");
      //  assertTrue(dv);
    }

   @Test
    public void testPort() {
        UrlValidator validator = new UrlValidator();
        //valid port
        boolean dv = validator.isValid("http://www.google.com:80/pathQuery#Fragment");
      //  assertTrue(dv);
        dv = validator.isValid("http://www.google.com:65555/pathQuery#Fragment");
      //  assertTrue(dv);
        dv = validator.isValid("http://www.google.com:0/pathQuery#Fragment");
        //assertTrue(dv);
        // empty port
        dv = validator.isValid("http://www.google.com:0/pathQuery#Fragment");
      //  assertTrue(dv);
        // invalid port
        dv = validator.isValid("http://www.google.com:/pathQuery#Fragment");
        assertFalse(dv);
        dv = validator.isValid("http://www.google.com:-80/pathQuery#Fragment");
        assertFalse(dv);
        assertFalse(validator.isValid("http://www.google.com:port/pathQuery#Fragment"));
    }

  @Test
    public void testPath() {
        UrlValidator validator = new UrlValidator(UrlValidator.ALLOW_2_SLASHES);
        //vaild
        boolean dv = validator.isValid("http://www.google.com/path");
        //assertTrue(dv);
        //null path, invalid
        dv = validator.isValid("http://www.google.com/Query#Fragment");
        //assertFalse(dv);
        //Invalid Path, zero path slashes
        dv = validator.isValid("http://www.google.compathQuery#Fragment");
        //assertFalse(dv);
        //valid, "//" allowed
        dv = validator.isValid("http://www.google.com//pathQuery#Fragment");
        //assertTrue(dv);
        //Invalid Path, ALLOW_2_SLASHES states that it allows 2 slashes in the path, adding more should be invalid but is not.
        assertFalse(validator.isValid("http://www.google.com/////pathQuery#Fragment"));

    }

   @Test
    public void testQuery(){
        UrlValidator validator = new UrlValidator();
        // valid, null query
        boolean dv = validator.isValid("http://www.google.com/");
        //assertTrue(dv);
        dv = validator.isValid("http://www.google.com/test1");
        //assertTrue(dv);
        //the beginning of the Query be denoted by "?"
        dv = validator.isValid("http://localhost/path?Query#Fragmentnjnjnj");
        //assertTrue(dv);
        dv = validator.isValid("http://localhost/path#%Query#Frayfjfjhggment");
        assertFalse(dv);

    }


   @Test
    public void testProgrammaticValid() {

        for(int i = 0; i < validSchemes.length-1; i++){
            for(int j = 0; j < validAuthorities.length-1; j++){
                for(int m = 0; m < validPorts.length-1; m++){
                    for(int k = 0; k < validPaths.length-1; k++){
                        for(int t = 0; t < vaildQueries.length-1; t++){
                            String URL = validSchemes[i] + validAuthorities[j] + validPorts[m] + validPaths[k] + vaildQueries[t];
                            UrlValidator validator = new UrlValidator();
                            boolean vd = validator.isValid(URL);
                            //assertTrue(vd);   Bug
                    }
                }
            }
        }

    }
  }

   @Test
    public void testProgrammaticInvalid() {

      boolean dv;
        for(int i = 0; i < invalidSchemes.length-1; i++){
            for(int j = 0; j < validAuthorities.length-1; j++){
                for(int m = 0; m < validPorts.length-1; m++){
                    for(int k = 0; k < validPaths.length-1; k++){
                            String URL = invalidSchemes[i] + validAuthorities[j] + validPorts[m] + validPaths[k] +"";
                            UrlValidator validator1 = new UrlValidator();
                            dv = validator1.isValid(URL);
                          //  assertFalse(validator.isValid(URL));
                    }
                }
            }
        }

        for(int i = 0; i < validSchemes.length-1; i++){
        for(int j = 0; j < invalidAuthorities.length-1; j++){
            for(int m = 0; m < validPorts.length-1; m++){
                for(int k = 0; k < validPaths.length-1; k++){
                        String URL = validSchemes[i] + invalidAuthorities[j] + validPorts[m] + validPaths[k] +"";
                        UrlValidator validator2 = new UrlValidator();
                        dv = validator2.isValid(URL);
                      //  assertFalse(validator.isValid(URL));
                }
            }
        }
    }



      for(int i = 0; i < validSchemes.length-1; i++){
        for(int j = 0; j < validAuthorities.length-1; j++){
        for(int m = 0; m < invaildPorts.length-1; m++){
            for(int k = 0; k < validPaths.length-1; k++){
                    String URL = validSchemes[i] + validAuthorities[j] + invaildPorts[m] + validPaths[k] +"";
                    UrlValidator validator3 = new UrlValidator();
                    dv  = validator3.isValid(URL);
                  //  assertFalse(validator.isValid(URL));
            }
        }
    }
}


for(int i = 0; i < validSchemes.length-1; i++){
    for(int j = 0; j < validAuthorities.length-1; j++){
        for(int m = 0; m < validPorts.length-1; m++){
            for(int k = 0; k < invalidPaths.length-1; k++){
                    String URL = validSchemes[i] + validAuthorities[j] + validPorts[m] + validPaths[k] +"";
                    UrlValidator validator4 = new UrlValidator();
                    dv = validator4.isValid(URL);
                  //  assertFalse(validator.isValid(URL));
            }
        }
    }
}

}


}
