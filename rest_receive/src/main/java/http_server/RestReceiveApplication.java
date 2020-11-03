package http_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.google.gson.Gson;

import gson.Func;
import gson.NFInstances;
import gson.NFProfile;


//・GETされると、JSON文字列を返す
//・JSONをPOSTされると、JSONを解析して結果を返す
//HTTPサーバー
public class RestReceiveApplication {
    public static void main(String[] args) {
        final int PORT = 8080;
        final Class<? extends Servlet> servlet = ExampleServlet.class;
        ServletContextHandler servletHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletHandler.addServlet(new ServletHolder(servlet), "/api");

        final Server jettyServer = new Server(PORT);
        jettyServer.setHandler(servletHandler);
        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("serial")
    public static class ExampleServlet extends HttpServlet {

        private final Gson mGson = new Gson();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            NFProfile nfprofile = new NFProfile();
            nfprofile.nfinstances = new NFInstances();
            nfprofile.nfinstances.nfInstanceID = "0000-1111-2222-3333";
            nfprofile.nfinstances.nfType = "PCF";
            nfprofile.nfinstances.nfStatus = "REGISTERWD";
            nfprofile.nfinstances.func = new ArrayList<Func>();
            Func func1 = new Func();
            func1.type = "pcf-nrf";
            func1.name = "test1";
            nfprofile.nfinstances.func.add(func1);
            Func func2 = new Func();
            func2.type = "pcf-smp";
            func2.name = "test2";
            nfprofile.nfinstances.func.add(func2);

            String json = mGson.toJson(nfprofile);

            resp.setContentType("text/html; charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            final PrintWriter out = resp.getWriter();
            out.println(json);
            out.close();

        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            final StringBuilder sb = new StringBuilder();

            String line = null;
            try {
                BufferedReader reader = req.getReader();
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (Exception e) {
            }

            final String body = sb.toString();
            final NFProfile nfprofile = mGson.fromJson(body, NFProfile.class);

            resp.setContentType("text/html; charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            final PrintWriter out = resp.getWriter();
            out.println("Server Generated Message");
            out.println("nfInstanceID: " + nfprofile.nfinstances.nfInstanceID);
            out.close();

        }

    }

}
