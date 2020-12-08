package org.bw.newssystem.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


//用来读取数据库的配置文件
//注意：读取文件只需一次就够了

public class DBConfigure {
	
	private final static String dbResource = "database.properties";
	//专门有盛放properties文件属性及值的集合
	private static Properties dbProperties = new Properties();

	static {
		//当前类加载到内存，并且获得当前类的类对象及类加载器
		//并且获得资源文件的字节流
		InputStream resStream = DBConfigure.class.getClassLoader().getResourceAsStream(dbResource);
		//把项目里的database.properties文件数据直接加载到Properties集合中
		
		try {
			
			dbProperties.load(resStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//读取database.properties的每一个属性和方法
	//@param propertyKey,代表了database.properties的键
	//@return 代表了根据参数传过来的键，获得相应的database.class
	
		public static String  getProperty(String propertyKey) {
			return dbProperties.getProperty(propertyKey);
		}
}
