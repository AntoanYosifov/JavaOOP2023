package inheritanceLab.stackOfStrings_04;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private final List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        int index = this.size() - 1;

        return this.data.remove(index);
    }

    public String peek() {
        int index = this.data.size() - 1;

        return this.data.get(index);
    }

    public int size() {
        return this.data.size();
    }
    public boolean isEmpty(){
        return this.size() == 0;
    }
}
