package com.example.file;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

public class ReadProperties  
{
    String nameFile="string.txt";


     @Test
    public void TestFile1()
    {
        try
        {
            File fichero = new File(nameFile);
            assertTrue(fichero.canRead());
        }
        catch(Exception e)
        {
            fail("Fail looking for file " + nameFile);
        }
   }

   
    
}

    