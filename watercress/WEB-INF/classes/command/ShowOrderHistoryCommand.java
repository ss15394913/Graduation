package command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bean.ProductBean;
import bean.ProductImageBean;
import bean.PurchaseHistoryBean;
import dao.AbstractDaoFactory;
import dao.ProductDao;
import dao.ProductImageDao;
import dao.PurchaseHistoryDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className ShowOrderHistoryCommand
 *@author �͖�
 *@date 2017/02/08
 *@description �w��������\��
 */

public class ShowOrderHistoryCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext responseContext)
			throws LogicException{
		/*RequestContext�̃C���X�^���X���擾*/
		RequestContext requestContext = getRequestContext();

		/*getParameter�Ńy�[�W�ԍ����擾*/
		Integer pageNum = 1;
		String[] pageParam = requestContext.getParameter("pageNum");
		if(pageParam != null){
			pageNum = Integer.parseInt(pageParam[0]);
		}
		/*memberId���󂯎��*/
		int memberId = Integer.parseInt(requestContext.getSessionAttribute("login").toString()) ;

		/*�y�[�W�J�E���g�p�̕ϐ�*/
		int i=0;

		/*Product�\�̃��X�g��S���擾�̂��߂̃��X�g*/
		List<ProductBean> allProducts = new ArrayList<ProductBean>();

		/*�w�����X�g��S���擾�̂��߂̃��X�g*/
		List<PurchaseHistoryBean> allPurchaseProducts
		= new ArrayList<PurchaseHistoryBean>();

		/*ProductImage���X�g��S���擾�̂��߂̃��X�g*/
		List<ProductImageBean> allProductsImage
		= new ArrayList<ProductImageBean>();

		ProductImageBean productsImageBean =null;

		ProductBean productBean = null;

		/*List�P���*/
		List purchaseHistories1 = new ArrayList();

		/*List�Q���*/
		List purchaseHistories2 = new ArrayList();

		/*�ŏI�I�ɕԂ�List�̓�����List*/
		List purchaseProductsInfo = new ArrayList();

		/*�L�[�ɓ��t�A�l�ɂ��̓��ɍw���������i�̃��X�g������Map*/
		Map purchaseMap = new HashMap();

		try{
			/*AbstractDaoFactory�̃C���X�^���X���擾*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();

			/*ProductDao�̃C���X�^���X���擾*/
			ProductDao productDao = factory.getProductDao();

			/*PurchaseHistoryDao�̃C���X�^���X���擾*/
			PurchaseHistoryDao purchaseHistoryDao
			= factory.getPurchaseHistoryDao();

			/*ProductImageDao�̃C���X�^���X���擾*/
			ProductImageDao productImage = factory.getProductImageDao();

			/*Products���X�g��S���擾*/
			allProducts = productDao.getProducts();

			/*�w�����X�g��S���擾*/
			allPurchaseProducts = purchaseHistoryDao.getPurchaseHistories();

			/*ProductsImage���X�g��S���擾*/
			allProductsImage = productImage.getProductImages();


			Iterator allPurchaseIterator =  allPurchaseProducts.iterator();
			while(allPurchaseIterator.hasNext()){
				// purchaseHistoryBean�ɓ����
				PurchaseHistoryBean purchaseHistoryBean
				= (PurchaseHistoryBean)allPurchaseIterator.next();
				/*��r�p��PurchaseHistoryBean��ProductId���i�[*/
				String purchaseProductId = (String)purchaseHistoryBean.getProductId();

				/*�S���i���X�g�̃C�e���[�^*/
				Iterator allProductsIterator = allProducts.iterator();
				while(allProductsIterator.hasNext()){
					/*Product���X�g���ꌏ���i�[*/
					productBean = (ProductBean)allProductsIterator.next();
					/*��r�p��ProductBean��ProductId���i�[*/
					String productId = productBean.getProductId();
					if(purchaseProductId.equals(productId)){
						break;
					}
				}
				/*�S���i�摜���X�g�̃C�e���[�^*/
				Iterator productsImageIterator = allProductsImage.iterator();
				while(productsImageIterator.hasNext()){
					/*ProductImage���X�g���ꌏ���i�[*/
					productsImageBean
					= (ProductImageBean)productsImageIterator.next();
					/*��r�p��ProductIamgeBean��ProductId���i�[*/
					String productImageId = productsImageBean.getProductId();
					if(purchaseProductId.equals(productImageId)){
						break;
					}
				}

				if(memberId == purchaseHistoryBean.getMemberId()){
					//if((pageNum - 1) * 10 <= i && i < pageNum * 10){
					purchaseHistories1 = new ArrayList();

					/*���t�̏����ϊ�*/
					String[] pdate = purchaseHistoryBean.getPurchaseOrderDate().split("\\s");
					String d = pdate[0].replaceAll("-", "/");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			        Date date = sdf.parse(d);
			        d = sdf.format(date);
			        purchaseHistoryBean.setPurchaseOrderDate(d);

					purchaseHistories1.add(purchaseHistoryBean);
					purchaseHistories1.add(productBean);
					purchaseHistories1.add(productsImageBean);

					purchaseHistories2.add(purchaseHistories1);

					//i++;
					//}
				}
			}


			/*�w���������i��񕪃C�e���[�^�ŉ�*/
			Iterator purchase2Iterator = purchaseHistories2.iterator();
			while(purchase2Iterator.hasNext()){

				/*�w���������i���ꌏ�����X�g�Ɋi�[*/
				List purchase2Products = (ArrayList)purchase2Iterator.next();

				/*purchaseMap�̃L�[(���t)�ɊY�����鏤�i���Ȃ��ꍇ*/
				/*purchaseMap�̒l�ɂ��̓��t�̃��X�g���쐬���i�[*/
				if(!purchaseMap.containsKey(((PurchaseHistoryBean)(purchase2Products.get(0))).getPurchaseOrderDate())){
					/*�V���ȓ��t�p�̃��X�g���쐬*/
					List newPurchaseProducts = new ArrayList();
					/*�V���ȃ��X�g�ɍw���������i���i�[*/
					newPurchaseProducts.add(purchase2Products);
					/*purchaseMap�ɃL�[�����̓��t�A�l�ɂ��̐V���ȃ��X�g���i�[*/
					purchaseMap.put(((PurchaseHistoryBean)(purchase2Products.get(0))).getPurchaseOrderDate(),newPurchaseProducts);
				/*purchaseMap�̃L�[(���t)�ƍw���������t����v�����ꍇ�̏���*/
				}else{
					/*�w���������i�̓��t�Ɉ�v�������X�g���i�[*/
					List dateMatchProducts = (ArrayList)purchaseMap.get(((PurchaseHistoryBean)(purchase2Products.get(0))).getPurchaseOrderDate());
					/*���̃��X�g�ɍw���������X�g���i�[*/
					dateMatchProducts.add(purchase2Products);
				}
			}

		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}catch(ParseException e){
			throw new LogicException(e.getMessage(), e);
		}

			responseContext.setResult(purchaseMap);

		/*�Z�b�V�����X�R�[�v�ɃC���X�^���X��ۑ�*/
		requestContext.setSessionAttribute("pageNum",pageNum);

		/*�]����̃r���[���w��*/
		responseContext.setTarget("orderhistory");

		/*return�Ō��ʂ�Ԃ�*/
		return responseContext;
	}
}