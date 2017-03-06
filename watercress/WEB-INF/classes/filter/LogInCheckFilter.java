/*
  @author 池田千鶴
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/* ログインが必要な特定のページに移動する際のログインチェックを行うフィルター */
/* フィルターが動作するjsp:leave /mypage /userconfig /orderhistory /payinput */
public class LogInCheckFilter implements Filter {
	private FilterConfig config;

	/* 初期化 */
	public void init(FilterConfig config)throws ServletException {
		this.config = config;
	}
	/* 死ぬやつ */
	public void destroy() {}

	/* 実際に動くやつ */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	throws ServletException, IOException {

		/* セッションからログイン情報を取得 */
		HttpSession session = ((HttpServletRequest)req).getSession();
		String login = (String)session.getAttribute("login");

		/* 未ログイン・ログインに失敗した場合、
			セッションに移動先情報を登録し再度ログイン画面へ飛ばす */
		if(login == null || "".equals(login)) {
			RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/jsp/filterlogin.jsp");

			/* ある時点でのログインフィルターで、一回以上ログインに失敗した場合
				PathInfoがnullになるのでそれを回避する(nullでない時のみターゲット登録) */
			if(!((((HttpServletRequest)req).getPathInfo()) == null)) {
				session.setAttribute
					("target", (((HttpServletRequest)req).getPathInfo()));
			}
			dis.forward(req, res);
		/* ログイン済の場合、元の移動先へ飛ばす */
		}else {
			chain.doFilter(req, res);
		}
	}
}