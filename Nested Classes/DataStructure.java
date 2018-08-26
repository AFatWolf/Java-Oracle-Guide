import java.util.Iterator;
import java.util.function.*;

public class DataStructure{
    // Create an array
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public DataStructure() {
        for(int i = 0; i < SIZE; i++){
            arrayOfInts[i] = i;
        }
    }

    public void printEven(){
        // print out values of even indices of the array
        DataStructureIterator iterator = new EvenIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next() + " ");   
        }
        System.out.println();
    }

    public EvenIterator createInstanceOfEvenIterator(){
        return new EvenIterator();
    }

    public DataStructureIterator createInstanceOfOddIterator(){
        return new DataStructureIterator(){
                private int nextIndex = 1;
                @Override
                public Integer next() {
                    Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
                   nextIndex += 2;
                  return retValue;
                }
        
                @Override
                public boolean hasNext() {
                    return (nextIndex < SIZE);
                }
        };
    }
    // for part b
    public void print(DataStructureIterator iterator) {
        while(iterator.hasNext()){
            System.out.println(iterator.next() + " ");
        }
        System.out.println();
    }

    // for part c
    public void printc (Function<Integer, Boolean> iterator) {
        Integer index = new Integer(0);
        while(iterator.apply(index) == Boolean.TRUE){
            //System.out.println("index is: " + index.intValue());
            index = index.valueOf(index.intValue() + 2);
        }
        System.out.println();
    }

    interface DataStructureIterator
        extends java.util.Iterator<Integer>{ }

    private class EvenIterator implements DataStructureIterator {
        private int nextIndex = 0;

        public boolean hasNext(){
            return (nextIndex <= SIZE - 1);
        }

        public Integer next() {
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
            nextIndex += 2;
            return retValue;
        }
    }

    public static Function<Integer, Boolean> createOddClass() {
        return (Integer i) -> {
            if(i.intValue() < SIZE){
                System.out.println((new DataStructure().arrayOfInts[i.intValue()] + 1) + " ");
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        };
    }

    public void printd(Function<Integer, Boolean> iterator){
        for(int i = 0; i < SIZE; i++){
            if(iterator.apply(new Integer(i)) == Boolean.TRUE)
                System.out.println(arrayOfInts[i] + " ");
        }
        System.out.println();
    }

    public static Boolean isEvenIndex(Integer i){
        return i.intValue() < SIZE && (i.intValue() % 2 == 0);
    }

    public static Boolean isOddIndex(Integer i){
        return i.intValue() < SIZE && (i.intValue() % 2 == 1);
    }

    public static void main(String[] args){
       DataStructure ds = new DataStructure();
       // a
       System.out.println("a:");
       DataStructureIterator it = ds.createInstanceOfEvenIterator();
       ds.print(it);
        // b
        System.out.println("b:");
//        ds.print(ds.createInstanceOfOddIterator());
        ds.print(new DataStructureIterator(){
            int index = 0;
            public boolean hasNext(){
                if(index == 0)  {
                    index = 1;
                    return true;
                }
                return false;
            }
            public Integer next(){
                return Integer.valueOf(300);
            }
        });
        // c
        // even index
        System.out.println("c:");
        System.out.println("Even:");
        ds.printc((Integer i) -> {
            if(i.intValue() < SIZE){
                System.out.println(new DataStructure().arrayOfInts[i.intValue()] + " ");
                return Boolean.TRUE;   
            }
            return Boolean.FALSE;
        });
        System.out.println("Odd:");
        // testing return a class 
        ds.printc(DataStructure.createOddClass());
        // d
        // you can use printd to solve problem c
        System.out.println("d:");
        // the way to use lamba to illustrate a way to solve problem c
        System.out.println("Using lamba:");
        ds.printd((Integer i) -> DataStructure.isEvenIndex(i));
        ds.printd((Integer i) -> DataStructure.isOddIndex(i));
        // the way using method reference
        System.out.println("Using method reference:");
        ds.printd(DataStructure::isEvenIndex);
        ds.printd(DataStructure::isOddIndex);
    }
}