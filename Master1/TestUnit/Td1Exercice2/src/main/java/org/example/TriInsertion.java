package org.example;

public class TriInsertion implements TriTableau {
    public int[] trier(int[] table) {
        int info;
        int pos;

        for (int i = 1; i < table.length; i++) {
            info = table[i];
            for (pos = i; (pos > 0) && (table[pos - 1] > info); pos--)
                table[pos] = table[pos - 1];
            table[pos] = info;
        }
        return table;
    }
}
