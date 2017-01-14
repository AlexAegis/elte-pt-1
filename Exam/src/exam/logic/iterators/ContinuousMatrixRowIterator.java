package exam.logic.iterators;


import java.util.Iterator;
import java.util.List;

public class ContinuousMatrixRowIterator<T> implements Iterator<T> {

    private List<List<T>> matrix;
    private int i = 0;
    private int j = 0;

    public ContinuousMatrixRowIterator(List<List<T>> matrix) {
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
        if(j + 1 >= matrix.get(i).size()) {
            i++;
            j = 0;
        } else {
            j++;
        }
        return result;
    }
}