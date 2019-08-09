import { Component } from "@angular/core";
import { Account } from "./app.Account";
import { AccountService } from "./app.AccountServiceClass";



@Component({
    selector: 'add-comp',
    templateUrl: 'withdraw.html'
})
 export class WithdrawMoney{
     ob: Account=new Account()
    constructor(private  service: AccountService){}
    from: any;
  amount: Account;
 
  
    
    ngOnInit() {
      }
    
      private DrawMoney() {
        console.log("service")
        this.service.withdrawMoney(this.mobile)
          .subscribe(res => {this.ob = res;
          });
        
      }}