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
 *@description ApplicationControllerサブクラスのファクトリクラス
 */
public abstract class ApplicationControllerFactory {
	
	// todo プロパティファイルへのパスを真面目に考える
	/** @value FILE_PATH プロパティファイルへの相対パス */
	private static final String FILE_PATH
	= "c:/j2ee4/ApplicationControllers.properties";
	
	/**
	 *@see ApplicationControllerFactory#getController
	 *@param key 特定のApplicationControllerのサブクラスに対応したキー値
	 *@return 引数で指定したキー値に対応した、
	 *        ApplicationControllerのサブクラスのインスタンス
	 *@exception LogicException ビジネスロジックレイヤで発生した例外のラッパー
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
		// 例外はすべてラップして上位クラスに送出
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