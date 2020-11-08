package http_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class RestEchoSrv {

	public static void main(String[] args) {
		//開始メッセージ
		System.out.println("Now Working REST ECHO......");

		//HTTPサーバ設定
		//http://localhost:8080/api
		final int PORT = 8080;
		final Class<? extends Servlet> servlet = ExampleServlet.class;
		ServletContextHandler servletHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		servletHandler.addServlet(new ServletHolder(servlet), "/api");

		//JettyでWebサーバを走らせる
		final Server jettyServer = new Server(PORT);
		jettyServer.setHandler(servletHandler);
		try {
			jettyServer.start();
			jettyServer.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static class ExampleServlet extends HttpServlet {

		@Override
		//メソッドがGETのecho
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			//requestされたbody部の格納
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = req.getReader();
			try {
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line).append('\n');
				}
			} finally {
				reader.close();
				//response設定と表示内容
				resp.setContentType("text/html; charset=UTF-8");
				resp.setCharacterEncoding("UTF-8");
				final PrintWriter out = resp.getWriter();
				out.println(req);//リクエスト時のメソッドとアドレス
				out.println(sb);//リクエスト時のbody部
				out.close();
			}
		}

		@Override
		//メソッドがPostの時のecho
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			//requestされたbody部の格納
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = req.getReader();
			try {
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line).append('\n');
				}
			} finally {
				reader.close();
				//response設定と表示内容
				resp.setContentType("text/html; charset=UTF-8");
				resp.setCharacterEncoding("UTF-8");
				final PrintWriter out = resp.getWriter();
				out.println(req);//リクエスト時のメソッドとアドレス
				out.println(sb);//リクエスト時のbody部
				out.close();
			}
		}

		@Override
		//メソッドがPutの時のecho
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			//requestされたbody部の格納
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = req.getReader();
			try {
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line).append('\n');
				}
			} finally {
				reader.close();
				//response設定と表示内容
				resp.setContentType("text/html; charset=UTF-8");
				resp.setCharacterEncoding("UTF-8");
				final PrintWriter out = resp.getWriter();
				out.println(req);//リクエスト時のメソッドとアドレス
				out.println(sb);//リクエスト時のbody部
				out.close();
			}
		}

		@Override
		//メソッドがDeleteの時のecho
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			//requestされたbody部の格納
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = req.getReader();
			try {
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line).append('\n');
				}
			} finally {
				reader.close();
				//response設定と表示内容
				resp.setContentType("text/html; charset=UTF-8");
				resp.setCharacterEncoding("UTF-8");
				final PrintWriter out = resp.getWriter();
				out.println(req);//リクエスト時のメソッドとアドレス
				out.println(sb);//リクエスト時のbody部
				out.close();
			}
		}
	}
}
