package com.qcj.servlet;

import com.qcj.dao.UserDao;
import com.qcj.dao.impl.UserDaoImpl;
import com.qcj.entity.Users;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    UserDao userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取参数
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        Users users = new Users(username,pwd);
        List<Users> list = userDao.loginUser(users);
        System.out.println(list.size());
        if (list.size() > 0){
            /*request.setAttribute("name",username);//这个只能在一次请求
            ServletContext application = getServletContext();
            application.setAttribute("user2",username);//整个应用程序都有用,但姓名会混乱
            //创建cookie
            Cookie cookie = new Cookie("user3",username);//cookie会话方式
            cookie.setMaxAge(30);//手动设置有效时长，默认是秒。关闭浏览器也没用
            //响应cookie到浏览器
            response.addCookie(cookie);
            //获取所有cookie
            Cookie[] cookies = request.getCookies();
            for (Cookie c: cookies) {
                if("user3".equals(c.getName())){
                    System.out.println(c.getValue());//得到值
                }
            }
            //session创建:第一次是创建，之后是获取
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60);//手动设置时长（秒）
            session.invalidate();//让session立即失效
            session.setAttribute("user4",username);
*/
            request.getRequestDispatcher("jstl.jsp").forward(request,response);
        }else {
            response.sendRedirect("fail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
