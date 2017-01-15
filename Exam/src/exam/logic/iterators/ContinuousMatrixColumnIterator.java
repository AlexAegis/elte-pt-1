package exam.logic.iterators;

import java.util.Iterator;
import java.util.List;

public class ContinuousMatrixColumnIterator<T> implements Iterator<T> {

    private List<List<T>> matrix;
    private int i = 0;
    private int j = 0;
    public ContinuousMatrixColumnIterator(List<List<T>> matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        boolean result = true;
        try {
            matrix.get(i).get(j);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public T next() {
        T result = matrix.get(i).get(j);
        if(i + 1 >= matrix.size()) {
            j++;
            i = 0;
        } else {
            i++;
        }
        return result;
    }
}