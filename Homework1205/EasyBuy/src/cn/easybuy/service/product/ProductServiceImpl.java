package cn.easybuy.service.product;
import java.sql.Connection;
import java.util.List;

import cn.easybuy.dao.MyBatisUtil;
import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.dao.product.ProductDaoImpl;
import cn.easybuy.dao.product.ProductMapper;
import cn.easybuy.utils.DataSourceUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import cn.easybuy.entity.Product;
/**
 * 商品的业务类
 */
public class ProductServiceImpl implements ProductService {

	private Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Override
	public boolean add(Product product) {
		SqlSession session = null;
		Integer count=0;
		try {
			session = MyBatisUtil.createSession();
			count =  session.getMapper(ProductMapper.class).add(product);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
			return count>0;
		}
//		Connection connection = null;
//		Integer count=0;
//		try {
//			connection = DataSourceUtil.openConnection();
//			ProductDao productDao = new ProductDaoImpl(connection);
//			count=productDao.add(product);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//			return count>0;
//		}
	}

	@Override
	public boolean update(Product product) {
		SqlSession  session = null;
		Integer count=0;
		try {
			session = MyBatisUtil.createSession();
			count = session.getMapper(ProductMapper.class).update(product);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
			return count>0;
		}
//		Connection connection = null;
//		Integer count=0;
//		try {
//			connection = DataSourceUtil.openConnection();
//			ProductDao productDao = new ProductDaoImpl(connection);
//			count=productDao.update(product);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//			return count>0;
//		}
	}

	@Override
	public boolean deleteProductById(Integer productId) {
		SqlSession  session = null;
		Integer count=0;
		try {
			session = MyBatisUtil.createSession();
			count = session.getMapper(ProductMapper.class).deleteProductById(productId);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
			return count>0;
		}
//		Connection connection = null;
//		Integer count=0;
//		try {
//			connection = DataSourceUtil.openConnection();
//			ProductDao productDao = new ProductDaoImpl(connection);
//			count=productDao.deleteProductById(productId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//			return count>0;
//		}
	}

	@Override
	public Product getProductById(Integer productId) {
		SqlSession  session = null;
		Product product=null;
		try {
			session = MyBatisUtil.createSession();
			product = session.getMapper(ProductMapper.class).getProductById(productId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
			return product;
		}
//		Connection connection = null;
//		Product product=null;
//		try {
//			connection = DataSourceUtil.openConnection();
//			ProductDao productDao = new ProductDaoImpl(connection);
//			product=productDao.getProductById(productId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//			return product;
//		}
	}

	@Override
	public List<Product> getProductList(Integer currentPageNo,Integer pageSize,String proName, Integer categoryId, Integer level) {
		SqlSession  session = null;
		List<Product> productList=null;
		try {
			session = MyBatisUtil.createSession();
			productList = session.getMapper(ProductMapper.class).getProductList(currentPageNo,pageSize,proName,categoryId,level);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
			return productList;
		}
//		Connection connection = null;
//		List<Product> productList=null;
//		try {
//			connection = DataSourceUtil.openConnection();
//			ProductDao productDao = new ProductDaoImpl(connection);
//			productList=productDao.getProductList(currentPageNo,pageSize,proName,categoryId,level);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//			return productList;
//		}
	}

	@Override
	public int count(String proName,Integer categoryId, Integer level) {
		SqlSession  session = null;
		Integer count=0;
		try {
			session = MyBatisUtil.createSession();
			count = session.getMapper(ProductMapper.class).queryProductCount(proName,categoryId,level);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
			return count;
		}
		}
//		Connection connection = null;
//		Integer count=0;
//		try {
//			connection = DataSourceUtil.openConnection();
//			ProductDao productDao = new ProductDaoImpl(connection);
//			count=productDao.queryProductCount(proName,categoryId,level);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//			return count;
//		}


	@Override
	public boolean updateStock(Integer productId, Integer stock) {
		SqlSession  session = null;
		Integer count=0;
		try {
			session = MyBatisUtil.createSession();
			count = session.getMapper(ProductMapper.class).updateStock(productId,stock);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
			return count>0;
		}

//		Connection connection = null;
//		Integer count=0;
//		try {
//			connection = DataSourceUtil.openConnection();
//			ProductDao productDao = new ProductDaoImpl(connection);
//			count=productDao.updateStock(productId,stock);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//			return count>0;
//		}
	}

}
