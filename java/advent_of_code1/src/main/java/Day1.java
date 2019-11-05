import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntConsumer;

public class Day1 {

    public static int computeResultingFrequency(String input) {
        String[] frequencies = input.split("\n");

        int sum = 0;
        for (String frequency : frequencies) {
            Integer value = Integer.parseInt(frequency);
            int i = value;
            sum += i;
        }
        return sum;
    }

    public static int computeDoubleFrequency(String input) {
        String[] frequencies = input.split("\n");

        Set<Integer> calculatedFrequencies = new HashSet<>();
        return getLastAcc(frequencies, calculatedFrequencies,0);
    }

    private static int getLastAcc(String[] frequencies, Set<Integer> calculatedFrequencies,int lastAcc) {
        EndStream endStream = new EndStream();

        int result =  Arrays.stream(frequencies)
                .map(Integer::parseInt)
                .mapToInt(value -> value)
                .reduce(lastAcc, (acc, integer) -> {
                    if (!calculatedFrequencies.add(acc)){
                        endStream.endOfStream = acc;
                        return acc;
                    }
                    return acc + integer;
                });

        if (endStream.endOfStream==null){
            return getLastAcc(frequencies,calculatedFrequencies,result);
        }
        return endStream.endOfStream;
    }
}
