package ejb;

public interface Account {

  long getMoney();
  void deposit(long amount);
  void withdraw(long amount) throws InsufficientFundsException;
}
