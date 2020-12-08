package com.luxoft.ejb.bankapp;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.NonFinal;
import lombok.val;
import ejb.Account;

//@Slf4j
@WebServlet("/hello")
//@RequiredArgsConstructor//(staticName = "from")
public final class HelloServlet extends HttpServlet {

  @NonFinal
//  @Resource(lookup = "ejb:/web-0.0.1-SNAPSHOT/AccountEJB!ejb.Account?stateful")
  @Resource(lookup = "java:global/web-0.0.1-SNAPSHOT/AccountEJB!ejb.Account")
  Account account;

  @Override
  @SneakyThrows
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    resp.setContentType("application/json");
    @Cleanup val writer = resp.getWriter();

    writer.println("{ \"hello\": \"world!\",");
    writer.printf("\"yourMoneyIs\": %d }%n", account.getMoney());
  }
}
