package command;

import ex.LogicException;
import ex.IntegrationException;

import logic.RequestContext;
import logic.WebRequestContext;
import logic.ResponseContext;

import javax.servlet.http.HttpSession;

/**
 *@className CartProductCommand
 *@author ���V
 *@date 2017/01/31
 *@description 
 */
public class CartProductCommand extends AbstractCommand{
	
	public CartProductCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		
		RequestContext req = new WebRequestContext();
		
		HttpSession session = (HttpSession)req.getSession();
		
		/*���͂��ꂽ�p�����[�^���󂯎��*/
		String[] name = req.getParameter("name");
		
		/*�Z�b�V�����X�R�[�v�ɈႤ�C���X�^���X��ۑ����邽�߂̕ϐ�*/
		int maxNum; 
		
		/*����̃��N�G�X�g����maxNum�̒l��Null�����肷��*/
		/*Null�łȂ��ꍇ��maxNum�ɂ��̒l������*/
		if(session.getAttribute("maxNum") != null){
			maxNum = (int)session.getAttribute("maxNum");
		}else{
			maxNum = 0;
		}
		
		/*�Z�b�V�����X�R�[�v�ɓ��͂��ꂽ�p�����[�^���������C���X�^���X��ۑ�*/
		session.setAttribute("result" + maxNum, name);
			/*�Z�b�V�����X�R�[�v��+1����maxNum��ۑ�*/
		session.setAttribute("maxNum", maxNum + 1);
		
		responseContext.setTarget("cart");
		System.out.println("�Ō��");
		return responseContext;
	}
}