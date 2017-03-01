<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <html>
     <head>
         <meta http-equiv="content-type" content="text/html; charset=utf-8">
         <title>ログイン</title>
     </head>
     <body>
     	<center><img src="${pageContext.request.contextPath}/images/login.png" alt="Login"></center>
         <div align="center">
         
             <table border="0">
                 <form action="${pageContext.request.contextPath}/front/logincomp" method="post">
                     <tr>
                         <th>
                             Email
                         </th>
                         <td>
                             <input type="email" name="email" size="24" required>
                         </td>
                     </tr>
                      <tr>
                          <th>
                              Password
                          </th>
                          <td>
                              <input type="password" name="pass" size="24" required>
                              <br>
                          </td>
                      </tr>
                      <tr>
                          <td colspan="2">
                          <br>
                              <center><input type="submit" value="GO"></center>
                          </td>
                      </tr>
                  </form>
              </table>
          </div>
          <center><p id="pagetop"><a href="${pageContext.request.contextPath}/front/top">PAGE TOP</a></p></center>
          <center><a href="${pageContext.request.contextPath}/front/userentry"><img src="${pageContext.request.contextPath}/images/new_member.png" width="240" height="80"alt="New Menber Resist"></a></center>
      </body>
  </html>
