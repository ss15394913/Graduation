package command;

import java.util.List;
import java.util.Iterator;

import java.io.IOException;
import javax.servlet.http.HttpSession;

import bean.ProductCatalogBean;
import bean.SubCategoryBean;
import dao.ProductCatalogDao;
import dao.OraProductCatalogDao;
import dao.SubCategoryDao;
import dao.AbstractDaoFactory;

import logic.ResponseContext;
import logic.RequestContext;
import logic.WebRequestContext;
import ex.IntegrationException;
import ex.LogicException;

/**
 *@className ShowProductsListCommand
 *@author �͖�
 *@date 2017/01/31 �y�[�W�ԍ����Z�b�V�����ŊǗ�����C�������܂����B
 *@description 
 */

public class ShowProductsListCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext responseContext) throws LogicException{
		
		/*RequestContext�̃C���X�^���X���擾*/
		RequestContext requestContext = new WebRequestContext();
		
		/*�y�[�W�̔ԍ�*/
		int pageNum = Integer.parseInt(requestContext.getParameter("pageNumber")[0]);
		
		/*�I�����ꂽ�T�u�J�e�S��*/
		String selectedSubCategory = requestContext.getParameter("subCategory")[0];
		
		int selectedSubCategoryId = 0;
		
		/*�\�[�g�p�̕ϐ�
		  priceAsc = �l�i�̈�����
		  priceDesc = �l�i�̍�����
		  purchaseAsc = �w���������Ȃ���
		  purchaseDesc = �w������������
		  nameAsc =50����
		  nameDesc =50�����̋t�� 
		*/
		String[] sortParam = requestContext.getParameter("sort");
		
		/*getProductCatalogs�ɓn������*/
		int[] sortArray = new int[3];
		
		/*�S�T�u�J�e�S���̏��̃��X�g*/
		List allSubCategoryList = null; 
		
		/*�S���i�̏��̃��X�g*/
		List allCatalogList = null; 
		
		/*�N���C�A���g�ɕԂ����i���*/
		List returnProductsList = null;
		
		for(int i = 0;i<=sortParam.length;i++){
			
			/*sortParam�̒��g�ɑΉ�����������ɂ��\�[�g����*/
			if(sortParam[i].equals("priceAsc")){
				sortArray[0] = ProductCatalogDao.SORT_BY_PRICE_ASC;
			}
			else if(sortParam[i].equals("priceDesc")){
				sortArray[0] = ProductCatalogDao.SORT_BY_PRICE_DESC;
			}
			else if(sortParam[i].equals("purchaseAsc")){
				sortArray[1] = ProductCatalogDao.SORT_BY_PURCHASE_COUNT_ASC;
			}
			else if(sortParam[i].equals("purchaseDesc")){
				sortArray[1] = ProductCatalogDao.SORT_BY_PURCHASE_COUNT_DESC;
			}
			else if(sortParam[i].equals("nameAsc")){
				sortArray[2] = ProductCatalogDao.SORT_BY_NAME_ASC;
			}
			else if(sortParam[i].equals("nameDesc")){
				sortArray[2] = ProductCatalogDao.SORT_BY_NAME_DESC;
			}
		}
		try{
			
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			
			/*Dao����T�u�J�e�S���̏����擾����*/
			SubCategoryDao subCategoryDao = factory.getSubCategoryDao();
			allSubCategoryList = subCategoryDao.getSubCategories();
			
			Iterator SubCategoryIterator = allSubCategoryList.iterator();
			while(SubCategoryIterator.hasNext()){
				/*�T�u�J�e�S����Bean���擾*/
				SubCategoryBean subCategory
				= (SubCategoryBean)SubCategoryIterator.next();
				/*Bean�̒��̃T�u�J�e�S���̖��O�ƁA�N���C�A���g���I������
				  �T�u�J�e�S���̖��O�������Ȃ�A���̃T�u�J�e�S����ID��
				  �ϐ��Ɋi�[����*/
				if(subCategory.getSubCategoryName()
					.equals(selectedSubCategory)){
						selectedSubCategoryId
						= subCategory.getSubCategoryId();
					break;
				}
			}
			
			/*Dao���珤�i�̏����擾����*/
			ProductCatalogDao pcd = factory.getProductCatalogDao();
			
			/*�S���i�̏��*/
			/*�ǂ̂悤�Ƀ\�[�g�����邩�����肳����*/
				allCatalogList = pcd.getProductCatalogs(sortArray);
			
			/*�S���i�̏��i����*/
			for(int i=0; i <= allCatalogList.size();){
				/*15���i��*/
				if((pageNum - 1) * 15 <= i && i <= pageNum * 15 - 1){
					/*List���̏��i����Bean�����o��*/
					ProductCatalogBean product
					= (ProductCatalogBean)allCatalogList.get(i);
					/*�I�����ꂽ�T�u�J�e�S���̏��i�Ȃ�A
					  �N���C�A���g�ɕԂ����i���ɉ�����*/
					if(product.getSubCategoryId()== selectedSubCategoryId){
						returnProductsList.add(allCatalogList.get(i));
						i++;
					}
				}
			}
			
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		
		/*�Z�b�V�����X�R�[�v�ɃC���X�^���X��ۑ�*/
		requestContext.setSessionAttribute("pageNum",pageNum);
		
		/*response�ő���l���Z�b�g*/
		responseContext.setResult(returnProductsList);
		
		/*�]����̃r���[���w��*/
		responseContext.setTarget("productlist");
		
		/*return�Ō��ʂ�Ԃ�*/
		return responseContext;
	}
}