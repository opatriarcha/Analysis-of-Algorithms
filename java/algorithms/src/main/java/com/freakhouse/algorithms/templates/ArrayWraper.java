package com.freakhouse.algorithms.templates;

import java.util.List;
import lombok.Data;

/**
 *
 * @author freakhouselabs
 * @param <T>
 */

@Data
public class ArrayWraper {
    private List<Integer>[] array;            
    
    
    public List<Integer>[] toRawArray(){
        return this.array.clone();
    }
}
