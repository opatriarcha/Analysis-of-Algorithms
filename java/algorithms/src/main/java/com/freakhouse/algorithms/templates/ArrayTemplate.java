package com.freakhouse.algorithms.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freakhouselabs
 */
public class ArrayTemplate implements TemplateLoader{
    
    public enum Fixtures{
        VALID_TEN_POSITIONS, VALID_ONE_HUNDRED_POSIITON;
    }
    

    @Override
    public void load() {
        //ArrayWraper<Integer> wrapper = new ArrayWraper<>();
        ArrayWraper wrapper = new ArrayWraper();
        
        
        Fixture.of(ArrayWraper.class).addTemplate("VALID_TEN_POSITIONS", new Rule() {{            
            add("array", random(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        }});
        
        Fixture.of(ArrayWraper.class).addTemplate("VALID_ONE_HUNDRED_POSIITON", new Rule() {{            
            add("array", random(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100));
        }});        
    }     
    
}
