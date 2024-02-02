package participant;

import java.util.ArrayList;
import java.util.List;

public class NameChecker {

    private List<String> nameList;
    private List<String> newNameList;

    public NameChecker(List<String> nameList) {
        this.nameList = nameList;
        this.newNameList = new ArrayList<String>();
    }

    public void check() {
        IsNameEmpty();
        IsNameEqualsDealer();
        hasDuplicateNames();
    }

    private void hasDuplicateNames() {
        for (String name : nameList) {
           if (this.newNameList.contains(name)) {
                throw new IllegalArgumentException("이름 중복");
            }
            newNameList.add(name);
        }
    }

    private void IsNameEqualsDealer() {
        for (String name : nameList) {
            if (name.equals("딜러")) {
                throw new IllegalArgumentException("딜러 이름 사용 불가");
            }
        }
    }

    private void IsNameEmpty() {
        for (String name : nameList) {
            if (name.isEmpty() || name.isBlank()) {
                throw new IllegalArgumentException("이름 빈칸 불가");
            }
        }
    }

    public List<String> getNewNameList() {
        return this.newNameList;
    }

}
