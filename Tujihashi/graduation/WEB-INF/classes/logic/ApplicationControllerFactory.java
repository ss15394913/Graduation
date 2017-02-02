package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import ex.LogicException;

/**
 *@className ApplicationControllerFactory
 *@author Fumihiro Miyazaki
 *@date 2017/01/25
 *@description ApplicationController�T�u�N���X�̃t�@�N�g���N���X
 */
public abstract class ApplicationControllerFactory {
	
	// todo �v���p�e�B�t�@�C���ւ̃p�X��^�ʖڂɍl����
	/** @value FILE_PATH �v���p�e�B�t�@�C���ւ̑��΃p�X */
	private static final String FILE_PATH
	= "c:/j2ee4/ApplicationControllers.properties";
	
	/**
	 *@see ApplicationControllerFactory#getController
	 *@param key �����ApplicationController�̃T�u�N���X�ɑΉ������L�[�l
	 *@return �����Ŏw�肵���L�[�l�ɑΉ������A
	 *        ApplicationController�̃T�u�N���X�̃C���X�^���X
	 *@exception LogicException �r�W�l�X���W�b�N���C���Ŕ���������O�̃��b�p�[
	 */
	public static ApplicationController getController(String key)
	throws LogicException {
		ApplicationController controller = null;
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream(FILE_PATH));
			
			String className = properties.getProperty(key);
			
			Class c = Class.forName(className);
			
			controller = (ApplicationController) c.newInstance();
		// ��O�͂��ׂă��b�v���ď�ʃN���X�ɑ��o
		}catch (FileNotFoundException e) {
			throw new LogicException(e.getMessage(), e);
		}catch (IOException e) {
			throw new LogicException(e.getMessage(), e);
		}catch (ClassNotFoundException e) {
			throw new LogicException(e.getMessage(), e);
		}catch (InstantiationException e) {
			throw new LogicException(e.getMessage(), e);
		}catch (IllegalAccessException e) {
			throw new LogicException(e.getMessage(), e);
		}catch (Exception e) {
			throw new LogicException(e.getMessage(), e);
		}
		return controller;
	}
}