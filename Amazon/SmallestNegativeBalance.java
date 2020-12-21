import java.util.*;

public class SmallestNegativeBalance {
    public List<String> findMinDebts(DebtRecord[] records) {
         Map<String,Integer> debts=new HashMap<>();
        for(var record:records) {
            var borrower=record.borrower;
            var lender=record.lender;
            var amount=record.amount;
            debts.put(borrower, debts.getOrDefault(borrower,0)-amount);
            debts.put(lender, debts.getOrDefault(lender,0)+amount);
        }
        var dest=new ArrayList<String>();
        var minDebt=Integer.MIN_VALUE;
        for(var entry:debts.entrySet()) {
            if (entry.getValue()>=0||entry.getValue()<minDebt) continue;
            if(entry.getValue()>minDebt) {
                minDebt=entry.getValue();
                dest.clear();
            }
            dest.add(entry.getKey());
        }
        return dest;
    }
}
