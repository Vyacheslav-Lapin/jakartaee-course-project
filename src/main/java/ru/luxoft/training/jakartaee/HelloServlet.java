package ru.luxoft.training.jakartaee;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
@WebServlet("/hello")
@RequiredArgsConstructor//(staticName = "from")
public final class HelloServlet extends HttpServlet {

  @Override
  @SneakyThrows
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    resp.setContentType("application/json");
    @Cleanup val writer = resp.getWriter();

    writer.println("{ \"hello\": \"world!\" }");
  }
}
