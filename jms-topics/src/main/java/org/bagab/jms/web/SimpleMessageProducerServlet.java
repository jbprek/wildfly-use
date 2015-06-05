package org.bagab.jms.web;

import org.bagab.jms.mdb.p2p.simple.SimpleMessageProducer;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author prekezes.
 */
@WebServlet("/simpleQueue")
public class SimpleMessageProducerServlet extends HttpServlet {

    @EJB
    private SimpleMessageProducer messageProducerBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (int i = 0; i < 5; i++) {
            messageProducerBean.sendMessage("Hello "+i);
        }
    }
}
