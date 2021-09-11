package com.knoldus.LSP

object TestLSP {

  val withdraw = (account: Account, amount:Double)=>{
    account.amount = account.amount - amount
    "ALERT: You've withdrawn Rs. " + amount + " Available Bal Rs.  " + account.amount
  }
  val deposit = (account: Account, amount:Double)=>{
    account.amount = account.amount + amount
    "UPDATE: Rs. " + amount + " has been deposited into your account. Avl Bal INR " + account.amount
  }


  def main(args: Array[String]): Unit = {

    val savingAccount = new SavingAccount("Mayank ", 45000.89)
    val currentAccount = new CurrentAccount("Ank", 30000.23)

    Printer(withdraw(savingAccount, 1500)).printMessage
    Printer(withdraw(currentAccount, 2000)).printMessage

    Printer(deposit(savingAccount, 1000)).printMessage

  }
}