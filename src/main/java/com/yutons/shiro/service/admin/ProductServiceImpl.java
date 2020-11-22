package com.yutons.shiro.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.Product;
import com.yutons.shiro.dao.admin.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Resource
    private ProductDao productDao;
    
    @Override
	public Product findByProductId(Integer pid) {
		return productDao.findByProductId(pid);
	}
	@Override
	public List<Product> selectProductByTypeId(Integer productTypeID) {
		Product product = new Product();
		product.setProductTypeID(productTypeID);
		return productDao.selectProductByCondition(product);
	}
	@Override
	public List<Product> selectProductById(Integer pid) {
		Product product = new Product();
		product.setPid(pid);
		return productDao.selectProductByCondition(product);
	}
	@Override
	public List<Product> selectProductByName(String productName) {
		Product product = new Product();
		product.setProductName(productName);
		return productDao.selectProductByCondition(product);
	}
	@Override
	public List<Product> selectProducts() {
		return productDao.selectProductByCondition(new Product());
	}
	@Override
	public ModulePage<Product> selectProductsByPage() {
		List<Product> data = productDao.selectProductByCondition(new Product());
		ModulePage<Product> productPage = new ModulePage<>();
		if (data != null) {
			productPage.setCount(data.size());
		}
		productPage.setData(data);
        return productPage;
	}
	@Override
	public Integer addProduct(Product product) {
		return productDao.insert(product);
	}
	@Override
	public Integer updateProduct(Product product) {
		return productDao.update(product);
	}
	@Override
	public Integer deleteProductById(Product product) {
		return productDao.deleteProductById(product);
	}
}
