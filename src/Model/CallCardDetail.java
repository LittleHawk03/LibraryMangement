/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;



/**
 *
 * @author honahl
 */
public class CallCardDetail {
    
    
    private int PM_ID;
    private int BookID;
    private Date BorrowDate;
    private Date DueTo;
    private int returnBook;

    public CallCardDetail() {
    }

    public int getPM_ID() {
        return PM_ID;
    }

    public void setPM_ID(int PM_ID) {
        this.PM_ID = PM_ID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public Date getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(Date BorrowDate) {
        this.BorrowDate = BorrowDate;
    }

    public Date getDueTo() {
        return DueTo;
    }

    public void setDueTo(Date DueTo) {
        this.DueTo = DueTo;
    }

  

    

    public int getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(int returnBook) {
        this.returnBook = returnBook;
    }


    
    
    
    
}
