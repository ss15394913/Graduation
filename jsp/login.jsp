<%@page pageEncoding="UTF-8"
 contentType="text/html;charset=UTF-8"%>

 <html>
     <head>
         <meta http-equiv="content-type" content="text/html; charset=utf-8">
         <title>ログイン</title>
     </head>
     <body>
     	<center><img src="${pageContext.request.contextPath}/images/login.png" alt="Login"></center>
         <div align="center">
             <table border="0">
                 <form action="front/logincomp" method="get">
                     <tr>
                         <th>
                             Email
                         </th>
                         <td>
                             <input type="text" name="user_id" value="" size="24">
                         </td>
                     </tr>
                      <tr>
                          <th>
                              Password
                          </th>
                          <td>
                              <input type="password" name="password" value="" size="24">
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
