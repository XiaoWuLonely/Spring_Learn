package cs01;

// 收入交税
class Income {
    protected double income;
    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1; //税:0.1
    }
}

// 工资多出交税
class Salary extends Income {
    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income < 5000) {
            return 0;
        } else {
            return (income - 5000) * 0.2;
        }
    }
}

// 特殊待遇
class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}

public class java015Duotai {
    // 将所有的税整合起来
    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }

    public static void main(String[] args) {
        Income[] incomes = new Income[]{
                new Income(3000),
                new Salary(6000),
                new StateCouncilSpecialAllowance(15000),
        };
        System.out.println(totalTax(incomes));
    }
}
