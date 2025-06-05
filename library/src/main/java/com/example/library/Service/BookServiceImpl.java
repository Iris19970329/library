package com.example.library.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.Dao.BookDaoJDBC;
import com.example.library.Dao.BorrowingRecordDaoJDBC;
import com.example.library.Dao.UserDaoJDBC;
import com.example.library.Entity.Book;
import com.example.library.Entity.Borrowingrecord;
import com.example.library.Entity.MyException;
import com.example.library.Entity.RequestVO;
import com.example.library.Entity.ResponseVO;
import com.example.library.Entity.User;

@Service
public class BookServiceImpl implements IBookService {

	
	@Autowired
	BookDaoJDBC bookdaojdbc;
	
	@Autowired
	UserDaoJDBC userdaojdbc;
	
	@Autowired
	BorrowingRecordDaoJDBC borrowingrecorddao;
	
	@Override
	public List<Book> getAllBooks(){
		List<Book> allbook = bookdaojdbc.getAllBooks();
		return allbook;
	};
	
	@Override
	public List<Borrowingrecord> getBorrowRecord(String phonenumber){
		//取得用戶id
		User user = userdaojdbc.findUserByPhoneNumber(phonenumber);
		//取得借書紀錄
		System.out.println(user.getUserId());
		List<Borrowingrecord> borrowingrecord = borrowingrecorddao.getBorrowingRecords(user.getUserId());
		return borrowingrecord;
	};
	
	
	public void borrowBook(RequestVO requestVO) throws MyException{

		try {
			//先檢核useer有沒有存在資料庫,如果沒有的話拋錯誤訊息
			User user = userdaojdbc.findUserByPhoneNumber(requestVO.getUserphonenumber());
			if (user == null) {
				throw new MyException("0001","用戶不存在");
			}
			//確認該書屬於可借閱狀態, 並更新借閱狀態為不可借閱
			int updaterow = bookdaojdbc.updateBookStatus(requestVO.getiSBN(),0,1);
			if (updaterow != 1) {
				throw new MyException("0002","書本不可借閱");
			}
			
			//新增使用者借閱紀錄
			bookdaojdbc.insertBorrowingRecord(user,requestVO);
			
		}catch (MyException e ) {
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public void returnBook(RequestVO requestVO) throws MyException{		
		try {
			//先檢核useer有沒有存在資料庫,如果沒有的話拋錯誤訊息
			User user = userdaojdbc.findUserByPhoneNumber(requestVO.getUserphonenumber());
			if (user == null) {
				throw new MyException("0001","用戶不存在");
			}
			//更新書籍借閱狀態為可借閱
			int updaterow = bookdaojdbc.updateBookStatus(requestVO.getiSBN(),1,0);
			if (updaterow != 1) {
				throw new MyException("0003","書本歸還失敗");
			}
			
			//更新使用者借閱紀錄
			bookdaojdbc.updateBorrowingRecord(user, requestVO);
			
		}catch (MyException e ) {
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
			e.printStackTrace();
		}

	};
	
	
}
