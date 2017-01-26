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
 *@description AbstractCommandのサブクラスのファクトリメソッド
 */
public abstract class CommandFactory {
	// todo プロパティファイルへのパスを真面目に考える
	/** @value FILE_PATH プロパティファイルへの相対パス */
	private static final String FILE_PATH
	= "c:/j2ee4/AbstractCommands.properties";

	/**
	 *@see CommandFactory#getCommand
	 *@param requestContext コマンドに対応したURLを取得するためのインスタンス
	 *@return 引数で指定したキー値に対応した、
	 *        AbstractCommandのサブクラスのインスタンス
	 *@exception LogicException ビジネスロジックレイヤで発生した例外のラッパー
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