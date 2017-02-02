package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import ex.LogicException;
import command.AbstractCommand;
/**
 *@className CommandFactory
 *@author Fumihiro Miyazaki
 *@date 2017/01/25
 *@description AbstractCommand�̃T�u�N���X�̃t�@�N�g�����\�b�h
 */
public abstract class CommandFactory {
	// todo �v���p�e�B�t�@�C���ւ̃p�X��^�ʖڂɍl����
	/** @value FILE_PATH �v���p�e�B�t�@�C���ւ̑��΃p�X */
	private static final String FILE_PATH
	= "c:/j2ee4/AbstractCommands.properties";

	/**
	 *@see CommandFactory#getCommand
	 *@param requestContext �R�}���h�ɑΉ�����URL���擾���邽�߂̃C���X�^���X
	 *@return �����Ŏw�肵���L�[�l�ɑΉ������A
	 *        AbstractCommand�̃T�u�N���X�̃C���X�^���X
	 *@exception LogicException �r�W�l�X���W�b�N���C���Ŕ���������O�̃��b�p�[
	 */
	public static AbstractCommand getCommand(RequestContext requestContext)
	throws LogicException {
		AbstractCommand command = null;
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream(FILE_PATH));
			
			String className = properties.getProperty(requestContext.getCommandPath());
			
			Class c = Class.forName(className);
			
			command = (AbstractCommand) c.newInstance();
		}catch(FileNotFoundException e) {
			throw new LogicException(e.getMessage(), e);
		}catch(IOException e) {
			throw new LogicException(e.getMessage(), e);
		}catch(ClassNotFoundException e) {
			throw new LogicException(e.getMessage(), e);
		}catch(InstantiationException e) {
			throw new LogicException(e.getMessage(), e);
		}catch(IllegalAccessException e) {
			throw new LogicException(e.getMessage(), e);
		}catch(Exception e) {
			throw new LogicException(e.getMessage(), e);
		}
		return command;
	}
}