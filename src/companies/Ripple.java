package companies;

import java.math.BigDecimal;

public class Ripple {
    // https://en.wikipedia.org/wiki/Money_multiplier

    public static void main(String args[]) {
        Bank bank = new Bank();
        bank.makeDeposit(new BigDecimal(100));
        System.out.println("Amount Deposited= " + bank.getDepositedAmount());
        System.out.println("Amount lended= " + bank.getLentAmount());
        System.out.println("Amount in reserve= " + bank.getTotalReserveAmount());
    }

    static class Bank {

        private BigDecimal depositedAmout;
        private BigDecimal lentAmount;

        public BigDecimal getTotalReserveAmount() {
            return totalReserveAmount;
        }

        public void setTotalReserveAmount(BigDecimal totalReserveAmount) {
            this.totalReserveAmount = totalReserveAmount;
        }

        private BigDecimal totalReserveAmount;
        private BigDecimal reserveAmount;

        public Bank() {
            depositedAmout = new BigDecimal(0);
            lentAmount = new BigDecimal(0);
            reserveAmount = new BigDecimal(0);
            totalReserveAmount = new BigDecimal(0);


        }

        public BigDecimal getDepositedAmount() {
            return depositedAmout;
        }
// public void setDepositedAmount(){
//   this.depositedAmout=depositedAmout;
// }

        public BigDecimal getLentAmount() {
            return lentAmount;
        }

        // public void setLentAmount(){
//   this.lentAmount=lentAmount;
// }
        public BigDecimal getReserveAmount() {
            return reserveAmount;
        }
// public void setReserveAmount(){
//   this.reserveAmount=reserveAmount;
// }

        public void makeDeposit(BigDecimal amount) {
            System.out.println("Amount in makeDeposit= " + amount);
            if (amount == null || amount.intValue() < 0) {
                throw new RuntimeException("invalid amount");
            }
            depositedAmout = depositedAmout.add(amount);
            totalReserveAmount = totalReserveAmount.add(amount);
            lendMoney(amount);
        }

        public void lendMoney(BigDecimal amount) {
            if (amount == null || amount.intValue() < 0) {
                throw new RuntimeException("invalid amount");
            }
            BigDecimal lendableAmount = amount.multiply(new BigDecimal("0.8"));
            BigDecimal substractableAmount = amount.multiply(new BigDecimal("0.2"));
            System.out.println("Amount lendableAmount= " + lendableAmount);
            if (lendableAmount.intValue() > 10) {
                lentAmount = lentAmount.add(lendableAmount);
                totalReserveAmount = totalReserveAmount.subtract(lendableAmount);
                System.out.println("reserveAmount=" + substractableAmount);// reserveAmount.subtract(substractableAmount));
                makeDeposit(lendableAmount);//80
            } else {
                System.out.println("amount is non lendable");
            }

        }
//journal

    }


}
