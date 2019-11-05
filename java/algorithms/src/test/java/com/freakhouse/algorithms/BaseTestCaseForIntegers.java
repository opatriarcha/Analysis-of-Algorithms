package com.freakhouse.algorithms;

//import br.com.six2six.fixturefactory.Fixture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
//import com.freakhouse.algorithms.templates.ArrayTemplate;
//import com.freakhouse.algorithms.templates.ArrayWraper;

/**
 * Gambiarra do demônio para nẽo ter a encheção de saco de randomizar os arrays.
 * @author freakhouselabs
 */
public class BaseTestCaseForIntegers {
    protected Integer[] TEN_POSITIONS_ARRAY;
    protected Integer[] HUNDRED_POSITIONS_ARRAY;
    protected Integer[] THOUSAND_POSITIONS_ARRAY;
    
    public BaseTestCaseForIntegers(){
        //FixtureFactoryLoader.loadTemplates("com.freakhouse.algorithms.templates");        
//        this.TEN_POSITIONS_ARRAY = Fixture.from(ArrayWraper.class).gimme(ArrayTemplate.Fixtures.VALID_TEN_POSITIONS.toString());
//        this.HUNDRED_POSITIONS_ARRAY = Fixture.from(ArrayWraper.class).gimme(ArrayTemplate.Fixtures.VALID_ONE_HUNDRED_POSIITON.toString());
        
        List<Integer> ten = new ArrayList<>();
        for( int i = 0; i < 10; i++ ){
            ten.add(i);
        }

        List<Integer> hundred = new ArrayList<>();
        for( int i = 0; i < 100; i++ ){
            hundred.add(i);
        }

        List<Integer> thousand = new ArrayList<>();
        for( int i = 0; i < 1000; i++ ){
            thousand.add(i);
        }
        
        Collections.shuffle(ten);
        Collections.shuffle(hundred);
        Collections.shuffle(thousand);
        
        Object[] tempArray = ten.toArray();
        this.TEN_POSITIONS_ARRAY = Arrays.copyOf(tempArray, tempArray.length, Integer[].class);ten.toArray();
        
        tempArray = hundred.toArray();
        this.HUNDRED_POSITIONS_ARRAY = Arrays.copyOf(tempArray, tempArray.length, Integer[].class);ten.toArray();
        
        tempArray = thousand.toArray();
        this.THOUSAND_POSITIONS_ARRAY = Arrays.copyOf(tempArray, tempArray.length, Integer[].class);ten.toArray();

    }        
    
    protected void sortArray(Integer[] array){        
        Arrays.sort(array);
    }
    
    protected void printArray(String msg, Integer[] array){
        StringBuilder builder = new StringBuilder();
        builder.append(msg);
        
        
        for( Integer i : array){
            builder.append(i);
            builder.append(", ");
        }
        String result = builder.toString();
        System.out.println(result.subSequence(0, result.lastIndexOf(", ")).toString());
        
    }
            
}
