/*
  @author �r�c���
  @date 2017/02/01
*/

package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/* ���O�C�����K�v�ȓ���̃y�[�W�Ɉړ�����ۂ̃��O�C���`�F�b�N���s���t�B���^�[ */
/* �t�B���^�[�����삷��jsp:leave /mypage /userconfig /orderhistory /payinput */
public class LogInCheckFilter implements Filter {
	private FilterConfig config;
	
	/* ������ */
	public void init(FilterConfig config)throws ServletException {
		this.config = config;
	}
	/* ���ʂ�� */
	public void destroy() {}
	
	/* ���ۂɓ������ */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	throws ServletException, IOException {
		System.out.println("--LogInCheckFilter--");
		
		/* �Z�b�V�������烍�O�C�������擾 */
		HttpSession session = ((HttpServletRequest)req).getSession();
		String login = (String)session.getAttribute("login");
		System.out.println("login=" + login);
		
		/* �����O�C���E���O�C���Ɏ��s�����ꍇ�A
			�Z�b�V�����Ɉړ������o�^���ēx���O�C����ʂ֔�΂� */
		if(login == null || "".equals(login) || "NG".equals(login)) {
			RequestDispatcher dis = req.getRequestDispatcher("/filterlogin.jsp");
			session.setAttribute
				("target", (((HttpServletRequest)req).getServletPath()));
			System.out.println("target="+session.getAttribute("target"));
			dis.forward(req, res);
		/* ���O�C���ς̏ꍇ�A���̈ړ���֔�΂� */
		}else {
			chain.doFilter(req, res);
		}
	}
}