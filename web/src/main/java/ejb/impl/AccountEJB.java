package ejb.impl;

import ejb.Account;
import ejb.InsufficientFundsException;
import javax.ejb.Stateful;
import lombok.Getter;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Stateful
public class AccountEJB implements Account {

  @NonFinal
  long money;

  @Override
  public void deposit(long amount) {
    money += amount;
    log.info("Money deposited. Total is $ {}", money);
  }

  @Override
  public void withdraw(long amount) throws InsufficientFundsException {
    long newAmount = money - amount;
    if (newAmount < 0) {
      throw new InsufficientFundsException("Insufficient money!");
    }
    money = newAmount;
    log.info("Money withdrawal. total is {}", money);
  }
}
