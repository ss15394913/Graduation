package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import command.AbstractCommand;
import ex.LogicException;
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
	= "c:/watercress/WEB-INF/data/properties/AbstractCommands.properties";

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

			System.out.println("a'");

			String className = properties.getProperty(requestContext.getCommandPath());

			System.out.println(className);

			Class c = Class.forName(className);
			System.out.println("a");

			command = (AbstractCommand) c.newInstance();
			System.out.println("b");
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

	/**
	 *@see CommandFactory#getCommand
	 *@param key 特定のコマンドに対応するキー値
	 *@return 引数で指定したキー値に対応した、
	 *        AbstractCommandのサブクラスのインスタンス
	 *@exception LogicException ビジネスロジックレイヤで発生した例外のラッパー
	 */
	public static AbstractCommand getCommand(String key) throws LogicException {
		AbstractCommand command = null;
		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream(FILE_PATH));

			String className = properties.getProperty(key);

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